package com.arthur;

public class NQueen {
    public static final int NUMBER = 8;
    public boolean[] col, leftDiagonal,rightDiagonal;
    public boolean[][] board;
    public int count;
    NQueen(){
        col = new boolean[NUMBER];
        leftDiagonal = new boolean[2*NUMBER-1];
        rightDiagonal = new boolean[2*NUMBER-1];
        board = new boolean[NUMBER][NUMBER];
        count =0;
        init();
    }
    private void init(){
        for (int i=0;i<col.length;i++){
            col[i]= true;
        }
        for (int j=0;j<leftDiagonal.length;j++){
            leftDiagonal[j] = true;
            rightDiagonal[j] = true;
        }
    }
    public void printSolution(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if(!board[i][j]){
                    System.out.print('-');
                }else{
                    System.out.print('*');
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void test(int i){
        for (int j=0;j<board.length;j++){
            if (isFree(i,j)){
                board[i][j]=true;
                col[j]=leftDiagonal[j-i+board.length-1]=rightDiagonal[i+j]=false;
                if (i== board.length-1){
                    printSolution();
                    count++;
                }else{
                    test(i+1);
                }
                board[i][j]=false;
                col[j]=leftDiagonal[j-i+board.length-1]=rightDiagonal[i+j]=true;

            }
        }
    }

    private boolean isFree(int i, int j) {
        return col[j]&&leftDiagonal[j-i+board.length-1]&&rightDiagonal[i+j];
    }
}