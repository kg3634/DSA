/*. You are given a number n.
2. You are given a base b. n is a number on base b.
3. You are required to convert the number n into its corresponding value in decimal number system. */
package DSA.functions;

import java.util.Scanner;

public class anyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
     }

     public static int getValueIndecimal(int n,int b){
        int bnum =0;
        int p = 1;
        while (n>0){
            int rem = n%10;// % by jisme convirt karna h
            n=n/10;// 
            bnum+=rem*p;
            p=p*b;// multiply by jsko convirt karna h

        }
        return bnum;
     }
}
    
