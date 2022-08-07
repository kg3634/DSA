/*1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a 
mobile phone. 2. The following list is the key to characters map 0 -> .; 1 -> abc 2 -> def 3 -> ghi 4 -> jkl 5 -> mno 6 -> pqrs 7 -> 
tu 8 -> vwx 9 -> yz 3. Complete the body of printKPC function - without changing signature - to print the list of all words that 
could be produced by the keys in str. Use sample input and output to take idea about output. Note -> The online judge can't force 
you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. 
The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= str.length <= 10 str contains numbers only */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class printKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str,"");

    }
    
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};

    public static void printKPC(String str, String asf) {
        //Logic:images/printKPC.png
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);

        String codeforch = codes[ch -'0'];

        for(int i=0;i<codeforch.length();i++){
            char cho = codeforch.charAt(i);
            printKPC(roq, asf+cho);
        }
    }

}
/*Sample Input

78

Sample Output
tv
tw
tx
uv
uw
ux */