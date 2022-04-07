package DSA;

import java.util.Scanner;

public class Loops {
    public static void main (String[] args) {

        /*valid loop
        int i = 10;
        for( ;i <= 10; ){
            System.out.println(i);
        i++;
        }*/
        
        /*do while executes atleast once
        int i = 1; 
        do{
        System.out.println(i);
        i++;
        }while(i <= 10);*/

        /* while loop
        int i = 1;
        while(i <= 10)
            {
            System.out.println(i);
            i++;
            }*/

        //taking input
        //NOTE: when int and string input are taken simultaneously Integer.parseInt() is used for int)
        //for only int input nextInt() can be used.
        //"nextInt()" method does not read the newline character of our input
        //,so when the "nextLine()" command is issued, the scanner object finds the new line character 
        //and gives you that as output.    
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        String name = scn.nextLine();
        for (int i=0;i<=n;i++){
            System.out.println("Please "+name+" find number given as "+i);
        }


    }
}
