package chapter1.CaseStudy;

import stdlib.StdOut;

/**
 * 加权quick-union 算法
 */
public class UFFaster implements IUF{
    private int[] id;//分量id
    private int count;//分量数量
    private int[]sz;//各个根节点所对应的分量大小
    public UFFaster(int N){
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        sz=new int[N];
        for (int i = 0; i < N; i++) {
            sz[i]=1;
        }
    }
    @Override
    public int count(){
        return count;
    }
    @Override
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot){
            return;
        }
        //将小树的节点连接到大树的根节点
        //p=q时，p当根结点 v
        if(sz[pRoot]<sz[qRoot]){
            id[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else{
            id[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }

        //StdPrint
        for (var item :id){
            StdOut.print(item+"\t");
        }
        StdOut.println();
        count--;
    }
    //森林
    @Override
    public int find(int p) {
        while (p!=id[p]){
            p=id[p];
        }
        return p;
    }
}
