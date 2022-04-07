/*1. You've to check whether a given number is prime or not.
2. Take a number "t" as input representing count of input numbers to be tested.
3. Take a number "n" as input "t" number of times.
4. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.
constraints:
1 <= t <= 10000,2 <= n < 10^9 
Sample Input: 5 13 2 3 4 5
Sample Output: prime prime prime not prime prime*/


package DSA.problemsbasics;

import java.util.Scanner;

public class prime {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        /*written by me: time complexity = [t*n]: in 3 Ghz(3* 10^9 cycles/sec) machine, 10^9 
        operations should take 1 sec. here TC = 10^4*10^9=10^13*/ 
        // int t = scn.nextInt();
        //   for (int i = 0; i < t; i++) {
        //     // int count=0 , count ++, if (count ==0) logic can be used also
        //     Boolean flag = true; 
        //     int n = scn.nextInt();
        //     for (int j = 2; j < n; j++) {
        //         if (n % j == 0) {
        //           flag = false;
        //           System.out.println("not prime");
        //           break;
        //         }
        //       }
        //       if (flag) {
        //         System.out.println("prime");
        //       }
        //    }
    
    /* Primality Test 
    100 divisors: 2 × 50, 4 × 25, 5 × 20, 10 × 10, [20 × 5, 25 × 4, 50 × 2] - repeated
    it will be divided by a number smaller than or equal to its square-root
    (or the closest integer value to it), and if it cannot be divided, 
    it can be said that the number is prime.
    In below code less TC = t*sqrt(n); and no use of flag/count */
    int t = scn.nextInt();              
    for (int i = 0; i < t; i++) {
        int n = scn.nextInt();
  
        int div = 2;
        while (div * div <= n) {
          if (n % div == 0) {
            break;
          }
          div++;
        }
        // for 12 div value is 3 goes to else as 3*3 < 12
        // for 11 div value is 4 goes to if as 4*4 > 11
        if (div * div > n) {
          System.out.println("prime");
        } else {
          System.out.println("not prime");
        }
      }
    
      }
    
}
