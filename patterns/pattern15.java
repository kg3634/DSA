//pattern15.png
package DSA.patterns;

import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        // step by step solve like this pattern15steps.png
        int sp = n/2;
        int star = 1;
        int num = 1;
        for (int i=1; i<=n;i++){
            for (int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            int numrow = num;
            for (int k=1;k<=star;k++){
                System.out.print(numrow+"\t");
                if (k<= star/2){ // controls colums
                    numrow++;
                }
                else{
                    numrow--;
                }
            }
            if (i <=n/2){ // controls rows
                sp--;
                star+=2;
                num++;
            }
            else {
                sp++;
                star-=2;
                num--;

            }

            System.out.println();
        } 
    }
    
}
