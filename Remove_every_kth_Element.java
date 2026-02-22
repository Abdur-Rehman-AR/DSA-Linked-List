import java.util.Scanner;

public class Remove_every_kth_Element {

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

    public Remove_every_kth_Element() 
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

    public void RemoveEveryKthElement(int k)
    {
        if (k <= 0 || head == null) return;

        if (k == 1) 
        {
            head = null;
            tail = null;
            return;
        }

        Node ptr = head;
        Node prev = null;
        int count = 1;

        while (ptr != null) 
        {
            if (count == k) 
            {
                prev.next = ptr.next;
                if (ptr == tail) 
                {
                    tail = prev;
                }

                ptr = prev.next;
                count = 1;
            } 
            else 
            {
                prev = ptr;
                ptr = ptr.next;
                count++;
            }
        }
    }
    public static void main(String[] args) 
    {
        Remove_every_kth_Element list = new Remove_every_kth_Element();
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        list.RemoveEveryKthElement(k);
        list.display();
        sc.close();
    }
}