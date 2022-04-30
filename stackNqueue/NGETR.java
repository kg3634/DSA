import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.
"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9 */
public class NGETR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int [n];
        for(int i=0;i< n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int [] nge = solve(a);
        display(nge);
              
    }
    // approach -1 : here we are starting from last element so it is right to left approach.
    // main logic code(NGETR.png): we will do [-(pop) a(answer) +(push)]
    // TC is O(2n) = O(n), as outerloop will run max for n times(1 push for all) and while wont run for all the time
    // as it will pop elements which are pushed, so max n times it would run, that y TC is 2n which is n only. 
    public static int[] solve(int[] arr){
        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        nge[arr.length - 1] = -1;// start with last element,as no one is right to it, so -1
        st.push(arr[arr.length - 1]);// + last element (push is done for all as it will be checked for next element)
        for(int i=arr.length - 2;i>=0;i--){// reverse loop start from second last element
            while(st.size() > 0 && arr[i] >= st.peek()){// pop untill stack is zero and current element >=
                st.pop();// -
            }
            if(st.size()>0){ // a
                nge[i] = st.peek();
            }else{// means no one is greater to right
                nge[i] = -1;
            }
            st.push(arr[i]); // +
        }
        return nge;

    }
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        
        for(int val: a){
            sb.append(val +"\n");
        }
        System.out.println(sb);
    }
    
}
