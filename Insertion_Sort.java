public class Insertion_Sort {
 
    static class Node {

        int data;
        Node next;

        public Node(int data) {

            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    public Insertion_Sort() {
        
        head = null;
        tail = null;
    }

    public void addNode(int data) {

        Node temp = new Node(data);

        if(head == null) {

            head = temp;
            tail = temp;
        }
        else {

            tail.next = temp;
            tail = tail.next;
        }

    }

    public void display() {

        Node ptr = head;
        while (ptr != null) {

            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public void insertionSort() {

        if(head == null || head.next == null)
        {
            return;
        }

        Node a = head.next;
        Node b;
        Node a_previous = head;

        while(a != null)
        {
            Node b_previous = null;
            b = head;
            
            while(b != null && b != a)
            {
                if(b.data <= a.data)
                {
                    b_previous = b;
                    b = b.next;
                }
                else
                {
                    if(a == tail )
                    {
                        tail = a_previous;
                    }
                    a_previous.next = a.next;
                    if(b == head)
                    {
                        head = a;
                    }
                    else
                    {
                        b_previous.next = a;
                    }

                    a.next = b;
                    break;
                }
            }
            if(a_previous.next == a)
            {
                a_previous = a;
            }
            a = a.next;
        }
    }

    public static void main(String[] args) {
        
        Insertion_Sort m = new Insertion_Sort();

        m.addNode(5);
        m.addNode(4);
        m.addNode(9);
        m.addNode(3);
        m.addNode(4);
        m.addNode(6);
        m.addNode(1);
        m.addNode(2);

        System.out.println("UnSorted List:");
        m.display();
        System.out.println();

        m.insertionSort();

        System.out.println("Sorted List:");
        m.display();
    }
}