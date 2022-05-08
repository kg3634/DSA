/*1. You are given a base b. 2. You are given two numbers n1 and n2 of base b. 3. 
You are required to add the two numbes and print their value in base b.
Constraints:2 <= b <= 10 0 <= n1 <= 256 0 <= n2 <= 256 */
package DSA.functions;

import java.util.Scanner;

public class anyBaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //anyBaseAddLogic1.png,anyBaseAddLogic2.png
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int addition = getAddition(b,n1,n2);
        System.out.println(addition);
       
    }

    public static int getAddition(int b,int n1, int n2){
        int carry = 0;
        int value = 0;
        int rv =0;
        int p = 1;
        while(n1>0 || n2>0 || carry >0){
            int rem1 = n1%10;
            n1=n1/10;
            int rem2 = n2%10;
            n2=n2/10;
            int sum = rem1+rem2+carry;
            carry = sum/b;
            value = sum%b;
            rv+=value*p;
            p=p*10;
        }

        return rv;
    }
    
}
