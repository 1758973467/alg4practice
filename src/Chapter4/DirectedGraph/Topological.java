package Chapter4.DirectedGraph;

import Chapter4.DirectedWeightGraph.EdgeWeightedDirectedCycle;
import Chapter4.DirectedWeightGraph.IEdgeWeightedDigraph;
import Chapter4.IDigraph;

/**
 * 拓扑排序
 * 有向图的逆后序遍历
 */
public class Topological {

    private Iterable<Integer>order;//顶点的拓扑排序
    public Topological(IDigraph G) {
        DirectedCycle cycleFinder=new DirectedCycle(G);
        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(G);
            order=dfs.reversePost();
        }

    }

    public Topological(IEdgeWeightedDigraph g) {
        EdgeWeightedDirectedCycle finder=new EdgeWeightedDirectedCycle (g);
        if(!finder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(g);
            order=dfs.reversePost();
        }
    }


    /**
     * G是否是有向无环图
     * @return
     */
    public boolean isDAG(){
        return order!=null;
    }

    /**
     * 拓扑排序的所有顶点
     * @return
     */
    public Iterable<Integer>order(){
        return order;
    }

    public boolean hasOrder() {
        return order!=null;
    }
}
