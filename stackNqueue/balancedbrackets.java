/*1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.
e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false */
import java.util.Scanner;
import java.util.Stack;
public class balancedBrackets {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        String expr = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            // logic: check open bracket and push it (ignore a,b,c,+) : balancedBracketsLogic.jpeg
            // when closed brackets come,pop untill we find corresponding open bracket handle below cases:
            // case-1:while poping stack size is zero means more closed brackets than open
            // case-2:we dont get corresponding open bracket on stack top means size mismatch
            // case-3: after for loop if stack size is non zero means more open bracker than closed.   
            if (ch == '[' || ch == '(' || ch == '{'){
                st.push(ch);
            } else if ( ch == ')'){
                boolean val = handleClosing(st,'(');
                if (!val){
                    System.out.println(val);
                    return;
                }
            } else if ( ch == ']'){
                boolean val = handleClosing(st,'[');
                if (!val){
                    System.out.println(val);
                    return;
                }
            } else if ( ch == '}'){
                boolean val = handleClosing(st,'{');
                if (!val){
                    System.out.println(val);
                    return;
                }
            }
        }

        if (st.size() == 0){
            System.out.println(true);
        }else { // handle case -3
            System.out.println(false);
        }

    }


    public static boolean handleClosing(Stack<Character> st,char corresoch){
        if (st.size() == 0){// handle case -1
            return false;
        }else {
            if (st.peek() != corresoch){// handle case -2
                return false;
            }else {
                st.pop();
                return true;
            }
        }

    } 
}