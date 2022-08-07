/*1. You are given a partially written BST class. 2. You are given a value. You are required to print all pair of 
nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. 
Make sure to print the pairs in increasing order. Use the question video to gain clarity. 3. Input and Output is 
managed for you.


Constraints
None */
package DSA.BinarySearchTree;

import java.io.*;
import java.util.*;

public class targetSumPair {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static boolean find(Node node, int data){
    if( node == null){
        return false;
    }
    if(data > node.data){
        return find(node.right,data);
    }else if( data < node.data){
        return find(node.left,data);
    }else{
        return true;
    }
  }
  public static void travelAndPrint(Node root, Node node,int tar){
    if( node == null){
        return;
    }
    travelAndPrint(root, node.left, tar);

    int comp = tar - node.data;//complement value
    //in order mn print karnge
    if(node.data < comp){//as for greater also it will print duplicates pairs and greater value first
        if(find(root,comp) == true){
            System.out.println(node.data+" "+comp);
        }
    }
    travelAndPrint(root, node.right, tar);
  }

  /*Alternate approaches:second appraoch : arraylist based
  for last approch TC is n(visiting all nodes)*h(for find-it will take time as height of tree) and SC is h(good) 
  below approach we will sort all element in arraylist and then use li and ri method(TC& SC : n)
  */
  public static void tnf(Node node, ArrayList<Integer> list){
    if( node == null){
        return;
    }
    tnf(node.left,list);
    list.add(node.data);//inorder will give sorted order nodes
    tnf(node.right,list);
  }

  public static void tnp(Node node,int data){
    ArrayList<Integer> list = new ArrayList<>();
    tnf(node,list);
    int li = 0;
    int ri = list.size() - 1;
    while(li< ri){
        int left  = list.get(li);
        int right = list.get(ri);
        if(left + right > data){
            ri--;
        }else if(left + right < data){
            li++;
        }else{
            System.out.println(left+" "+right);
            li++;
            ri--;
        }
    }

  }

  /*best approach : TC: n , SC : h by using iterative Inorder(for getting value like li in AL) and reverse iterative indrder
  (for gettting value like ri in AL), then apply same AL like appraoch*/
  public static class ITPair{
    Node node;
    int state = 0;

    ITPair(Node node,int state){
        this.node = node;
        this.state = state;
    }
  }
  public static void travelAndPrintBestApproach(Node node,int tar){
    //Logic:images/travelAndPrintBestApproach.png
    Stack<ITPair> ls = new Stack<>();
    Stack<ITPair> rs = new Stack<>();
    ls.push(new ITPair(node, 0));
    rs.push(new ITPair(node, 0));
    Node left = getNextFromNormalInOrder(ls);
    Node right = getNextFromReverseInOrder(rs);

    while(left.data < right.data){
        if(left.data + right.data < tar){
            left = getNextFromNormalInOrder(ls);
        }else if (left.data + right.data > tar){
            right = getNextFromReverseInOrder(rs);
        }else {
            System.out.println(left.data+" "+right.data);
            left = getNextFromNormalInOrder(ls);
            right = getNextFromReverseInOrder(rs);
        }
    }
  }

  public static Node getNextFromNormalInOrder(Stack<ITPair> st){
    while(st.size() > 0){
        ITPair top = st.peek();
        if(top.state == 0){
            if(top.node.left !=null){
                st.push(new ITPair(top.node.left, 0));
            }
            top.state++;
        }else if (top.state == 1){
            if(top.node.right !=null){
                st.push(new ITPair(top.node.right, 0));
            }
            top.state++;
            return top.node;            
        }else {
            st.pop();
        }
    }

    return null;
  }

  public static Node getNextFromReverseInOrder(Stack<ITPair> st){
    while(st.size() > 0){
        ITPair top = st.peek();
        if(top.state == 0){
            if(top.node.right !=null){
                st.push(new ITPair(top.node.right, 0));
            }
            top.state++;
        }else if (top.state == 1){
            if(top.node.left !=null){
                st.push(new ITPair(top.node.left, 0));
            }
            top.state++;
            return top.node;            
        }else {
            st.pop();
        }
    }

    return null;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // travelAndPrint(root, root, data);
    // tnp(root, data);
    travelAndPrintBestApproach(root,data);  

}

}
/*Sample Input

21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100

Sample Output
25 75
30 70 */