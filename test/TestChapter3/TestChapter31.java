package TestChapter3;

import Chapter3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestChapter31 {
    @Test
    public void TestST(){
        IST<String,Integer>st=new SequentialSearchST<>();
        In in=new In("test/TestChapter3/ST.txt");
        String[]arr=in.readAllStrings();
        for (int i = 0; i < arr.length; i++) {
            st.put(arr[i],i);
        }
        for(var key : st.keys()){
            StdOut.println(key+"\t"+st.get(key));
        }
        Assert.assertTrue(st.contains(arr[arr.length-1]));
        st.delete(arr[arr.length-1]);
        st.delete(arr[4]);
        st.delete(arr[0]);
        st.delete(arr[3]);
        Assert.assertEquals(st.size(),arr.length-4);
    }

    public void FrequencyCounter(int minlen,String file){
        In in=new In(file);
        String[]strs=in.readAllStrings();
        IST<String,Integer>st=new BinarySearchST<>(strs.length+1);
        for (var str :strs){
            String word=str;
            if(word.length()<minlen)continue;
            if(!st.contains(word))st.put(word,1);
            else st.put(word,st.get(word)+1);
        }

        String max="";
        st.put(max,0);
        for(var word : st.keys()){
            if(st.get(word)>st.get(max)){
                max=word;
            }
        }
        StdOut.println(max+" "+st.get(max));
    }



    @Test
    public void TestFreqCounter(){
        FrequencyCounter(10,"test/TestChapter3/leipzig1M.txt");
    }

}
