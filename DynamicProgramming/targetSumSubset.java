/*1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class targetSumSubset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        
        //create 2d array of row = arr.size+1 ,col = tar+1
        boolean [][] dp = new boolean [n+1][tar+1];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                //i tak ke run use krke j run banane h
                //divide in 4 parts : 1st cell,1row,1col and rest
                if(i==0&&j==0){
                    dp[i][j] = true;//for 0 true
                }else if(i==0){
                    dp[i][j] = false;//0 ko use karke o ke alawa kuch ni bana sakte
                }else if(j==0){//sabhi ko use karke 0 bana sakte h 
                    dp[i][j] = true;
                }else{
                    if(dp[i-1][j] == true){//immediate uper wala true then true(means )
                        dp[i][j] = true;
                    }else{
                        int val = arr[i-1];//if arr index is 0 and then dp row index is 1
                        if(j>= val){//j score jo bana h at least run se jayda hona chahiye
                            if(dp[i-1][j-val]==true){
                                dp[i][j] = true;
                            }
                        } 
                    }
                }
            }
        }

        System.out.println(dp[arr.length][tar]);
    }
    
}
/*Sample Input

5
4
2
7
1
3
10

Sample Output
true */