package chapter1.BagQueueStack;

import java.util.Arrays;

public class FixedCapacityStackOfString {
    private String[]a;//stack entries
    private int N;//size

    public FixedCapacityStackOfString(int cap) {
        a=new String[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void push(String item){
        a[N++]=item;
    }
    public String pop(){
        return a[--N];
    }
    public int size(){
        return N;
    }
    public boolean isFull(){
        return size()==a.length;
    }

    @Override
    public String toString() {
        return "FixedCapacityStackOfString{" +
                "a=" + Arrays.toString(a) +
                ", N=" + N +
                '}';
    }
}
