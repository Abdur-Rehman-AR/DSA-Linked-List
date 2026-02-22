public class Sorted_Insertion {

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

    public Sorted_Insertion()
    {
        head = null;
        tail = null;
    }

    public void addNode(int data)
    {
        Node temp = new Node(data);
        Node previous = null;

        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            Node ptr = head;
            while(ptr != null)
            {
                if(ptr.data < temp.data)
                {
                    if(ptr.next == null)
                    {
                        ptr.next = temp;
                        tail = temp;
                        break;
                    }
                    previous = ptr;
                    ptr = ptr.next;
                }
                else
                {
                    temp.next = ptr;
                    if(previous == null)
                    {
                        head = temp;
                    }
                    else
                    {
                        previous.next = temp;
                    }
                    break;
                }
            }
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

    public static void main(String[] args) {
        
        Sorted_Insertion obj = new Sorted_Insertion();

        
        obj.addNode(5);
        obj.addNode(1);
        obj.addNode(3);  
        obj.addNode(7);  
        obj.addNode(0);  
        obj.addNode(10);  
        obj.addNode(4);   

        System.out.println("List:");
        obj.Display();
    }
}