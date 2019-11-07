package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import Chapter4.IPaths;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class DepthFirstPaths implements IPaths {

    private boolean[]marked;
    private int edgeTo[];
    private int distTo[];
    private final int s;
    public DepthFirstPaths(IDigraph g,int s) {
        this.s=s;
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        distTo=new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i]=Integer.MAX_VALUE;
        }
        distTo[s]=0;
        dfs(g,s);
    }

    private void dfs(IDigraph g, int s) {
        marked[s]=true;
        for(int w:g.adj(s)){
           if(!marked[w]){
               edgeTo[w]=s;
               distTo[w]=distTo[s]+1;
               dfs(g,w);
           }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        Stack<Integer>stack=new LinkedListStack<>();
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
