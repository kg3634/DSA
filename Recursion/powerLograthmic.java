//optimization of x^n
package DSA.Recursion;

import java.util.Scanner;

public class powerLograthmic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x,n));
    }

    public static int power (int x , int n){
        if(n ==0){
            return 1;
        }

        /*images/powerLograthmic.png
        TC calculation: n,n/2,n/4....1 is GP with a =n,r =1/2 ===> aofk = 1=n*(1/2)^k-1 ===> k(level) proporsional to log(base2)n.
        so TC for below code is log(n), but for normal it was n.
        example for n 1024, k would be 10*/
        int xpnb2 = power(x,n/2);
        int xn = xpnb2 * xpnb2;

        if(n%2 == 1){//if n is odd  
            xn = xn * x;
        }
        return xn;
    }
}
