public class Insertion {

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

    public Insertion()
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

    public void Display()
    {
        Node ptr = head;
        while(ptr != null)
        {
            System.out.print(ptr.data +" -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public void InsertionAtStart(int data)
    {
        Node temp = new Node(data);

        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            temp.next = head;
            head = temp;
        }        
    }

    public void InsertionAtEnd(int data)
    {
        addNode(data);
    }

    public void InsertionAtSpecifiedPosition(int data, int position)
    {
        // if user want to insert at negative positions or if the list is empty.
        if(position < 1)
        {
            System.out.println("Specified position not Available.");
            return;
        }
        
        Node temp = new Node(data);

        // Insertion at head
        if(position == 1)
        {
            temp.next = head;
            head = temp;

            if(tail == null)
            {
                tail = temp;
            }
            return;
        }

        //finding size of Linked List for where we have to insert Element
        Node ptr = head;
        int size = 0;

        while(ptr != null && size < position-2)
        {
            ptr = ptr.next;
            size++;
        }

        // If user specified position is beyond size
        if(ptr == null)
        {
            System.out.println("Specified position not Available.");
            return;
        }
        // Insertion at middle or at end(tail)
        else
        {
            temp.next = ptr.next;
            ptr.next = temp;
            if(temp.next == null)
            {
                tail = temp;
            }
        }
    }

    public static void main(String[] args) {
        
        Insertion obj = new Insertion();

        obj.addNode(5);
        obj.addNode(10);
        obj.addNode(15);
        obj.addNode(20);

        System.out.println("Before List:");
        obj.Display();
        System.out.println();

        obj.InsertionAtStart(2);
        System.out.println("List After Insertion at Start:");
        obj.Display();
        System.out.println();

        obj.InsertionAtEnd(25);
        System.out.println("List After Insertion at End:");
        obj.Display();
        System.out.println();

        obj.InsertionAtSpecifiedPosition(50, 0);
        System.out.println("List After Insertion at specific position:");
        obj.Display();
    }
}
