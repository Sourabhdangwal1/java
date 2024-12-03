import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class basicArrays1 {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 4 };
        int arr2[] = {4, 3, 2, 1, 5};
        int[] arr={1,1,0,1,1,1,1};

//        int[] ans = union(arr1, arr2);
        ArrayList<Integer> ans1=union1(arr1,arr2);
        System.out.println(ans1);
//        for (int e : ans) {
//            System.out.println(e);
//        }
        System.out.println(missingNumber(arr1));
        System.out.println(consectiveNumber(arr));
        System.out.println(comeOnce(arr));
    }

    public static int[] union(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> ds = new HashMap<>();

        // Adding elements from arr1
        for (int element : arr1) {
            ds.put(element, ds.getOrDefault(element, 0) + 1);
        }

        // Adding elements from arr2
        for (int element : arr2) {
            ds.put(element, ds.getOrDefault(element, 0) + 1);
        }

        // Use ArrayList to dynamically handle the size of the union result
        ArrayList<Integer> tempList = new ArrayList<>();

        // Adding the unique keys (elements) to tempList
        for (Map.Entry<Integer, Integer> ele : ds.entrySet()) {
            tempList.add(ele.getKey());  // Adding the key (element) to the list
        }

        // Convert the ArrayList to an array
        int[] ans = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            ans[i] = tempList.get(i);
        }

        return ans;
    }

    public static ArrayList<Integer> union1(int[] arr1,int[] arr2){
        HashSet<Integer> ds =new HashSet<>();
         for (int e : arr1){
             ds.add(e);
         }
        for (int e : arr2){
            ds.add(e);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for (int element:ds){
            ans.add(element);
        }
        return ans;
    }

    public static int missingNumber(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=i+1){
                return i+1;
            }
        }
        return -1;
    }
//    public static int missingNumber1(int[] arr){
//        int sum=0;
//        int n=arr[arr.length-1];
//        for (int i = 0; i <arr.length ; i++) {
//            sum=sum+arr[i];
//        }
//        int s=((n)*(n+1))/2;
//        return s-sum;
//    }
//
    public static int consectiveNumber(int[] arr){
        int count=1;
        int maxcount=1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]){
                count++;
            }
            else {
                count=1;
            }
            if (count>maxcount){
                maxcount=count;
            }
        }
        return maxcount;
    }

    //to find number that appear once in an array
    //check for each array and then count how much time they appeaer
    //optimal approach
    public static int comeOnce(int[] arr){
        HashMap<Integer,Integer> ds=new HashMap<>();
        for(int element:arr){
            ds.put(element,ds.getOrDefault(element,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:ds.entrySet()){
           int x= e.getKey();
           int y=e.getValue();
           if(y==1){
               return x;
           }
        }
        return -1;
    }

}

