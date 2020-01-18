package Chapter6;

import Chapter2.Quick3Way;

/**
 * 后缀数组实现
 */
public class SuffixArray {
    /**
     * 后缀数组
     */
    private final String[]suffixes;
    /**
     * 字符串(和数组)的长度
     */
    private final int N;

    public SuffixArray(String s) {
        this.N=s.length();
        suffixes=new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i]=s.substring(i);
        }
        Quick3Way quick3Way=new Quick3Way();
        quick3Way.sort(suffixes);
    }

    /**
     * 文本的长度
     * @return
     */
    public int length(){
        return N;
    }

    /**
     * 后缀数组的第i个元素
     * @param i
     * @return
     */
    public String select(int i){
        return suffixes[i];
    }


    public int index(int i){
        return N-suffixes[i].length();
    }

    /**
     * select(i) select(i-1)的最长公共前缀的长度
     * @param i
     * @return
     */
    public int lcp(int i){
        return lcp(suffixes[i],suffixes[i-1]);
    }

    private int lcp(String s, String t) {
        int min=Math.min(s.length(),t.length());
        for (int i = 0; i < min; i++) {
            if(s.charAt(i)!=t.charAt(i)){
                return i;
            }
        }
        return min;
    }

    /**
     * 小于Key的后缀数量
     * @param key
     * @return
     */
    public int rank(String key){
        int lo=0,hi=N-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            int cmp=key.compareTo(suffixes[mid]);
            if(cmp<0){
                hi=mid-1;
            }else if(mid>0){
                lo=mid+1;
            }else return mid;
        }
        return -1;
    }


}
