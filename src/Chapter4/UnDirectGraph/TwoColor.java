package Chapter4.UnDirectGraph;

import Chapter4.IGraph;

/**
 * 判断图是否是二分图
 */
public class TwoColor {
    private boolean []marked;
    private boolean[]color;
    private boolean isTwoColorable=true;

    public TwoColor(IGraph g) {
        marked=new boolean[g.V()];
        color=new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if(!marked[s]){
                dfs(g,s);
            }
        }
    }

    private void dfs(IGraph g, int s) {
        marked[s]=true;
        for(int w:g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }else if(color[w]==color[s])isTwoColorable=false;
        }
    }

    public boolean IsBitpartite(){
        return isTwoColorable;
    }
}
