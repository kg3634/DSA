/*1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.Sample Input 3,Sample Output
*	
*	*   
*   *   *                 
*/

package DSA.patterns;

import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // abstraction concept when we are thinking about outer for loop, we dont worry about inner for loop
        for (int i=1 ; i <= n; i++){
            for (int j =1 ; j<=i;j++){ // loop printing i no of *
                System.out.print("*\t");// \t for tab
            }
            System.out.println();// for next line
        }
                
    }
    
}
