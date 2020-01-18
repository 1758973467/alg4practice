package Chapter6.MaxFlow;

import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

import java.lang.reflect.Array;

/**
 * 流量网络
 */
public class FlowNetWork {
    private final Queue<FlowEdge>[] adj;
    private final int v;
    private int e;
    public FlowNetWork(int v) {
        this.v=v;
        this.adj= (Queue<FlowEdge>[]) Array.newInstance(LinkedListQueue.class,v);
        this.e=0;
    }

    public int V(){
        return v;
    }

    public int E(){
        return e;
    }

    public void addEdge(FlowEdge e){
        adj[e.from()].enqueue(e);
    }

    public Iterable<FlowEdge>adj(int v){
        return adj[v];
    }

    public Iterable<FlowEdge>edges(){
        Bag<FlowEdge>bag=new LinkedListBag<>();
        for (int i = 0; i < v; i++) {
            for (FlowEdge edge:adj[i]){
                bag.add(edge);
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(V()+" vertices,"+E()+" edges\n");
        for (int v = 0; v < V(); v++) {
            builder.append(v+": ");
            for (FlowEdge edge:adj(v)){
                builder.append(edge);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
