/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of IsPalindrome function. The function is expected to check if the 
linked list is a palindrome or not and return true or false accordingly.
3. Input and Output is managed for you.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n) */
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class isLLPalindrom {

  public static class LinkedList extends reverseDataRecursive.LinkedList {

    //Logic: images\isLLPaindrome.png
    //used data recursive technique. vapas laute hue below kam kar lnge
    //1) left right ka data check kar lnge ==> not eual return false ==> ek mn bhi ress false ho gya to return false 
    //2) otherwise left ko age badha dnge and return true
    private boolean IsPalindromeHelper(Node right){
      if(right == null){
        return true;
      }
      Boolean ress = IsPalindromeHelper(right.next);
      if(ress == false){
        return false;
      }else if (pleft.data != right.data){
        return false;
      }else{
          pleft = pleft.next;
          return true;
        }
      }
    

    Node pleft;
    public boolean IsPalindrome() {
      pleft = head;
      return IsPalindromeHelper(head);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    LinkedList l1 = new LinkedList();
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      int d = Integer.parseInt(values1[i]);
      l1.addLast(d);
    }

    System.out.println(l1.IsPalindrome());
  }
}
/*Sample Input

5
1 2 3 2 1

Sample Output
true */