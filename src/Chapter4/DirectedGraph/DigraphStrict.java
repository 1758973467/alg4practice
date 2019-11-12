package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import Chapter4.UnDirectGraph.GraphUtil;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import stdlib.In;

import java.lang.reflect.Array;

public class DigraphStrict implements IDigraph {
    private final int V;
    private int E;
    private Bag<Integer>adj[];

    public DigraphStrict(int v) {
        this.V=v;
        this.E=0;
        adj=(Bag<Integer>[]) Array.newInstance(LinkedListBag.class,V);
        for (int i = 0; i < V; i++) {
            adj[i]=new LinkedListBag<>();
        }
    }

    public DigraphStrict(DigraphStrict digraphStrict) {
        this(digraphStrict.V());
        for (int v = 0; v < digraphStrict.V(); v++) {
            for(int w:digraphStrict.adj(v)){
                addEdge(v,w);
            }
        }
    }

    public DigraphStrict(In in) {
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
        DigraphStrict reverseGraph=new DigraphStrict(V());
        for (int v = 0; v < V(); v++) {
            for (int w:adj(v)){
                reverseGraph.addEdge(w,v);
            }
        }
        return reverseGraph;
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
        if (containsParallelEdgeAndSelfLoop(v, w)) return;
        adj[v].add(w);
        E++;
    }

    /**
     * 判断是否存在平行边和自环
     * @param v
     * @param w
     * @return
     */
    private boolean containsParallelEdgeAndSelfLoop(int v, int w) {
        if(v==w||adj[v].contains(w))return true;
        else return false;
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
