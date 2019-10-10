package chapter1;

import stdlib.StdDraw;

import java.awt.*;
//alg4 1.2.10
public class VisualCounter {
    private int opMaxCount;//操作最大次数
    public VisualCounter(int opMaxCount,int max){
        if(opMaxCount>max){
            throw new IllegalArgumentException();
        }
    }
    public VisualCounter()
    {
        this(0,Integer.MAX_VALUE);
    }
    public void increment(){
        opMaxCount++;
        var oldColor=StdDraw.getPenColor();
        StdDraw.filledSquare(0.02,.98,.02);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(0.02,.98,""+opMaxCount);
        StdDraw.setPenColor(oldColor);
    }
    public void decrement(){
        opMaxCount--;
        var oldColor=StdDraw.getPenColor();
        StdDraw.filledSquare(0.02,.98,.02);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(0.02,.98,""+opMaxCount);
        StdDraw.setPenColor(oldColor);
    }

}
