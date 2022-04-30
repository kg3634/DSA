import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given a number n, representing the size of array a. 2. You are given n numbers, 
representing the height of bars in a bar chart. 3. You are required to find and print the area 
of largest rectangle in the histogram. e.g. for the array [6 2 5 4 5 1 6] -> 12
Constraints:0 <= n < 20 0 <= a[i] <= 10 */
public class largesthistarea {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        // logic(largesthistarea.png): we will find right boundary(nse on right) and left boundary(nse on left)
        // area = array value * width(rb - lb - 1), for no nse on right,ans = a.length and on left ans = -1
        // If a.length = 7,then width= 7 - (-1) - 1 = 7
        int [] rb = new int [a.length];// nse index on the right
        // right to left approch, as here only index is needed so in stack index will be pushed
        Stack <Integer> st = new Stack<>();
        st.push(a.length - 1);
        rb[a.length - 1 ] = a.length;//for last element no nse on right, so setting it to a.length
        for(int i=a.length -2;i>=0;i--){
            while(st.size()>0 && a[i] <= a[st.peek()]){// pop untill current element is greater to stack top
                // euqual wale ko bhi pop karana hoga that is why =
                st.pop();
            }
            if(st.size() == 0){// if no element in stack , means no nse on right
                rb[i] = a.length;
            }else{
                rb[i] = st.peek();//answer will be stack peek which will be next smallest to right 
            }
            st.push(i);
        }
        //finding left boundary
        int [] lb = new int [a.length];//nse index on the left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i=1;i< a.length;i++){
            while(st.size()>0 && a[i] <= a[st.peek()]){
                st.pop();
            }
            if(st.size() == 0 ){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();            
            }
            st.push(i);
        }

        int maxArea =0;
        for(int i=0;i< a.length;i++){
            int width = rb[i] - lb[i]  - 1;
            int area = a[i] * width;
            if (area > maxArea){
                maxArea = area;
            }
        }

        System.out.println(maxArea);
     }
    
}
