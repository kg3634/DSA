/*1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subsets of arr. Each subset should be
on separate line. For more clarity check out sample input and output.

Constraints
1 <= n <= 10
0 <= n1, n2, .. n elements <= 10^3 */
package DSA.functions;

import java.io.*;
import java.util.*;

public class subsetArray{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    //Logic:images/subsetArray.png
    //loop will run 0 to 2^arr.length ,convert each number to binary and then print arr[] val when 1 , print - when 0
    int limit = (int)Math.pow(2,arr.length);

    for(int i=0;i<limit;i++){//loop will run 0 to 2^arr.length
        int temp =i;
        String set = "";
        for(int j = arr.length - 1;j>=0;j--){//reverse loop because in binary first remainder will form last digit
            //convert binary main logic
            int r = temp%2;
            temp = temp/2;
            if(r ==0){//remainder 0 then print -
                set = "-\t"+set;//we are printing from last and we have to make --30 not 30--
            }else{
                set = arr[j] +"\t"+set;
            }

        }
        System.out.println(set);
    }
 }

}
/*Sample Input

3
10
20
30

Sample Output
-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
10	20	30 */