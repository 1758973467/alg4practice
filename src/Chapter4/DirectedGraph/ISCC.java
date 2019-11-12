package Chapter4.DirectedGraph;

/**
 * 强连通API
 */
public interface ISCC {
    /**
     * v,w是否是强连通的
     * @param v
     * @param w
     * @return
     */
    boolean stronglyConnected(int v,int w);

    /**
     * 图的强连通分量的总数
     * @return
     */
    int count();

    /**
     * v所在的强连通分量的标识符
     * [0,count()-1]
     * @param v
     * @return
     */
    int id(int v);
}
