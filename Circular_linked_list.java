public class Circular_linked_list {

    static class Node 
    {
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Circular_linked_list() 
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
            temp.next = head;
        } 
        else 
        {
            tail.next = temp;
            tail = tail.next;
            temp.next = head;
        }
    }

    public void display() 
    {
        Node ptr = head;
        if(ptr != null) 
            {
                do 
                {
                    System.out.print(ptr.data + " -> ");
                    ptr = ptr.next;
                } 
                while(ptr != head);
                System.out.println("(back to head)");
            }
    }
    public static void main(String[] args) 
    {
        Circular_linked_list list = new Circular_linked_list();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.display(); 
    }
}