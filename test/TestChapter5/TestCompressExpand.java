package TestChapter5;

import Chapter5.DataCompress.Gemome;
import Chapter5.DataCompress.LZW;
import org.testng.annotations.Test;
import stdlib.BinaryIn;
import stdlib.BinaryOut;

public class TestCompressExpand {

    @Test
    public void testGemome(){
        BinaryIn bin=new BinaryIn("test/TestChapter5/genomeTiny.txt");
        BinaryOut bout=new BinaryOut("test/TestChapter5/genomeTinyout.bin");
        Gemome.compress(bin,bout);
        Gemome.expand(new BinaryIn("test/TestChapter5/genomeTinyout.bin"), new BinaryOut(System.out));
    }

    @Test
    public void testGemomeVirus(){
        BinaryIn bin=new BinaryIn("test/TestChapter5/genomeVirus.txt");
        BinaryOut bout=new BinaryOut("test/TestChapter5/genomeVirusout.bin");
        Gemome.compress(bin,bout);
        Gemome.expand(new BinaryIn("test/TestChapter5/genomeVirusout.bin"), new BinaryOut(System.out));
    }


    @Test
    public void testLZW(){
        BinaryIn bin=new BinaryIn("test/TestChapter5/genomeTiny.txt");
        BinaryOut bout=new BinaryOut("test/TestChapter5/lzwgenomeTinyout.bin");
        LZW.compress(bin,bout);
        LZW.expand(new BinaryIn("test/TestChapter5/lzwgenomeTinyout.bin"), new BinaryOut(System.out));
    }


}
