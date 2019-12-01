package Chapter5.DataCompress;

import stdlib.BinaryIn;
import stdlib.BinaryOut;

/**
 * 游程编码-二进制
 */
public class RunLength {
    public static void compress(BinaryIn bin, BinaryOut bout){
        char cnt=0;
        boolean b,old = false;
        while (!bin.isEmpty()){
            b=bin.readBoolean();
            if(b!=old){
                bout.write(cnt);
                cnt=0;
                old=!old;
            }else {
                if(cnt==255){
                    bout.write(cnt);
                    cnt=0;
                    bout.write(cnt);
                }

            }
            cnt++;
        }
        bout.write(cnt);
        bout.close();
    }

    public static void expand(BinaryIn bin, BinaryOut bout){
        boolean b=false;
        while (!bin.isEmpty()){
            char cnt=bin.readChar();
            for (int i = 0; i < cnt; i++) {
                bout.write(b);
            }
            b=!b;
        }
        bout.close();
    }
}
