package Chapter4.UnDirectGraph;

import Chapter4.IGraph;
import Chapter4.IPaths;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.Stack;

public class BreadthFirstPaths implements IPaths {
    private boolean []marked;
    private int []edgeTo;
    private final int s;
    private int []distTo;
    public BreadthFirstPaths(IGraph g, int s){
        this.s=s;
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        distTo=new int[g.V()];
        bfs(g,s);
    }

    private void bfs(IGraph g, int s) {
        for (int v = 0; v < g.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        Queue<Integer>queue=new LinkedListQueue<>();
        queue.enqueue(s);
        marked[s]=true;
        distTo[s]=0;
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for (int w:g.adj(v)){
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    distTo[w]=distTo[v]+1;
                    queue.enqueue(w);
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
        if(!hasPathTo(v)) return null;
        Stack<Integer>stack= new LinkedListStack();
        for(int w=v;w!=s;w=edgeTo[w]){
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }

    @Override
    public int distTo(int v) {
        return distTo[v];
    }
}
