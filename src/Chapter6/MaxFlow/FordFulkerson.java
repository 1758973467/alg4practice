package Chapter6.MaxFlow;

/**
 * 最短增广路径FordFulkerson最大流量算法
 */
public class FordFulkerson {
    private boolean[]marked;//在剩余网络中是否存在从s到v的路径
    private FlowEdge[]edgeTo;//从s到v的最短路径上的最后一条线
    private double value;//当前最大流量

    public FordFulkerson(FlowNetWork G,int s,int t) {
        //find s->t的流量网络G的最大流量配置
        while (hasAugmentingPath(G,s,t)){
            //利用所有存在的增广路径
            //计算当前的瓶颈容量
            double bottle=Double.POSITIVE_INFINITY;
            for (int v = t; v!=s; v=edgeTo[v].other(v)) {
                bottle=Math.min(bottle,edgeTo[v].residualCapacity(v));
            }
            //增大流量
            for (int v = t; v !=s ; v=edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v,bottle);
            }
            value+=bottle;
        }
    }

    private boolean hasAugmentingPath(FlowNetWork g, int s, int t) {
        return false;
    }

    public double value(){
        return value;
    }

    public boolean inCut(int v){
        return marked[v];
    }

}
