// pattern11.png
package DSA.patterns;

import java.util.Scanner;

public class pattern11 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 1;
        for (int i=1;i<= n; i++){

            for (int j =1;j<= i;j++){

                System.out.print(count + "\t");
                count++;
            }


            System.out.println();
        }
        
        
    }
    
}
