/*1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' 
(1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used 
to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10
0 <= m <= 10 */
package DSA.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //also: images/getMazePathsAlgo.png, Logic:images/getMazePaths.png
        //base case
        if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if(sc < dc){//upto right wall
            hpaths = getMazePaths(sr, sc+1, dr, dc);
        }
        if(sr < dr){//upto bottom wall
            vpaths = getMazePaths(sr+1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();
        for (String hpath: hpaths){//adding h to hpaths faith
            paths.add('h'+hpath);
        }
        for (String vpath: vpaths){//adding v to vpaths faith
            paths.add('v'+vpath);
        }        
        return paths;
    }

}
/*Sample Input

3
3

Sample Output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh] */