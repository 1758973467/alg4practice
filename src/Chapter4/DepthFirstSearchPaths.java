package Chapter4;

import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

/**
 * dfs
 */
public class DepthFirstSearchPaths implements IPaths{
    private boolean marked[];//这个顶点调用过dfs了
    private int edgeTo[];//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;//起点
    private int[]distTo;
    /**
     * 在G中找出所有起点为s的路径
     * @param G
     * @param s
     */
    public DepthFirstSearchPaths(IGraph G, int s){
        this.s=s;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        distTo=new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s]=0;
        dfs(G,s);
    }

    private void dfs(IGraph g, int v) {
        marked[v]=true;
        for (int w:g.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                distTo[w]=distTo[v]+1;
                dfs(g,w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v){
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<Integer>path= new LinkedListStack<Integer>();
        for(int w=v;w!=s;w=edgeTo[w]){
            path.push(w);
        }
        path.push(s);
        return path;
    }

    @Override
    public int distTo(int v) {
        return distTo[v];
    }


}
