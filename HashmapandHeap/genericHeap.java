/* how to make pq class generic, our class was working for integer only */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;


public class genericHeap {
    //Java PQ class
    /*Comparable class implement in class itself bit Comparator class needs to impleented seperatly */
    static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;

        Student(int rno,int ht,int wt){
            this.rno = rno;;
            this.ht = ht;
            this.wt = wt;
        }

        public int compareTo(Student o){
            /*Logic:images/genericHeap1.png: */
            return this.rno - o.rno;//smaller no first
            /*return o.rno - this.rno;//larger no first  */
        }

        //overriding toString to print object details
        public String toString(){
            return "R.No = "+this.rno+" HT = "+this.ht+" WT = "+this.wt;
        } 


    }
    //Comparator class to compare based on different properties
    static class StudentHtComparator implements Comparator<Student>{
        public int compare(Student s1,Student s2){
            return s1.ht - s2.ht;
        }
    }

    //class for comparing wt
    static class StudentWtComparator implements Comparator<Student>{
        public int compare(Student s1,Student s2){
            return s1.wt - s2.wt;
        }        
    }

    //Our Priority Queue Class
    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;//for comparator
    
        public PriorityQueue() {
          data = new ArrayList<>();
          comp = null;
        }
        
        //new parameterized Constructor for Comparator
        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
          }        
        /*added isSamller as generic comparison function which can use Comparable and Comparator both  */
        private boolean isSmaller(int i ,int j){
            if(comp ==null){
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if(ith.compareTo(jth) < 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                T ith = data.get(i);
                T jth = data.get(j);

                if(comp.compare(ith, jth) < 0){
                    return true;
                }else {
                    return false;
                }
            }

        }
        public void add(T val) {
          data.add(val); 
          upheapify(data.size() - 1);
        }
    
        private void upheapify(int i){
          if(i ==0){
            return;
          }
          int pi = (i - 1)/2;
          if(isSmaller(i, pi) == true){
            swap(i,pi);
            upheapify(pi);
          }
        }
    
        private void swap(int i ,int j){
          T ith = data.get(i);
          T jth = data.get(j);
          data.set(i,jth);
          data.set(j,ith);
        }
    
        public T remove() {
          if(this.size() ==0){
            System.out.println("Underflow");
            return null;
          }
    
          swap(0,data.size() -1);
          T p = data.remove(data.size() -1);
          downheapify(0);
          return p;
    
        }
    
        private void downheapify(int pi){
          int mini = pi;
    
          int li = 2*pi +1;
          if(li < data.size() && isSmaller(li, mini) ){
            mini = li;
          }
          int ri = 2*pi +2;
          if(ri < data.size() && isSmaller(ri, mini)){
            mini = ri;
          }
    
          if(mini !=pi){
            swap(pi,mini);
            downheapify(mini);
          }      
        }
        public T peek() {
          if(this.size() ==0){
            System.out.println("Underflow");
            return null;
          }
          return data.get(0);
        }
    
        public int size() {
          return data.size();
        }
      }
    public static void main(String[] args) {
        //object priority queue
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());//for different property comparion need to pass
        //class
        pq.add(new Student(11, 300, 90));
        pq.add(new Student(2, 201, 21));
        pq.add(new Student(30, 102, 12));
        pq.add(new Student(41, 603, 63));
        pq.add(new Student(5, 704, 44));
        while(pq.size() >0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
