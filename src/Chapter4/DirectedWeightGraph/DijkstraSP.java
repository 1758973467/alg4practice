package Chapter4.DirectedWeightGraph;

import Chapter2.IndexMinPQ;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class DijkstraSP implements ISP {
    private DirectedEdge[]edgeTo;
    private double[]distTo;
    private IndexMinPQ<Double>pq;

    public DijkstraSP(IEdgeWeightedDigraph G,int s) {
        edgeTo=new DirectedEdge[G.V()];
        distTo=new double[G.V()];
        pq=new IndexMinPQ<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0d;
        pq.insert(s,0d);
        while (!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }

    private void relax(IEdgeWeightedDigraph g, int v) {
        for (var edge:g.adj(v)){
            int w= edge.to();
            if(distTo[w]>distTo[v]+edge.weight()){
                distTo[w]=distTo[v]+edge.weight();
                edgeTo[w]=edge;
                if(pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
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
        Stack<DirectedEdge>paths=new LinkedListStack<>();
        while (edgeTo[v]!=null){
            paths.push(edgeTo[v]);
            v=edgeTo[v].from();
        }
        return paths;
    }
}
