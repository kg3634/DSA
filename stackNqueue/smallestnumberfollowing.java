import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given a pattern of upto 8 length containing characters 'i' and 'd'. 2. 'd' stands for 
decreasing and 'i' stands for increasing 3. You have to print the smallest number, using the digits 
1 to 9 only without repetition, such that the digit decreases following a d and increases follwing 
an i. e.g. d -> 21 i -> 12 ddd -> 4321 iii -> 1234 dddiddd -> 43218765 iiddd -> 126543
Constraints
0 < str.length <= 8 str contains only 'd' and 'i' */
public class smallestnumberfollowing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        //Logic(smallestnumberfollowing.png) : agar d dikhta h to push karke num badhate h, i dikhta h to push karke num badhate h 
        // and num ko pop karke print bhi karte h and last mn pop krke print karte h bache hue ko
        //
        Stack <Integer> st = new Stack<>();
        int num = 1;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if (ch == 'd'){//agar d dikhta h to push karke num badhate h
                st.push(num);
                num++;
            }else{
                st.push(num);//i dikhta h to push karke num badhate h
                num++;
                while(st.size()>0){//and num ko pop karke print bhi karte h
                    System.out.println(st.pop());
                }
            }
        }
        st.push(num);//push increased number
        while(st.size()>0){//last mn pop krke print karte h bache hue ko
            System.out.println(st.pop());
        }
    }
    
}
