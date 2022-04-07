// pattern6.png
// pattern
// 3(n/2+1)*  1s     3*
// 2* -1      3s +2  2*
// 1* -1      5s +2  1*  n/2
// 2* +1      3s -2  2*
// 3* +1      1s -2  3*
package DSA.patterns;

import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int st = n/2 + 1;
        int sp = 1;
        for (int i=1;i<= n ; i++){
            for (int j=1;j <= st;j++){
                System.out.print("*\t");
            }

            for(int k=1;k<=sp;k++){
                System.out.print("\t");
            }

            for (int l=1;l <= st;l++){
                System.out.print("*\t");
            }


            if (i <= n/2){
                sp+=2;
                st--;
            }
            else{
                sp-=2;
                st++;
            }

            System.out.println();
        }

    }
    
}
