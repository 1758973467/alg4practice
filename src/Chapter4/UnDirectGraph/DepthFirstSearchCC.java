package Chapter4.UnDirectGraph;

import Chapter4.ICC;
import Chapter4.IGraph;

public class DepthFirstSearchCC implements ICC {
    private boolean marked[];
    private int[]id;
    private int count;

    public DepthFirstSearchCC(IGraph g) {
        marked=new boolean[g.V()];
        id=new int[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if(!marked[s]){
                dfs(g,s);
                count++;
            }
        }
    }

    private void dfs(IGraph g, int v) {
        marked[v]=true;
        id[v]=count;
        for (int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v]==id[w];
    }

    @Override
    public int id(int v) {
        return id[v];
    }

    @Override
    public int count() {
        return count;
    }
}
