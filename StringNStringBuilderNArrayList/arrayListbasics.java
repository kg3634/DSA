package DSA.StringNStringBuilderNArrayList;
import java.util.*;
/**
 * arrayListbasics
 */
public class arrayListbasics {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list+"==>"+list.size());
        list.add(10);
        list.add(20);
        list.add(1,1000);//will add at 1 position
        System.out.println(list+"==>"+list.size());        

        //set
        list.set(1,20000);
        System.out.println(list+"==>"+list.size());//will set at 1 not list[1]        

        list.remove(1);
        System.out.println(list+"==>"+list.size());
        
        //display loop 1
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //display loop2
        for( int val:list){
            System.out.println(val);
        }

        //string type

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("keelo");
        System.out.println(list2+"==>"+list2.size());        


    }
}