/*1.You are given a number n, representing the size of array a.
2.You are given n distinct numbers, representing elements of array a.
3. You are given another number d.
4. You are required to check if d number exists in the array a and at what index (0 based). If found print the index, otherwise print -1. */
package DSA.functions;

import java.util.Scanner;

public class findelementinarray {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for (int i=0;i< arr.length;i++){
            arr[i]= scn.nextInt();
        }
        int d = scn.nextInt();
        // boolean flag = false;//no need
        int index = -1;
        for (int i=0;i<arr.length;i++){
            if (d==arr[i]){
                index = i;
                // flag = true;
                break;
            }
         }
        //  if(!flag){ // no need
        //      System.out.println("-1");
        //  }
        //  else{
        //      System.out.println(index);
        //  }
        System.out.println(index);
    }
    
}
