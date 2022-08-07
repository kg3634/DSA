package DSA.DynamicProgramming;

import java.util.Scanner;

/*1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again 
                  and again.

Constraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10 */
public class unboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        for(int i =0;i<vals.length;i++){
            vals[i] = scn.nextInt();
        }
        for(int i =0;i<wts.length;i++){
            wts[i] = scn.nextInt();
        }            
        int cap = scn.nextInt();

        int [] dp = new int[cap+1];
        dp[0] = 0;
        /*Logic:unboundedKnapsack.png: here you can apply both coin combination and permutation 
        as we are calulating sum */        
        for(int bagc=1;bagc<=cap;bagc++){
            int max = 0;
            for(int i =0;i<n;i++){
                if(bagc >= wts[i]){
                    int rbagc = bagc - wts[i];//remaining bag cap
                    int rbagv = dp[rbagc];//remaining bag value
                    int tbagv = rbagv + vals[i];//total bag value
                    if(tbagv > max){
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }

        System.out.println(dp[cap]);
    }
    
}
/*Sample Input

5
15 14 10 45 30
2 5 1 3 4
7

Sample Output
100 */