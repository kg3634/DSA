/*1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000 */
package DSA.DynamicProgramming;
import java.io.*;
import java.util.*;
public class minCostInMazeTravel {
    public static void main(String[] args) {
        //Logic:images/minCostInMazeTravel.png
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] maze = new int[n][m];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                maze[i][j] = scn.nextInt();
            }
        }

        int [][] dp = new int[n][m];//maze size dp 2d array, each cell would contain minimum cost from this cell to last cell.

        for(int i = maze.length -1;i>=0;i--){//choti problem last cell mn h isliye ulta travel karnege
            for(int j = maze[0].length -1;j>=0;j--){
                //now we have divided probmr in 4 area given below
                if(i == dp.length -1 && j == dp.length -1){//last cell
                    dp[i][j] = maze[i][j];//same cost as arr
                }else if (i == dp.length -1){//last row
                    dp[i][j] = dp[i][j+1] + maze[i][j];//can only move h, so adding next cell in h direction  + maze cell cost 
                }else if (j == dp.length -1){//last column
                    dp[i][j] = dp[i+1][j] + maze[i][j];//can only move v, so adding next cell in v direction  + maze cell cost                     
                }else{//rest
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + maze[i][j];//need to take min for next (h and v direction cell)                    
                }
            }

        }

        System.out.println(dp[0][0]);
    }
}
/*Sample Input

6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output
23 */