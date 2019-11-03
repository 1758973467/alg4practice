package Chapter4;


public class DepthFirstSearchSearch implements ISearch {
    private boolean marked[];
    private int count;
    public DepthFirstSearchSearch(IGraph G, int s) {
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
            if(!marked[s]){
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
