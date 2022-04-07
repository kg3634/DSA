/* 1. You've to print all prime numbers between a range. 
2. Take as input "low", the lower limit of range.
3. Take as input "high", the higher limit of range.
4. For the range print all the primes numbers between low and high (both included).
Input Format: low  high
Output Format: n1 n2
.. all primes between low and high (both included)
Constraints: 2 <= low < high < 10 ^ 6 */
package DSA.problemsbasics;

import java.util.Scanner;

public class primeInRange {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        
        for (int i=low; i <= high; i++ ){
            int div = 2;
            while (div * div <= i){
                if (i % div == 0){
                    break;
                }
                div++;
            }
            
            if (div * div > i){
                System.out.println(i);
            }
        }
    }
}
