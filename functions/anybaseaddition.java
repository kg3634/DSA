/*1. You are given a base b. 2. You are given two numbers n1 and n2 of base b. 3. 
You are required to add the two numbes and print their value in base b.
Constraints:2 <= b <= 10 0 <= n1 <= 256 0 <= n2 <= 256 */
package DSA.functions;

import java.util.Scanner;

public class anybaseaddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int addition = getaddition(b,n1,n2);
        System.out.println(addition);
       
    }

    public static int getaddition(int b,int n1, int n2){
        while(n1>0 && n2>0){
            int rem1 = n1%b;
            int rem2 = n2%b;
            if (rem1+rem2 < b){
    
            }
        }


        return addition;
    }
    
}
