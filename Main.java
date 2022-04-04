package com.arthur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Character> path = new ArrayList<>();
    public static Character[][] labyrinth;
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<Integer, Long> myMap = new HashMap<>();
    public static void main(String[] args) {
	// Calling of Exercise 1
        int[] arr = {1, 2, 3, 4};
        int[] arr2 = {-1,0,1};
        System.out.println("Sum array recursive:");
        System.out.println(sum(arr,arr.length-1));
        System.out.println(sum(arr2,arr2.length-1));
        System.out.println("------------------------------");
        //Calling of Exercise 2
        printFigure(5);
        printFigure(8);
        System.out.println("------------------------------");
        //Calling of Exercise 3
        arr = new int[3];
        arr2 = new int[5];
        generateVector(arr,0);
        generateVector(arr2,0);
        System.out.println("------------------------------");
        //Calling of Exercise 4
        System.out.println("Factorial of 5 ="+factorial(5));
        System.out.println("Factorial of 7 ="+factorial(7));

        //Calling of Exercise 5
        //createLabyrinth();
        //System.out.println(isInBounds(-1,-1));
       // findPaths(0,0,'O');
        //Calling of Exercise 6
        NQueen myQueen = new NQueen();
        myQueen.test(0);
        System.out.println("There is "+myQueen.count+ " solutions");
        myMap.put(0,0l);
        myMap.put(1,1l);
        System.out.println("Nhap so fibonacci thu n de tinh toan");
        int n = sc.nextInt();
        System.out.println("So fibonacci thu "+n +" la:"+ getFibonacci(n));

    }

    /**
     * It will take as arguments the input array and the current index.
     * @param array: input array
     * @param numbers: the current index
     * @return return the sum of the number
     */
    public static int sum(int[] array, int numbers){
        if (numbers==0) return array[0];
        return sum(array,numbers-1)+array[numbers];
    }

    /**
     * Exercise 2: Print figure as described
     * @param n the number to of line figure
     */
    public static void printFigure(int n){
        if (n==0){
          return;
        }
        printLineOfChars('*',n);
        printFigure(n-1);
        printLineOfChars('#',n);
    }

    private static void printLineOfChars(char c, int n) {
        for (int i=0;i<n;i++){
            System.out.print(c);
        }
        System.out.println();
    }

    /**
     *
     * @param vector our vector
     * @param index current index
     */
    public static void generateVector(int [] vector, int index){
        if  (index==vector.length){
            for (int i=0;i<vector.length;i++){
                System.out.print(vector[i]);
            }
            System.out.println();
        }else {
            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generateVector(vector, index + 1);
            }
        }

    }

    /**
     *
     * @param n the input for calculate factorial
     * @return the factorial of n
     */
        public static int factorial(int n){
            if (n<0) throw new IllegalStateException("n can not be negative");
            if (n==0||n==1) return 1;
            return n*factorial(n-1);
    }

    public static void findPaths(int row, int col, char direction){
            if (!isInBounds(row, col)){
                return;
            }
            path.add(direction);
            if (isExit(row,col)){
                printPath();
            }else if(!isVisited(row,col) && isFree(row,col)){
                mark(row,col);
                findPaths(row,col+1,'R');
                findPaths(row+1,col,'D');
                findPaths(row,col-1,'L');
                findPaths(row-1,col,'U');
                unMark(row,col);
            }
            path.remove(path.size()-1);
    }

    private static boolean isFree(int row, int col) {
            return labyrinth[row][col]=='-';
    }

    private static boolean isVisited(int row, int col) {
            return labyrinth[row][col]=='x';
    }

    private static void mark(int row, int col) {
            labyrinth[row][col] = 'x';
    }
    private static void unMark(int row, int col) {
        labyrinth[row][col] = '-';
    }

    private static void printPath() {
            for (int i=1;i<path.size();i++){
                System.out.print(path.get(i));
            }
            System.out.println();
    }

    private static boolean isExit(int row, int col) {
            return labyrinth[row][col] =='e';
    }

    private static boolean isInBounds(int row, int col) {
            if (row<0||col<0||row>=labyrinth.length||col>=labyrinth[0].length) {
                return false;
            }
            return true;
    }
    private static void createLabyrinth(){
        int row = Integer.parseInt(sc.nextLine());
        int col = Integer.parseInt(sc.nextLine());
        labyrinth = new Character[row][col];
        for (int i=0;i<row;i++){
            String line = sc.nextLine();
            for (int j=0;j<col;j++){
                labyrinth[i][j] = line.charAt(j);
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(labyrinth[i][j]);
            }
            System.out.println();
        }
    }
    public static long getFibonacci(int n){
            if (myMap.containsKey(n)){
                return myMap.get(n);
            }
            long value = getFibonacci(n-1)+getFibonacci(n-2);
            myMap.put(n,value);
            return value;
    }
}
