import java.util.Stack;

public class Reverse_List {

    Stack<Integer> stack = new Stack<>();
 
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

    public Reverse_List()
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

        stack.push(temp.data);
    }

    public void reverse()
    {
        while (!stack.empty()) 
        {
            System.out.print(stack.pop() +" -> ");
        }
        System.out.print("null");
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

    public static void main(String[] args) {
        
        Reverse_List obj = new Reverse_List();

        obj.addNode(5);
        obj.addNode(7);
        obj.addNode(12);
        obj.addNode(23);

        System.out.println("List:");
        obj.display();
        System.out.println();

        System.out.println("New Reversed List:");
        obj.reverse();
    }
}