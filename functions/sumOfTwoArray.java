/*1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays.Constraints:1 <= n1, n2 <= 100,0 <= a1[i], a2[i] < 10 */
package DSA.functions;

import java.util.Scanner;

public class sumOfTwoArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Ist array input
        int n1 = scn.nextInt();
        int [] a1 = new int[n1];
        for (int i=0;i< a1.length;i++){
            a1[i]= scn.nextInt();
        }

        //IInd arr input
        int n2 = scn.nextInt();
        int [] a2 = new int[n2];
        for (int i=0;i< a2.length;i++){
            a2[i]= scn.nextInt();
        }

        // create new arr with max of(n1,n2) length
        int [] sum = new int[n1 > n2?n1:n2];//tertiary operator - check once
        // logic sumOfArrayLogic.png
        int c =0;
        int i = a1.length -1;
        int j = a2.length -1;
        int k = sum.length -1;

        while (k>=0){
            int d = c;// adding carry to digit
            if (i>=0){
                d+=a1[i];// adding first array element
            }
            if(j>=0){
                d+=a2[j];//adding 2nd array element
            }
            //proceed for actual kth digit
            c=d/10;
            d=d%10;
            sum[k] = d;
            i--;
            j--;
            k--;

        }
        // if k becomes zero but carry is still there like 999 +28=1027, so handle the case below
        if (c !=0){
            System.out.println(c);
        }

        for(int val:sum){
            System.out.println(val);

        }
    }
}
