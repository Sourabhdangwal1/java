public class stackans{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class LinkedStack{
        Node head=null;
        Node tail=null;
        int size=0;
        public void push(int data){//insertAtStart
            Node temp = new Node(data);
            if(head==null){
                head=tail=temp;
                return;
            }
            temp.next=head;
            head=temp;
            size++;
        }
        public int pop(){//deleteAtStart
            if(head==null){
                System.out.println("Stack is already empty");
                return -1;
            }
            int x=head.data;
            Node temp=head.next;
            head=null;
            head=temp;
            size--;
            return x;
        }
        int peek(){
            if(head==null){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
        int size(){
            if(size<=0){
                System.out.println("stack is Empty");
            }
            return size;
        }
        void display(){
            stackdisplay(head);
        }
        void stackdisplay(Node head){
            if(head==null){
                return;
            }
            stackdisplay(head.next);
            System.out.println(head.data);
        }

    }
    public static class stack {
        private int arr[] = new int[6];
        int index = -1;

        void push(int data) {
            if(arr.length<index){
                System.out.println("Stack is full");
                return;
            }
            index++;
            arr[index] = data;
        }

        int peek() {
            if (index == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[index];
        }

        int pop() {
            if (index == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            int x = arr[index];
            arr[index] = 0;
            index--;
            return x;
        }

        void display() {
            for (int i = 0; i < index + 1; i++) {
                System.out.println(arr[0]);
            }
        }
        int size(){
            return index;
        }
        boolean isEmpty(){
            if(index==-1){
                return true;
            }
            return false;
        }
        boolean isfull(){
            if(index<arr.length){
                return false;
            }
            return true;
        }

        }

    public static void main(String[] args) {
//        stack s1=new stack();
//        System.out.println(s1.isEmpty());
//        s1.push(5);
//        s1.push(6);
//        System.out.println(s1.pop());
//        s1.display();
//        s1.isfull();
        LinkedStack l1=new LinkedStack();
        l1.push(5);
        l1.push(6);
        l1.push(7);
        l1.push(10);
        l1.pop();
        l1.display();
    }
}