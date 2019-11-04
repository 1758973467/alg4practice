package Chapter4;

import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import stdlib.In;
import stdlib.StdIn;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * 无向图-邻接表实现
 * 不允许含有平行边和自环
 */
public class GraphRestrict implements IGraph{
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[]adj;//邻接表
    /**
     * 创建含有V个顶点但不含边的图
     * @param V
     */
    public GraphRestrict(int V){
        this.V=V;
        adj= (Bag<Integer>[])Array.newInstance(LinkedListBag.class,V);
        for (int i = 0; i < V; i++) {
            adj[i]=new LinkedListBag<>();
        }
    }

    /**
     * 从标准输入流读入一幅图
     * @param in
     */
    public GraphRestrict(In in){
        //V
        this(in.readInt());
        //E
        int E=in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);
        }
    }

    /**
     * 从标准输入流读入图的邻接表
     */
    public GraphRestrict(Scanner scanner){
        this(scanner.nextInt());
        int E=scanner.nextInt();
        for (int i = 0; i < E; i++) {
            String[] vals=scanner.nextLine().split(" ");
            int v=Integer.parseInt(vals[0]);
            for (int j = vals.length-1; j >1 ; --j) {
                addEdge(v,Integer.parseInt(vals[j]));
            }
        }

    }

    /**
     * 复制构造函数
     * @param G
     */
    public GraphRestrict(GraphRestrict G){
        this(G.V());
        int E=G.E();
        for (int i = 0; i < adj.length; i++) {
            for(int edge:G.adj[i]){
                adj[i].add(edge);
            }
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        //
        if (containsParallelEdgeAndSelfLoop(v, w)) return;
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 判断是否存在平行边和自环
     * @param v
     * @param w
     * @return
     */
    private boolean containsParallelEdgeAndSelfLoop(int v, int w) {
        for (int w1:adj[v]){
            //有
            if(w1==w||w1==v){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否含有v-w边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v,int w){
        return adj[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString(){
        return GraphUtil.toString(this);
    }
}
