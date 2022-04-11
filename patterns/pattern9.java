//pattern9.png
package DSA.patterns;

import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        for (int i=1;i<= n ; i++){ //decides the number of rows for output printing

            for (int j=1;j<=n;j++){ //prints the stars in the row
    
                if (i +j == n+1 || i == j){ //when row number == column number
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        
    }
    
}
