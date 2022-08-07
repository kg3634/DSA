/*1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically 
(as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to 
move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10
0 <= m <= 10 */
package DSA.Recursion;

import java.io.*;
import java.util.*;

public class getMazePathWithJumps {

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
        if(sr == dr && sc == dc){
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }
        //base logic:images/getMazePathJumps.png
        ArrayList<String> paths = new ArrayList<>();

        for(int ms =1;ms<= dc -sc;ms++){//move size for horizontal moves
            ArrayList<String> hpaths = getMazePaths(sr, sc+ms, dr, dc);
            for(String hpath:hpaths){
                paths.add("h"+ms+hpath);//apply double quotes as "" is String and '' is char
            }
        }

        for(int ms =1;ms<= dr -sr;ms++){//move size for vertical moves
            ArrayList<String> vpaths = getMazePaths(sr+ms, sc, dr, dc);
            for(String vpath:vpaths){
                paths.add("v"+ms+vpath);
            }
        }

        for(int ms =1;ms<= dr -sr && ms<=dc-sc;ms++){//move size for diagonal moves,condition is for both column and row as dono ke
            //bhar ja sakta h
            ArrayList<String> vpaths = getMazePaths(sr+ms, sc+ms, dr, dc);
            for(String vpath:vpaths){
                paths.add("d"+ms+vpath);
            }
        }        

        return paths;
    }

}
/*Sample Input

2
2

Sample Output
[h1v1, v1h1, d1] */