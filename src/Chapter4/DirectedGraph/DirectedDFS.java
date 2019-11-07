package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import Chapter4.ISearch;

public class DirectedDFS implements ISearch {
    private boolean []marked;
    private int count;
    public DirectedDFS(IDigraph G,int s) {
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(IDigraph g, int s) {
        marked[s]=true;
        count++;
        for(int w:g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }


    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }


}
