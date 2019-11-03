package Chapter4;

/**
 * 所有的连通分量
 */
public interface ICC  {
    /**
     * v和w的是否连通
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v,int w);

    /**
     * v所在的连通标识符(0~count-1)
     * @param v
     * @return
     */
    int id(int v);

    /**
     * 连通分量数
     * @return
     */
    int count();
}
