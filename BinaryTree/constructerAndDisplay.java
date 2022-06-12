package DSA.BinaryTree;
/*in Binary tree atmost 2 child can be present.
* In Node class ==> data,(left and right) nodes will be present 
Logic:images/constructerBT.png
* There would be pair class: node,state
* state 1 - left child, state 2 - right child, state 3 - pop
* first node is root, if 
*/

import java.util.Stack;

public class constructerAndDisplay {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node (int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    public static class Pair{
        Node node;
        int state;

        Pair(){}
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    //Logic:images/display.png
    public static void display(Node node) {
        //base case(in GT loop that isliye not needed as no of children zero hone per vapas)
        if(node == null){
            return;
        }
        //khud ke left right  print in form 25 <- 50 -> 75,left/right null hone per "." print
        String str ="";

        str+= node.left == null?"." : node.left.data +"";
        str+=" <- " + node.data + " -> ";
        str+= node.right == null?"." : node.right.data +"";

        System.out.println(str);
        display(node.left);//assume left child khud ko print kar lega
        display(node.right);//assume
    }
    public static void main(String[] args) throws Exception {
        Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;//reading from arr
        while(st.size() >0){
            Pair top = st.peek();

            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }

                top.state++;    
            }else if (top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }

                top.state++;
            }else{
                st.pop();
            }
        }
        
        display(root);
    }
}
/*output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
30 <- 37 -> .
. <- 30 -> .
62 <- 75 -> 87
. <- 62 -> 70
. <- 70 -> .
. <- 87 -> . 
*/
