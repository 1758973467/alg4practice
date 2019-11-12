package Chapter4.DirectedGraph;

import Chapter4.IDigraph;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;

public class Degrees {
    private int[]indegrees;
    private int[]outdegrees;
    private boolean isMap;
    public Degrees(IDigraph G){
        indegrees=new int[G.V()];
        outdegrees=new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            for (int w:G.adj(i)){
                indegrees[w]++;
                outdegrees[i]++;
            }
        }
        for (int i = 0; i < G.V(); i++) {
            if(indegrees[i]==1&&outdegrees[i]==1){
                isMap=true;
            }else{
                isMap=false;
                break;
            }
        }

    }

    /**
     * v的入度
     * @param v
     * @return
     */
    public int indegree(int v){
        return indegrees[v];
    }

    /**
     * v的出度
     * @param v
     * @return
     */
    public int outdegree(int v){
        return outdegrees[v];
    }

    /**
     * 所有起点的集合
     * 入度为0
     * @return
     */
    public Iterable<Integer>sources(){
        Bag<Integer>bag=new LinkedListBag<>();
        for (int v = 0; v < indegrees.length; v++) {
            if(indegrees[v]==0){
                bag.add(v);
            }
        }
        return bag;
    }

    /**
     * 所有终点的集合
     * 终点 出度为0
     * @return
     */
    public Iterable<Integer>sinks(){
        Bag<Integer>bag=new LinkedListBag<>();
        for (int v = 0; v < outdegrees.length; v++) {
            if(outdegrees[v]==0){
                bag.add(v);
            }
        }
        return bag;
    }

    /**
     * G是一幅映射
     * @return
     */
    public boolean isMap(){
        return isMap;
    }
}
