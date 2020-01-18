package Chapter6.MaxFlow;

/**
 * 流量网络中的边
 */
public class FlowEdge {
    /**
     * 边的起点
     */
    private final int v;
    /**
     * 边的终点
     */
    private final int w;
    /**
     * 容量
     */
    private final double capacity;
    /**
     * 流量
     */
    private double flow;

    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
        this.flow=0f;
    }

    /**
     * 起始顶点
     * @return
     */
    public int from(){
        return v;
    }

    /**
     * 边的目的顶点
     * @return
     */
    public int to(){
        return w;
    }

    /**
     * 边的容量
     * @return
     */
    public double capacity(){
        return capacity;
    }

    /**
     * 边的流量
     * @return
     */
    public double flow(){
        return flow;
    }

    /**
     * 边的另一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex){
        if(vertex==v){
            return w;
        }else if(vertex==w){
            return v;
        }else throw new IllegalArgumentException();
    }

    /**
     * v的剩余容量
     * @param vertex
     * @return
     */
    public double residualCapacity(int vertex){
        if(vertex==v)return flow;
        else if(vertex==w)return capacity-flow;
        else throw new RuntimeException("Inconsistent edge");
    }

    /**
     * 将v的流量增加delta
     * @param vertex
     * @param delta
     */
    public void addResidualFlowTo(int vertex,double delta){
        if(vertex==v)flow-=delta;
        else if(vertex==w)flow+=delta;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f %.2f",v,w,capacity,flow);
    }
}
