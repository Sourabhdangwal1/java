public class queueans {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class queue{
        int f=-1;
        int r=-1;
        int size=0;
        int arr[]=new int[108];
        void add(int data){
            if(r== arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(size==0){
              f++;
              r++;
              arr[r]=data;
            }
            else{
                arr[++r]=data;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            int x=arr[f];
            f++;
            size--;
            return x;
        }
        public int peek(int[] arr){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[f];
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is empty");
            }
            else {
                for (int i = f; i <= r; i++) {
                    System.out.println(arr[f]);
                }
            }
        }
    }
    public static class linkedqueue{
        Node head=null;
        Node tail=null;
        int size=0;
        public void add(int data){
            Node temp=new Node(data);
            if(head==null){
                tail=head=temp;
            }
//            Node temp1=head;
//            while(temp1.next!=null){
//                temp1=temp1.next;
//            }
//            temp1.next=temp;
            tail.next=temp;
            size++;
        }//add at end
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        public int remove(){
            int x=head.data;
            Node temp=head.next;
            head=temp;
            size--;
            return x;
        }
        public int peek(){
            if(size==0){
                System.out.println("Invalid");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        linkedqueue l1=new linkedqueue();
        l1.add(10);
        l1.add(4);
        l1.display();
        l1.remove();
        l1.display();
        System.out.println(l1.size);
    }
}
