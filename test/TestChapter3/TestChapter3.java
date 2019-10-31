package TestChapter3;

import Chapter3.*;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestChapter3 {
    @Test
    public void TestIST(){
        IST<String, Integer> st = new SeparateChainingHashST<>();
        IST(st);
        st=new LinearProbingHashST<>(5);
        IST(st);
        st=new LinearProbingHashSTDuplicateKey<>(5);
        IST(st);
    }
    @Test
    public void TestIOrderKeyST(){
        IOrderKeyST<String, Integer> st = new OrderedLinkedListSequentilSearchST<>();
        /*
        IOrderKeyST(st);
        st=new BinarySearchST<String, Integer>(100);
        IOrderKeyST(st);
        st=new BST<>();
        IOrderKeyST(st);
        */
        st=new RedBlackBST<>();
        IOrderKeyST(st);
        st=new BSTDuplicateKey<>();
        IOrderKeyST(st);
        st=new RedBlackBSTDuplicateKey<>();
        IOrderKeyST(st);
    }
    @Test
    public void TestIOrderKeySTDuplicate(){
        IOrderKeyST<String, Integer> st =null;
        st=new BSTDuplicateKey<>();
        IOrderKeySTDuplicate(st);
        st=new RedBlackBSTDuplicateKey<>();
        IOrderKeySTDuplicate(st);
    }

    @Test
    public void TestFreqCounter(){
        FrequencyCounter(10,"test/TestChapter3/leipzig1M.txt");
    }

    @Test
    public void TestInvert(){
        IST<String,Bag<String>>st=null;
        String []files={
                "test/TestChapter3/amino.csv",
        };
        for(var file :files) {
            In in=new In(file);
            st=new LinearProbingHashST<>();
            while (in.hasNextLine()){
                String line=in.readLine();
                String[]tokens=line.split(",");
                String key=tokens[0];
                String val=tokens[1];
                if(!st.contains(key)){
                    st.put(key,new LinkedListBag<>());
                }
                st.get(key).add(val);
            }
            var ts=Invert(st);
            for (var key :ts.keys()){
                var v=ts.get(key);
                //ts k-v ==st k-v
                StdOut.println(key+"------");
                for (var val:v){
                    Assert.assertEquals(st.contains(val),true);
                    Assert.assertEquals(st.get(val).contains(key),true);
                    StdOut.println(val);
                }
                StdOut.println();
            }
        }
    }

    @Test
    public void TestSparseVector(){
        //a = [1,0,1,0,3]
        //b =[-1,0,1,2,0]
        SparseVector a=new SparseVector();
        a.put(0,1);
        a.put(2,1);
        a.put(4,3);

        SparseVector b=new SparseVector();
        b.put(0,-1);
        b.put(2,1);
        b.put(3,2);

        var c=a.sum(b);
        Assert.assertEquals(c.get(0),0.0);
        Assert.assertEquals(c.get(1),0.0);
        Assert.assertEquals(c.get(2),2.0);
        Assert.assertEquals(c.get(3),2.0);
        Assert.assertEquals(c.get(4),3.0);
    }

    private static IST<String,Bag<String>> Invert(IST<String, Bag<String>>st){
        IST<String,Bag<String>>ts=new LinearProbingHashST<>();
        for (String key:st.keys()){
            for(String item:st.get(key)){
                if(!ts.contains(item)){
                    ts.put(item,new LinkedListBag());
                }
                ts.get(item).add(key);
            }
        }
        return ts;
    }

    private void IST(IST<String,Integer> st){
        String []files={
                "test/TestChapter3/UNOrderedST.txt",
                "test/TestChapter3/OrderedST.txt"
        };
        for(var file :files) {
            In in=new In(file);

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
            for (int i = 0; i < arr.length; i++) {
                st.delete(arr[i]);
            }
            Assert.assertEquals(st.size(),0);
        }
    }

    private void FrequencyCounter(int minlen, String file){
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

    private void IOrderKeyST(IOrderKeyST<String, Integer> st) {
        String []files={
                "test/TestChapter3/UNOrderedST.txt",
                "test/TestChapter3/OrderedST.txt"
        };
        for(var file :files){
            In in = new In(file);
            String[] strs = in.readAllStrings();
            for (int i = 0; i < strs.length; i++) {
                st.put(strs[i], i);
            }
            Assert.assertEquals(st.floor("09:05:00"), "09:03:13");
            Assert.assertEquals(st.floor("08:55:55"), null);
            Assert.assertEquals(st.floor("09:40:00"), st.max());
            Assert.assertEquals(st.ceiling("09:30:00"), "09:35:21");
            Assert.assertEquals(st.ceiling("09:40:00"), null);
            Assert.assertEquals(st.ceiling("08:55:55"), st.min());
            Assert.assertEquals(st.size("09:15:00", "09:25:00"), 5);
            Assert.assertEquals(st.size(st.max(), st.min()), 0);
            Assert.assertEquals(st.size(st.min(), st.max()), st.size());
            String min=st.min();
            st.deleteMin();
            Assert.assertEquals(st.contains(min),false);
            String max=st.max();
            st.deleteMax();
            Assert.assertEquals(st.contains(max),false);
            Assert.assertEquals(st.size(), strs.length - 2);
            for(var key :st.keys()){
                StdOut.println(key);
            }
            while (!st.isEmpty()){
                st.deleteMax();
            }

            Assert.assertEquals(st.size(),0);
        }
    }

    private void IOrderKeySTDuplicate(IOrderKeyST<String, Integer> st) {
        String []files={
                "test/TestChapter3/UNOrderedSTDuplicate.txt",
                "test/TestChapter3/OrderedSTDuplicate.txt"
        };
        for(var file :files){
            In in = new In(file);
            String[] strs = in.readAllStrings();
            for (int i = 0; i < strs.length; i++) {
                st.put(strs[i], i);
            }
            Assert.assertEquals(st.floor("09:05:00"), "09:03:13");
            Assert.assertEquals(st.floor("08:55:55"), null);
            Assert.assertEquals(st.floor("09:40:00"), st.max());
            Assert.assertEquals(st.ceiling("09:30:00"), "09:35:21");
            Assert.assertEquals(st.ceiling("09:40:00"), null);
            Assert.assertEquals(st.ceiling("08:55:55"), st.min());
            //Assert.assertEquals(st.size("09:15:00", "09:25:00"), 5);
            Assert.assertEquals(st.size(st.max(), st.min()), 0);
            Assert.assertEquals( st.size(),strs.length);
            String min=st.min();
            st.deleteMin();
            Assert.assertEquals(st.contains(min),false);
            String max=st.max();
            st.deleteMax();
            Assert.assertEquals(st.contains(max),false);
            //Assert.assertEquals(st.size(), strs.length - 2);
            for(var key :st.keys()){
                StdOut.println(key);
            }
            while (!st.isEmpty()){
                st.deleteMax();
            }

            Assert.assertEquals(st.size(),0);
        }
    }


}
