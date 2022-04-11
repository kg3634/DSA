/*1. You are given a number n.
2. You are given a base b1. n is a number on base b.
3. You are given another base b2.
4. You are required to convert the number n of base b1 to a number in base b2. */
package DSA.functions;

import java.util.Scanner;

public class any2any {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase= scn.nextInt();
        int num = getAnyToAny(n,sourceBase,destBase);
        System.out.println(num);
    }


    public static int getAnyToAny(int n , int sourceBase, int destBase){
        int decNum = getAnytoDec(n,sourceBase);// first convirt to any to dec
        int finalnum = getDectoAny(decNum,destBase);// then dec to any
        return finalnum;

    } 
    public static int getAnytoDec(int n, int sourceBase){

        int bnum =0;
        int p =1;
        while(n>0){
            int rem = n%10;
            n=n/10;
            bnum+=rem*p;
            p=p*sourceBase;
        }

        return bnum;
    }
    public static int getDectoAny(int numInDec, int destBase){

        int bnum =0;
        int p =1;
        while(numInDec>0){
            int rem = numInDec%destBase;
            numInDec=numInDec/destBase;
            bnum+=rem*p;
            p=p*10;
        }

        return bnum;
    }

    
}
