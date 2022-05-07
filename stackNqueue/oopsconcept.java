public class oopsconcept {
    //class Person
    public static class Person {
        //data members
        int age;
        String name;

        //function
        void saysHi() {
            System.out.println(name + "[" + age + "] says hi");
        }

        Person() { //1 Default constructor
        }

        Person(int age, String name) { //2 Parameterized constructor
        this.age = age;
        this.name = name;
        }

    }
    //memory diagram: oopsmemorydiagram.png
    public static void main(String[] args) {
        //object p1
        Person p1 = new Person();//reference would be stored in p1, lets say 4k
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();

        //object p2
        Person p2 = new Person();//reference would be stored in p2, lets say 5k
        p2.age = 20;
        p2.name = "B";
        p2.saysHi();

       /*Person p3 = p1;  //reference would be assigned
        p3.age = 30;  //it would change p1.age
        p1.saysHi();  */

        //Swap Game1:
        swap3(p1, p2);

        p1.saysHi();
        p2.saysHi();

        //Constructor code
        constructor();

    }

    //oppsswap1.png  oopsswap2.png
    public static void swap3(Person psn1, Person psn2) {
        // by default new object ke liye int value =0 and string = null
        psn1 = new Person();// ye kisi aur space ko point kar ra h 

        int age = psn1.age;//age = 0
        psn1.age = psn2.age;
        psn2.age = age;//psn2.age = 0[ ye p2 ki age ko chnage kar dega kyuki psn2 abi abhi bhi p2 ko point kar ra h]

        psn2 = new Person();// ye kisi aur space ko point kar ra h

        // below code mn p1,p2 per koi fark ni padega kyuki psn1 and psn2 new space ko point kar re h
        String name = psn1.name;//name = null
        psn1.name = psn2.name;//
        psn2.name = name;

    }

    //Constructors and this
    //constructor.png
    public static void constructor(){
        Person p1 = new Person(); //ye default constructor h 
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();
        Person p2 = new Person(20, "B"); //[this] p2 ka reference store karta h ,=5k
        p2.saysHi();
    /* whenever an object of a class is made the following steps take place:
    Space allocation.
    Parsing - parse params values(age,name...)
    Constructor firing - 
        *same as name of class
        *agar define ni kiya h to java default provide kar deta h
        *agar parametrized define kiya h to java default provide ni karega hume define karna padega */
    }

}
