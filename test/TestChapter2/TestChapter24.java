package TestChapter2;

import Chapter2.IMaxPQ;
import Chapter2.MaxPQ;
import Chapter2.MaxPQArray;
import Chapter2.MaxPQArrayOrdered;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChapter24 {
    @Test
    public void TestMaxPQ(){
        String[] a =new String[]{
                "E","A","S","Y"
        };

        IMaxPQ<String> maxPQ1=new MaxPQ<>(a.length);
        IMaxPQ<String>maxPQ2=new MaxPQArray<>();
        IMaxPQ<String>maxPQ3=new MaxPQArrayOrdered<>();
        for (var item : a){
            maxPQ1.insert(item);
            maxPQ2.insert(item);
            maxPQ3.insert(item);
        }
        while (!maxPQ1.isEmpty()){
            //StdOut.println(maxPQ1.deleteMax()+" "+maxPQ2.deleteMax()+" "+maxPQ3.deleteMax());
            String item=maxPQ1.deleteMax();
            Assert.assertEquals(item,maxPQ2.deleteMax());
            Assert.assertEquals(item,maxPQ3.deleteMax());
        }
    }
}
