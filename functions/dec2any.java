/*1. You are given a decimal number n.
2. You are given a base b.
3. You are required to convert the number n into its corresponding value in base b. */
package DSA.functions;

import java.util.Scanner;

public class dec2any {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int bnum = getValueInBase(n,b);
        System.out.println(bnum);
        
    }

    public static int getValueInBase(int n,int b){
        // jis base mn jana hota h usse divide krte h and multiply jis base ko convirt kar re h usse
        // example (57)b10 = (111001)b2 is calculate as 57%2 and 57/2..till no >0
        // new base num = 1strem*10^0 + 2ndrem*10^1 + ...
        // why of logic dec2anywhy.png
        int bnum =0;
        int p = 1;
        while(n>0){
            int rem = n%b;//calculate remainder
            n=n/b;// num ko chota kar re
            bnum += rem*p;// base number form kar re
            p=p*10;//muliplier is increase by base for each iteration
        }
        return bnum;
    }


    
}
