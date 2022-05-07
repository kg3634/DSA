import java.util.ArrayDeque;
import java.util.Queue;

public class Queuebasic {
    public static void main(String[] args) {
        Queue <Integer> que = new ArrayDeque<>();// first in first out
        //public class ArrayDeque<E> extends AbstractCollection<E>implements Deque<E>, Cloneable, Serializable
        //public interface Deque<E> extends Queue<E>
        que.add(10);
        System.out.println(que); 
        que.add(20);
        System.out.println(que); 
        que.add(30);
        System.out.println(que); 
        System.out.println(que.peek());
        System.out.println(que); 
        System.out.println(que.remove());
        System.out.println(que); 

    }
    
}
