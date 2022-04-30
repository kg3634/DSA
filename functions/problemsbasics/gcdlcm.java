/*1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
3. Take input "num1" and "num2" as the two numbers.
4. Print their GCD and LCM.*/
// GCD.png
// GCD2.png
package DSA.functions.problemsbasics;

import java.util.Scanner;

public class gcdlcm {

    public static void main(String[] args) {

        
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt(); 
        int n2 = scn.nextInt();
        int ogn1 = n1;
        int ogn2 = n2;
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        System.out.println(n2);
        int lcm = (ogn1*ogn2)/n2;
        System.out.println(lcm); 

    }

    
}
