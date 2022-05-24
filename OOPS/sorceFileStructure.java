package DSA.OOPS;


/*Summary
1. Java file can contain many classes.
2. When compiled each class will be converted to .class file
3. When there is no public class then the .java file can have any name.
4. At most one public class in a java file.
5. If a public class exists then the name of the java file and the name of the class must match */

/*Import 
1. names such as java.util.ArrayList are called fully qualified names.
2. import java.util.* - implicit import ===> never use 
3. import java.util.ArrayList - explicit import ===> always use as it improves readability
4. All classes inside same CWD or packages are not required import statement
5. By default java.lang(String,Exception,Thread...) classes and interface are available for all
6. In importing packages all classes are available but not subpackage classes
*/
//point:6
//import java.*;//wont work
//import java.util.*;//wont work
import java.util.regex.*;//Subpackage needs to be imported
class importTest {
    public static void main(String[] args) {
        Pattern t = Pattern.compile("ab");
    }
}

//Packages:
/*1. package should be the first statement even before the import
2. Atmost one package statement in a class is possible */