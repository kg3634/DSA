// 1. You are given a number n.
// 2. You've to write code to print it's multiplication table up to 10 in format given below. 
// print table as pattern14.png
package DSA.patterns;

import java.util.Scanner;

public class pattern14 {
    public static void main(String[] args) {

        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        for (int i =1; i <=10;i++){
            System.out.print(n+" * "+i+" = "+n*i);
            System.out.println();

        }
        
    }
    
}
