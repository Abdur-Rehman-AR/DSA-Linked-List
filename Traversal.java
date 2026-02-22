import java.util.Stack;

public class Traversal {

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

    public Traversal()
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

    public void forwardDisplay()
    {
        Node ptr = head;
        while(ptr != null)
        {
            System.out.print(ptr.data +" -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public void backwardDisplay()
    {
        Stack<Integer> stack = new Stack<>();

        Node ptr = head;
        while(ptr != null)
        {
            stack.push(ptr.data);
            ptr = ptr.next;
        }

        System.out.print("null -> ");

        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
            if(!stack.isEmpty())
            {
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) {
        
        Traversal obj = new Traversal();

        obj.addNode(5);
        obj.addNode(10);
        obj.addNode(15);
        obj.addNode(20);

        System.out.println("Forward Traversal:");
        obj.forwardDisplay();
        System.out.println();

        System.out.println("Backward Traversal:");
        obj.backwardDisplay();
    }
}