package TestChapter3;

import Chapter3.BinarySearchST;
import Chapter3.IOrderKeyST;
import Chapter3.IST;
import Chapter3.SequentialSearchST;
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
        IST<String,Integer>st=new BinarySearchST<>(strs.length);
        for (var str :strs){
            String word=str;
            if(word.length()<minlen)continue;
            if(!st.contains(word))st.put(word,1);
            else st.put(word,st.get(word)+1);
        }
        while (!in.isEmpty()){
            String word=in.readString();
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
    public void TestOrderedST(){
        In in=new In("test/TestChapter3/OrderedST.txt");
        String[]strs=in.readAllStrings();
        IOrderKeyST<String,Integer> st=new BinarySearchST<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            st.put(strs[i],i);
        }
        Assert.assertEquals(st.floor("09:05:00"),"09:03:13");
        Assert.assertEquals(st.floor("08:55:55"),null);
        Assert.assertEquals(st.floor("09:40:00"),st.max());
        Assert.assertEquals(st.ceiling("09:30:00"),"09:35:21");
        Assert.assertEquals(st.ceiling("09:40:00"),st.max());
        Assert.assertEquals(st.ceiling("08:55:55"),st.min());
        Assert.assertEquals(st.size("09:15:00","09:25:00"),5);
        Assert.assertEquals(st.size(st.max(),st.min()),0);
        Assert.assertEquals(st.size(st.min(),st.max()),st.size());
        st.deleteMax();
        st.deleteMax();
        st.delete(strs[0]);
        Assert.assertEquals(st.size(),strs.length-3);
    }
}
