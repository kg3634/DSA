import java.io.BufferedReader;
import java.io.InputStreamReader;

/*1. You are required to complete the code of our CustomQueue class. The class should mimic the behaviour of a Queue 
and implement FIFO semantic.
2. Here is the list of functions that you are supposed to complete
     2.1. add -> Should accept new data if there is space available in the underlying 
     array or print "Queue overflow" otherwise.
     2.2. remove -> Should remove and return value according to FIFO, if available or 
     print "Queue underflow" otherwise and return -1.
     2.3. peek -> Should return value according to FIFO, if available or print "Queue 
     underflow" otherwise and return -1.
     2.4. size -> Should return the number of elements available in the queue.
     2.5. display -> Should print the elements of queue in FIFO manner (space- 
     separated) ending with a line-break.
3. Input and Output is managed for you. */
public class buildnormalqueue {
    //queue.png
    public static class CustomQueue {
        //queue mn add and remove alag alag jgh se hota h isilye 2 variable
        int[] data;
        int front;
        int size;
    
        public CustomQueue(int cap) {
          data = new int[cap];
          front = 0;
          size = 0;
        }
    
        int size() {
          // write ur code here
          return size;
        }
    
        void display() {
          // write ur code here
          for(int i=0;i < size;i++){
              int idx = (front + i) % data.length;
              System.out.print(data[idx]+ " ");
          }
          System.out.println();
        }

        //addqueue1.png,addqueue2.png
        //value rear mn dalnge,front se start krte h usme size jod kar rear ata h
        // but agar rear out of array na nikle uske liye % lagate h for circuler 
        void add(int val) {
          // write ur code here
          if (size == data.length){
            System.out.println("Queue overflow");
          }else{
              int rear = (front + size) % data.length;
              data[rear] = val;
              size++;
          }
        }
    
        
        int remove() {
          // write ur code here
          //front value ko return kar do and then front badhao(with% logic) and size ghatao
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }else{
                int val = data[front];
                front = (front +1) % data.length;//just like add, front ko bas badha ni sakte circuler banana padega
                size--;
                return val;
            }          
        }
    
        int peek() {
           // write ur code here
           if(size == 0){
                System.out.println("Queue underflow");
                return -1;
           }else{
               return data[front];
           }
        }
      }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);
    
        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("add")){
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if(str.startsWith("remove")){
            int val = qu.remove();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("peek")){
            int val = qu.peek();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("size")){
            System.out.println(qu.size());
          } else if(str.startsWith("display")){
            qu.display();
          }
          str = br.readLine();
        }        
    }
    
}
