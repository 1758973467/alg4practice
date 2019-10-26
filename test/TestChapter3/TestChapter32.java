package TestChapter3;

import Chapter3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestChapter32 {
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
            st.deleteMin();
            st.deleteMax();
            Assert.assertEquals(st.size(), strs.length - 2);
            while (!st.isEmpty()){
                st.deleteMax();
            }
            Assert.assertEquals(st.size(),0);
        }


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
        st=new RedBlackST<>();
        IOrderKeyST(st);
    }
}
