
import java.util.*;
public class sumK {
    public static void main(String[] args) {
     int arr[]={1,3,4,2,2};
       // System.out.println(sumK(arr,7));
        System.out.println(sumK2(arr,7));
    }
    public static List<List<Integer>> sumK(int[] arr,int t){
      ArrayList<Integer> list = new ArrayList<>();
      List<List<Integer>> newList = new ArrayList<>();
        findSum(arr,t,list,0,newList);
      return newList;
    }
    public static void findSum(int[] arr,int t,ArrayList<Integer> list,int i,List<List<Integer>> newList){
        if(i== arr.length){
            if(t==0){
                // why we are creating copy of list and not using real array list
                // because newList will get refrence of list if we will update list later(which will happen in backtracking) then newList will also  get updated

                newList.add(new ArrayList<>(list));
                //syntex to copy a array list into new arraylist
               // ArrayList<Integer> copiedList = new ArrayList<>(originalList);
            }
            return;
        }
        if(arr[i]<=t) {
            list.add(arr[i]);
            findSum(arr, t - arr[i], list, i,newList);
            list.remove(list.size() - 1);
        }
        findSum(arr,t,list,i+1,newList);
    }

    public static List<List<Integer>> sumK2(int[] arr,int t){
        Arrays.sort(arr);
        List<List<Integer>> newList = new ArrayList<>();
        findSum2(arr,0,t,newList,new ArrayList<>());
        return newList;
    }
    public static void findSum2(int[] arr,int i,int t,List<List<Integer>> newList,ArrayList<Integer> list){
        if(t==0){
            newList.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<arr.length;j++) {
            if(j>i && arr[j]==arr[j-1]){
                continue;
            }
            if(arr[j]>t){
                break;
            }
            list.add(arr[j]);
            findSum2(arr,   j + 1, t - arr[j], newList, list);
            list.remove(list.size()-1);

        }
    }
}
