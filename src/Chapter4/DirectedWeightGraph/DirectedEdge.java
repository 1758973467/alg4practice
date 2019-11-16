package Chapter4.DirectedWeightGraph;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int v;//顶点之一
    private final int w;//另一个顶点
    private final double weight;//边的权重

    public DirectedEdge(int v, int w, double weight) {
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
    public int from(){
        return v;
    }

    /**
     * 另一个顶点
     * @return
     */
    public int to(){
       return w;
    }


    @Override
    public int compareTo(DirectedEdge that) {
        if(weight()<that.weight()){
            return -1;
        }else if(weight()>that.weight()){
            return 1;
        }else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f",v,w,weight);
    }
}
