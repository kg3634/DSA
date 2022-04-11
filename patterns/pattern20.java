//pattern20.png
package DSA.patterns;

import java.util.Scanner;

public class pattern20 {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // for(int i=1;i<=n;i++){

        //     for(int j=1;j<=n;j++){

        //         if ((i<= n/2 && (j ==1 || j==n))
        //         || (i == n/2+1 && (j==1 || j==n || j==n/2+1) )
        //         || ((i> n/2+1 && i<n) &&(j ==i || j+i==n+1 || j ==1 || j==n) )
        //         || (i==n && (j==1 || j==n))){
        //             System.out.print("*\t");
        //         }
        //         else{
        //             System.out.print("\t");
        //         }
        //     }
        //     System.out.println();
        // }

        // optimised approach
        for (int i = 1; i <= n; i++)
        {
          for (int j = 1; j <= n; j++)
          {
            if ( j == 1 || j == n) //if first or last column
            {
              System.out.print("*	");
            }
            else if (i > n / 2 && (i == j || i + j == n + 1)) // part of either diagonal below middle row
            {
              System.out.print("*	");
            }
            else
            {
              System.out.print("	");
            }
          }
          System.out.println();
        }
    }
    
}
