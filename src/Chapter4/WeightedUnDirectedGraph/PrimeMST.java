package Chapter4.WeightedUnDirectedGraph;

import Chapter2.IndexMinPQ;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;

import java.util.Arrays;

public class PrimeMST implements IMST {
    private boolean marked[];//最小生成树顶点
    private WeightedEdge[]edgeTo;
    private double[]distTo;

    private IndexMinPQ<Double> pq;//横切边(包括失效的边)

    public PrimeMST(IEdgeWeightedGraph G) {
        marked=new boolean[G.V()];
        edgeTo=new WeightedEdge[G.V()];
        distTo=new double[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        pq=new IndexMinPQ<>(G.V());

        distTo[0]=0d;
        pq.insert(0,0d);

        while (!pq.isEmpty()){
            visit(G,pq.delMin());//假设G是连通的

        }
    }

    private void visit(IEdgeWeightedGraph g, int v) {
        marked[v]=true;
        for(var edge:g.adj(v)){
            int w= edge.other(v);
            if(marked[w])continue;
            if(edge.weight()<distTo[w]){
                edgeTo[w]=edge;
                distTo[w]=edge.weight();
                if(pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }


    @Override
    public Iterable<WeightedEdge> edges() {
        Bag<WeightedEdge> edges=new LinkedListBag<>();
        for (var edge:edgeTo){
            edges.add(edge);
        }
        return edges;
    }

    @Override
    public double weight() {
        return Arrays.stream(distTo).sum();
    }
}
