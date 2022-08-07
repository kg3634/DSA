/*1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). 
Make sure to not print duplicates (a2 may have same value present many times).

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n) */
package DSA.HashmapandHeap;

import java.util.HashMap;
import java.util.Scanner;

public class getCommonElement1 {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);

        int n1 = scn.nextInt();
        int [] a1 = new int[n1];
        for(int i =0;i<a1.length;i++){
            a1[i] = scn.nextInt();
        }
    
        int n2 = scn.nextInt();
        int [] a2 = new int[n2];
        for(int i =0;i<a2.length;i++){
            a2[i] = scn.nextInt();
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        //creating freuqncy map for a1
        for(int val:a1){
            if(hm.containsKey(val)){
                int of = hm.get(val);
                int nf = of+1;
                hm.put(val,nf);
            }else{
                hm.put(val,1);
            }
        }

        //comparing val of a2 from hashmap and printing and then removing value so that it does not repeat
        for(int val:a2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
    }
    
}
/*Sample Input

9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5

Sample Output
9
0
3
5
8 */
