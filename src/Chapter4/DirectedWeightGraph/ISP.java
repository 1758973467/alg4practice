package Chapter4.DirectedWeightGraph;

/**
 * 最短路径API
 */
public interface ISP {
    /**
     * 从顶点s到v的距离，如果不存在就是无穷大
     * @param v
     * @return
     */
    double distTo(int v);

    /**
     * 是否存在从顶点s到v的路径
     * @param v
     * @return
     */
    boolean hasPathTo(int v);

    /**
     * 从顶点s到v的路径，如果不存在为null
     * @param v
     * @return
     */
    Iterable<DirectedEdge>pathTo(int v);
}
