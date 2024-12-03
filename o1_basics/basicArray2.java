import java.util.ArrayList;

public class basicArray2 {
    public static void main(String[] args) {
     int arr[]={1,2,3,5};
        System.out.println(longestSubarray(arr,5));
       // arr=rotatetod(arr,2);
        arr=rotatetod2(arr,2);
        for (int i:arr){
            System.out.println(i);
        }
    }
    public static int longestSubarray(int[] arr,int n){
        int l=0;
        int sum=0;
        int maxl=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                l++;

                if(sum==n){
                    maxl=Math.max(maxl,l);
                }
                if (sum>n){
                    sum=0;
                    l=0;
                    break;
                }
            }
        }
        return maxl;
    }

    public static int[] rotatetod(int[] arr,int d){
        d=d%(arr.length-1);
        ArrayList<Integer> ds=new ArrayList<>();
        for (int i = 0; i < d; i++) {
            ds.add(arr[i]);
        }
        for (int i = d; i < arr.length; i++) {
            arr[i-d]=arr[i];
        }
        int j=0;
        for (int i = arr.length-ds.size(); i < arr.length; i++) {
            arr[i]=ds.get(j);
            j++;
        }
        return arr;
    }
   //tc=o(d)+o(n-d)+o(d)=o(n+d)
    //it is taking extra space because of extra temp variable
   public static int[] rotatetod2(int[] arr, int d) {
       int n = arr.length;
       d = d % n;  // In case d is greater than n, this reduces unnecessary rotations

       // Step 1: Reverse the first d elements
       reverse(arr, 0, d - 1);

       // Step 2: Reverse the remaining elements from d to end
       reverse(arr, d, n - 1);

       // Step 3: Reverse the entire array
       reverse(arr, 0, n - 1);

       return arr;
   }

    // Helper method to reverse a section of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
