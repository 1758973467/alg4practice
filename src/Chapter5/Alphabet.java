package Chapter5;

import java.util.Arrays;

/**
 * 字母表API
 */
public class Alphabet {
    /**
     *  The binary alphabet { 0, 1 }.
     */
    public static final Alphabet BINARY = new Alphabet("01");

    /**
     *  The octal alphabet { 0, 1, 2, 3, 4, 5, 6, 7 }.
     */
    public static final Alphabet OCTAL = new Alphabet("01234567");

    /**
     *  The decimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    /**
     *  The hexadecimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F }.
     */
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    /**
     *  The DNA alphabet { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     *  The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     *  The uppercase alphabet { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     *  The protein alphabet { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     *  The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     *  The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     *  The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    private char[] alphabet;     // the characters in the alphabet
    private int[] inverse;       // indices
    private final int Radix;         // the radix of the alphabet

    public Alphabet(String alpha) {
        boolean[]unicode=new boolean[Character.MAX_VALUE];
        for (int i = 0; i <alpha.length() ; i++) {
            char c=alpha.charAt(i);
            if(unicode[c]){
                throw new IllegalArgumentException("");
            }
            unicode[c]=true;
        }
        alphabet=alpha.toCharArray();
        Radix =alpha.length();
        inverse=new int[Character.MAX_VALUE];
        Arrays.fill(inverse, -1);

        for (int c = 0; c < Radix; c++) {
            inverse[alphabet[c]]=c;
        }
    }

    private Alphabet(int radix){
        this.Radix =radix;
        alphabet=new char[Radix];
        inverse=new int[Radix];

        for (int i = 0; i < Radix; i++) {
            alphabet[i]=(char)i;
        }
        for (int i = 0; i < Radix; i++) {
            inverse[i]=i;
        }
    }

    private Alphabet(){
        this(256);
    }
    /**
     * 获取字母表中索引位置的字符
     * @param index
     * @return
     */
    public char toChar(int index){
        return alphabet[index];
    }



    /**
     * 获取c的索引，[0,R-1]
     * @param c
     * @return
     */
    public int toIndex(char c){
        return inverse[c];
    }

    /**
     * c在字母表之中
     * @param c
     * @return
     */
    public boolean contains(char c){
        return inverse[c]!=-1;
    }

    /**
     * 基数，字母表字符的数量
     * @return
     */
    public int Radix(){
        return Radix;
    }

    /**
     * 一个索引所需的位数
     * @return
     */
    public int lgR(){
        int lgR=0;
        for (int t = Radix -1; t >=1 ; t/=2) {
            lgR++;
        }
        return lgR;
    }

    /**
     * 将s转换为R进制的整数
     * @param s
     * @return
     */
    public int[] toIndices(String s){
        char[]source=s.toCharArray();
        int[]target=new int[s.length()];
        for (int i = 0; i < source.length; i++) {
            target[i]=toIndex(source[i]);
        }
        return target;
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     * @param indices
     * @return
     */
    public String toChars(int[] indices){
        StringBuilder s=new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++) {
            s.append(toChar(indices[i]));
        }
        return s.toString();
    }
}
