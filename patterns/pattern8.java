// pattern8.png
package DSA.patterns;

import java.util.Scanner;

public class pattern8 {

public static void main(String[] args) {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    // int sp = n-1;
    // for (int i=1;i<= n;i++){
    //     for (int j=1;j<=sp;j++){
    //         System.out.print("\t");
       
    //     }
    //     System.out.print("*\t");
    //     sp--;

    //     System.out.println();

    // }
    

    //alternate approach, check image for i=j = n+1 pattern8diagonal.png
    for (int i=1;i<= n ; i++){ //decides the number of rows for output printing

        for (int j=1;j<=n;j++){ //prints the stars in the row

            if (i +j == n+1){ //when row number == column number
                System.out.print("*\t");
                break; // break out of the loop as star is printed  }
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }

}
    
}
