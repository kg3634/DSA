/*1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to subtract n1 from n2 and print the value.
Constraints:2 <= b <= 10,0 <= n1 <= 256,n1 <= n2 <= 256 */
package DSA.functions;

import java.util.Scanner;

public class anyBaseSubstraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); 
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int substraction = getSubstration(b,n1,n2);
        System.out.println(substraction);
       
    }
    //anyBaseSubtractLogic1.png,anyBaseSubstractLogic2.png
    public static int getSubstration(int b,int n1,int n2){
        int rv = 0;
        int carry = 0;
        int sub = 0;
        int p =1;
        while(n2>0){// only big number check is enough
            int rem1 = n2%10;
            n2=n2/10;
            int rem2 = n1%10;
            n1=n1/10;
            rem1 = rem1 +carry;// important line as removes extra variables
            if (rem1 <rem2){
                sub = rem1+b - rem2;
                carry = -1;
            }
            else{
                sub = rem1 - rem2;
                carry = 0;
            }
            rv+=sub*p;
            p=p*10;
        }

        return rv;

    }

    // alternate clean code
    public static int getDifference(int b, int n1, int n2) {
        int rv = 0;
     
        int c = 0;
        int p = 1;
        while (n2 > 0) {
          int d1 = n1 % 10;
          int d2 = n2 % 10;
          n1 = n1 / 10;
          n2 = n2 / 10;
     
          int d = d2 - d1 - c;// optimised important line
     
          if (d < 0) {
            c = 1;
            d += b;
          } else {
            c = 0;
          }
     
          rv += d * p;
          p = p * 10;
        }
        return rv;
      }

    
}
