/*1. You are given a number n.
2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10 */
package DSA.Recursion;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(factorial(n));

    }
    
    //Logic:images/factorial.png
    public static int factorial(int n){
        if(n==1){
            return 1;
        }

        int fnm1 = factorial(n-1);
        int fact = n * fnm1;
        return fact;
    }
    
}
