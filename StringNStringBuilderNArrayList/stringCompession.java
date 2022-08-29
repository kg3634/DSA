/*1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive duplicates of characters are 
   replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are 
   replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".

Constraints
1 <= length of string <= 1000 */
package DSA.StringNStringBuilderNArrayList;

import java.util.*;

public class stringCompession {

	public static String compression1(String str){
        String s = str.charAt(0) + "";//need to add " " to convirt char to str
        for( int i = 1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr!=prev){
                s+=curr;
            }
        }

		return s;
	}

	public static String compression2(String str){
        /*Logic:images/stringCompression.png: initialise s with0th char and loop from 1 to e
        if curr == prev, then increase count,other wise add count in string(if c >1),reset it to 1  and 
        then add curr string */
        String s = str.charAt(0) +"";
        int count = 1;
        for(int i =1;i<str.length();i++){
            char curr = str.charAt(i) ;
            char prev = str.charAt(i-1);
            if( curr == prev){
                count++;
            }else{//1 ko print ni karna h
                if(count > 1){
                    s+=count;
                    count =1;
                }
                s+=curr;//ye dhyan rakhna h,ye har case mn add karna h not in if condition
            }
        }
        if(count > 1){//end count ko add karne ke liye
            s+=count;
            count =1;
        }

		return s;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
        scn.close();
	}

}
/*Sample Input

wwwwaaadexxxxxx

Sample Output
wadex
w4a3dex6 */