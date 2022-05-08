/*1. You are given a number n.
2. You are given a base b1. n is a number on base b.
3. You are given another base b2.
4. You are required to convert the number n of base b1 to a number in base b2. */
package DSA.functions;

import java.util.Scanner;

public class anyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase= scn.nextInt();
        int num = getAnyToAny(n,sourceBase,destBase);
        System.out.println(num);
    }


    public static int getAnyToAny(int n , int sourceBase, int destBase){
        int decNum = anyBaseToDecimal.getValueIndecimal(n,sourceBase);// first convirt to any to dec
        int finalnum = decimalToAnyBase.getValueInBase(decNum,destBase);// then dec to any
        return finalnum;

    } 
}
