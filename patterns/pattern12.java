// pattern12.png
package DSA.patterns;

import java.util.Scanner;

public class pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int a =0;
        int b =1;
        for (int i=1;i<= n ;i ++){
            for (int j=1;j<= i;j++){ // prints fibonacci
                System.out.print(a+"\t");
                int c = a+b;
                a=b;
                b=c;

            }


            System.out.println();
        }
        
    }
    
}
