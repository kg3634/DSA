/*1. You've to display the digits of a number.
2. Take as input "n", the number for which digits have to be displayed.
3. Print the digits of the number line-wise.*/
package DSA.problemsbasics;

import java.util.Scanner;

public class PrintdigitsImp {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int temp = n; // need to reuse n 
        int dig =0;
        // count no of digits : for example for 754 is 3
        while(temp!=0){
            temp= temp/10;
            dig++;
        }
        // initial divisor = (Number Of Digits in the Number)-1
        // until the divisor becomes zero we will keep on print the quotient
        // we will reduce the number to number divided by the divisor 
        // which will also be divided by 10 each time
        int div = (int) Math.pow(10,dig-1); // Math.pow  gives float, so converting into int
        while (div!=0 ){
          int q=n/div; // q = 7,5,4
          n=n%div; // n = 54, 4
          div = div/10; // div = 10,1,0 
          System.out.println(q);
        }
        
    }
    
}
