package Chapter4.UnDirectGraph;


import Chapter4.IGraph;
import Chapter4.ISearch;

public class DepthFirstSearch implements ISearch {
    private boolean marked[];
    private int count;
    public DepthFirstSearch(IGraph G, int s) {
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    /**
     * 深度优先遍历
     * @param g
     * @param s
     */
    private void dfs(IGraph g, int s) {
        marked[s]=true;
        count++;
        for (int w:g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    @Override
    public boolean marked(int v){
        return marked[v];
    }

    @Override
    public int count(){
        return count;
    }
}
