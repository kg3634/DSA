/*Tower Of Hanoi

1. There are 3 towers. Tower 1 has n disks, where n is a positive number. Tower 2 and 3 are empty. 2. The disks are increasingly 
placed in terms of size such that the smallest disk is on top and largest disk is at bottom. 3. You are required to 3.1. 
Print the instructions to move the disks. 3.2. from tower 1 to tower 2 using tower 3 3.3. following the rules 3.3.1 move 1 disk at 
a time. 3.3.2 never place a smaller disk under a larger disk. 3.3.3 you can only move a disk at the top. Note -> The online judge 
can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. 
The purpose of the question is to aid learning recursion and not test you.


Constraints
0 <= n <= 9 10 <= n1, n2, n3 <= 10^9 n1 != n2 != n3 */
package DSA.Recursion;

import java.util.Scanner;

public class towerOfHanoi {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1d = scn.nextInt();
        int t2d = scn.nextInt();
        int t3d = scn.nextInt();
        toh(n,t1d,t2d,t3d);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n ==0){
            return;
        }
        /*Logic:images/toh.png
        leftcall
        1[10 -> 11]
        2[10 -> 12]
        1[11 -> 12]

        3[10 -> 11] -- in area

        right call
        1[12 -> 10]
        2[12 -> 11]
        1[10 -> 11]  
        faith that below code will print the instructions to move n-1 disks from t1 to t3 using t2(*)*/
        toh(n-1,t1id,t3id,t2id);//left call 
        System.out.println(n+"["+t1id+" -> "+ t2id+"]");//this is in area and will provide instruction to move from t1 to t2
        toh(n-1,t3id,t2id,t1id);//right call 
    }

}

/*Sample Input

3
10
11
12

Sample Output
1[10 -> 11]
2[10 -> 12]
1[11 -> 12]
3[10 -> 11]
1[12 -> 10]
2[12 -> 11]
1[10 -> 11] */