/*1. You are given an array(arr) of distinct integers and a target. 2. You have to print all the pairs having their sum equal to 
the target.
Constraints
1 <= N <= 10000 -10^9<= arr[i] <= 10^9 */
package DSA.TimeandSpace;

import java.util.*;

public class targetSumPair1 {

  public static void targetSumPair(int[] arr, int target){
    /*Logic:images/targetSumPair1.png: sort it , tc will be nlogn, then just create left index and right index
    and sum and change accordignly: after thsi we will get pairs with all rules follow(smallest first and in a1b1,a2b2 pair
    a1 < a2)*/
    Arrays.sort(arr);//nlog(n)
    int li = 0;
    int ri = arr.length -1;
    while(li < ri){
        if(arr[li] + arr[ri] > target){
            ri--;
        }else if(arr[li] + arr[ri] < target){
            li++;
        }else{
            System.out.println(arr[li]+", "+arr[ri]);
            li++;
            ri--;
        }
    }

  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
    scn.close();
  }

}
/*Sample Input

12
9 
-48 
100 
43 
84 
74 
86 
34 
-37 
60 
-29 
44
160

Sample Output
60, 100
74, 86 */