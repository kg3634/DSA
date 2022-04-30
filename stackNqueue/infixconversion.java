import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers. */
public class infixconversion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        //logic(infixcovversion1png.png,infixconversion2.png):
        //for postfix(cretae stack) ---> v1 v2 operator =(strings)
        //for prefix(cretae stack) ---> operator v1 v2 = (strings)
        // create one stack for operator
        // agar open bracket aye to operator mn push and close bracket aye tab (main pop- check process function logic) jab tak open bracket na mile and
        // last mn open bracket bhi pop
        // for numbers and alphabets ko pre and post mn push
        // for operators(&,/,-,+) jab tak stack khali na ho aur chota precedence na aye aur opening bracket na aye(ek bhi condition fail loop stop) - do main pop
        // last mn ch khud ko push in operator
        // loop ke bahar , agar stack khali ni h, tb hhi do main pop
        Stack<String> postfix = new Stack<>();// string stack
        Stack<String> prefix = new Stack<>();// string stack
        Stack<Character> ops = new Stack<>();// char stack

        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);

            if (ch == '('){//agar open bracket aye to operator mn push
                ops.push(ch);

            }else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){//for numbers and alphabets ko pre and post mn push
                postfix.push(ch + "");
                prefix.push(ch + "");
            }else if(ch == ')'){//close bracket aye tab pop in operator jab tak open bracket na mile
                while(ops.peek() != '('){
                    process(ops,postfix,prefix);//main pop
                }
                ops.pop();// last mn open bracket bhi pop
            }else if((ch == '+') || (ch == '-') || (ch == '/') || (ch == '*')){//for operators(&,/,-,+)
                while(ops.size() > 0 && precedence(ch) <= precedence(ops.peek()) && ops.peek() !='('){// ye loop jab tak chalega 
                    // jab tak stack khali na ho aur chota precedence na aye aur opening brackket na aye(ek bhi condition fail loop stop that y &&)
                    process(ops,postfix,prefix);
                }

                ops.push(ch);//pushing current operator

            }
        }

        while(ops.size() >0){// loop ke bahar agar stack khali rh jaye to do main pop
            process(ops,postfix,prefix);
        }

        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
        
     }

     public static void process(Stack<Character> ops, Stack<String> postfix, Stack<String> prefix){
        char operator = ops.pop();//pop operator
        String postv2 = postfix.pop();// pop second value- ye bad mn ayegi
        String postv1 = postfix.pop();//pop first value - ye phle
        String postv = postv1 + postv2 + operator; //for postfix ---> v1 v2 operator =(strings)
        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev = operator + prev1 + prev2;//for prefix ---> operator v1 v2 = (strings)
        postfix.push(postv);// push evaluated value in post
        prefix.push(prev);// push evaluated value in pre
     }

     public static int precedence(char op){
         if (op == '+' || op == '-'){
            return 1;
         }else if (op == '*' || op =='/'){
            return 2;
         }else {// just for java compiler as if we pass other operator then it shoudl return int
             return 0;
         }
     }

    
}
