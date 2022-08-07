/*1. You are given a string str.
2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
Use sample input and output to take idea about permutations.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= str.length <= 7
 */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class printPermutations {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str, "");

    }

    public static void printPermutations(String ques, String asf) {
        //Logic:images/printPermutations.png
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i = 0;i< ques.length();i++){
            char ch = ques.charAt(i);
            String lqpart = ques.substring(0,i);//would provide upto i-1 string
            String rqpart = ques.substring(i+1);
            String roq = lqpart + rqpart;//rest of question
            printPermutations(roq, asf+ch);
        }
    }

}
/*Sample Input

abc

Sample Output
abc
acb
bac
bca
cab
cba */