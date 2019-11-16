package Chapter4.WeightedUnDirectedGraph;


import Chapter2.MinPQ;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;
import chapter1.CaseStudy.IUF;
import chapter1.CaseStudy.UFFaster;

public class KruskalMST implements IMST {
    private Queue<WeightedEdge>mst;

    public KruskalMST(IEdgeWeightedGraph G) {
        mst=new LinkedListQueue<>();
        MinPQ<WeightedEdge> pq=new MinPQ<WeightedEdge>(0);
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
        }
    }

    @Override
    public Iterable<WeightedEdge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return 0;
    }
}
