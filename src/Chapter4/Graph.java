package Chapter4;

import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import stdlib.In;

import java.lang.reflect.Array;

/**
 * 无向图-邻接表实现
 */
public class Graph implements IGraph{
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[]adj;//邻接表
    /**
     * 创建含有V个顶点但不含边的图
     * @param V
     */
    public Graph(int V){
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
    public Graph(In in){
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
        adj[v].add(w);
        adj[w].add(v);
        E++;
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
