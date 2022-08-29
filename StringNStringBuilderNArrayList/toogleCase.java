package DSA.StringNStringBuilderNArrayList;

import java.io.*;
import java.util.*;

public class toogleCase {

	public static String toggleCase(String str){
        /*Logic: images/toogleCase.png */
        StringBuilder sb = new StringBuilder(str);//as need to modify ,cant use String
        for( int i =0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(ch>= 'a' && ch<= 'z'){
                char uch = (char)('A'+ch -'a');//lower char ka 'a' ke sath difference 'A' mn add
                //need ot cast to char as while adding it wil convirt into int
                sb.setCharAt(i,uch);
            }else if (ch >= 'A' && ch<= 'Z'){
                char lch = (char)('a'+ch - 'A');//upper ch ka 'A' ke sath diff 'a' mn add
                sb.setCharAt(i, lch);
            }
        }

        return sb.toString();
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
        scn.close();
	}

}
/*Sample Input

pepCODinG

Sample Output
PEPcodINg */