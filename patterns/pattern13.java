// pattern13.png
package DSA.patterns;

import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //pattern13rowcolumn.png
        // The output shows symmetry in the elements it prints. First and last entry on each row is '1'. 
        // We know that nc0 = 1 = ncn.
        for (int i=1;i <=n;i++){ // (0 < i <n) == (1<i<=n) 
            int icj = 1;
            for (int j =1;j<=i;j++){// 0<j <=i because for each row, the number of columns is one more than row number
                System.out.print(icj+"\t");
                int icjp1 = (icj * (i-j))/(j+1);//formula to print next column  5C1 with the use of previous column 5C0 
                icj = icjp1;

            }
            System.out.println();
        }
        
    }
    
}
