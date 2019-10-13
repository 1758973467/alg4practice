package chapter1.CaseStudy;

import stdlib.StdOut;

/**
 * quick-find算法
 */
public class QuickFindUF implements IUF{
    private int[] id;//分量id
    private int count;//分量数量
    public QuickFindUF(int N){
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }

    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public void union(int p ,int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i]==pID){
                id[i]=qID;
            }
        }
        //StdPrint
        for (var item :id){
            StdOut.print(item+"\t");
        }
        StdOut.println();
        count--;
    }
    public int find(int p){
        return id[p];
    }


}
