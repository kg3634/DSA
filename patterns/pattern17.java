//pattern17.png
package DSA.patterns;

import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        // pattern17logic.png
        int sp = n/2;
        int st =1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=sp;j++){
                if (i == (sp+1)){ // for middle row print start in place of space
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }                

            }
  
            for (int j=1;j<=st;j++){
                System.out.print("*\t");
            }
            if (i<=n/2){
                st++;
            }
            else{
                st--;
            }

            System.out.println();
        }

        
    }
    
}
