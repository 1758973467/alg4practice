package TestChapter1;

import chapter1.CaseStudy.IUF;
import chapter1.CaseStudy.UF;
import chapter1.CaseStudy.UFBetter;
import chapter1.CaseStudy.UFFaster;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestChapter15 {

    @Test
    public void testUF(){
        In in=new In("test/TestChapter1/largeUF.txt");
        int N= in.readInt();

        IUF uf=new UF(N);
        testUFImpl(uf,in);
        //8m 43s
    }
    @Test
    public void testUFBetter(){
        In in=new In("test/TestChapter1/largeUF.txt");
        int N= in.readInt();
        IUF uf=new UFBetter(N);
        testUFImpl(uf,in);
        //60 min more
    }
    @Test
    public void testUFFaster(){
        In in=new In("test/TestChapter1/largeUF.txt");
        int N= in.readInt();
        IUF uf=new UFFaster(N);
        testUFImpl(uf,in);
        //4seconds
    }
    public void testUFImpl(IUF uf,In in){

        while(!in.isEmpty()){
            int p=in.readInt();
            int q=in.readInt();
            if(!uf.connected(p, q)){
                uf.union(p, q);
                StdOut.println(p+" "+q);
            }
        }
        StdOut.println(uf.count()+"components");
    }

    @Test
    public void Test151(){
        UF uf=new UF(10);
        int []pArray={9,3,5,7,2,5,0,4};
        int []qArray={0,4,8,2,1,7,3,2};
        for (int i = 0; i < pArray.length; i++) {
            int p=pArray[i];
            int q=qArray[i];
            if(!uf.connected(p, q)){
                uf.union(p, q);
                StdOut.println(p+" "+q);
            }
        }
    }

    @Test
    public void test152(){
        IUF uf=new UFBetter(10);
        int []pArray={9,3,5,7,2,5,0,4};
        int []qArray={0,4,8,2,1,7,3,2};
        for (int i = 0; i < pArray.length; i++) {
            int p=pArray[i];
            int q=qArray[i];
            if(!uf.connected(p, q)){
                uf.union(p, q);
                StdOut.println(p+" "+q);
            }
        }
    }
}
