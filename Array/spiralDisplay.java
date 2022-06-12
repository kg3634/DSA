/*1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a.
4. You are required to traverse and print the contents of the 2d array in form of a spiral.
Note - Please check the sample output for details.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e1, e2, .. n * m elements <= 10^9 */
package DSA.Array;

import java.util.Scanner;

public class spiralDisplay {
    public static void main(String[] args) {
        //Logic:images/spiral.png
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
    
        int [][] arr = new int[m][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j <arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;// notice -1 to avoid IndexOutOfBound
        int maxc = arr[0].length - 1;//notice -1

        int tne = m*n;//total number of element
        int cnt = 0;//to monitor count

        while(cnt < tne){
            //left wall: column fix,row increasing
            for(int i=minr,j=minc;i<=maxr&& cnt < tne;i++ ){//cne < tne is to avoid duplicate prints in case all 
                //walls are not present
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;//to avoid printing corners twice

            //bottom wall: row fix,column increasing
            for(int i=maxr,j=minc;j<=maxc && cnt < tne;j++ ){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxr--;

            //right wall: colum fix,row decreasing
            for(int i=maxr,j=maxc;i>=minr && cnt < tne;i-- ){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxc--;
            
            //top wall: row fix, column decreasing
            for(int i=minr,j=maxc;j>=minc && cnt < tne;j-- ){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minr++;//for starting printing for second round            
        }
    }
    
}
/* Sample Input

3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35

Sample Output
11
21
31
32
33
34
35
25
15
14
13
12
22
23
24 */
