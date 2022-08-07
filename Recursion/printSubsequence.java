/*1. You are given a string str.
2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= str.length <= 7 */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class printSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str,"");
    }

    public static void printSS(String qsn, String ans) {
        /*Logic:images/printSubsequence.pngSpace complexity: if we store element in arraylist then for 31 length string, 31 gb(2^(n-1)*n char) 
        space would be required in RAM but if we store it in euler form then (n+1)*n char would be used as at one time max
        n+1 levels would be there in stack and n char per level*/

        if(qsn.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = qsn.charAt(0);
        String roq = qsn.substring(1);//rest of question
        printSS(roq, ans+ch);//answer is yes
        printSS(roq, ans+"");//answer is no

    }

}
/*Sample Input

yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A */