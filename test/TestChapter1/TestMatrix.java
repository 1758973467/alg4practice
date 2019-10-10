package TestChapter1;

import com.company.Matrix;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMatrix {
    @Test
    public void TestDot(){
        double[]x={1,2};
        double[]y={3,4};
        double answer=3+8;
        Assert.assertEquals(Matrix.dot(x,y),answer);
    }

    @Test
    public void TestMult(){
        double[][]a={
                {1,2},
                {3,4}
        };
        double[][]b={
                {1},
                {2}
        };
        double [][]answer={
                {5},
                {11}
        };
        var result=Matrix.mult(a,b);
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(result[i],answer[i]);
        }
    }

    @Test
    public void TestMult1(){
        double[][]a={
                {1,2},
                {3,4}
        };
        double []d={1,2};
        double[]multAnswer={5,11};
        Assert.assertEquals(Matrix.mult(a,d),multAnswer);
    }
    @Test
    public void TestMult2(){
        double[][]a={
                {1,2},
                {3,4}
        };
        double []d={1,2};
        double[]multAnswer={7,10};
        Assert.assertEquals(Matrix.mult(d,a),multAnswer);
    }
}
