public class Middle_Node {
 
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

    public Middle_Node()
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

    public int getMiddleElement(){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        
        Middle_Node obj = new Middle_Node();

        obj.addNode(2);
        obj.addNode(4);
        obj.addNode(6);
        obj.addNode(8);
        obj.addNode(10);
        obj.addNode(12);

        System.out.println("Middle Element is: " +obj.getMiddleElement());
    }
}