package com.company;

public class Matrix {
    /**
     * 向量点乘
     * @param x
     * @param y
     * @return
     */
    public static double dot(double[]x,double[]y){
        assert x.length==y.length:"x与y length不一致";
        double result=0;
        for (int i = 0; i < x.length; i++) {
            result+=x[i]*y[i];
        }
        return result;
    }

    /**
     * 矩阵与矩阵乘积
     * @param a
     * @param b
     * @return
     */
    public static double[][]mult(double[][]a,double[][]b){
        double[][]result=new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 转置矩阵
     * @param a
     * @return
     */
    public static double[][]transpose(double[][]a){
        double[][]result=new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i]=a[i][j];
            }
        }
        return result;
    }

    /**
     * 矩阵和向量之积
     * @param a
     * @param x
     * @return
     */
    public static double[]mult(double[][]a,double[]x){
        assert a[0].length==x.length;
        double []result=new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i]+=a[i][j]*x[j];
            }
        }
        return result;
    }

    /**
     * 向量和矩阵之积
     * @param y
     * @param a
     * @return
     */
    public static double[] mult(double[]y,double[][]a){
        assert y.length==a.length;
        double[]result=new double[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j]+=y[i]*a[i][j];
            }
        }
        return result;
    }

}
