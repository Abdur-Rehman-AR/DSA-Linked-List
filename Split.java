public class Split {
    
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

    public Split()
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

    public Node splitList()
    {
        if(head == null)
        {
            System.out.println("List is Empty.");
            return null;
        }
        if(head == tail)
        {
            System.out.println("List has only 1 Node, cannot be split.");
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node pre = slow.next;
        slow.next = null;
        return pre;
    }

    public static void main(String[] args) {
        
        Split obj = new Split();

        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);

        Node a = obj.splitList();
        System.out.print("List 1: ");
        obj.display(obj.head);

        System.out.println();

        System.out.print("List 2: ");
        obj.display(a);
    }
}