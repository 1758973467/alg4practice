package Chapter5.StringSort;

/**
 * 基数排序
 *
 */
public class LSD {
    private static int Radix =256;
    private static String[]aux;
    /**
     * 定长字符串排序
     * @param a
     * @param w 长度
     */
    public static void sort(String[]a,int w){
        int N=a.length;
        aux=new String[N];
        for (int d = w-1; d >=0 ; d--) {
            //根据第d个字符用键索引计数法排序
            int[]count=new int[Radix +1];
            for (int i = 0; i < N; i++) {//计算出现频率
                count[a[i].charAt(d)+1]++;
            }
            for (int r = 0; r < Radix; r++) {//频率转换为索引
                count[r+1]+=count[r];
            }
            for (int i = 0; i < N; i++) {//将元素分类
                aux[count[a[i].charAt(d)]++]=a[i];
            }
            for (int i = 0; i < N; i++) {//回写
                a[i]=aux[i];
            }
        }
    }

    public static void sort(String[]a){
        int N=a.length;
        aux=new String[N];
        int w=0;
        for (var str:a){
            w=Math.max(w,str.length());
        }

        for (int d = w-1; d >=0 ; d--) {
            //根据第d个字符用键索引计数法排序
            int[]count=new int[Radix +1];

            for (String s : a) {//计算出现频率
                count[s.charAt(d) + 1]++;
            }
            for (int r = 0; r < Radix; r++) {//频率转换为索引
                count[r+1]+=count[r];
            }
            for (int i = 0; i < N; i++) {//将元素分类
                aux[count[a[i].charAt(d)]++]=a[i];
            }

            for (int i = 0; i < N; i++) {//回写
                a[i]=aux[i];
            }

        }
    }
}
