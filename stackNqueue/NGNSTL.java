import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Next greater element and next smallet element to left : for reference check NGETR.java 
public class NGNSTL {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int [n];
        for(int i=0;i< n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int [] nge = solve4(a); // change the function for coorecponding output
        display(nge);
              
    }

    // next greater element to left : right to left appraoch becomes left to right
    public static int [] solve(int [] arr){
        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        nge[0] = -1;
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if (st.size()>0){
                nge[i] = st.peek();
            }else{
                nge[i] = -1;
            }
            st.push(arr[i]);
        }

        return nge;
    }

    // next greater element to left: left to right appraoch becomes right to left
    public static int [] solve2(int [] arr){
        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        for(int i=arr.length -2;i>=0;i--){
            while(st.size() >0 && arr[i] >= arr[st.peek()]){
                int pos = st.peek();
                nge[pos]= arr[i];
                st.pop();
            }
            st.push(i);                
        }        
        
        while(st.size()>0){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }
        return nge;
    }

    // next smaller element to left: approach 1
    public static int [] solve3(int [] arr){
        int [] nse = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        nse[0] = -1;
        for(int i=1;i< arr.length;i++){
            while(st.size()> 0 && arr[i] <= st.peek()){
                st.pop();
            }
            if(st.size()>0){
                nse[i] = st.peek();
            }else{
                nse[i] = -1;
            }
            st.push(arr[i]);
        }
        return nse;
    }

    // next smaller element to left: approach 2
    public static int [] solve4(int [] arr){
        int [] nse = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length -1);
        for(int i=arr.length -2;i>=0;i--){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                int pos = st.peek();
                nse[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size()>0){
            int pos = st.peek();
            nse[pos] = -1;
            st.pop();
        }
        return nse;
    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        
        for(int val: a){
            sb.append(val +"\n");
        }
        System.out.println(sb);
    }
    
}
