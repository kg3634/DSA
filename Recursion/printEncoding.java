/*1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
 Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you. */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class printEncoding {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");

    }

    public static void printEncodings(String qsn,String asf) {
        if(qsn.length()==0){
            System.out.println(asf);
            return;
        }else if(qsn.length() == 1){
            char ch = qsn.charAt(0);
            if( ch == '0'){//we have to return on 0 value
                return;
            }else {//here convirting ch(of number) to int and extracting corresponding code and adding it to answer
                int chv = ch - '0';
                char code = (char) ('a' +chv -1);//forming codes: as a is start from 1 thats why substracting 1
                System.out.println(asf+code);
            }
        }else{//if length is more than 1
            /*for first digit  and first 2 digits would be considered as a options */
            //first digit
            char ch = qsn.charAt(0);
            String roq = qsn.substring(1);
            if(ch == '0'){
                return;
            }else {
                int chv = ch - '0';
                char code = (char)('a' +chv -1);
                printEncodings(roq, asf+code);
            }
            //first two digits
            String ch12 = qsn.substring(0,2);
            String roq12 = qsn.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <=26){
                char code12 = (char) ('a'+ch12v-1);
                printEncodings(roq12, asf+code12);                 
            }
  

        }
        
    }

}
/*Sample Input

655196

Sample Output
feeaif
feesf */