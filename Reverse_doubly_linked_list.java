public class Reverse_doubly_linked_list {

    static class Node 
    {
        Node previous;
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;

    public Reverse_doubly_linked_list() 
    {
        head = null;
        tail = null;
    }

    public void addNode(int data) 
    {
        Node temp = new Node(data);
        if (head == null) 
        {
            head = temp;
            tail = temp;
        } 
        else 
        {
            tail.next = temp;
            temp.previous = tail;
            tail = tail.next;
        }
    }

    public void display_Forward() 
    {
        Node ptr = head;
        while (ptr != null) 
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public void display_Backward() 
    {
        Node ptr = tail;
        while (ptr != null) 
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.previous;
        }
        System.out.println("null");
    }
    public static void main(String[] args) 
    {
        Reverse_doubly_linked_list list = new Reverse_doubly_linked_list();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        System.out.println("Forward Display:");
        list.display_Forward();
        System.out.println("Backward Display:");
        list.display_Backward(); 

    }
}