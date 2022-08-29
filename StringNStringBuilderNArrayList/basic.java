package DSA.StringNStringBuilderNArrayList;

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // String s1 = "hello";//s1 per stack mn 4k address, in heap on 4k address "hello" is there
        // String s2 = scn.nextLine();//scn.next() take input upto space
        // String s3 = scn.nextLine();
        // System.out.println(s1);
        // System.out.println(s2);
        // System.out.println(s3);

        // String s = scn.nextLine();
        // System.out.println(s);
        // System.out.println(s.length());//in array length is datamember but here it is a function

        //s.charAt(0) = 'z';//wont work: cant replace in string

        /*print all substring:images/basic.png
        String s = "abcd";
        for(int i=0;i<s.length();i++){//0 to 3
            for(int j =i+1;j<=s.length();j++){//0 to 4
                System.out.println(s.substring(i,j));
            }
        }*/

        // String s = "hello";
        // s+=' ';
        // s+='w';//can add char like this
        // s+='o';
        // s+=10;//this will be converted in to string
        // String s2 = "world";
        // String s3 = s+" "+s2;
        // System.out.println(s3);
        // System.out.println("hello"+10+20);//will evaluate from left to right,so will convirt into string hello1020

        String s = "abc def ghi jkl mno";
        String [] parts = s.split(" ");
        for(int i=0;i<parts.length;i++){//here parts is array, so using datamember length, not function
            System.out.println(parts[i]);
        }

    }
    
}
