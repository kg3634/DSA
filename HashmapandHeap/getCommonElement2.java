/*1. You are given a number n1, representing the size of array a1. 2. You are given n1 numbers, representing elements of array a1. 
3. You are given a number n2, representing the size of array a2. 4. You are given n2 numbers, representing elements of array a2. 
5. You are required to find the intersection of a1 and a2. To get an idea check the example below: 
if a1 -> 1 1 2 2 2 3 5 and a2 -> 1 1 1 2 2 4 5 intersection is -> 1 1 2 2 5 Note -> Don't assume the arrays to be sorted. 
Check out the question video.


Constraints
1 <= n1, n2 <= 100 0 <= a1[i], a2[i] < 10 Time complexity should be O(n) */
package DSA.HashmapandHeap;

import java.util.HashMap;
import java.util.Scanner;

public class getCommonElement2 {
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

        //need to print all common elements
        for(int val:a2){
            if(hm.containsKey(val) && hm.get(val) > 0){
                System.out.println(val);
                //reduce frequency by 1
                int of = hm.get(val);
                int nf = of-1;
                hm.put(val,nf);                
            }
        }
        
    }
    
}
/*Sample Input

7
1
1
2
2
2
3
5
7
1
1
1
2
2
4
5

Sample Output
1
1
2
2
5 */