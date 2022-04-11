/*1. You are given a number n.
2. You are given a digit d.
3. You are required to calculate the frequency of digit d in number n. */
package DSA.functions;

import java.util.Scanner;

public class digitfrequency {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequncy(n,d);
        System.out.println(f);

    }
    public static int getDigitFrequncy (int n,int d){
        int counter = 0; // initialize digit counter to 0
        while(n>0){
            int dig = n%10;// Extract Digits
            n=n/10;// Divide N by 10
            if (dig == d){// Logic Applied
                counter++;
            }
        }
        return counter;

        }

}
