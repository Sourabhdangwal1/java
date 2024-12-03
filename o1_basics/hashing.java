import java.util.HashMap;
import java.util.*;

public class hashing {
    //om
    public static void main(String[] args) {
int arr[]={4,3,2,1,1,7,7};
        System.out.println(freq1(arr,7));
        System.out.println(highFrequency(arr));
    }
//    public static int freq(int[] arr,int value){
////        HashMap<Integer,Integer> freq=new HashMap<>();
////        for (int i = 0; i < arr.length; i++) {
////            if(freq.containsKey(arr[i])){
////                freq.put(arr[i],freq.get(arr[i])+1);
////            }
////            else{
////                freq.put(arr[i],1);
////            }
////        }
//////        for (Map.Entry<Integer,Integer> e:freq.entrySet()){
//////            System.out.println("key"+ e.getKey()+ "value"+ e.getValue());
//////        }
////       return freq.getOrDefault(value,0);
////        }


    //put is used to fill key and value
    //put(key ,value)


    //getOrDefaultvalue(key,0)  used to give key value of any specific key given in bracket if it is not given then we can give default values


public static int freq1(int[] arr,int n){
    HashMap<Integer,Integer> freq=new HashMap<>();
    for(int element:arr){
      freq.put(element,freq.getOrDefault(element,0)+1);
    }
    return freq.getOrDefault(n,0);
    }

    public static int highFrequency(int[] arr){
        HashMap <Integer,Integer> freq = new HashMap<>();
        for(int element:arr){
            freq.put(element,freq.getOrDefault(element,0)+1);
        }
        int max=0;
        int x=0;
        for (Map.Entry<Integer,Integer> e:freq.entrySet()) {
        if(e.getValue()>max){
            max=e.getValue();
            x=e.getKey();
        }
        }
        return x;
    }
}
