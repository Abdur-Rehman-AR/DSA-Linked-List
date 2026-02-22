public class Merging {
    
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

    public Merging()
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

    public void display(Node n)
    {
        Node ptr = n;
        while(ptr != null)
        {
            System.out.print(ptr.data +" -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public Node mergeList(Node x, Node y) 
    {
        Node start = null;
        Node a = x;
        Node b = y;
        Node pre = null;

        if(a == null) return b;
        if(b == null) return a;

        if(a.data <= b.data)
        {
            start = a;
            pre = a;
            a = a.next;
        }
        else
        {
            start = b;
            pre = b;
            b = b.next;
        }

        while(a != null && b != null)
        {
            if(a.data <= b.data)
            {
                pre.next = a;
                pre = a;
                a = a.next;
            }
            else
            {
                pre.next = b;
                pre = b;
                b = b.next;
            }
        }

        if(a == null && b != null)
        {
            pre.next = b;
        }
        if(b == null && a != null)
        {
            pre.next = a;
        }
            return start;
    }

    public static void main(String[] args) {
        
        Merging obj = new Merging();
        Merging obj1 = new Merging();

        obj.addNode(1);
        obj.addNode(4);
        obj.addNode(6);
        obj.addNode(7);
        obj.addNode(10);

        obj1.addNode(2);
        obj1.addNode(3);
        obj1.addNode(5);
        obj1.addNode(8);
        obj1.addNode(9);

        Node a = obj.head;
        Node b = obj1.head;

        Node result = obj.mergeList(a, b);
        obj.display(result);
        
    }
}