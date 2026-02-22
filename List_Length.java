public class List_Length {
    
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

    public List_Length()
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

    public void getLength()
    {
        int i = 0;
        Node ptr = head;
        while(ptr != null)
        {
            i = i+1;
            ptr = ptr.next;
        }
        System.out.println("Size of list is: " +i);
    }

    public static void main(String[] args) {
        
        List_Length obj = new List_Length();

        obj.addNode(5);
        obj.addNode(7);
        obj.addNode(12);
        obj.addNode(23);

        System.out.println("List:");
        obj.display();
        System.out.println();

        obj.getLength();
    }
}