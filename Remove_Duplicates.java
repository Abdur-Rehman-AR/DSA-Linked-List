import java.util.HashSet;

public class Remove_Duplicates {
    
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

    public Remove_Duplicates()
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

    public void removeDuplicates()
    {
        HashSet<Integer> l = new HashSet<>();
        Node pre = null;
        Node ptr = head;

        while(ptr != null)
        {
            if(l.contains(ptr.data))
            {
                pre.next = ptr.next;
            }
            else
            {
                l.add(ptr.data);
                pre = ptr;
            }
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        
        Remove_Duplicates obj = new Remove_Duplicates();

        obj.addNode(2);
        obj.addNode(6);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(6);
        obj.addNode(2);
        obj.addNode(4);
        obj.addNode(5);

        System.out.print("List before removing duplicates: ");
        obj.display();
        System.out.println();

        System.out.print("List after removing duplicates: ");
        obj.removeDuplicates();
        obj.display();
        System.out.println();
    }
}