package TestChapter2;

import Chapter2.Example;
import Chapter2.HeapSort;
import Chapter2.MaxPQ;
import Chapter2.QuickSort;
import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;

public class TestChapter24 {

    @Test
    public void TestHeapSort(){

        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new HeapSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void TestChapter24(){
        String[] a =new String[]{
                "E","A","S","Y","Q","U","E","S","T","I","O","N"
        };
        MaxPQ<String> maxPQ=new MaxPQ<>(a.length);
        for (var item :a){
            maxPQ.insert(item);
        }
        String[]expect=new String[]{
                null,"Y","T","U","S","Q","N","E","A","S","I","O","E"
        };
        Assert.assertEquals(expect,maxPQ.getPq());
    }

    @Test
    public void TestChapter2415(){
        String[]expect=new String[]{
                null,"Y","T","U","S","Q","N","E","A","S","I","O","E"
        };
        Assert.assertEquals(isMaxHeap(expect),true);
    }

    //从a[1]开始
    public boolean isMaxHeap(Comparable[]a){
        return isMaxHeap(a,1);
    }
    private boolean isMaxHeap(Comparable[]a,int k){
        if(2*k<a.length){
            if(a[k].compareTo(a[2*k])<0){
                return false;
            }
            return isMaxHeap(a,2*k);
        }
        if(2*k+1<a.length){
            if(a[k].compareTo(a[2*k+1])<0){
                return false;
            }
            return isMaxHeap(a,2*k+1);
        }
        return true;
    }

    @Test
    public void TestMaxPQArray(){
        String[] a =new String[]{
                "E","A","S","Y","Q","U","E","S","T","I","O","N"
        };
        MaxPQ<String> maxPQ=new MaxPQ<>(a);
        Assert.assertEquals(isMaxHeap(maxPQ.getPq()),true);

    }
}
