package Chapter4.DirectedWeightGraph;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

public class BellmanFordSP implements ISP {
    private double[]distTo;
    private DirectedEdge[]edgeTo;
    private boolean[]onQ;
    private Queue<Integer>queue;
    private int cost;
    private Iterable<DirectedEdge>cycle;

    public BellmanFordSP(IEdgeWeightedDigraph G,int s) {
        distTo=new double[G.V()];
        edgeTo=new DirectedEdge[G.V()];
        onQ=new boolean[G.V()];
        queue=new LinkedListQueue<>();
        for (int i = 0; i < G.V(); i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0d;
        queue.enqueue(s);
        onQ[s]=true;
        while (!queue.isEmpty()&&!this.hasNegativeCycle()){
            int v=queue.dequeue();
            onQ[v]=false;
            relax(G,v);
        }
    }

    private void relax(IEdgeWeightedDigraph g, int v) {

    }

    private boolean hasNegativeCycle() {
        return false;
    }

    @Override
    public double distTo(int v) {
        return 0;
    }

    @Override
    public boolean hasPathTo(int v) {
        return false;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }
}
