/*1. You are given a string. 
2. You have to print all palindromic substrings of the given string.

Constraints
1 <= length of string <= 500 */
package DSA.StringNStringBuilderNArrayList;

import java.util.*;

public class palindromString {

	public static void solution(String str){
		/*Logic:images/palindrom.png */
		for(int i=0;i<str.length();i++){
			for(int j =i+1;j<=str.length();j++){
				if(isPalindrom(str.substring(i,j))){
					System.out.println(str.substring(i,j));
				}
			}
		}
		
	}

	public static Boolean isPalindrom(String str){
		//compare first and last , and then next and so on
		int li = 0;
		int ri = str.length() -1;
		char ch1 = str.charAt(li);
		char ch2 = str.charAt(ri);

		while(li <=ri){
			if(ch1!=ch2){
				return false;
			}else {
				li++;
				ri--;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
/*Sample Input

abcc

Sample Output
a
b
c
cc
c  */