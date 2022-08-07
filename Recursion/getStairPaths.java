/*1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be 
used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10 */
package DSA.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths); 

    }

    //algo:images/getStairPathAlgo.png
    //Logic:images/getStairPathogic.png
    public static ArrayList<String> getStairPaths(int n) {

        //base case for 0 and -ve value
        if(n ==0){//0 se 0 per bhi 1 path hoga hum chale hi na
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }else if (n <0){//for -ve no paths woudl be there
            ArrayList<String> bpath = new ArrayList<>();
            return bpath;
        }
        //in below recursion 2 inner areas are present
        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);

        ArrayList<String> paths = new ArrayList<>();
        //post order
        for(String val: path1){
            paths.add(1+val);
        }
        for(String val: path2){
            paths.add(2+val);
        }
        for(String val: path3){
            paths.add(3+val);
        }
        return paths;
    }

}
/*Sample Input

3

Sample Output
[111, 12, 21, 3] */