package Chapter5.Search;

public class BoyerMooreSearch implements ISubStringSearch {
    private int[]right;
    @Override
    public int search(String pattern, String txt) {
        CtorJumpTable(pattern);
        int M=pattern.length();
        int N=txt.length();
        int skip;
        for (int i = 0; i <=N-M; i+=skip) {
            skip=0;
            for (int j = M-1; j>=0 ; j--) {
                if(pattern.charAt(j)!=txt.charAt(i+j)){
                    skip=j-right[txt.charAt(i+j)];
                    if(skip<1){
                        skip=1;
                    }
                    break;
                }
                //FOUND
                if(skip==0){
                    return i;
                }
            }
        }
        //NOTFOUND
        return -1;
    }

    private void CtorJumpTable(String pattern) {
        int M=pattern.length();
        int R=256;
        right=new int[R];
        for (int c = 0; c < R; c++) {
            right[c]=-1;
        }
        for (int j = 0; j < M; j++) {
            right[pattern.charAt(j)]=j;
        }
    }
}
