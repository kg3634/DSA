/*1. You are given an ArrayList of positive integers. 2. You have to remove prime numbers from the given 
ArrayList and return the updated ArrayList. Note -> The order of elements should remain same.


Constraints
1 <= N <= 10000 */
package DSA.StringNStringBuilderNArrayList;

import java.util.*;

public class removePrimesArrayList {

    public static Boolean isPrime(int val){
        for(int div =2;div*div<=val;div++){
            if(val%div == 0){
                return false;
            }
        }

        return true;
    }

	public static void solution(ArrayList<Integer> al){
		/*Logic: we will use reverse loop as if we use nomal loop then after removing value ,index
        will get shifted and we wil miss some values, but in reverse, shifted values we have already checked
         */

        for(int i =al.size() - 1;i>=0;i--){
            int val = al.get(i);
            if(isPrime(val)){
                al.remove(i);//index not value
            }
        } 
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
        scn.close();
	}

}
/*Sample Input

4
3 12 13 15

Sample Output
[12, 15] */