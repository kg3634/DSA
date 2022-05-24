/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in 
"levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a 
space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class levelOrderLineWiseGT extends travarsalOfGtree{
  //Logic:images/levelLineWise.png
  //2 Queue lenge and will do remove ,print add child(child add new queue mn karnge)
  //agar mainq empty ho jati h tab usko childQ ka baraber kar dnge and child q ko new kar lnge and enter laga dnge
  
  public static void levelOrderLineWise(Node node){
      Queue<Node> mq = new ArrayDeque<>();
      Queue<Node> cq = new ArrayDeque<>();
      mq.add(node);

      while(mq.size() > 0){
          node = mq.remove();
          System.out.print(node.data+" ");

          for(Node child:node.children){
              cq.add(child);
          }
          //agar mainq empty ho jati h tab usko childQ ka baraber kar dnge and child q ko new kar lnge and enter laga dnge
          if(mq.size() == 0){
              mq = cq;
              cq = new ArrayDeque<>();
              System.out.println();
          }
      }
  }

  //delimiler - using one Queue
  public static void levelOrderLineWiseApproach2(Node node){
    Queue<Node> q = new ArrayDeque<>();

    q.add(node);
    q.add(new Node(-1));//this is marker - have created new constructer in Node class for this 

    //if node.data !=null,then remove,print,add childs,else add -1 and enter (if q !=0) 
    while(q.size() > 0 ){
      node = q.remove();
      if(node.data != -1){
        System.out.print(node.data+" ");
        for(Node child: node.children){
          q.add(child);
        }
      }else {
        if(q.size() > 0){
          q.add(new Node(-1));
          System.out.println();
        }
      }
    }
  }

  //Logic:levelOrderLineWiseAppraoch3.png
  public static void levelOrderLineWiseApproach3(Node node){
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);

    while(q.size() > 0){
      int cicl = q.size();

      for(int i = 0; i < cicl; i++ ){
        node = q.remove();
        System.out.print(node.data+" ");
        for(Node child: node.children){
          q.add(child);
        }
      }
      System.out.println();
    }
  }

  private static class Pair{
    Node node;
    int level;

    Pair(Node node,int level){
      this.node = node;
      this.level = level;
    }
  }

  //Analyse below approach as it is newone and difficult than others
  //Logic: images/levelOrderLineWiseApproach4.png
  //Creating new class pair(node,level), in queue pair would be added and removed
  public static void levelOrderLineWiseApproach4(Node node){
    Queue<Pair> q = new ArrayDeque<>();//Pair type queue
    q.add(new Pair(node,1));//initial pair level

    int level = 1;//level variable
    while(q.size() > 0){
      Pair p = q.remove();
      if(p.level > level){//this would be true if pair level is of next level
        level = p.level;//setting level variable to new pair level
        System.out.println();
      }
      System.out.print(p.node.data+" ");
      for(Node child:p.node.children){
        Pair cp = new Pair(child,p.level +1);//adding pair with increasing level
        q.add(cp);
      }
    }
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
    // levelOrderLineWise(root);
    // levelOrderLineWiseApproach2(root);
    // levelOrderLineWiseApproach3(root);
    levelOrderLineWiseApproach4(root);
  }

}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 
20 30 40 
50 60 70 80 90 100 
110 120 */