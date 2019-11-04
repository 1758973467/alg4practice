package Chapter4;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

public class BreadthFirstPaths implements IPaths {
    private boolean []marked;
    private int []edgeTo;
    private final int s;
    private int []distTo;
    public BreadthFirstPaths(IGraph g,int s){
        this.s=s;
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        distTo=new int[g.V()];
        bfs(g,s);
    }

    private void bfs(IGraph g, int s) {
        Queue<Integer>queue=new LinkedListQueue<>();
        queue.enqueue(s);
        marked[s]=true;
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
        return false;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        return null;
    }

    @Override
    public int distTo(int v) {
        return distTo[v];
    }
}
