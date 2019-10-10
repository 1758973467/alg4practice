package com.company;

import chapter1.Counter;

public class BinarySearch {
    public static int rank(int key,int[]a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])hi=mid-1;
            else if(key>a[mid])lo=mid+1;
            else return mid;
        }
        //NOT FOUND
        return -1;
    }
    //返回被查找的键匹配的最小元素
    public static int rankAdvanced(int key,int[]a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])hi=mid-1;
            else if(key>a[mid])lo=mid+1;
            else {
                while (mid>0&&a[mid-1]==key){
                    mid--;
                }
                return mid;
            };

        }
        //NOT FOUND
        return -1;
    }

    public static int rank(int key, int[]a, Counter c){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            c.increment();
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])hi=mid-1;
            else if(key>a[mid])lo=mid+1;
            else return mid;
        }
        //NOT FOUND
        return -1;
    }

    public static int rankLower(int key,int []a){
        int index=rank(key,a);
        if(index==-1){
            return index;
        }
        for (int i = index; i >0 ; i--) {
            if(a[i]==key){
                index--;
            }
            if(a[i]<key){
                break;
            }
        }
        return index;
    }
    public static int count(int key,int []a){
        int index=rank(key,a);
        if(index==-1){
            return index;
        }
        int count=1;
        for (int i = index-1; i >=0 ; i--) {
            if(a[i]==key){
               count++;
            }
            if(a[i]<key){
                break;
            }
        }
        for (int i = index+1; i <a.length ; i++) {
            if(a[i]==key){
                count++;
            }
            if(a[i]>key){
                break;
            }

        }
        return count;
    }
    //
    public static int rankRecursion(int key,int[]a){
        return _rankRecursion(key,a,0,a.length-1,1);
    }

    private static int _rankRecursion(int key, int[] a, int lo, int hi, int deepth) {
        for (int i = 0; i < deepth; i++) {
            System.out.print("\t");
        }
        System.out.println("lo:"+lo+"\thi:"+hi+"\tdeepth:"+deepth);

        if(lo>hi){
            return -1;
        }
        int mid=(lo+hi)/2;
        if(key>a[mid]){
            return _rankRecursion(key,a,mid+1,hi,deepth+1);
        }else if(key<a[mid]){
            return _rankRecursion(key,a,lo,mid-1,deepth+1);
        }else
        {
            System.out.println("found "+mid);
            return mid;
        }

    }

    public static int BruteForceSearch(int key,int []a){
        for (int i = 0; i < a.length; i++) {
            if(key==a[i]){
                return i;
            }
        }
        return -1;
    }
}
