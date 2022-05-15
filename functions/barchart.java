/*1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print a bar chart representing value of arr a.
Constraints:1 <= n <= 30,0 <= n1, n2, .. n elements <= 10
Input:
A number n
n1
n2
.. n number of elements
Output
A bar chart of asteriks representing value of array a */
package DSA.functions;

import java.util.Scanner;

public class barChart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int max = arr[0];
        for (int i=1;i<arr.length;i++){
            if( arr[i] > max){
                max = arr[i];
            }

        }
        //logic barChartLogic.png 
        //outer loop upto max floor and inner loop through all element 
        //will print space and start row wise and then enter.(space for smaller building and * for greater and equal to max)
        for(int floor = max;floor>=1;floor--){// will go to max floor
            for (int i=0;i<arr.length;i++){//will run for all buildings and prints one row at a time
                if(arr[i]>= floor){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }       
    }
    
}
