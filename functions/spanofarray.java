/*Array Theory
1)When we just write this:- ( int arr[]; ), It only creates a variable in the stack and has value null by default.array1.png
2)aftre that,we allocate memory like this:- arr = new int[5];array2.png
3)when we do operations like:arr[0] = 10,arr[3]= 40;arr -> 4000. so arr[0] is 0 integer away from 4000.arr[3] represents the 4012 memory block. 
Which is the 4th block. array3.png
4) 3 implications are given below
a) performance -  arr[500]=7, arr[700]=7 - Both will take the same time because in both cases we know the exact memory location. 
b) Assignment: int arr [] one = new int[2];
one [0]=10;
one[1]=20
int [] two = one;
two [1] = 30; 
both one and two will print 10,30;
NOTE:Heap will only allocate new memory space only if you use the new keyword. Otherwise, a simple shallow copy will take place.
c) Functions: When we pass arrays as a parameter to a function only shallow copy takes place. And if any changes occur inside 
the function then the changes will be reflected everywhere. 
*/

/*Question:1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.
Constraints:1 <= n <= 10^4,0 <= n1, n2 .. n elements <= 10 ^9 */

package DSA.functions;

import java.util.Scanner;

public class spanOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        // to find max and min just suppose first num as max or min and compare it with all

        int max = arr[0];
        int min = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]> max){
                max = arr[i];
            }
            if (arr[i]< min){
                min = arr[i];
            }
        }
        System.out.println(max-min);

    }
    
}
