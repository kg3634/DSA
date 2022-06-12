/*We want the function to directly return all the elements in the tree in preorder without the use of indices */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

/*Interfaces:
* An interface is a mechanism which contains just the method of those functions but not the body. 
The purpose of these interfaces is to define the signature of the functions.Hence, the interface declares the functions 
and the class implementing it defines those functions. This concept is quite useful because it sets the signature for a 
function. 
Use case: If developer 1 has to write a class1 and developer 2 has to write a class 2, and both have to use the same 
function, "Func( )", then we want them both to call the function "Func( )" of the same signature.
* Interface object can be created like I obj = new A () where A which implements the iterface.
* GT implements Iterable<Integer> interface
* Interable interface has one method iterator() which returns type obj is Iterator<Integer> which is also a interface
* class GTPreorderIterator implements Iterator<Integer>
* Iterator interface as two methos hasNext(): whether new value if available
and next(): returns current value and sets up for next value
*   for(int val:gt){
        System.out.println(val);
    }

    Iterator<Integer> gti = gt.iterator();
    while(gti.hasNext() == true){
        System.out.println(gti.next());
    }
    above both code are same

*/
public class iterableAndIterators {
  //Logic: images/iterableAnditerators.png: nval ki current value store karke next value set
  public static class GenericTree implements Iterable<Integer>{
      Node root;

      GenericTree(Node root){
          this.root = root;
      }

      public Iterator<Integer> iterator(){ //this is methos defined in iterable interface
        //return type Iterator is also a interface
        Iterator<Integer> obj = new GTPreorderIterator(root);//interface obj is created with class which implements it.
        return obj;
      }
 }
  public static class GTPreorderIterator implements Iterator<Integer>{
        Integer nval;/*diff between int and Integer
        * int default value is 0 while Integer is null
        * int is in stack while Integer in stack contains only address,actualy value is in heap */
        Stack<Pair> st;
        public GTPreorderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root,-1));
            next();//as nval ki default value null h , has next false return karega ,
            //isiliye ek baar chala kar next value set ki h
        }
        public boolean hasNext(){
            if(nval == null){
                return false;
            }else{
                return true;
            }
        }

        public Integer next(){
            Integer fr = nval;
            //moves nval forward,if not possible sets it to null
            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();

                if(top.state == -1){
                    nval = top.node.data; 
                    top.state++;
                    break;      
                }else if (top.state >=0 && top.state < top.node.children.size()){
                    Pair cp = new Pair(top.node.children.get(top.state),-1);
                    st.push(cp);

                    top.state++;
                }else{
                    st.pop(); 
                }
            }
            return fr;
        }
    }
      
  private static class Pair{
          Node node;
          int state;

          Pair(Node node, int state){
              this.node = node;
              this.state = state;
          }
      }
  
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    Node root = construct(arr);

    GenericTree gt = new GenericTree(root);

    for(int val:gt){
        System.out.println(val);
    }
    Iterator<Integer> gti = gt.iterator();
    while(gti.hasNext() == true){
        System.out.println(gti.next());
    }  
  }
}
