package Chapter5;


import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSearch implements ISubStringSearch {
    private int M;
    private long patternHash;
    private int R=256;
    private long RM;
    private long Q;

    private void Init(String pattern){
        M=pattern.length();
        Q=longRandomPrime();
        RM=1;
        for (int i = 1; i <=M-1 ; i++) {
            RM=(R*RM)%Q;
        }
        patternHash=hash(pattern,M);
    }
    @Override
    public int search(String pattern, String txt) {
        Init(pattern);
        //true search
        int N=txt.length();
        long txtHash=hash(txt,M);
        if(patternHash==txtHash&&check(0))return 0;

        for (int i = M; i <N; i++) {
            txtHash=(txtHash+Q-RM*txt.charAt(i-M)%Q)%Q;
            txtHash=(txtHash*R+txt.charAt(i))%Q;
            if(patternHash==txtHash){
                if(check(i-M+1)){
                    return i-M+1;
                }
            }
        }
        return -1;
    }

    private boolean check(int i){
        return true;
    }
    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private long hash(String key, int M) {
        long h=0;
        for (int j = 0; j < M; j++) {
            h=(R*h+key.charAt(j))%Q;
        }
        return h;
    }
}
