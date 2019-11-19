package Chapter4.DirectedWeightGraph;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.Stack;

public class BellmanFordSP implements ISP {
    private double[]distTo;//从起点到某个顶点的路径长度
    private DirectedEdge[]edgeTo;//从起点到某个顶点的最后一条边
    private boolean[]onQ;//该顶点是否存在于队列中
    private Queue<Integer>queue;//正在被放松的顶点
    private int cost;//relax()调用的次数
    private Iterable<DirectedEdge>cycle;//edgeTo中是否由父权重的环

    public BellmanFordSP(IEdgeWeightedDigraph G,int s) {
        distTo=new double[G.V()];
        edgeTo=new DirectedEdge[G.V()];
        onQ=new boolean[G.V()];
        queue=new LinkedListQueue<>();
        for (int i = 0; i < G.V(); i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0d;
        queue.enqueue(s);
        onQ[s]=true;
        while (!queue.isEmpty()&&!this.hasNegativeCycle()){
            int v=queue.dequeue();
            onQ[v]=false;
            relax(G,v);
        }
    }

    private void relax(IEdgeWeightedDigraph g, int v) {
        for(DirectedEdge e:g.adj(v)){
            int w=e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
                if(!onQ[w]){
                    queue.enqueue(w);
                    onQ[w]=true;
                }
            }
            if(cost++%g.V()==0){
                findNegativeCycle();
            }
        }
    }

    private void findNegativeCycle(){
        EdgeWightedDigraph edgeWightedDigraph=new EdgeWightedDigraph(edgeTo.length);
        for (int v = 0; v < edgeTo.length; v++) {
            if(edgeTo[v]!=null){
                edgeWightedDigraph.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedDirectedCycle cf=new EdgeWeightedDirectedCycle(edgeWightedDigraph);
        cycle=cf.cycle();

    }
    public boolean hasNegativeCycle() {
        return cycle!=null;
    }

    public Iterable<DirectedEdge>negativeCycle(){
        return cycle;
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> edges=new LinkedListStack<>();
        while (edgeTo[v]!=null){
            edges.push(edgeTo[v]);
            v=edgeTo[v].from();
        }
        return edges;
    }
}
