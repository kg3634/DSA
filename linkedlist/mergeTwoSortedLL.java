/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of mergeTwoSortedLists function. The function is static 
and is passed two lists which are sorted. The function is expected to return a new sorted list containing 
elements of both lists. Original lists must stay as they were.
3. Input and Output is managed for you.

Constraints
1. O(n) time complexity and constant space complexity expected. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import DSA.linkedlist.addLastElement.Node;

public class mergeTwoSortedLL {

    public static class LinkedList extends midOfLL.LinkedList{
 
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            // merge2LL.png
            // dono LL ke head per node ko vitha do(one, two), fir don ke data ko comapre karo,chote wale ko 
            //addLast kar do new LL mn, ye jab tak karo tab tak one and two null na ho jaye;
            // agar one/two mn se ek phle null hogya tp LL mn use addLast kar lo
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();        
            
            while(one != null && two != null){
                if (one.data < two.data){
                    res.addLast(one.data);
                    one = one.next;
                }else{
                    res.addLast(two.data);
                    two = two.next;
                }
            }

            while(one != null){
                res.addLast(one.data);
                one = one.next;
            }

            while(two != null){
                res.addLast(two.data);
                two = two.next;
            }
            return res;
        }
    }    
    public static void main(String[] args) throws Exception{
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
        LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
        merged.display();
        l1.display();
        l2.display();
    }
}
/*Sample Input

5
10 20 30 40 50
10
7 9 12 15 37 43 44 48 52 56

Sample Output
7 9 10 12 15 20 30 37 40 43 44 48 50 52 56 
10 20 30 40 50 
7 9 12 15 37 43 44 48 52 56  */