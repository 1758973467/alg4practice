package Chapter5.Search;

/**
 * 算法第四版实现，看不懂
 */
public class KMPSearch implements ISubStringSearch{

    private int[][]dfa;

    public KMPSearch() {
        //由pattern构造dfa

    }

    private void CtorDfa(String pattern) {
        int m=pattern.length();
        int R=256;
        dfa=new int[R][m];
        dfa[pattern.charAt(0)][0]=1;
        for (int X=0,j = 1; j <m ; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j]=dfa[c][X];
            }
            dfa[pattern.charAt(j)][j]=j+1;
            X=dfa[pattern.charAt(j)][X];
        }
    }

    @Override
    public int search(String pattern, String txt) {
        CtorDfa(pattern);
        int i,j,N=txt.length(),M=pattern.length();
        for (i=0,j=0;i<N&&j<M;i++){
            j=dfa[txt.charAt(i)][j];
        }
        if(j==M)return i-M;
        else return N;
    }
}
