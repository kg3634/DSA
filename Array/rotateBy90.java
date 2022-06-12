/*1. You are given a number n, representing the number of rows and number of columns.
2. You are given n*n numbers, representing elements of 2d array a.
3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*

Constraints
1 <= n <= 10^2
-10^9 <= e1, e2, .. n * n elements <= 10^9 */
package DSA.Array;

import java.util.Scanner;

public class rotateBy90 {
    public static void main(String[] args) {
        //square matrix of n*n
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        int [][] arr = new int[n][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j <arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        //transpose
        for(int i = 0;i<arr.length;i++){
            for(int j =i;j<arr[0].length;j++){//j=i means first half of triangle ,if we take full then it will transpose 
                //2 times
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse of each row
        for(int i = 0;i< arr.length;i++){
            int li = 0;//left index
            int ri = arr.length - 1;//right index

            while(li < ri){ //swap only in half way
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }

        display(arr);
    }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }    
}
/*Sample Input

4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44

Sample Output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14 */