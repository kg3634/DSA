/*1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.

Constraints
1 <= M <= 100000
1 <= N <= 50000
1 <= Pi <= M
1 <= Ri <= 100
1 <= T */
package DSA.DynamicProgramming;

import java.util.Scanner;

import DSA.HashmapandHeap.writeHashmap.HashMap;
public class highwayBillboard{
    public static int solution1(int m , int[] x, int[] rev, int t) {
        /*Logic1 TC(n*n), space(n): images/highwayBillboard1.png: this approach is based on num. of boards
        dp[i] = max till i-1 boards + rev[i];then cal overall max of all dps as last value wont be max in 
        all cases*/
        int ans =0;
        int [] dp = new int[x.length];//meaning of dp[3]: agar 4th board lagana jaruri h to waha tak max kitne 
        //reveue h
        dp[0] = rev[0];
        for(int i=1;i<x.length;i++){
            int max = 0;
            for(int j =0;j<i;j++){//cheking all values till i-1
                int dist = x[i] - x[j];//x contains position of boards,so helping in cal dis bw boards
                if(dist > t){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] =max + rev[i];//cal max of previous board and add current rev
            ans = Math.max(ans,dp[i]);//ans needs to update to find max of overall, as it is not mandatory that 
            //last element of dp would be max value
        }
        return ans;
    }

    public static int solution2(int m , int[] x, int[] rev, int t) throws Exception{
        /*Logic: Tc(no of miles),SC(no of miles): images/highwaybillboard2.png: based on number of miles 
         hashmap mn board position:reveue ka map bana lo,dp m+1 ki create hogi:
         agar koi board ni h then previous value ,other wise 2 condition:
         a) board ko install na kare- previous value ans b) board ko install kare: ans dp[i-t-1]+0(t miles 
         tak 0board) + current board revenew from hashmap       
        */
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<x.length;i++){//created map [board position:revenue] 
            map.put(x[i],rev[i]);
        }
        int [] dp = new int[m+1];
        dp[0] = 0;
        for(int i=1;i<=m;i++){//make sure i==m included
            if(map.containsKey(i) == false){
                dp[i] = dp[i-1];//last value
            }else{//either install board or not, take max of both condition
                int boardNotInstalled = dp[i-1];//last value
                int boardInstalled = map.get(i);
                if(i>=t+1){//if less value ,then will throw exception no use of ging back value which does ot exist
                    boardInstalled +=dp[i-t-1];//dp[i-t-1]+0(t miles tak 0board) + map.get(i)
                }
                dp[i] = Math.max(boardInstalled,boardNotInstalled);
            }
        }

        return dp[m];
        
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args) throws Exception{
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        // System.out.println(solution1(m, x, revenue, t));//TC(n*n),SC(n)
        System.out.println(solution2(m, x, revenue, t));//TC(m),SC(m)

        scn.close();
    }
}
/*Sample Input

20
5
6 7 12 14 15
5 8 5 3 1
5

Sample Output
11 */