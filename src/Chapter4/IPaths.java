package Chapter4;

/**
 * 路径API
 */
public interface IPaths {
    /**
     * 是否存在s到v的路径
     * @param v
     * @return
     */
    boolean hasPathTo(int v);
    /**
     * s到v的路径，如果不存在则返回null
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v);

    /**
     * 返回从起点到给定的顶点的路径长度
     * o(n)
     * @param v
     * @return
     */
    int distTo(int v);

}
