package Chapter4.DirectedWeightGraph;

import Chapter4.DirectedGraph.Topological;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

/**
 * 无环加权有向图的SP
 * 比Dijkstra算法更快
 */
public class AcyclicSP implements ISP {
    private double[]distTo;
    private DirectedEdge[]edgeTo;

    public AcyclicSP(IEdgeWeightedDigraph g,int s) {
        distTo=new double[g.V()];
        edgeTo=new DirectedEdge[g.V()];

        for (int v = 0; v < g.V(); v++) {
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0d;

        Topological topological=new Topological(g);
        if(!topological.hasOrder()){
            throw new IllegalArgumentException("Digraph is not acyclic");
        }
        for(int v:topological.order()){
            System.out.println(v);
            for (DirectedEdge e:g.adj(v)){
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v=e.from();
        int w=e.to();
        if(distTo[w]>distTo[v]+e.weight()){
            distTo[w]=distTo[v]+e.weight();
            edgeTo[w]=e;
        }
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new LinkedListStack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
