package Chapter4.UnDirectGraph;

import Chapter4.IGraph;

/**
 * 判断简单图G是否是无环图
 */
public class Cycle {
    private boolean[]marked;
    private boolean hasCycle;

    public Cycle(IGraph g) {
        marked=new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if(!marked[s]){
                dfs(g,s,s);
            }
        }
    }


    private void dfs(IGraph g, int v, int u) {
        //v 当前节点，u上一节点
        //w是当前节点v的邻节点
        //判断有环 如果v的邻节点中
        // 如果存在访问过节点不是u之外的节点，那么必然存在环
        // 因为是先dfs遍历，必定先访问节点
        marked[v]=true;
        for(int w:g.adj(v)){
            //check自环和平行边
            if(w==v){//自环
                hasCycle=true;
            }
            if(!marked[w]){
                dfs(g,w,v);
            }else if(w!=u){
                hasCycle=true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

}
