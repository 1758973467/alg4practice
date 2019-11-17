package Chapter4.DirectedWeightGraph;

import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import stdlib.In;

import java.lang.reflect.Array;

public class EdgeWightedDigraph implements IEdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[]adj;

    public EdgeWightedDigraph(int V) {
        this.V=V;
        this.E=0;
        adj= (Bag<DirectedEdge>[]) Array.newInstance(LinkedListBag.class,V);
        for (int i = 0; i < V; i++) {
            adj[i]=new LinkedListBag<>();
        }
    }

    public EdgeWightedDigraph(In in) {
        this(in.readInt());
        int E=in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            double weight=in.readDouble();
            DirectedEdge edge=new DirectedEdge(v,w,weight);
            addEdge(edge);
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
    public void addEdge(DirectedEdge e) {
        int w=e.from();
        adj[w].add(e);
        E++;
    }

    @Override
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    @Override
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge>edges=new LinkedListBag<>();
        for (int i = 0; i < V(); i++) {
            for(var edge:adj[i]){
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(V()+" vertices,"+E()+" edges\n");
        for (int v = 0; v < V(); v++) {
            builder.append(v+": ");
            for (var item:adj(v)){
                builder.append(item+" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
