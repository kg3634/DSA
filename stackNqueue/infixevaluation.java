import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers. */
public class infixevaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        //logic: will create operators(/,*,+,-) and operands(1,2,3,4) stack 
        // then precedence(will return higher precedence) and operation function(will do required operation)
        // will push '(' directly, for ')' jab tak '('ni a jata tab tak pop
        // main poping: for 1 operator and 2 operands pop and then operation ke baad jo vaule ayegi usko oprands mn push
        // for /,*,+,-, jab tak operator size zero ni and operator peak '(' ni aye and apne se chota precedent na aye tab tak main poping
        Stack<Integer> oprnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i=0;i< exp.length();i++){
            char ch = exp.charAt(i);

            if (ch == '('){
                optors.push(ch);

            }else if(ch == ')'){
                while(optors.peek() != '('){//jab tak '('ni a jata tab tak pop
                    char optor = optors.pop();// for 1 operator 2 operands pop 
                    int v2 = oprnds.pop();// for case a-b (bad wale mn se minus karenge)
                    int v1 = oprnds.pop();

                    int opv = operation(v1,v2,optor);
                    oprnds.push(opv);// push value to operands

                }                
            }else if(Character.isDigit(ch)){
                oprnds.push(ch - '0'); // (char to int convirsion)agar character ko number mn convirt karna ho to char '0' minus krte h 
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //ch is wanting highest priority operators to solve first 
                while(optors.size() > 0 && optors.peek() != '('  && precedence(ch) <=precedence(optors.peek())){//jab tak operator size zero ni 
                // and operator peak '(' ni aye 
                //and apne se chota precedent na aye tab tak main poping
                // ek bhi condition fail to loop stop ,isliye &&
                    char optor = optors.pop();
                    int v2 = oprnds.pop();
                    int v1 = oprnds.pop();

                    int opv = operation(v1,v2,optor);
                    oprnds.push(opv);                    
                }
                //ch is pushing itself now
                optors.push(ch);

            }
        }
        while(optors.size() != 0){// agar 2-3*4 mn koi pop ni hoga to uske liye case h ye, just do main poping jab tak opertor size zero na ho 
            char optor = optors.pop();
            int v2 = oprnds.pop();
            int v1 = oprnds.pop();

            int opv = operation(v1,v2,optor);
            oprnds.push(opv);

        }

        System.out.println(oprnds.peek());

 
     }

     public static int precedence(char optor){
        if(optor == '+'){
            return 1;
        }else if (optor == '-'){
            return 1;
        }else if (optor == '/'){
            return 2;
        }else{
            return 2;
        }
    }

    public static int operation(int v1,int v2,char optor){
        if(optor == '+'){
            return v1 + v2;
        }else if (optor == '-'){
            return v1-v2;
        }else if (optor == '/'){
            return v1/v2;
        }else{
            return v1*v2;
        }
    }
    
}
