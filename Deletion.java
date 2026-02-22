public class Deletion {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public Deletion() {
        head = null;
        tail = null;
    }

    public void addNode(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
    }

    public void Display() 
    {
        if(head == null)
        {
            System.out.println("List is Empty.");
            return;
        }
        Node ptr = head;
        while (ptr != null) 
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    // deleting the 1st node

    public void deletionAtStart() {

        if(head == null)
        {
            return;
        }
        head = head.next;
        if(head == null)
        {
            tail = null;
        }
    }

    // deleting the last node

    public void deletionAtEnd() {

        if(head == null)
        {           
            return;
        }

        if(head == tail)
        {
            head = null;
            tail = null;
            return;
        }

        Node ptr = head;
        Node previous = null;

        while (ptr != null) 
        {
            if (ptr.next == null) 
            {
                break;
            } 
            else 
            {
                previous = ptr;
                ptr = ptr.next;
            }
        }
        previous.next = null;
        tail = previous;
    }

    // deleting the node with specific data part

    public void deletingSpecificNumber(int data) {

        if(head == null)
        {           
            return;
        }

        if(head == tail)
        {
            if(head.data == data)
            {
                head = null;
                tail = null;
                return;
            }
            else
            {
                System.out.println("Invalid Number.");
                return;
            }
        }

        Node ptr = head;
        Node previous = null;
        boolean deleted = false;

        while (ptr != null) 
        {
            if(ptr.data == data)
            {
                if (ptr == head) 
                {
                    head = head.next;
                } 
                else if (ptr == tail) 
                {
                    previous.next = null;
                    tail = previous;
                } 
                else 
                {
                    previous.next = ptr.next;
                }
                deleted = true;
                break;
            }
            else 
            {
                previous = ptr;
                ptr = ptr.next;
            }
        }
        if(!deleted)
        {
            System.out.println("Number not found.");
        }
    }

    // deleting the node with a specific position

    public void deletionAtSpecificPosition(int pos) {

        if (pos < 1 || head == null) 
        {
            System.out.println("Position not Available.");
            return;
        }

        if (pos == 1) 
        {
            head = head.next;
            if (head == null) 
            {
                tail = null;
            }
            return;
        }

        Node ptr = head;
        Node previous = null;

        for (int i = 1; i < pos; i++) 
        {
            previous = ptr;
            ptr = ptr.next;
            if (ptr == null) 
            {
                System.out.println("Position not Available.");
                return;
            } 
        }

        previous.next = ptr.next;

        if(ptr == tail)
        {
            tail = previous;
        }
    }

    // deleting the entire list

    public void deletingList() {

        head = null;
        tail = null;
    }

    public static void main(String[] args) {

        Deletion obj = new Deletion();

        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(6);
        obj.addNode(7);
        obj.addNode(8);

        System.out.println("Actual List:");
        obj.Display();
        System.out.println();

        obj.deletionAtStart();
        System.out.println("List After Deletion at Start:");
        obj.Display();
        System.out.println();

        obj.deletionAtEnd();
        System.out.println("List After Deletion at End:");
        obj.Display();
        System.out.println();

        obj.deletingSpecificNumber(5);
        System.out.println("List After Deleting a specific number:");
        obj.Display();
        System.out.println();

        obj.deletionAtSpecificPosition(2);
        System.out.println("List After Deletion at specific position:");
        obj.Display();
        System.out.println();

        obj.deletingList();
        System.out.println("List After Deleting entire List:");
        obj.Display();
    }
}