/*1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, 
rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for negative value of k. 
Also k can have an absolute value larger than number of digits in n.
2. Take as input n and k.
3. Print the rotated number.
4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
   n = 12340056,k = 3,r = 05612340 */

package DSA.functions.problemsbasics;

import java.util.Scanner;

public class rotateImp {
    
    public static void main(String[] args) {


        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        // logic example: for 562984, k =2, ans is 845629 is calc by 84*10000(muliplier)+5629(quotient)
        // for -ve values like k = -5, just use k = -5 + 6(no of digit) = 1
        // for big values like k = 10987; use k = k % 6 = 1
        //Find out the div and mul; div is 10^k, mul is 10^(power value is calcuated by unroatetd parts no of digit)
        /*int mulcount = 0;
        int div = (int)Math.pow(10, k);
        int rem = n % div; //rorated part
        int q = n / div; // unrotated part
        int temp = q;
        //unrotated part count
        while (temp > 0 ) {
          temp = temp / 10;
          mulcount++;
        }
        int mul = (int)Math.pow(10, mulcount);
        
        int finalnum =  rem * mul + q;
    
        System.out.println(finalnum);*/

        //Optimised code
        int nod = 0;  //number of digits
        int temp = n; //temporarily storing number to perform division
        while (temp != 0)
        {
            temp /= 10;
            nod++;
        }

        k = k % nod;  // to deal with k values > nod
        if (k < 0) // to check if k is negative
        {
            k = k + nod; // to accomodate -k cases
        }

        int div = 1;  //initialize divisor = 1
        int mult = 1; //initialize multiplier = 1

        for (int i = 1; i <= nod; i++)
        {
            if (i <= k) //while the iterator is less than k
            { //we increase the value of divisor
            div *= 10;
            }
            else         //or else we increase the value of multiplier
            {
            mult *= 10;
            }
        }

        int quo = n / div;    // extracting the quotient
        int rem = n % div;    // extracting the remainder

        int r = rem * mult + quo; //forming the rotated number
        System.out.println(r);
        

        
    }
}
