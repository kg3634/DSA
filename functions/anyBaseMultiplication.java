/*1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to multiply n1 and n2 and print the value.
Constraints:2 <= b <= 10,0 <= n1 <= 10000,0 <= n2 <= 10000 */
package DSA.functions;

import java.util.Scanner;

public class anyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in); 
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int multiplication = getMultiplication(b,n1,n2);
        System.out.println(multiplication);
    }
    //moduler approach anyBaseMultiModuler.png
    //example anyBaseMultiExample.png
    //detailed approch anyBaseMultiDeatiled.png
    public static int getMultiplication(int b, int n1,int n2){
        int rv =0;
        int p=1;
        while(n1>0){

            int rem=n1%10;
            n1=n1/10;
            int sprd = getProductWithSingleDigit(b, rem, n2);//multiply single digit of n1 to whole n2
            rv=anyBaseAddition.getAddition(b, rv, sprd*p);// while adding we have to shift by one place as well
            p=p*10;
        }
        return rv;
    }
    // first multiply from single digit to whole number.
    public static int getProductWithSingleDigit(int b,int n1rem, int n2){
        int rv =0;
        int p =1;
        int carry=0;
        while (n2>0|| carry >0){
            int rem = n2%10;
            int d = rem*n1rem+carry;// check this one as did mistake here
            n2=n2/10;
            int dig = d%b;
            carry = d/b;
            rv+=dig*p;
            p=p*10;

        }

        return rv;
    }
   
}
