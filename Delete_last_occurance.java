import java.util.Scanner;

public class Delete_last_occurance {

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

    public Delete_last_occurance() 
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

    public void deleteLastOccurance(int n) 
    {
        if (head == null) return;

        Node ptr = head;
        Node prevOfLast = null; 
        Node last = null;       
        Node prev = null;       

        while (ptr != null) 
        {
            if (ptr.data == n) 
            {
                last = ptr;
                prevOfLast = prev;
            }
            prev = ptr;
            ptr = ptr.next;
        }

        if (last == null) return;

        if (prevOfLast == null) 
        { 
            head = head.next;
        } 
        else 
        { 
            prevOfLast.next = last.next;
        }
    }
    public static void main(String[] args) 
    {
        Delete_last_occurance list = new Delete_last_occurance();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(2);
        list.addNode(4);
        list.addNode(2);
        list.addNode(2);
        list.addNode(5); 

        System.out.print("Enter number you want to delete: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Original List: ");
        list.display();
        list.deleteLastOccurance(n);
        System.out.println("List after deleting last occurance of "+n);
        list.display();

        sc.close();
    }
}