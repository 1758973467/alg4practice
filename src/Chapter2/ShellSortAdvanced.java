package Chapter2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//练习11，12
public class ShellSortAdvanced extends Example {
    @Override
    public void sort(Comparable[] a) {
        int []array=new int[a.length/3];

        double []compareCount=new double[a.length];//比较次数

        array[0]=1;
        int index=1;
        for (; index < a.length&&array[index-1]<a.length/3; index++) {
            array[index]=array[index-1]*3+1;
        }
        for (; index >=0 ; index--) {
            int h=array[index];
            for (int i =h ; i <a.length ; i++) {

                for (int j = i; j >=h; j-=h) {
                    compareCount[j]+=1;
                    compareCount[j-h]+=1;
                    if(less(a[j],a[j-h])){
                        exch(a,j,j-h);
                    }else break;
                }
            }
        }
        //print
        for (int i = 0; i < compareCount.length; i++) {
            compareCount[i]/=a.length;

        }
        try{
            FileWriter writer=new FileWriter("test/TestChapter2/2112.txt");
            writer.append(Arrays.toString(compareCount));
            writer.append("\n");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
