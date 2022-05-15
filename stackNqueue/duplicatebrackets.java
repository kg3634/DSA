/*1. You are given a string exp representing an expression. 2. Assume that the expression is balanced 
i.e. the opening and closing brackets match with each other. 3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise. 
e.g.' ((a + b) + (c + d)) -> false (a + b) + ((c + d)) -> true
Constraints: 0 <= str.length <= 100 */
import java.util.Scanner;
import java.util.Stack;
public class duplicateBrackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String expr = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i < expr.length();i++){
            char ch = expr.charAt(i);
            // push all ch in stack untill you get closed bracket. when you get closed bracket pop untill you get open bracket.
            // if you get open bracket immediatly without poping anything, then it is a duplicate case.
            if (ch == ')'){
                if (st.peek() == '('){ // if you get '(' immediatly it is a duplicate case.
                    System.out.println(true);
                    return;
                }
                else{ // pop untill you get '('
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop(); // pop '(' also.
                }
            }
            else{ // push untill you get ')'
                st.push(ch);
            }
        }
        System.out.println(false);// if above loop does not return, then it is not duplicate case.

    }

    
}