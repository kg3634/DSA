/*1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

Assumption - number represented by a2 is greater. */
package DSA.functions;

import java.util.Scanner;

public class diffOfTwoArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int [] a1 = new int[n1];
        for(int i=0;i<a1.length;i++){
            a1[i]=scn.nextInt();
        }

        int n2 = scn.nextInt();
        int [] a2 = new int[n2];
        for(int i=0;i<a2.length;i++){
            a2[i]=scn.nextInt();
        }

        int [] diff = new int[n2];
        int b = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        int k = j;

        while(k>=0){
            int d = - b;
            // applied int d = d2 - d1 - b substraction logic in array
            if (j>=0){
                d += a2[j];
            }

            if(i>=0){
                d -= a1[i];
            }

            if(d<0){
                b = 1;
                d+=10;
            }
            else{
                b=0;
            }
            diff[k] = d;
            i--;
            j--;
            k--;

        }
        // logic to ignore prior zeros
        int idx = 0;
        // this loop will ignore initial zero values and will increase index value
        while(idx < diff.length){
            if(diff[idx] == 0){
                idx++;
            }
            else{
                break;
            }
        }
        //below loop will print value from increased index 

        while(idx < diff.length){
            System.out.println(diff[idx]);
            idx++;// is per dhyan dena h ,otherwise infinite loop h jyega
        }
        
    }
    
}
