package com.arthur;

public class DemoRecursion {
    public static void main(String[]args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr,0));
        System.out.println(factoriel(5));
        printFigure(5);
        System.out.println(tich(5,6));
        System.out.println(fib(10));
        System.out.println(fib(49));
    }
    public static int sum(int[]arr, int index){
        if (index ==arr.length-1){
            return arr[index];
        }
        return arr[index] + sum(arr, index+1);
    }
    public static int factoriel(int n){
        if (n<0) throw new IllegalStateException("N is negative!");
        if (n==0|| n==1){
            return 1;
        }
        return factoriel(n-1)*n;
    }
    public static int sumInteger(int n){
        if (n<=0) throw new IllegalStateException("N is negative or zero!");
        if (n==1){
            return 1;
        }
        return sumInteger(n-1)+n;
    }
    public static void printFigure(int n){
        if (n==0){
            return;
        }
        printLineOfChars('*',n);
        printFigure(n-1);
        printLineOfChars('#',n);

    }
    public static void printLineOfChars(char ch, int n){
        for (int i=0;i<n;i++)
            System.out.print(ch);
        System.out.println();
    }
    public static int tich(int a, int b){
        if (b==1){
            return a;
        }else{
            return tich(a,b-1)+a;
        }
    }
    public static long fib(int n){
        if (n<=1) return 1;
        return fib(n-1)+fib(n-2);
    }
}
