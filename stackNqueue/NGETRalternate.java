import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGETRalternate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int [n];
        for(int i=0;i< n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int [] nge = solve(a);
        NGETR.display(nge);
              
    }

    // approach -2 : here we are starting from first element so it is left to right approach.
    // main logic code(NGETRalternate.png): we will do [-(pop)&a(answer) +(push)] and we will pass array index to stack.
    public static int[] solve(int[] arr){
        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);// pushing Ist index to stack
        for (int i=1;i<arr.length;i++){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){//pop untill stack is zero and current elem >=,here using arr[st.peek]
                int pos = st.peek();//make index as stack
                nge[pos] = arr[i];//add greater number as answer to new array
                st.pop();// pop smaller number
            }
            st.push(i);//push number
        }

        while(st.size()>0){//numbers for which no pop&answer is done, add value as -1.
            int pos =  st.peek();
            nge[pos] = -1;
            st.pop();       
        }
        return nge;

    }
   
}
