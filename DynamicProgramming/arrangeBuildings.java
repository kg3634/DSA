/*1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of 
roads.

Constraints
0 < n <= 45 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class arrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();    
        long ocb = 1;//old count zeroes
        long ocs = 1;//old count ones

        for(long i =2;i<=n;i++){
            long ncb = ocs;
            long ncs = ocs+ocb;

            ocs = ncs;
            ocb = ncb;
        }
        /*logic:images/arrangeBuildings.png: we will fill one side of road like countBinary question
        and then would square of that as on one side we can put 5 ways and same as other side so total ways =5*5
        */
        long total = ocs + ocb;
        total = total*total;
        System.out.println(total);        
    }
    
}
/*Sample Input

6

Sample Output
441 */