/*1. You are given a string. 2. You have to print all permutations of the given string iteratively.


Constraints
1 <= length of string <= 15 */
package DSA.StringNStringBuilderNArrayList;

import java.util.*;

public class permutationOfStringIterative {

	public static void solution(String str){
        /*Logic:images/permutationOfStringIterative.png: calclate fact of(str.length()): for abc it is !3 = 6
        for 0 to 5,each value needs to be div by 3(str.length()),2,1 ==>,for each cal quotient(/) and remainder(%)
        r is the index which needs to be printed and then deleted. for 2, q is new divisor, cal new q and new r  
         */
		
        int n = str.length();//3
        int f = factorial(n);//6
        
        for(int i =0;i<f;i++){//0 to 5
            StringBuilder sb = new StringBuilder(str);//for each i new str and 
            //as deletion also needs to be done
            int temp = i;// preserving i
            for( int div = n;div >=1;div --){
                int q = temp/div;
                int r = temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            
            System.out.println();

        }
	}

    public static int factorial(int n ){
        int val = 1;
        for( int i =2;i<=n;i++){
            val*=i;
        }
        return val;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
        scn.close();
	}

}

/*Sample Input

abc

Sample Output
abc
bac
cab
acb
bca
cba */