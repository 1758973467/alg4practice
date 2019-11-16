package Chapter4.WeightedUnDirectedGraph;

import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;

import java.lang.reflect.Array;

public class EdgeWeightedGraph implements IEdgeWeightedGraph{
    private final int V;
    private int E;
    private Bag<WeightedEdge>[]adj;
    public EdgeWeightedGraph(int V) {
        this.V=V;
        this.E=0;
        adj= (Bag<WeightedEdge>[]) Array.newInstance(LinkedListBag.class,V);
        for (int i = 0; i < V; i++) {
            adj[i]=new LinkedListBag<>();
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
    public void addEdge(WeightedEdge e) {
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    @Override
    public Iterable<WeightedEdge> adj(int v) {
        return adj[v];
    }

    @Override
    public Iterable<WeightedEdge> edges() {
        Bag<WeightedEdge>edges=new LinkedListBag<>();
        for (int i = 0; i < V(); i++) {
            for(var edge:adj[i]){
                if(!edges.contains(edge)){
                    edges.add(edge);
                }
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
