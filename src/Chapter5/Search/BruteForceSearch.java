package Chapter5.Search;

public class BruteForceSearch implements ISubStringSearch{
    @Override
    public int search(String pattern, String txt) {
        int M=pattern.length();
        int N=txt.length();
        for (int i=0;i<=N-M;++i){
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if(txt.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if(j==M){//FOUND
                return i;
            }
        }
        return -1;//NOT FOUND
    }
}
