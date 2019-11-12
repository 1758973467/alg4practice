package Chapter4.DirectedGraph;

import Chapter4.IDigraph;

/**
 * 计算强连通分量Kosaraju算法
 * 计算图的反向图的逆后序排列，然后按照逆后序排列以深度搜索的方式访问图
 */
public class KosarajuSCC implements ISCC {
    private boolean[]marked;
    private int[]id;//强连通分量标识符
    private int count;//强连通分量数量

    public KosarajuSCC(IDigraph G) {
        marked=new boolean[G.V()];
        id=new int[G.V()];
        DepthFirstOrder order=new DepthFirstOrder(G.reverse());
        for (int w:order.reversePost()){
            if(!marked[w]){
                dfs(G,w);
                count++;
            }
        }
    }

    private void dfs(IDigraph g, int v) {
        marked[v]=true;
        id[v]=count;
        for (int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    @Override
    public boolean stronglyConnected(int v,int w){
        return id[v]==id[w];
    }
    @Override
    public int id(int v){
        return id[v];
    }
    @Override
    public int count(){
        return count;
    }

}
