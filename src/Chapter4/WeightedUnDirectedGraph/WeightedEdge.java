package Chapter4.WeightedUnDirectedGraph;

/**
 * 带权重的边
 */
public class WeightedEdge implements Comparable<WeightedEdge> {
    private final int v;//顶点之一
    private final int w;//另一个顶点
    private final double weight;//边的权重

    public WeightedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 边的权值
     * @return
     */
    public double weight(){
        return weight;
    }

    /**
     * 边的两端的顶点之一
     * @return
     */
    public int either(){
        return v;
    }

    /**
     * 另一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex){
        if(vertex==v)return w;
        else if(vertex==w)return v;
        else throw new RuntimeException("Inconsistent Edge");
    }


    @Override
    public int compareTo(WeightedEdge that) {
        if(weight()<that.weight()){
            return -1;
        }else if(weight()>that.weight()){
            return 1;
        }else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f",v,w,weight);
    }
}
