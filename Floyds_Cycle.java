public class Floyds_Cycle {
    
    static class Node {

    int data;
    Node next;  
    
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

    Node head;
    Node tail;

    public Floyds_Cycle()
    {
        head = null;
        tail = null;
    }

    public void addNode(int data)
    {
        Node temp = new Node(data);

        if(head == null)
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
        while(ptr != null)
        {
            System.out.print(ptr.data +" -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public void detectCycle()
    {
        Node slow = head;
        Node fast = head; 

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                System.out.println("Cycle Exists.");
                return;
            }
        }
            System.out.println("Cycle Doesn't Exists.");
    }

    public static void main(String[] args) {
        
        Floyds_Cycle obj = new Floyds_Cycle();

        obj.addNode(2);
        obj.addNode(6);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(6);
        obj.addNode(2);
        obj.addNode(4);
        obj.addNode(5);

        obj.tail.next = obj.head.next.next;

        obj.detectCycle();
    }
}