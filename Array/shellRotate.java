/*You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m 
numbers representing the elements of the matrix.
You will be given a ring number 's' representing the ring of the matrix. For details, 
refer to imageimages/shellRotateQuestion.png. You will be given a number 'r' representing number of rotations in an 
anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.
Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
0 < s <= min(n, m) / 2
-10^9 <= r <= 10^9*/
package DSA.Array;

import java.util.*;

public class shellRotate {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int [][] arr = new int[n][m];

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int r = scn.nextInt();

        rotateShell(arr,s,r);
        display(arr);
    }

    public static void rotateShell(int arr[][],int s ,int r){
        //3 steps: get oned from shell, rotate it and then again get shell from oned
        int [] oned = fillOnedFromShell(arr,s);
        rotateOned(oned,r);
        fillShellFromOned(arr,s,oned);
    }

    //spiral like logic
    public static int [] fillOnedFromShell(int arr [][],int s){
        //Logic:images/shellSize.png: check size from image
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        //shell size calculation: lw + bw + rw + tw - 4(for duplicate corners)
        //can be written as 2(lw)+2(tw) - 4
        int sz = 2*(maxr - minr + 1) + 2*(maxc - minc +1) - 4;

        int [] oned = new int[sz];

        int idx =0;

        //left wall
        for(int i=minr,j=minc;i<=maxr;i++){//equal condition shoudl be there ,did mistake here
            oned[idx] = arr[i][j];
            idx++;
        }

        //bottom wall
        for(int i=maxr,j=minc +1;j<=maxc;j++){//j will start from minc +1 to avoid duplicate corner 
            oned[idx] = arr[i][j];
            idx++;
        }
        
        //right wall
        for(int i=maxr -1,j=maxc;i>=minr;i--){
            oned[idx] = arr[i][j];
            idx++;
        }

        //top wall
        for(int i=minr,j=maxc -1;j>=minc + 1;j--){//j will start from max-1 and end min +1 to avoid duplicate corner
            oned[idx] = arr[i][j];
            idx++;
        }

        return oned;        
    }

    //just reverse assignment 
    public static void fillShellFromOned(int arr[][],int s,int [] oned){
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        int idx =0;
        //left wall
        for(int i=minr,j=minc;i<=maxr;i++){
            arr[i][j] = oned[idx];
            idx++;
        }

        //bottom wall
        for(int i=maxr,j=minc +1;j<=maxc;j++){ 
            arr[i][j] = oned[idx];
            idx++;
        }
        
        //right wall
        for(int i=maxr -1,j=maxc;i>=minr;i--){
            arr[i][j] = oned[idx];
            idx++;
        }

        //top wall
        for(int i=minr,j=maxc -1;j>=minc + 1;j--){
            arr[i][j] = oned[idx];
            idx++;
        }        
    } 

    //old questions
    public static void rotateOned(int [] oned,int r){
        r = r % oned.length;
        if(r<0){
            r = r + oned.length;
        }

        //reverse part1
        reverse(oned,0,oned.length -r -1);

        //p2
        reverse(oned,oned.length - r,oned.length-1);

        //whole reverse
        reverse(oned,0,oned.length -1);
    }

    public static void reverse(int [] oned, int li,int ri){
        while(li < ri){
            int temp = oned[li];
            oned[li] = oned[ri];
            oned[ri] = temp;
            li++;
            ri--;
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
/*Sample Input

5
7
11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57
2
3

Sample Output
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57 */