package chapter1.CaseStudy;

import stdlib.StdOut;

/**
 * quick-union 算法
 */
public class QuickUnionUF implements IUF {
    private int[] id;//分量id
    private int count;//分量数量
    public QuickUnionUF(int N){
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
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
        id[pRoot]=qRoot;

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
