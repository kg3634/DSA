/*1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic 
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
     print 0.

Constraints
0 < str.length <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class countEncodings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        /*Logic:images/countEncodings1.png:S&M: each element of dp will store coding ways upto ith string
        4 corner cases : 00,01,10,11 type: we will check in single and double combinatio and try to make call
        to previous (i-1(single char),i-2(double char)) 
        */
        int [] dp = new int[str.length()];
        dp[0] = 1;
        for(int i =1;i<dp.length;i++){
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0'){//00
                dp[i] = 0;
            }else if (str.charAt(i-1)=='0' && str.charAt(i)!='0'){//01
                dp[i] = dp[i-1];//i-2 is like 02, no use
            }else if (str.charAt(i-1)!='0' && str.charAt(i)=='0'){//10
                if(str.charAt(i-1)=='1' || str.charAt(i)=='2'){//images/countEncodings2.png
                    dp[i] = (i>=2?dp[i-2]:1);//for 2 digit no 20,i=1,so call will be for 20 as a single char 
                }else{
                    dp[i] = 0;//as for 30,40...no coding is there so work like 00
                }
            }else{//11
                if(Integer.parseInt(str.substring(i-1,i+1)) <=26){//if both <=26 then only i-2
                    dp[i] = dp[i-1] + (i>=2?dp[i-2]:1);
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }

        System.out.println(dp[str.length() -1]);
    }
    
}
/*Sample Input

123

Sample Output
3 */