/*You are required to check if a given set of numbers is a valid Pythagorean triplet.
Take as input three numbers a, b and c.
Print true if they can form a Pythagorean triplet and false otherwise. */
package DSA.functions.problemsbasics;
import java.util.Scanner;

public class pythaTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int max = 1;
        int base = 1;
        int perp = 1;
        if (a > b && a > c){
            max = a;
            base = b;
            perp = c;
        }
        else if (b > c && b > a) {
            max = b;
            base = a;
            perp = c;
        }
        else {
            max =c;
            base = a;
            perp = b;
        }
        if ( (max * max) == (base * base) + (perp * perp)) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }


        
    }
    
}
