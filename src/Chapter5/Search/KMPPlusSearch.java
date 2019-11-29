package Chapter5.Search;

public class KMPPlusSearch implements ISubStringSearch {
    @Override
    public int search(String pattern, String txt) {
        int i = 0;
        int j = 0;
        int []next=new int[pattern.length()];
        GetNext(pattern,next);
        while (i < txt.length() && j < pattern.length())
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || txt.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pattern.length())
            return i - j;
        else
            return -1;
    }


    private void GetNext(String pattern, int[] next)
    {
        int pLen = pattern.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k))
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }
        }
    }
}
