public class Pairwise_swap {

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

    public Pairwise_swap() 
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
            tail = tail.next;
        }
    }

    public void display() 
    {
        Node ptr = head;
        while (ptr != null) 
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public void pairwiseSwap()
    {
        if(head == null || head.next == null)
        {
            return;
        }

        Node ptr = head;
        Node prev = null;
        Node nxt = null;
        head = ptr.next;

        while(ptr != null && ptr.next != null)
        {
            nxt = ptr.next;
            ptr.next = ptr.next.next;
            nxt.next = ptr;
            if(prev != null)
            {
                prev.next = nxt;
            }
            prev = ptr;
            if(ptr.next == null)
            {
                tail = ptr;
            }
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) 
    {
        Pairwise_swap list = new Pairwise_swap();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addNode(8);
        list.addNode(9);
        list.addNode(10);
        list.display(); 
        list.pairwiseSwap();
        System.out.println("After pairwise swapping:");
        list.display();
    }
}