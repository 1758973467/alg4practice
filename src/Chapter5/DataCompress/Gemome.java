package Chapter5.DataCompress;

import Chapter5.Alphabet;
import stdlib.BinaryIn;
import stdlib.BinaryOut;

/**
 * DNA 压缩
 */
public class Gemome {
    public static void compress(BinaryIn bin,BinaryOut bout){
        Alphabet DNA= Alphabet.DNA;
        String s=bin.readString();
        int N=s.length();
        bout.write(N);
        for (int i = 0; i < N; i++) {
            int d=DNA.toIndex(s.charAt(i));
            bout.write(d,DNA.lgR());
        }
        bout.close();
    }

    public static void expand(BinaryIn bin, BinaryOut bout){
        Alphabet DNA= Alphabet.DNA;
        int N=bin.readInt();

        for (int i = 0; i < N; i++) {
            char c=bin.readChar(DNA.lgR());
            bout.write(DNA.toChar(c));
        }
        bout.close();
    }
}
