/*1. You are given a number n and a number k separated by a space, representing the number of houses and number 
of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with 
one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any 
consecutive house with same color.

Constraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class paintHouseManyColors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();//no of houses
        int k = scn.nextInt();//no of colors
        int [][] arr = new int[n][k];//row houses,col-color

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        /*Tc(n*n*n):images/paintHousemanyColors.png 
        dp[4][3] - 5 ghar tak paint karne ka min cost 5th ghar per 4th paint karna jaruri ho(rule follow krte hue)
        like mincostadjques ,dp[il[j] = last row mn other colors ka min + arr[i][j]
        final ans = last row ka min        
        

        long[][] dp = new long[n][k];
        for(int j=0;j<k;j++){//fill 1st row as it is
            dp[0][j] = arr[0][j];
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<k;j++){
                long min = Integer.MAX_VALUE;
                for(int c=0;c<k;c++){//making loop in last row and skipping same colum elem(color)
                    if(c!=j){
                        min = Math.min(dp[i-1][c],min);
                    }
                }
                dp[i][j] = arr[i][j] + min;            
            }
        }
        long min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){//min of last row
            min = Math.min(dp[n-1][i],min);
        }

        System.out.println(min);*/
        /*TC(n*n):Logic:images/paintHouseManyColors2.png: least and seond least nikal lo har row ka phle hi
        then previous ke least ke equal to dp[i][j]+sleast, otherwise dp[i][j]+ least
        */

        int [][] dp = new int[n][k];
        //first row ke least and slst cal:
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            dp[0][j] = arr[0][j];
            //standard code for least and sleast
            if(arr[0][j]<= least){
                sleast = least;
                least = arr[0][j];
            }else if(arr[0][j]<= sleast){
                sleast = arr[0][j];
            }
        }

        for(int i=1;i<n;i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for(int j =0;j<k;j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = arr[i][j]+ sleast;
                }else{
                    dp[i][j] = arr[i][j] + least;
                }

                //calc new least and new sleast for next row

                if(dp[i][j]<= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }else if(dp[i][j]<= nsleast){
                    nsleast = dp[i][j];
                }                
            }

            //store least for next row
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);

    }
    
}
/*Sample Input

4 3
1 5 7
5 8 4
3 2 9
1 2 4

Sample Output
8 */