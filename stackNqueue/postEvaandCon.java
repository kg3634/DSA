/*1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.
Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Constraints
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class postEvaandCon {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> value = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();

        //logic:postEvaandCon.png
        for(int i=0;i< exp.length();i++){
            char ch = exp.charAt(i);

            if((ch >= '0' && ch <= '9')){
                value.push(ch - '0');// char to int
                prefix.push(ch +"");// char to string
                infix.push(ch+"");// char to string
            }else if ((ch == '+') || (ch == '-') || (ch == '/') || (ch == '*')){

                    // value 
                    int valv2 = value.pop();
                    int valv1 = value.pop();
                    int val = operation(valv1,valv2,ch);// left this part as manie function ni banaya tha
                    value.push(val);

                    //prefix---> operator v1 v2
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String prev = ch + prev1 + prev2;
                    prefix.push(prev);
                    
                    // infix ---> (v1 operator v2)
                    String infv2 = infix.pop();
                    String infv1 = infix.pop();
                    String infv = "(" + infv1 + ch + infv2 + ")";
                    infix.push(infv);
  

            }
            
        }

        System.out.println(value.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());

    }

    public static int operation(int v1, int v2, char operator){
        if(operator == '/'){
            return v1/v2;
        }else if(operator == '*'){
            return v1*v2;
        }else if (operator == '-'){
            return v1-v2; 
        }else {
            return v1+v2;
        }

    }


}