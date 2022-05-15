package DSA.GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class displayAndSizeOfGTree {
    //constructor:
    //Euler path images/eulerPath.png: node ke right se jane per -1(means wipe out from stack)
    //images/createTree.png: if stack empty h then create new node as root node, set data 
    // if stack.size()>0, then create new node ,set data and add it to the children of peek of stack node.
    // -1 per wipe out the node from stack
    public static class Node {
        int data; //for storing data
        ArrayList<Node> children = new ArrayList<>(); //for storing the child nodes
    }

    //display: 
    //images/display.png,images/displayExample.png: use recursion : expectation: display(root) function will print entire tree rooted 
    //at node root, faith display(child) will print the subtree rooted at the node child. 

    public static void display(Node node){
        // below code will print all the children of node
        String str = node.data + "->";
        for(Node child:node.children){
            str += child.data +",";
        }
        str+=".";
        System.out.println(str);

        //failth that below code will print all children of children of root 
        for(Node child: node.children){
            display(child);
        }
    }

    //size(euler method):images/size.png
    //E of S(10) = F of [S(20) +  S(30) + S(40)] ==>recursion
    //final S = S(10) + 1;
    public static int size(Node node){
        int s = 0;
        for(Node child:node.children ){
            int cs = size(child);
            s+=cs;
        }
        s = s + 1;

        return s;
    }
    public static void main(String[] args) {
        Node root = null;//unique node for a tree
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack<Node> st = new Stack<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                //creating node and adding data 
                Node t = new Node();
                t.data = arr[i];

                //if stack is empty then set it as root node, otherwise add it to the children of stack peek , at the end push it to stack.
                if(st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        }

        display(root);
        System.out.println(size(root));
    }
}
