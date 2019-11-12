package Chapter4.DirectedGraph;

import Chapter4.IDigraph;

/**
 * 顶点对可达性API
 */
public class TransitiveClosure {
    private DirectedDFS[]all;
    public TransitiveClosure(IDigraph G) {
        all=new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v]=new DirectedDFS(G,v);
        }
    }

    /**
     * 从v是否可以到达w
     * @param v
     * @param w
     * @return
     */
    public boolean reachable(int v, int w){
        return all[v].marked(w);
    }
}
