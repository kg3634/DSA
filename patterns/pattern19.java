//pattern19.png
package DSA.patterns;

import java.util.Scanner;

public class pattern19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        //solutionpattern19sol.png
        // for (int i =1;i<=n;i++){
        //     for (int j=1;j<=n;j++){
        //         if ((i ==1 && (j==n || j<= n/2 +1)) 
        //         || (i<= n/2+1 && (j ==n || j== n/2+1)) 
        //         || i == n/2+1 
        //         || (i > n/2+1 && (j==1 || j == n/2+1)) 
        //         || (i==n && (j >= n/2+1)))
        //         System.out.print("*\t");
        //         else{
        //             System.out.print("\t");
        //         }
        //     }

        //     System.out.println();
        // }

        // alternate neat code 
        for (int i = 1 ; i <= n; i++)
        {
          for (int j = 1 ; j <= n; j++)
          {
            if ( i == 1) //first component
            {
              if ( j == n || j <= n / 2 + 1)
              {
                System.out.print("*	");
              }
              else
              {
                System.out.print("	");
              }
            }
            else if (i <= n / 2) //second component
            {
              if ( j == n || j == n / 2 + 1)
              {
                System.out.print("*	");
              }
              else
              {
                System.out.print("	");
              }
            }
            else if ( i == n / 2 + 1) //third component
            {
              System.out.print("*	");
            }
            else if (i < n) // fourth component
            {
              if (j == 1 || j == n / 2 + 1)
              {
                System.out.print("*	");
              }
              else
              {
                System.out.print("	");
              }
            }
            else    //fifth component
            {
              if (j == 1 || j >= n / 2 + 1)
              {
                System.out.print("*	");
              }
              else
              {
                System.out.print("	");
              }
            }
          }
          System.out.println(); // changing row
        } 
    }
    
}
