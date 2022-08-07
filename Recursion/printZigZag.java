/*1. Here are a few sets of inputs and outputs for your reference
Input1 -> 1
Output1 -> 1 1 1

Input2 -> 2
Output2 -> 2 1 1 1 2 1 1 1 2

Input2 -> 3
Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

2. Figure out the pattern and complete the recursive function pzz to achieve the above for any positive number n.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 10
question is for understanding pre, in and post area of tree 
 */
package DSA.Recursion;

import java.util.Scanner;

public class printZigZag {
    public static void main(String[] args) {
        

        /*Analysis:images/zigzag.png
         Pre are < left call and right call
         left call < in area < right call
         left call and right call < post area
        */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);        

    }
    public static void pzz(int n){
        if(n ==0){
            return;
        }

        System.out.print(n+ " ");//pre area
        pzz(n-1);//left call
        System.out.print(n+" ");//in area
        pzz(n-1);//right call
        System.out.print(n+" ");//post area
        
    }
}
/*Sample Input

3

Sample Output
3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3 */