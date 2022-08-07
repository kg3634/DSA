/*1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a 
mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by 
the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.                 

Constraints
0 <= str.length <= 10
str contains numbers only */
package DSA.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getKeypadCombination {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = getKPC(str);
        System.out.println(res);
    }

    //define global array of string for keys
    static String [] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        //Logic:images/getKeypadCombination.png
        /*solution for adding " " in arraylist is that " " will make the size of arraylist as 1 and the inner loop 
        for(String rstr : rres) will run once for every character ( lets say abc for case of integer 2). 
        Now if we did not add " " then the inner loop will never run and hence the size of arraylist will remain zero, 
        final output will always be a zero size empty arraylist. */
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);//6
        String ros = str.substring(1);//78
        ArrayList<String> rres = getKPC(ros);//["tv", "tw", "tx", "uv", "uw", "ux"]

        ArrayList<String> mres = new ArrayList<>();
        String codeforch = codes[ch - '0'];//to get actual number from char,substract '0' char or 48 number 
        //"pqrs"

        for(int i =0;i<codeforch.length();i++){//loog through all char of ch to addin with rres arrayList elem
            char chcode = codeforch.charAt(i);
            for(String var:rres){
                mres.add(chcode+var);
            }  

        }
        return mres;
        
    }


    
}
/*Sample Input

78

Sample Output
[tv, tw, tx, uv, uw, ux] */