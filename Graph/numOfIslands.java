/*1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.

Constraints
None */
package DSA.Graph;

import java.io.*;

public class numOfIslands {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      /*images/numOfIslands.png: using get connected concept,as we need only count, so not using comp and comps arraylist:
      we will source each cell for tree and in main fuction all condition will apply in base case itself
       */

       boolean[][] visited = new boolean[arr.length][arr[0].length];
       int count =0;
       for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if(arr[i][j] == 0 &&  visited[i][j] == false){/*if land is there and is not visited */
                drawTreeAndCountComp(arr,i,j,visited);
                count++;//counting each isand
            }
        }
       }
       System.out.println(count);
   }

   public static void drawTreeAndCountComp(int[][] arr,int i,int j ,boolean[][] visited){
        //putting all condition in base case itself
        if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j] == 1||visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        drawTreeAndCountComp(arr, i-1, j, visited);//call in north
        drawTreeAndCountComp(arr, i, j-1, visited);//east
        drawTreeAndCountComp(arr, i, j+1, visited);//west
        drawTreeAndCountComp(arr, i+1, j, visited);//south
   } 
}
/*Sample Input

8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Sample Output
3 */