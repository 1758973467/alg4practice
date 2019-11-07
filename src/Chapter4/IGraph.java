package Chapter4;

/**
 * 无向图API
 * 1.邻接矩阵 V*V的布尔矩阵表示边的连接
 * 2.变的数组 使用Edge类表示v-w的连接
 * 3. 邻接表数组 顶点为索引的列表数组
 *
 * 邻接矩阵无法处理大数量，以及平行边
 */
public interface IGraph {

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
     * 向图中添加一条边v-w
     * @param v
     * @param w
     */
    void addEdge(int v,int w);
    /**
     * 和v相邻的所有顶点
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);


}
