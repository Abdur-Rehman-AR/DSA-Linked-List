public class Sort_0s_1s_2s {

    static class Node 
    {
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Sort_0s_1s_2s() 
    {
        head = null;
        tail = null;
    }

    public void addNode(int data) 
    {
        Node temp = new Node(data);
        if (head == null) 
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
        while (ptr != null) 
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public void sortList()
    {
        if(head == null || head.next == null)
        {
            return;
        }
        else
        {
        Node a = null;
        Node b = null;
        Node c = null;
        Node ah = null;
        Node bh = null;
        Node ch = null;
        Node ptr = head;
        Node next = null;

        while(ptr != null)
        {
            next = ptr.next;
            ptr.next = null;

            if(ptr.data == 0)
            {
                if(a == null)
                {
                    a = ptr;
                    ah = ptr;
                }
                else
                {
                    a.next = ptr;
                    a = a.next;
                }
            }

            else if(ptr.data == 1)
            {
                if(b == null)
                {
                    b = ptr;
                    bh = ptr;
                }
                else
                {
                    b.next = ptr;
                    b = b.next;
                }
            }

            else if(ptr.data == 2)
            {
                if(c == null)
                {
                    c = ptr;
                    ch = ptr;
                }
                else
                {
                    c.next = ptr;
                    c = c.next;
                }
            }
            else
            {
                return;
            }
            ptr = next;
        }

        if(ah != null) head = ah;
        else if(bh != null) head = bh;
        else head = ch;

        if(c != null) tail = c;
        else if(b != null) tail = b;
        else tail = a;
        
        if(a != null) a.next = bh;
        if(b != null) b.next = ch;
        if(c != null) c.next = null;
        return;
        }
    }
    public static void main(String[] args) 
    {
        Sort_0s_1s_2s list = new Sort_0s_1s_2s();
        list.addNode(1);
        list.addNode(2);
        list.addNode(0);
        list.addNode(1);
        list.addNode(2);
        list.addNode(0);
        list.addNode(0);
        list.addNode(0);
        list.display(); 
        list.sortList();
        list.display();
    }
}