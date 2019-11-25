package TestChapter5;

import Chapter5.Alphabet;
import org.testng.annotations.Test;
import stdlib.StdIn;
import stdlib.StdOut;

public class TestString {
    @Test
    public void TestCount(){
        Alphabet alphabet=new Alphabet("ABCDR");
        count(alphabet,"ABRACADABRA!");
    }

    public void count(Alphabet alphabet,String str){
        int radix=alphabet.Radix();
        int []count=new int[radix];

        int N=str.length();
        for (int i = 0; i < N; i++) {
            if(alphabet.contains(str.charAt(i))){
                count[alphabet.toIndex(str.charAt(i))]++;
            }
        }
        //print
        for (int c = 0; c < radix; c++) {
            StdOut.println(alphabet.toChar(c)+"  "+count[c]);
        }
    }
}
