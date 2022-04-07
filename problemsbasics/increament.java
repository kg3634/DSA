package DSA.problemsbasics;

public class increament {
    public static void main(String[] args) {
        int i = 10;
        if(i++ == i) // 10 != 11
          System.out.println(i + " is good");
        else
          System.out.println(i + " is bad");
     
        int j = 20;
        if(++j == j) // 21= 21
          System.out.println(j + " is good");
        else
          System.out.println(j + " is bad");
    }
    
}
