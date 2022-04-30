import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?

Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1) */

// ek hi celebrity ho sakta h kyuki isko sab jante h , iska matlab baki log 1 ko jante h to wo ni ho sakte
public class celebrityprob {
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for(int j=0;j<n;j++){
        String line = br.readLine();
        for(int k=0;k<n;k++){
            arr[j][k]= line.charAt(k) - '0';
        }
    }

    //Logic(celebrityprob.png): n members ko stack mn push karo and then 2 ko check karo agar jo nahi janta dusre ko use fir push kar do
    // isse (n-1) ka ye check ho jyega ki wo cleberity nahi h but ab 1 bacha h ye abi potential celebrity h not celebrity
    // abi uske liye baki row and column check karo agar use baki bhi jate h , and wo baki ko nahi janta tab he is the celebrity


    findCelebrity(arr);


}

public static void findCelebrity(int[][]arr){

    Stack<Integer> st = new Stack<>();
    for(int i=0;i<arr.length;i++){// n members ko stack mn push karo
        st.push(i);
    }
    while(st.size() >= 2){//2 ko check karo agar jo nahi janta dusre ko use fir push kar do
        int i = st.pop();
        int j = st.pop();
        if(arr[i][j] == 1){// check i, j ko janta h y anahi
            st.push(j);
        }else{
            st.push(i);
        }
    }

    int pot = st.pop();// potential celeberity 
    for(int i=0;i< arr.length;i++){
        if(i != pot){// khud ko janta h ya ni isko ni check karna
            if(arr[i][pot] == 0 || arr[pot][i] == 1){//koi i h jo pot ko nahi janta ya pot h jo kisi i ko ni janta
                System.out.println("none");
            }
        }
    }
    System.out.println(pot);

}
    
}