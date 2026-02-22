import java.util.Scanner;

public class Deletion_circular_linkedlist {

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

    public Deletion_circular_linkedlist() 
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
            temp.next = head;
        } 
        else 
        {
            tail.next = temp;
            tail = tail.next;
            temp.next = head;
        }
    }

    public void display() 
    {
        Node ptr = head;
        if(ptr != null) 
            {
                do 
                {
                    System.out.print(ptr.data + " -> ");
                    ptr = ptr.next;
                } 
                while(ptr != head);
                System.out.println("(back to head)");
            }
    }

    public void deleteNode(int n)
    {
        if(head == null)
        {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        else if(head == tail && head.data == n)
        {
            head = tail = null;
            return;
        }
        else if(head.data == n)
        {
            head = head.next;
            tail.next = head;
            return;
        }
        else
        {
            Node a = head;
            Node ptr = head.next;
            while(ptr != head)
            {
                if(ptr.data == n)
                {
                    a.next = ptr.next;
                    if(ptr == tail)
                    {
                        tail = a;
                    }
                    return;
                }
                a = ptr;
                ptr = ptr.next;
            }
        }
    }
    public static void main(String[] args) 
    {
        Deletion_circular_linkedlist list = new Deletion_circular_linkedlist();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.display();
        System.out.print("Enter the number you want to delete: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        list.deleteNode(n);
        list.display();
        sc.close();
    }
}