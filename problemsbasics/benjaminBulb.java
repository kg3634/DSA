/*1. You are given n number of bulbs. They are all switched off. A weird fluctuation in voltage 
hits the circuit n times. In the 1st fluctuation all bulbs are toggled, in the 2nd fluctuation 
every 2nd bulb is toggled, in the 3rd fluctuation every 3rd bulb is toggled and so on. You've to 
find which bulbs will be switched on after n fluctuations.
2. Take as input a number n, representing the number of bulbs.
3. Print all the bulbs that will be on after the nth fluctuation in voltage. */
package DSA.problemsbasics;

import java.util.Scanner;

public class benjaminBulb {
    public static void main(String[] args) {

        // benjaminBulb.png
        //After 20 fluctuations, turned on bulbs are 1 4 9 16 - an odd number of fluctuations
        //All of these bulb numbers are perfect squares. If a bulb had an even number of factors,
        //then it would participate in an even number of cycles, thus, it would then keep the bulb off, reverse for odd
        // So, all perfect square numbers have odd numbers of factors given in oddfactors.png
        // we just have to print all the perfect squares up to the user input number.
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i*i <= n;i++){
            System.out.println(i*i);
        }


    }
    
}
