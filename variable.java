package DSA;

public class variable {

public static void main(String[] args) {
    int x = 15;
    int y = 10;
    // x /y
    int div = x/y;
    int div2 = y/x;
    int mod = x%y; //prints remainder
    System.out.println("the div of "+ x + "and " + y + " is " + div );
    System.out.println("the div of "+ y + "and " + x + " is " + div2 );
    System.out.println("the mod of "+ y + "and " + x + " is " + mod );
    //Note: in int division, it only prints quotient value 
    //No BODMAS here. (*/% have equal) > (+- have equal), In equal left to right. from braket()
    // we can change periority
    int exp = (x*y)/(x+y);
    System.out.println(exp);
}
    
}
