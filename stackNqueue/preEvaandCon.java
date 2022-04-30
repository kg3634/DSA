import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class preEvaandCon {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
           
        //logic: postEvaandCon ki trh hi hoga but main difference is
        // 1) ulta start karenge
        // 2) upar wali v1 and niche wali v2 
        Stack<Integer> value = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        
        for(int i = exp.length()-1; i>= 0;i--){// exp.length loge to string out of index error ayega
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int valv1 = value.pop();// first pop is v1
                int valv2 = value.pop();
                int val = operation(valv1,valv2,ch);
                value.push(val);
    
                String infv1 = infix.pop();
                String infv2 = infix.pop();
                String infv = "(" + infv1 + ch + infv2 + ")";
                infix.push(infv);
    
                String postv1 = postfix.pop();
                String postv2 = postfix.pop();
                String postv = postv1 + postv2 + ch;
                postfix.push(postv);
            }else {
                value.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");
                
            }
        }
    
        System.out.println(value.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
     }

     public static int operation(int v1, int v2, char operator){
        if(operator == '/'){
            return v1/v2;
        } else if (operator == '*'){
            return v1*v2;
        }else if (operator == '+'){
            return v1+v2;
        }else{
            return v1-v2;
        }
    }
    
}
