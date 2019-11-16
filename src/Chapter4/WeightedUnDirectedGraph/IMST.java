package Chapter4.WeightedUnDirectedGraph;

/**
 * 最小生成树API
 */
public interface IMST {
    /**
     * 最小生成所有边
     * @return
     */
    Iterable<WeightedEdge> edges();

    /**
     * 最小生成树高度
     * @return
     */
    double weight();
}
