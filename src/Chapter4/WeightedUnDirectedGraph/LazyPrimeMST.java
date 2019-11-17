package Chapter4.WeightedUnDirectedGraph;

import Chapter2.MinPQ;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

public class LazyPrimeMST implements IMST {
    private boolean marked[];//最小生成树顶点
    private Queue<WeightedEdge> mst;//最小生成树边
    private MinPQ<WeightedEdge> pq;//横切边(包括失效的边)
    private double weight;
    public LazyPrimeMST(IEdgeWeightedGraph G) {
        pq=new MinPQ<>(G.E());
        marked=new boolean[G.V()];
        mst=new LinkedListQueue<>();
        visit(G,0);//假设G是连通的
        while (!pq.isEmpty()){
            WeightedEdge e=pq.delMin();
            int v=e.either();
            int w=e.other(v);
            if(marked[v]&&marked[w])continue;
            mst.enqueue(e);
            weight+=e.weight();
            if(!marked[v])visit(G,v);
            if(!marked[w])visit(G,w);
        }
    }

    private void visit(IEdgeWeightedGraph g, int v) {
        marked[v]=true;
        for(var edge:g.adj(v)){
            if(!marked[edge.other(v)]){
                pq.insert(edge);
            }
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
