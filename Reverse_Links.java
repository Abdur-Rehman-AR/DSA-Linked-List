public class Reverse_Links {
 
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

    public Reverse_Links()
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

    public void reverse() 
    {
        Node prev = null;
        Node curr = head;
        Node next = null;
        tail = head;

        while (curr != null) 
        {
            next = curr.next;  
            curr.next = prev;  
            prev = curr;      
            curr = next;        
        }

        head = prev;
    }

    public static void main(String[] args) {
        
        Reverse_Links obj = new Reverse_Links();

        obj.addNode(5);
        obj.addNode(7);
        obj.addNode(12);
        obj.addNode(23);

        System.out.println("Actual List:");
        obj.display();
        System.out.println();

        obj.reverse();

        System.out.println("Reversed List:");
        obj.display();
    }
}