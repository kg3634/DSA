/*1. You are given a number following certain constraints.
2. The key constraint is if the number is 5 digits long, it'll contain all the digits from 1 to 5 without 
missing any and without repeating any. e.g. 23415 is a 5 digit long number containing all digits from 1 to 5 
without missing and repeating any digit from 1 to 5.Take a look at few other valid numbers - 624135, 81456273 
etc.Here are a few invalid numbers - 139, 7421357 etc.
3. The inverse of a number is defined as the number created by interchanging the face value and index of digits 
of number.e.g. for 426135 (reading from right to left, 5 is in place 1, 3 is in place 2, 1 is in place 3, 6 is 
in place 4, 2 is in place 5 and 4 is in place 6), the inverse will be 416253 (reading from right to left, 3 is 
in place 1, 5 is in place 2,2 is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6) More examples 
- inverse of 2134 is 1243 and inverse of 24153 is 24153    
4. Take as input number "n", assume that the number will follow constraints.
5. Print it's inverse.
 */

package DSA.functions.problemsbasics;

import java.util.Scanner;

public class customInverse {
    
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int position = 1; //original position
        int invert = 0 ; // interted no at the start
        while (n> 0){
           int digit = n%10; // last digit of orginal no.
           n=n/10; // reduce last digit
           // To form any number like 123 = 1*10^2 + 2*10^1 + 3*10^0 [digit * 10^(position -1)]
           // flip digit and position for original number and make inverted number with below formula
           invert = invert + position * (int) Math.pow(10,digit - 1);
           position ++;

        }
        System.out.println(invert);
        
    }
}
