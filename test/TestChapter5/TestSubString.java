package TestChapter5;

import Chapter5.Search.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubString {
    private void testSubStringSearch(ISubStringSearch subStringSearch){
        String pattern="AAAAB";
        String txt="AAAAAAAAAB";
        Assert.assertEquals(subStringSearch.search(pattern,txt),5);
        pattern="DABCDABDE";
        txt="BBC ABCDAB ABCDABCDABDE";
        Assert.assertEquals(subStringSearch.search(pattern,txt),14);
    }
    @Test
    public void testBruteForce(){
        ISubStringSearch subStringSearch=new BruteForceSearch();
        testSubStringSearch(subStringSearch );
    }

    @Test
    public void testKMP(){
        ISubStringSearch subStringSearch=new KMPSearch();
        testSubStringSearch(subStringSearch );
    }

    @Test
    public void testKMPlus(){
        ISubStringSearch subStringSearch=new KMPPlusSearch();
        testSubStringSearch(subStringSearch );
    }

    @Test
    public void testBoyerMoore(){
        ISubStringSearch subStringSearch=new BoyerMooreSearch();
        testSubStringSearch(subStringSearch );
    }

    @Test
    public void testRabinKarp(){
        ISubStringSearch subStringSearch=new RabinKarpSearch();
        testSubStringSearch(subStringSearch );
    }


}
