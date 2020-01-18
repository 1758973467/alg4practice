package Chapter5.DataCompress;

import Chapter5.ST.IStringST;
import Chapter5.ST.TrieST;
import stdlib.BinaryIn;
import stdlib.BinaryOut;

public class LZW {
    private static final int R=256;
    private static final int L=4096;
    private static final int W=12;

    public static void compress(BinaryIn binaryin, BinaryOut binaryOut){
        String input = binaryin.readString();
        IStringST<Integer> st = new TrieST<Integer>();
        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R+1;  // R is codeword for EOF

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);  // Find max prefix match s.
            binaryOut.write(st.get(s), W);      // Print s's encoding.
            int t = s.length();
            if (t < input.length() && code < L)    // Add s to symbol table.
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);            // Scan past s in input.
        }
        binaryOut.write(R, W);
        binaryOut.close();
    }

    public static void expand(BinaryIn binaryin, BinaryOut binaryOut) {
        String[] st = new String[L];
        int i; // next available codeword value

        // initialize symbol table with all 1-character strings
        for (i = 0; i < R; i++)
            st[i] = "" + (char) i;
        st[i++] = "";                        // (unused) lookahead for EOF

        int codeword = binaryin.readInt(W);
        if (codeword == R) return;           // expanded message is empty string
        String val = st[codeword];

        while (true) {
            binaryOut.write(val);
            codeword = binaryin.readInt(W);
            if (codeword == R) break;
            String s = st[codeword];
            if (i == codeword) s = val + val.charAt(0);   // special case hack
            if (i < L) st[i++] = val + s.charAt(0);
            val = s;
        }
        binaryOut.close();
    }
}
