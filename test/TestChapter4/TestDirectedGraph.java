package TestChapter4;

import Chapter4.DirectedGraph.*;
import Chapter4.IDigraph;
import Chapter4.IGraph;
import Chapter4.IPaths;
import Chapter4.ISearch;
import Chapter4.UnDirectGraph.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

import java.io.FileNotFoundException;

public class TestDirectedGraph {

    @Test
    public void TestToString(){
        In in =new In("test/TestChapter4/tinyDG.txt");
        IDigraph g=new Digraph(in);
        StdOut.println(g.toString());
    }

    @Test
    public void TestISearch(){
        In in =new In("test/TestChapter4/tinyDG.txt");
        IDigraph g=new Digraph(in);
        ISearch search=new DepthFirstSearch(g,0);
        ISearchTinyDG(search,g);
        search=new BreadFirstSearch(g,0);
        ISearchTinyDG(search,g);

    }

    private void ISearchTinyDG(ISearch search, IGraph g){
        Assert.assertEquals(search.count(),6);
        for (int i = 0; i < g.V(); i++) {
            if(i<6){
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
    public void TestISCC(){
        In in =new In("test/TestChapter4/tinyDGex2.txt");
        IDigraph g=new Digraph(in);
        ISCC scc=new KosarajuSCC(g);
        Assert.assertEquals(scc.count(),7);
        Assert.assertEquals(scc.stronglyConnected(6,7),false);
        Assert.assertEquals(scc.stronglyConnected(1,8),false);
        Assert.assertEquals(scc.stronglyConnected(2,10),true);
    }

    @Test
    public void TestGraphNoParallelLineAndSelfLoop() throws FileNotFoundException {
        In in =new In("test/TestChapter4/tinyDGex2.txt");
        IDigraph g=new DigraphStrict(in);
        g.addEdge(0,6);
        g.addEdge(0,0);

        Assert.assertEquals(g.V(),12);
        Assert.assertEquals(g.E(),16);
    }

    @Test
    public void testTopological(){
        In in =new In("test/TestChapter4/tinyDGex2.txt");
        IDigraph g=new Digraph(in);
        Topological topological=new Topological(g);

        for (var e:topological.order()){
            System.out.println(e);
        }
    }

}
