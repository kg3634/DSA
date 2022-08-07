/*1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. 
Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 10 */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class nQueens {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {//row is as a level
        //Logic:images/printNQueens.png
        if(row == chess.length){
            System.out.println(qsf+".");
            return;
        }
        //part before loop is left side of node
        for(int col =0;col<chess.length;col++){//col are as a options
            if(isItaSafePlaceForQueen(chess,row,col) == true){
                chess[row][col] = 1;//left side edge- before going into recursion
                printNQueens(chess, qsf+row+"-"+col+", ", row+1);
                chess[row][col] = 0;//right side edge - going out of recursion
            }
        }
        //part after loop is right side of node
        
    }

    public static boolean isItaSafePlaceForQueen(int[][] chess,int row,int col){
        for(int i = row-1,j =col;i>=0;i--){//check upwards in same col
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row-1,j =col-1;i>=0&&j>=0;i--,j--){//check left diagonal in upward direction 
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row-1,j =col+1;i>=0&&j<chess.length;i--,j++){//check right diagonal in upward direction
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }
}
/*Sample Input

4

Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, . */