/*1. You are required to display the prime factorization of a number.
    2. Take as input a number n.
    3. Print all its prime factors from smallest to largest.*/
package DSA.functions.problemsbasics;

import java.util.Scanner;

public class primFactor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // we can optimize this code as we know from finding prime numbers, 
        // that we do not need to iterate the loop till n. Rather, iterating till sqrt(n) or conditioning div*div
        //It is not possible for p > sqrt(n) and q > sqrt(n) at the same time, and we make use of this fact.
        // dividing no from 2 to sqrt(n) assuming there is no factor beyond it, but there can be max one factor 
        //beyond it which is being handled in if 
        for (int div = 2; div * div <= n; div++)
        {
          while (n % div == 0)// untill it divides with number
          {
            System.out.print(div + " ");
            n = n / div;
          }
        }
        if (n != 1) // for 46, n will be 23 after div which is also a prime factor, so handling case when n !=1 or
        // div is beying sqrt(n)
        {
          System.out.print(n);
        }
    }
    
}
