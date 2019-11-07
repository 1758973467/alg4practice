package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import Chapter4.IPaths;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.Stack;

public class BreadFirstPaths implements IPaths {
    private boolean[]marked;
    private int []edgeTo;
    private int[] distTo;
    private final int s;

    public BreadFirstPaths(IDigraph g, int s) {
        this.s = s;
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        distTo=new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i]=Integer.MAX_VALUE;
        }
        distTo[s]=0;

        bfs(g,s);
    }

    private void bfs(IDigraph g, int s) {
        Queue<Integer>queue=new LinkedListQueue<>();
        queue.enqueue(s);
        marked[s]=true;
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for(int w:g.adj(v)){
                if(!marked[w]){
                    queue.enqueue(w);
                    edgeTo[w]=v;
                    distTo[w]=distTo[v]+1;
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack=new LinkedListStack<>();
        stack.push(v);
        for(;v!=s;v=edgeTo[v]){
            stack.push(v);
        }
        stack.push(s);
        return stack;
    }

    @Override
    public int distTo(int v) {
        return distTo[v];
    }
}
