package Chapter4.DirectedGraph;

import Chapter4.DirectedWeightGraph.DirectedEdge;
import Chapter4.DirectedWeightGraph.IEdgeWeightedDigraph;
import Chapter4.IDigraph;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.Stack;

public class DepthFirstOrder {
    private boolean[]marked;
    private Queue<Integer>pre;//所有顶点的前序排列
    private Queue<Integer>post;//所有顶点的后序排序
    private Stack<Integer> reversePost;//所有顶点的逆后序排列

    public DepthFirstOrder(IDigraph G) {
        marked=new boolean[G.V()];
        pre=new LinkedListQueue<>();
        post=new LinkedListQueue<>();
        reversePost=new LinkedListStack<>();

        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public DepthFirstOrder(IEdgeWeightedDigraph G) {
        marked=new boolean[G.V()];
        pre=new LinkedListQueue<>();
        post=new LinkedListQueue<>();
        reversePost=new LinkedListStack<>();

        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(IDigraph g, int v) {
        marked[v]=true;
        pre.enqueue(v);
        for (int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(IEdgeWeightedDigraph g, int v) {
        marked[v]=true;
        pre.enqueue(v);
        for (DirectedEdge w:g.adj(v)){
            if(!marked[w.from()]){
                dfs(g,w.to());
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer>pre(){
        return pre;
    }
    public Iterable<Integer>post(){
        return post;
    }
    public Iterable<Integer>reversePost(){
        return reversePost;
    }
}
