import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//cretae array with next smaller element to right: refer NGETR.java 
public class NSETR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int [n];
        for(int i=0;i< n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int [] nge = solve2(a);
        display(nge);
              
    }
    //right to left approach
    public static int[] solve(int [] arr){
        int [] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        nse[arr.length - 1] = -1; 
        st.push(arr[arr.length - 1]);
        for(int i=arr.length -2;i>=0;i--){
            while(st.size() >0 && arr[i] <= st.peek()){
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
    //left to right approach
    public static int[] solve2(int [] arr){
        int [] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
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
