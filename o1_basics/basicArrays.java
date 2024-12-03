import java.sql.SQLOutput;
import java.util.*;
public class basicArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int arr[] = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
//        int max1 = findLargest(arr);
        int max2 = findSecondLargest(arr);
//        System.out.println(max1);
        System.out.println(max2);
//        System.out.println(checkIfSorted(arr));
//        rotate(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        int[] arr1 = {1, 2, 1, 4, 5, 5};
//        System.out.println(unique(arr1));
        moveZero2(arr);
        for(int x:arr){
            System.out.println(x);

        }
        }


        public static int findLargest(int[] arr) {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];

                }
            }
            return max;
        }



        public static int findSecondLargest(int[] arr){
            int max=findLargest(arr);
            int max2=arr[0];
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] < max && arr[i] > max2) {
                    max2 = arr[i];
                }
            }
            return max2;

        }



    public static int findSecondLargest2(int[] arr){
       Arrays.sort(arr);
       int sl=0;
        for (int j = arr.length-2; j>=0 ; j--) {
            if (arr[arr.length]!=arr[j]){
                sl=arr[j];
                break;
            }
        }
        return sl;
    }



        public static boolean checkIfSorted(int[] arr){
            for (int i = 0; i <arr.length-1 ; i++) {
                if (arr[i]>arr[i+1]){
                    return false;
                }

            }
            return true;
        }



        public static void rotate(int[] arr){
            int temp=arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i]=arr[i+1];

            }
            arr[arr.length-1]=temp;
            //om namah shivay
        }

    public static int unique(int[] arr){
        //int arr1[] = new int[arr.length];
        ArrayList<Integer> ds = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {

            if(!isThere(arr[i],arr,i)){
                ds.add(arr[i]);
            }

        }
        return ds.size();

    }
    public static boolean isThere(int t,int[] arr,int n){
        for (int i = 0; i < n; i++) {
            if (t==arr[i]){
                return true;
            }
        }
        return false;
    }

    public static int unique1(int[] arr){
        int j=0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j]!=arr[i]){
                arr[j+1]=arr[i];
                j++;
            }
        }
        return j+1;
    }


    

    public static void moveZero(int[] arr){
        int nz=0;
        int[] arr1=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
               arr1[nz]=arr[i];
               nz++;
            }
        }
        while(nz<arr.length){
            arr1[nz]=0;
            nz++;
        }
        for (int k = 0; k < arr.length; k++) {
           arr[k]=arr1[k];
        }
    }



    public static int[] moveZero1(int[] arr){
             int i=0;
             int j=-1;
        for ( i = 0; i <arr.length ; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }

        }
        if(j==-1){
            return arr;
        }
        for (i = j+1; i < arr.length; i++) {
           if(arr[i]!=0){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;
           }
        }
        return arr;

    }
    public static int[] moveZero2(int[] arr){
        int i;
        int j=-1;
        for (i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for ( i=j+1; i <arr.length ; i++) {
           if(arr[i]!=0){
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
               j++;
           }
        }
        return arr;
    }
    }
