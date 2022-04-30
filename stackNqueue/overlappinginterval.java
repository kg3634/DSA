import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.

Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100 */
public class overlappinginterval {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];

        for(int i =0; i< n;i++){
            String line = br.readLine();
            arr[i][0]= Integer.parseInt(line.split(" ")[0]);//reading start time at input
            arr[i][1]= Integer.parseInt(line.split(" ")[1]);//reading end time at input

        }

        mergeOverlappingIntervals(arr);


        
    }

    //logic(overlapping.png): pair(start and end time) ka comparable interface ke sath class create karo
    // jisme compareTo method mn start time ke basis per sort ka code likho 
    //pair class(start and end time pairs) ki array create and initialize karni h 
    //pair ko start time ke basis per sort karo and then stack mn push karo
    //main logic: first element ko direct push , then agar ane wale element ka start time stack ke top ke end time 
    // se bada h to use push kar do ,otherwise stack ke top ke end time ko updtae kar do
    //based on max(ane wale ke endtime and top ke end time)
    // last answer ke liye fir new stack banake usme push karna padega kyuki ascending mn print karna h.
    public static void mergeOverlappingIntervals(int[][] arr){
        //merge overlapping interval and print in increasing order of start
        Pair [] pairs = new Pair[arr.length];//pair class(start and end time pairs) ki array
        for(int i=0;i<arr.length;i++){// initialize pair ki array with input given
            pairs[i] = new Pair(arr[i][0],arr[i][1]);//Pair is  parameterized constructor
        }
        
        Arrays.sort(pairs);//sort based on start time
        Stack<Pair> st = new Stack<>();//pair class ki stack
        for(int i=0;i<pairs.length;i++){
            if(i ==0){// first element ko dirct push
                st.push(pairs[i]);
            }else{
                Pair top = st.peek();

                if(pairs[i].st > top.et){// ane wale ka start time > top ka end time
                    st.push(pairs[i]);
                }else {//ane wale ka start time < top ka end time
                    top.et = Math.max(top.et,pairs[i].et);//update top ka endpoint
                }

            }
        }
        //new stack banake print karna h kyuki acsendeing order mn print karna h ,st mn decending order mn print hoga 
        Stack<Pair> rs = new Stack<>();
        while(st.size()>0){//new stack for ascending order
            rs.push(st.pop());
        }

        while(rs.size()>0){//print new stack which will provide pair in acsending order
            Pair p = rs.pop();
            System.out.println(p.st+" "+p.et);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        // this > other return +ve
        // this = other return 0
        // this < other return -ve
        public int compareTo(Pair other){
            if (this.st != other.st){
                return this.st - other.st;
            }else{
                return this.et - other.et;
            }

        }


    }

    
}
