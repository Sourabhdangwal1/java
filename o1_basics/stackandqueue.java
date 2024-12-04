import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackandqueue {
public static class queueimple{
    //using stack
    Stack<Integer> i=new Stack<>();
    Stack<Integer> o=new Stack<>();
    public void add(int data){
        while(i.empty()!=true){
            o.push(i.pop());
        }
        i.push(data);
        while (o.empty()!=true){
            i.push(o.pop());
        }
    }
    public int remove(){
        if(i.empty()==true){
            System.out.println("Empty");
        }
        int x=i.peek();
        i.pop();
        return x;
    }
    public int peek(){
        if(i.empty()==true){
            System.out.println("Empty");
            return -1;
        }
        return i.peek();
    }
    public int size(){
        return i.size();
    }
    public void display(){
        for (int item:i){
            System.out.println(i);
        }
    }
}
public static class stackimple{
    Queue<Integer> i=new LinkedList<>();
    Queue<Integer> o=new LinkedList<>();
    public void push(int data){
        while(i.isEmpty()!=true){
            o.add(i.remove());
        }
        i.add(data);
        while (o.isEmpty()!=true){
            i.add(o.remove());
        }
    }
    public int pop(){
       if(i.isEmpty()==true){
           System.out.println("Empty");
           return -1;
       }
       int x=i.peek();
       i.remove();
       return x;
    }
    public int top(){
        if(i.isEmpty()==true){
            System.out.println("Empty");
            return -1;
        }
        return i.peek();
    }
    public void display() {
       for(int item:i){
           System.out.println(i);
       }
    }
    }

    public static void main(String[] args) {
        queueimple q1=new queueimple();
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.remove();
        q1.display();
        stackimple s1=new stackimple();
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.pop();
        s1.display();
    }
}
