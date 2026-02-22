import java.util.HashMap;

public class Cloning {

    static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    Node head;
    Node cloneHead;

    public void addNode(int data) 
    {
        Node temp = new Node(data);

        if (head == null) 
        {
            head = temp;
        } 
        else 
        {
            Node ptr = head;
            while (ptr.next != null) 
            {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
    }

    public void display(Node head) 
    {
        Node ptr = head;
        while (ptr != null) 
        {
            System.out.print(ptr.data + "(");
            if (ptr.random != null)
            {
                System.out.print(ptr.random.data);
            }
            else
            {
                System.out.print("null");
            }
            System.out.print(") -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public void cloneList() 
    {
        HashMap<Node, Node> map = new HashMap<>();

        Node ptr = head;

        // Step 1: Clone nodes (next pointers only)
        while (ptr != null) 
        {
            map.put(ptr, new Node(ptr.data));
            ptr = ptr.next;
        }

        // Step 2: Assign next and random pointers
        ptr = head;
        while (ptr != null) 
        {
            Node cloned = map.get(ptr);
            cloned.next = map.get(ptr.next);
            cloned.random = map.get(ptr.random);
            ptr = ptr.next;
        }

        cloneHead = map.get(head);
    }

    public static void main(String[] args) {

        Cloning obj = new Cloning();

        obj.addNode(2);
        obj.addNode(4);
        obj.addNode(6);

        obj.head.random = obj.head.next.next;
        obj.head.next.random = null;         
        obj.head.next.next.random = obj.head;

        System.out.print("Original List: ");
        obj.display(obj.head);

        obj.cloneList();

        System.out.print("Cloned List:   ");
        obj.display(obj.cloneHead);
    }
}