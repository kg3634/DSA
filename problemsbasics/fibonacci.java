/*1. You've to print first n fibonacci numbers.
2. Take as input "n", the count of fibonacci numbers to print.
3. Print first n fibonacci numbers.*/
package DSA.problemsbasics;

import java.util.Scanner;

public class fibonacci {

    public static void main(String[] args) {
     
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int a = 0;// first FN
      int b = 1;
      for (int i = 0; i < n;i++ ){
          // We are shifting a and b value like below and printing only a:
          // 0 1 1 2
          // a b    (b is reassined as a+b)
          //   a b 
          //     a b
          System.out.println(a);
          int c = a + b;
          a = b;
          b = c;
      }
    }
    
}
