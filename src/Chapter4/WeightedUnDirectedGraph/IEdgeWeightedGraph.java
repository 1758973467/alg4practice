package Chapter4.WeightedUnDirectedGraph;

public interface IEdgeWeightedGraph{

    /**
     * 顶点数
     * @return
     */
    int V();

    /**
     * 边数
     * @return
     */
    int E();

    /**
     * 向图中添加一条边e
     * @param e
     */
    void addEdge(WeightedEdge e);

    /**
     * 和v相关联的所有边
     * @param v
     * @return
     */
    Iterable<WeightedEdge> adj(int v);

    /**
     * 图的所有边
     * @return
     */
    Iterable<WeightedEdge> edges();
}
