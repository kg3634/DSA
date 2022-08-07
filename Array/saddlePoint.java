/*1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
2. You are required to find the saddle price of the given matrix and print the saddle price. 
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.

Constraints
1 <= n <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9 */
package DSA.Array;

import java.util.Scanner;

public class saddlePoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [][] arr = new int[n][n];

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        for(int i =0;i<arr.length;i++){//checking row wise
            //first check: in each row ,will check smallest  value of column
            int svj =0;//suppose smallest value of column
            for(int j =0;j<arr[0].length ;j++){//column are varying
                if(arr[i][j] < arr[j][svj]){
                    svj = j;
                }
            }

            //second check, so now we got svj, will check in all row if any value is greater than svj
            boolean flag = true;
            for(int k =0;k<arr.length;k++){//rows are varying,svj is fixed
                if(arr[k][svj] > arr[i][svj]){//mistake in index--please analyse
                    flag = false;
                }
            }

            if(flag ==true){
                System.out.println(arr[i][svj]);
                return;
            }
        }

        System.out.println("Invalid input");
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
41 */