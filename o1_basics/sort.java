import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 7, 5, 3, 6, 4, 11};
//        selection(arr);
//        for (int i:arr) {
//            System.out.println(i);
//        }
//        bubble(arr);
//        for (int i:arr) {
//            System.out.println(i);
//        }
        // insertion(arr);
//        int[] x = mergeSort(arr);
//        for(int i:x){
//            System.out.println(i);
//        }

//        quickSort(arr);
        recursiveInsertion(arr,arr.length,1);
        for(int i:arr){
           System.out.println(i);
        }
   }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //outer loop will run upto n-2(second last element) because when we will arrange upto second last element
    // then every element will get arranged automatically
    //for ineer loop, inner loop will start running from i+1 because we took i as a minimum to compare in future and moreover we know
    // in starting minimum elements will come(which we already checked) so we need to apply loop to remaining elements
    public static void selection(int[] arr){
        for (int i=0; i<arr.length-1;i++){
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }

            }
            swap(arr,i,min);
        }
    }
    //for inner loop similar reason last element remaining  will get automatically arranged as other element will get arranged to last according to there order
//for outer loop we are going upto arr.length-1-i because for arr.length - 1 =>because we are comparing arr[j+1] with arr[j] so if reach at last element
// it doesnot have anything next to compare
// thats why it can give array exception out of bounds
// and for -i we can say with each loop largest element in total array of number counted is arranges at the last

//    public static void bubble(int[] arr){
//         for (int i = 0; i < arr.length - 1; i++) {
//        for (int j = 0; j < arr.length - 1 - i; j++) {
//            if (arr[j] > arr[j + 1]) {
//                swap(arr, j, j + 1);
//            }
//        }
//    }
//}

    // for outer loop here we started loop from backward n-1 to 1 th element not zero becuse similar reason
    //another is similar just in inner loop j will go upto i because other elements will get settled at end which are greater in array
    public static void bubble(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }

        }
    }
    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                    j--;
                } else {
                    break;
                }

            }
        }

    }


    //merge sort
//    public static void mergeSort(int[] arr){
//        int low=0;
//        int high= arr.length-1;
//       // int mid=(low+high)/2;
//
//        m(arr,low,high);
//    }
//    public static void m(int[] arr,int start, int end){
//
//        if(start>=end){
//            return;
//
//        }
//       int  mid=(start+end)/2;
//        m(arr,start,mid);
//        m(arr,mid+1,end);
//        merge(arr,start,mid,end);
//
//    }
//
//    public static  void merge(int[] arr,int start,int mid,int end){
//        int i=start;
//        int j=mid+1;
//        int k=0;
//        int[] a=new int[arr.length];
//        while(i<=mid && j<=end){
//            if (arr[i]<arr[j]){
//                a[k]=arr[i];
//                i++;
//            }
//            else {
//                a[k]=arr[j];
//                j++;
//            }
//            k++;
//        }
//        while(i<=mid){
//            a[k]=arr[i];
//            i++;
//            k++;
//        }
//        while(j<=end){
//            a[k]=arr[j];
//            j++;
//            k++;
//        }
//        for (int l = start; l <=end ; l++) {
//            arr[l]=a[l-start];//jai shree ram
//
//        }
//
//    }

    public static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left= mergeSort(Arrays.copyOfRange(arr,0,mid));//this function wil gve array from 0 to mid-1 here mid is excluded
        int[] right= mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
         return merge(left,right);
    }
    public static int[] merge(int[] left,int[] right){
        int i=0;
        int j=0;
        int k=0;
        int ans[]= new int[left.length+right.length];
        while (i<left.length && j<right.length){
            if(left[i]<right[j]){
                ans[k]=left[i];
                i++;
            }
            else{
                ans[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
           ans[k]=left[i];
           i++;
           k++;
        }
        while(j<right.length){
            ans[k]=right[j];
            j++;
            k++;
        }
     return ans;

    }

    public static void quickSort(int[] arr){
        int low=0;
        int high=arr.length-1;
        int p=0;
        qs(arr,low,high);
    }
    public static void qs(int[] arr,int start,int end){
        if(start<end){//so that array contains more than 1 element or number
            int pos=partition(arr,start,end);
            qs(arr,start,pos-1);
            qs(arr,pos+1,end);
        }

    }


    public static int partition(int[] arr,int start,int end){
        //our aim here is to set pivot at a specific point where element its left are smaller and element on its right should be greater
        int pivot=arr[start]; //choosing first element as pivot
        int i=start;
        int j=end;
        while(i<j){
            //if any element is greater then pivot starting from left then choose it
            while(arr[i]<=pivot && i<end){ //i<=end-1 to not get array out of bounds
                
                i++;
            }
            //if any element is smaller then pivot starting from right then choose it
            while(arr[j]>pivot && j>start){ //j>=start+1 to not get array out of bounds
                j--;
            }
            //swap bigger number from starting and smaller number from last
            if(i<j){
                swap(arr,i,j);
            }

        }
        //swap when j crosses i
        //swap j element and pivot element because it should be the perfect position of pivot element
        swap(arr,start,j);
        return j;
    }
    public static void recursiveBubble(int[] arr,int n){  //n is no of elements in array
        if(n==1)//it is working as outer loop
            return;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
            recursiveBubble(arr,n-1);
    }
    public static void recursiveInsertion(int[] arr,int n,int i){
        if(i==n-1){ //n is array.length
            return;
        }

          while(arr[i]<arr[i-1]){
              swap(arr,i,i-1);
              i--;
          }
          recursiveInsertion(arr,n,i+1);
    }

}