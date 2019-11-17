package TestChapter4;

import Chapter4.WeightedUnDirectedGraph.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestWeightedUnDirectedGraph {

    private static final double FLOATING_POINT_EPSILON = 1e-12;

    private IEdgeWeightedGraph graph;
    public TestWeightedUnDirectedGraph() {
        In in=new In("test/TestChapter4/tinyEWG.txt");
        graph=new EdgeWeightedGraph(in);
    }

    @Test
    public void testMST(){
        StdOut.println("LazyPrimeMST");
        IMST mst=new LazyPrimeMST(graph);
        testMST(mst);
        StdOut.println("PrimeMST");
        mst=new PrimeMST(graph);
        testMST(mst);
        StdOut.println("KruskalMST");
        mst=new KruskalMST(graph);
        testMST(mst);
    }

    public void testMST(IMST mst){
        for (var e:mst.edges()){
            StdOut.println(e);
        }
        Assert.assertEquals(mst.weight(),1.81);
    }


}
