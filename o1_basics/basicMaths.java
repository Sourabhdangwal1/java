import java.util.*;
public class basicMaths{
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int x=countDigits(n);
     System.out.println(x);
        System.out.println(reverse(n));
        System.out.println(checkPalindrome(n));
        System.out.println(armstrong(n));
        System.out.println(isPrime(n));
       printDivisor(n);
        System.out.println(gcd(40,45));
    }
    static int countDigits(int n){
        int count = 0;
        while(n!=0){
            n=n/10;
             count++;
        }
        return count;
    }
    public static int reverse(int n){
        int rev=0;
        while(n!=0){
            int a=n%10;
            rev=rev*10+a;
            n=n/10;
        }
      return rev;
    }
    public static boolean checkPalindrome(int n){
        int x=reverse(n);
        if(n==x){
            return true;
        }
        return false;
    }
    public static boolean armstrong(int n){
        int a=n;
        int sum=0;
        while(n!=0){
            int b=n%10;
            sum=sum+(b*b*b);
            n=n/10;
        }
        if(sum==a){
            return true;
        }
        return false;
    }
    private static boolean isPrime(int n){
        int i=1;
        int count=0;
        while(i*i<=n){
            if(n%i==0){
                count++;
                if(n/i!=i){
                    count++;
                }
            }
            if(count>2){
                return false;
            }
            i++;
        }
        return true;
    }
 public static void printDivisor(int n){
        int i=1;
        while(i*i<=n){
            if(n%i==0){
                System.out.println(n);
                if(n/i!=i){
                    System.out.println(i);
                }
            }
            i++;
        }
    }
    public static int gcd(int n1,int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = (n1 % n2);
            } else {
                n2 = (n2 % n1);
            }
        }
        if(n1==0) {
            return n2;
        }
        else{
            return n1;
        }
    }
}