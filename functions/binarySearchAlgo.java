package DSA.functions;

public class binarySearchAlgo {
    public static void main(String[] args) {
        //algorithm: there is low and high.we would find out mid , if data > value at mid,increase low to mid+1,
        //if data < value at mid;decrease high to mid-1;otherwise l=h=m and print m
        //if no condition matches then low > high,loop will terminate and print -1 
        int [] arr = {10,20,30,40,50,60,70,80,90,100};
        int data = 10;
        int l = 0;//low
        int h = arr.length - 1;//high
        while(l<=h){
            int m = (l+h)/2;
            if(data > arr[m]){
                l = m+1;
            }else if (data < arr[m]){
                h = m -1;
            }else {
                System.out.println(m);
                return;
            }
        }

        System.out.println(-1);

    }
    
}
