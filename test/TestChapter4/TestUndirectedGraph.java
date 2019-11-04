package TestChapter4;

import Chapter4.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestUndirectedGraph {

    @Test
    public void TestToString(){
        In in =new In("test/TestChapter4/tinyG.txt");
        IGraph g=new Graph(in);
        StdOut.println(g.toString());
    }

    @Test
    public void TestISearch(){
        In in =new In("test/TestChapter4/tinyG.txt");
        IGraph g=new Graph(in);
        ISearch search=new DepthFirstSearch(g,0);
        ISearchTinyG(search,g);
        search=new BreadFirstSearch(g,0);
        ISearchTinyG(search,g);
        search=new UnionFindSearch(g,0);
        ISearchTinyG(search,g);
    }

    private void ISearchTinyG(ISearch search, IGraph g){
        Assert.assertEquals(search.count(),7);
        for (int i = 0; i < g.V(); i++) {
            if(i<7){
                Assert.assertEquals(search.marked(i),true);
            }else {
                Assert.assertEquals(search.marked(i),false);
            }
        }
    }

    @Test
    public void TestIPaths(){
        In in =new In("test/TestChapter4/tinyG.txt");
        IGraph g=new Graph(in);
        IPaths paths=new DepthFirstSearchPaths(g,0);
        Assert.assertEquals(paths.hasPathTo(7),false);
        Assert.assertEquals(paths.hasPathTo(6),true);
        int[]dfsAnswer={0,6,4,5,3};
        int i=0;
        for (int w:paths.pathTo(3)){
            Assert.assertEquals(dfsAnswer[i++],w);
        }
        Assert.assertEquals(paths.distTo(3), dfsAnswer.length-1);
        paths=new BreadthFirstPaths(g,0);
        int[]bfsAnswer={0,5,3};
        i=0;
        for (int w:paths.pathTo(3)){
            Assert.assertEquals(bfsAnswer[i++],w);
        }
        Assert.assertEquals(paths.distTo(3),bfsAnswer.length-1);
    }

    @Test
    public void TestICC(){
        In in =new In("test/TestChapter4/tinyG.txt");
        IGraph g=new Graph(in);
        ICC cc=new DepthFirstSearchCC(g);
        Assert.assertEquals(cc.count(),3);
        Assert.assertEquals(cc.connected(6,7),false);
        Assert.assertEquals(cc.connected(9,10),true);
        Assert.assertEquals(cc.connected(9,0),false);
    }

    @Test
    public void TestGraphUtil(){
        In in =new In("test/TestChapter4/tinyG.txt");
        IGraph g=new Graph(in);
        Assert.assertEquals(GraphUtil.maxDegree(g),4);
        Assert.assertEquals(GraphUtil.degree(g,6),2);
        Assert.assertEquals(GraphUtil.numberOfSelfLoops(g),0);
    }

}
