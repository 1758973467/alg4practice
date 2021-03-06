package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import Chapter4.UnDirectGraph.GraphUtil;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import stdlib.In;

import java.lang.reflect.Array;

public class Digraph implements IDigraph {
    private final int V;
    private int E;
    private Bag<Integer> adj[];

    public Digraph(int v) {
        V = v;
        this.E=0;
        adj= (Bag<Integer>[]) Array.newInstance(LinkedListBag.class,V);
        for (int i = 0; i < V; i++) {
            adj[i]=new LinkedListBag<>();
        }
    }



    public Digraph(Digraph digraph) {
        this(digraph.V());
        for (int v = 0; v < digraph.V(); v++) {
            for(int w:digraph.adj(v)){
                addEdge(v,w);
            }
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int E=in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);
        }
    }

    @Override
    public IDigraph reverse() {
        IDigraph R=new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w:adj(v)){
                R.addEdge(w,v);
            }
        }

        return R;
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
        E++;
    }

    @Override
    public boolean hasEdge(int v,int w){
        return adj[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        return GraphUtil.toString(this);
    }
}
