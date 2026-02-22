public class Remove_Cycle {
    
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

    public Remove_Cycle()
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

    public void removeCycle() 
    {
        Node slow = head;
        Node fast = head;

        boolean cycleExists = false;
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) 
            {
                cycleExists = true;
                break;
            }
        }

        if (!cycleExists) return;

        slow = head;
        while (slow.next != fast.next) 
        {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
    }

    public static void main(String[] args) {
        
        Remove_Cycle obj = new Remove_Cycle();

        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(6);
        obj.addNode(7);
        obj.addNode(8);

        obj.tail.next = obj.head.next.next;

        obj.removeCycle();
        obj.display();
    }
}