/*1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
e1, e2, .. n * m elements belongs to the set (0, 1) */
package DSA.Array;

import java.util.Scanner;

public class exitPointOfMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
    
        int [][] arr = new int[m][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j <arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int dir = 0;//E - 0, S -1, W -2, N -3
        int i =0;
        int j =0;
        //Logicimages/exitPointOfMatrix.png
        while(true){
            dir = (dir + arr[i][j])%4;//main line

            if(dir ==0){//east
                i++;
            }else if (dir == 1){//south
                j++;
            }else if (dir == 2){//west
                i--;
            }else if (dir == 3){//north
                j--;
            }

            //below 4 condition could be exit point

            if(i < 0){
                i++;//as we have to print last row/colm before exit
                break;
            }else if (j < 0){
                j++;
                break;
            }else if (i == arr.length){
                i--;
                break;
            }else if (j == arr[0].length){
                j--;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);
        
    }
    
}
/*Sample Input

4
4
0
0
1
0
1
0
0
0
0
0
0
0
1
0
1
0

Sample Output
1
3 */