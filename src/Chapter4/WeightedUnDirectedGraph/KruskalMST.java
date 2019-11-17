package Chapter4.WeightedUnDirectedGraph;


import Chapter2.MinPQ;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;
import chapter1.CaseStudy.IUF;
import chapter1.CaseStudy.UFFaster;

public class KruskalMST implements IMST {
    private Queue<WeightedEdge>mst;
    private double weight;
    public KruskalMST(IEdgeWeightedGraph G) {
        mst=new LinkedListQueue<>();
        MinPQ<WeightedEdge> pq=new MinPQ<WeightedEdge>(G.E());
        for (var edge:G.edges()){
            pq.insert(edge);
        }
        IUF uf=new UFFaster(G.V());
        while (!pq.isEmpty()&&mst.size()<G.V()-1){
            WeightedEdge edge=pq.delMin();
            int v= edge.either();
            int w=edge.other(v);
            if(uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            mst.enqueue(edge);
            weight+=edge.weight();
        }
    }

    @Override
    public Iterable<WeightedEdge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return weight;
    }
}
