/*1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.
e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
Constraints
0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class slidingwindow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        //logic:slidingwindow.png: 
        int [] nge = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        nge[arr.length - 1] = arr.length;//check reason in next loop
        st.push(arr.length -1);
        for(int i=arr.length -2;i>=0;i--){
            //-a+
            while(st.size()>0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = arr.length;// check reason in next loop
            }else{
                nge[i] = st.peek();
            }

            st.push(i);
        }

        int j=0;
        for (int i = 0 ; i<= arr.length -k;i++){// (length - k) isliye kiya h kyuki last window mn i ,i-k tak hi jyega
            //enter the loop to find the maximum of window starting at i
            if (j < i){// ki baar j, i se chota rh jyega jab nge ni milega, tab j=i kar do 
                j=i;
            }
            while(nge[j] < i+k){ // ye loop  last nge in window per ake ruk jyega wahi j ki value ho jyegi, 
                //jiska koi nge ni h uski value arr.length isliye li taki nge window ke bahar a jaye aur last nge hi value ban jaye
                j = nge[j];
            }

            System.out.println(arr[j]);

        }


    }
}
