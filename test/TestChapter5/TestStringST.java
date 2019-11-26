package TestChapter5;


import Chapter5.ST.IStringST;
import Chapter5.ST.TrieST;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;

public class TestStringST {
    @Test
    public void testTrieST(){
        In in=new In("test/TestChapter5/shellsST.txt");
        String[]a=in.readAllStrings();
        IStringST<Integer> stringST=new TrieST<>();
        for (int i = 0; i < a.length; i++) {
            stringST.put(a[i],i);
        }

        Assert.assertEquals(stringST.contains("sea"),true);
        Assert.assertEquals(stringST.contains("sea3"),false);
        Assert.assertEquals(stringST.contains("se"),false);
        Assert.assertEquals(stringST.longestPrefixOf("shell"),"she");
        Assert.assertEquals(stringST.longestPrefixOf("shells"),"shells");
        Assert.assertEquals(stringST.isEmpty(),false);
        Assert.assertEquals(stringST.size(),7);
        //sells,sea
        System.out.println("------------keysWithPrefix");
        for(var key:stringST.keysWithPrefix("se")){
            System.out.println(key);
        }
        //she the
        System.out.println("------------keysThatMatch");
        for(var key:stringST.keysThatMatch(".he")){
            System.out.println(key);
        }
        System.out.println("------------keys");
        for (var key:stringST.keys()) {
            System.out.println(key);
        }
        for(var key:a){
            stringST.delete(key);
        }
        Assert.assertEquals(stringST.isEmpty(),true);



    }

}
