/*1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.

Constraints
0 < str.length <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class countABCSubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int a =0;
        int ab =0;
        int abc =0;
        //logic:images\countABCSubsequences.png
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if( ch == 'a'){
                a = 2*a +1;//aa'(a e sath aye)+a'(a ke sath na aye)+a'(single aye)
            }else if(ch == 'b'){
                ab = 2*ab + a;//abb'+ab+alla*b'
            }else if(ch == 'c'){
                abc = 2*abc + ab;//abcc'+abc + allb*c'
            }
        }

        System.out.println(abc);
    }
    
}
/*Sample Input

abcabc

Sample Output
7 */
