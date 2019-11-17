package Chapter4.DirectedGraph;


import Chapter4.IDigraph;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class DirectedCycle {
    private boolean[]marked;
    private int[]edgeTo;
    private Stack<Integer>cycle;//有向环中的所有顶点
    private boolean[]onStack;//递归调用的栈上的所有顶点

    public DirectedCycle(IDigraph G) {
        onStack=new boolean[G.V()];
        edgeTo=new int[G.V()];
        marked=new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(IDigraph g, int v) {
        onStack[v]=true;
        marked[v]=true;
        for (int w:g.adj(v)){
            if(hasCycle())return;
            else if(!marked[w]){
                edgeTo[w]=v;
                dfs(g,w);
            }else if(onStack[w]){
                cycle=new LinkedListStack<>();
                for (int x = 0; x !=w; x=edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer>cycle(){
        return cycle;
    }


}