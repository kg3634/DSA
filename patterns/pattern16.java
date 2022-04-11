//pattern16.png
package DSA.patterns;

import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        // check this first pattern16hint.png
        int sp = 2*n - 3;
        int st = 1;//  controls how many num
        for (int i=1;i<=n;i++){
            int cval =1 ;
            for (int j=1;j<= st;j++){ // prints first half num
                System.out.print(cval+"\t");
                cval++;
            }
            for (int k=1;k<=sp;k++){ // prints middle space
                System.out.print("\t");
            }
            if (i==n){ // 1 num less in last row
                st--; 
                cval--;
            }
            for (int l=1;l<= st;l++){// prints last num
                cval--;
                System.out.print(cval+"\t");
            }

            sp-=2;
            st++;
            System.out.println();
        }
    }


    }
    
