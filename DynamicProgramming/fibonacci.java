/*1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8

Constraints
0 <= n <= 45 */
package DSA.DynamicProgramming;

import java.io.*;
import java.util.*;
/*why DP: when in recursion trees repeated work is done in calls. 
two implementation in DP: 1)Bottom up approach or memoization in which we are memorizing the answer so that 
we dont need to make call again for same question.images/fibonacci.png
2)top down approach or tabulation: in which we are doing below things
a)storage banayenge and cell ko meaning assign karenge like storing fibonacci value for that cell
b) direction of (<>) problem : choti probem kidhar h and badi problem kidhar h: like 0 ka fibonacci easy h ya 6 ka
0 ka easy h 0 to 6 jayenge
c)travel and solve : 0 to 6 like 0,1,2,3,4,5,6
*/
public class fibonacci{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // int fibn = FibMemoization( n, new int [n+1] );//for 0 to n ,qb array size is n+1
    int fibn = FibTabulation(n);
    System.out.println(fibn);
 }

public static int Fib(int n){
    if(n == 0 || n ==1){
        return n;
    }

    int fibnm1 = Fib(n-1);
    int fibnm2 = Fib(n-2);
    int fibn = fibnm1 + fibnm2;

    return fibn;
}

//memoization method
public static int FibMemoization(int n,int [] qb){//question bank array t memorize the answer
    if(n == 0 || n ==1){
        return n;
    }

    if(qb[n] !=0){
        return qb[n];
    }
    int fibnm1 = FibMemoization(n-1,qb);
    int fibnm2 = FibMemoization(n-2,qb);
    int fibn = fibnm1 + fibnm2;
    qb[n] = fibn;//adding values in qb 
    return fibn;
}

//tabulation method
public static int FibTabulation(int n){
    int [] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}

}
/*Sample Input

10

Sample Output
55 */