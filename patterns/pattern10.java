//pattern10.png
//logic
// Outerspace  Innerspace 
// 2s           0s (if taken as -1)   
// 1s           1s +2                 
// 0s           3s +2                 
// 1s           1s -2                 
// 2s           0s
// for star put condition on first and last line
package DSA.patterns;

import java.util.Scanner;

public class pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ol = n/2;//outer spacing = half of n
        int il = -1;//same as 0; not to print anything
        for (int i=1; i <= n;i++){
            for (int j=1;j<= ol;j++){//print outer spaces
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int k=1;k <= il;k++){
                System.out.print("\t");
            }
            if (i <=n/2){
                ol--;
                il+=2;
            }
            else{
                ol++;
                il-=2;
            }
            //now we address the special condition
            //as we print only a single star on the first
            //and last row without any inner space
            if (i >1 && i< n){//if the current row is neither first or last
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
    
}
