//pattern3.png
package DSA.patterns;

import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // write ur code here
        // we have to print 4space,1* 3space,2* 2space,3* and so on....
        int n = scn.nextInt();
        int temp = n;
        for(int i=1;i <=n;i++){
            for (int k=1; k< temp;k++){// loop for printing space will start from (temp-1)
                System.out.print("\t");
            }
            temp--;
            for (int j=1;j<=i;j++){// loop for print *
                System.out.print("*\t");
            }
            
            System.out.println();

        }

        // alternate approach
        // int sp = n - 1, st = 1; // sp = spaces ; st = stars
        // for (int i = 1; i <= n; i++)
        // {
        //   for (int j = 1; j <= sp; j++) // runs till the number of spaces on particular line
        //   {
        //     System.out.print("\t");  //prints the number of spaces required on the line
        //   }
        //   for (int j = 1; j <= st; j++) // runs till the number of stars on particular line
        //   {
        //     System.out.print("*\t"); //prints the number of stars required on the line
        //   }
        //   sp--;                      //decrementing the spaces by 1 for next line
        //   st++;                      //incrementing the stars by 1 for next line
        //   System.out.println();      //Adding new line for output on console
        // }
        
        
    }
    
}
