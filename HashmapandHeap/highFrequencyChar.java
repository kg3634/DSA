/*1. You are given a string str.
2. You are required to find the character with maximum frequency.

Constraints
0 < str.length() <= 100
There will be a single character with highest frequency */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class highFrequencyChar {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        //creating hashmap like a-2, b -3,....
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch);//old frequency
                int nf = of +1;//new frequency
                hm.put(ch,nf);
            }else{
                hm.put(ch,1);
            }
        }

        char mfc = str.charAt(0);//doing mistake here-- supposing first string char as maximum frequency char
        for(Character key:hm.keySet()){
            if(hm.get(key) > hm.get(mfc)){  
                mfc = key;
            }
        }
        System.out.println(mfc);
    }

}
/*Sample Input

zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc

Sample Output
q */