// pattern4.png
package DSA.patterns;

import java.util.Scanner;

public class pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int star = n;
        for (int i=1; i<=n;i++){
            for (int k=1; k<i;k++){
                System.out.print("\t");
            }
            for (int j=1; j<=star;j++){
                System.out.print("*\t");
            }
            star--;
            System.out.println();
        }
        
    }
    
}
