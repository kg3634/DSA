package DSA.linkedlist;

/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLinkedLists function. The function is passed two linked lists which 
represent two numbers - the first element is the most significant digit and the last element is the least significant digit. 
The function is expected to add the two linked list and return a new linked list.

The following approaches are not allowed :
    1. Don't reverse the linked lists in order to access them from least significant digit 
     to most significant.
     2. Don't use arrays or explicit extra memory.
     3. Don't convert linked lists to number, add them up and convert the result back 
     to a linked list.

Hint - You are expected to take help of recursion to access digits from least significant to most significant. You have to 
tackle the challenge of unequal size of lists and manage carry where required.

3. Input and Output is managed for you. 

Note-> Make sure to set head and tail appropriately because addFirst and addLast has been used to test their values in the 
input-output code.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n) */
import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class addTwoLL {

  public static class LinkedList extends foldLL.LinkedList {

    //Logic:images/addTwoLL.png
    //dono list ka head, size (place value) and new list pass karenge
    // place value jab tak barabar ni hogi tab tak dono ko next krnge , launte hue add karna shuru karenge(initial oc = 0 from return 0)
    //jiski place value jyada hogi usi mn data hoga , to use ho add karenge with carry
    // actual data (data%10) and carry (data/10) and will add in new list hath ke hath
    private static int addListHelper(Node one, int pv1,Node two,int pv2, LinkedList res){
        if (one == null && two == null){
            return 0;
        }

        int data = 0;
        if(pv1 > pv2){
            int oc = addListHelper(one.next, pv1-1, two, pv2, res);
            data = one.data + oc;
        }else if (pv1 < pv2){
            int oc = addListHelper(one, pv1, two.next, pv2-1, res);
            data = two.data + oc;
        }else{
            int oc = addListHelper(one.next, pv1-1, two.next, pv2-1, res);
            data = one.data + two.data + oc;
        }

        int nd = data % 10;
        int nc = data / 10;

        res.addFirst(nd);
        return nc;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
        int oc = addListHelper(one.head,one.size,two.head,two.size,res);

        if (oc > 0){
            res.addFirst(oc);
        }
        return res;
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

    int n2 = Integer.parseInt(br.readLine());
    LinkedList l2 = new LinkedList();
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      int d = Integer.parseInt(values2[i]);
      l2.addLast(d);
    }

    LinkedList sum = LinkedList.addTwoLists(l1, l2);

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    l1.display();
    l2.display();
    sum.display();
    sum.addFirst(a);
    sum.addLast(b);
    sum.display();
  }
}

/*Sample Input

1
1
3
9 9 9
10
20

Sample Output
1 
9 9 9 
1 0 0 0 
10 1 0 0 0 20 */