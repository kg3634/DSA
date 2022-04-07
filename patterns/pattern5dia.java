// pattern5dia.png
package DSA.patterns;

import java.util.Scanner;

public class pattern5dia {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // pattern 
        // 2sp 2=n/2      1* 
        // 1sp -1         3* +2
        // 0sp -1         5* +2     n/2
        // 1sp +1         3* -2
        // 2sp +1         1* -2
        int sp = n/2;
        int st = 1;
        for (int i=1;i<= n;i++){

            for (int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            for (int k =1;k<=st;k++){
                System.out.print("*\t");
            }
            System.out.println();

            if (i <=n/2){
                sp--;
                st+=2;
            }
            else {
                sp++;
                st-=2;
            }
        }
        
    }
    
}
