package TestChapter2;

import Chapter2.Other;
import Chapter2.Version;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChapter25 {
    @Test
    public void TestSelect(){
        String []a={"4","2","3","3","5"};
        Assert.assertEquals("2", Other.select(a,0));
        Assert.assertEquals("3", Other.select(a,1));
        Assert.assertEquals("3", Other.select(a,2));
        Assert.assertEquals("4",Other.select(a,3));
        Assert.assertEquals("5",Other.select(a,4));
    }

    @Test
    public void TestSelectRecsive(){
        String []a={"4","2","3","3","5"};
        Assert.assertEquals("2", Other.selectRecsive(a,0));
        Assert.assertEquals("3", Other.selectRecsive(a,1));
        Assert.assertEquals("3", Other.selectRecsive(a,2));
        Assert.assertEquals("4",Other.selectRecsive(a,3));
        Assert.assertEquals("5",Other.selectRecsive(a,4));
    }

    @Test
    public void TestVersion(){
        Version v1=new Version("115.1.1");
        Version v2=new Version("115.10.1");
        Version v3=new Version("115.10.2");
        Assert.assertTrue(v1.compareTo(v2)<0);
        Assert.assertTrue(v2.compareTo(v3)<0);
    }
}
