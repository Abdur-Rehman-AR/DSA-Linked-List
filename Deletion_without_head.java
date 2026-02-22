public class Deletion_without_head {

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

    public Deletion_without_head() 
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

    public void deleteNode(Node node)
    {
        if(node == null || node.next == null)
        {
            System.out.println("Cannot delete the given node using this method.");
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
    public static void main(String[] args) 
    {
        Deletion_without_head list = new Deletion_without_head();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addNode(8);
        list.addNode(9);
        list.addNode(10);
        list.display(); 
        list.deleteNode(list.head.next.next);
        list.display();
    }
}