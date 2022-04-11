// pattern7.png
package DSA.patterns;

import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        // int sp = 0;
        // for (int i=1;i<= n;i++){
        //     for (int j=1;j<=sp;j++){
        //         System.out.print("\t");
           
        //     }
        //     System.out.print("*\t");
        //     sp++;

        //     System.out.println();

        // }

        // alternate approch
        for (int i = 1; i <= n; i++) //decides the number of rows for output printing
        {
          for (int j = 1; j <= n; j++) //prints the stars in the row
          {
            if (i == j)                 //when row number == column number
              System.out.print("*\t");
            else                        //when row number != column number
              System.out.print("\t");
          }
          System.out.println();   //changes the row on output console
        }
    }
    
}
