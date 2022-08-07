/*1. You are given a string str. 2. Complete the body of getSS function - without changing signature - to calculate all 
subsequences of str. Use sample input and output to take idea about subsequences. Note -> The online judge can't force 
you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. 
The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= str.length <= 20 */
package DSA.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getSubSequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        //size calculate: array list ==> .size() and String ==> .length()
        //at index: AL == > get(i) and Str ==> charAt(i); 
        System.out.println(res);

    }

    //Logic:images/getSubSequence.png
    //bc -> [--, -c, b-, bc]
    //abc -> [---, --c, -b-, -bc, a--, a-c, ab-, abc] ==> adding - and a in bc
    public static ArrayList<String> gss(String str) {
        //In base returninig size(1) of arryaList = [""] with empty str as for empty str 1 subsequence is emty str itself. 
        //like indentity in if we add "" in any string , it does not affect it like in 2^0 there is no multiple of two but value is 1 not zero
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);//a
        String ros = str.substring(1);//bc
        //substring(1,5)==> does not include 5 th index
        ArrayList<String> rres = gss(ros);//[--, -c, b-, bc]

        ArrayList<String> mres = new ArrayList<>();//my result

        //add "-" in myarrayList
        for(String var: rres){//traversal of Str
            mres.add(""+var);
        }

        //add "a" in myarrayList
        for(String var: rres){
            mres.add(ch + var);
        }
        return mres;
    }

}
/*Sample Input

abc

Sample Output
[, c, b, bc, a, ac, ab, abc] */