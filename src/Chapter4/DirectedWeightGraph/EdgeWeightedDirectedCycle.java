package Chapter4.DirectedWeightGraph;

import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class EdgeWeightedDirectedCycle {
    private boolean[]marked;
    private DirectedEdge[]edgeTo;
    private boolean[]onStack;
    private Stack<DirectedEdge>cycle;
    public EdgeWeightedDirectedCycle(IEdgeWeightedDigraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new DirectedEdge[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]){
                dfs(G, v);
            }
    }

    private void dfs(IEdgeWeightedDigraph g, int v) {
        onStack[v]=true;
        marked[v]=true;
        for(DirectedEdge e:g.adj(v)){
            int w=e.to();
            if(cycle!=null)return;
            else if(!marked[w]){
                edgeTo[w]=e;
                dfs(g,w);
            }else if(onStack[w]){
                cycle=new LinkedListStack<>();
                DirectedEdge f=e;
                while (f.from()!=w){
                    cycle.push(f);
                    f=edgeTo[f.from()];
                }
                cycle.push(f);
                return;
            }
        }
        onStack[v]=false;

    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }
}
