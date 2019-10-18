package TestChapter3;

import Chapter3.IST;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestChapter31 {
    @Test
    public void TestST(){
        IST<String,Integer>st=null;
        In in=new In("test/TestChapter3/ST.txt");
        int i=0;
        while (!in.isEmpty()){
            st.put(in.readString(),i++);
        }
        for(var key : st.keys()){
            StdOut.println(key+"\t"+st.get(key));
        }
    }

    public void FrequencyCounter(int minlen,String file){
        IST<String,Integer>st=null;
        In in=new In(file);
        int i=0;
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
}
