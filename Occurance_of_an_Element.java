import java.util.Scanner;

public class Occurance_of_an_Element {

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

    public Occurance_of_an_Element() 
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

    public void countOccurrences(int value) 
    {
        Node ptr = head;
        int count = 0;
        while (ptr != null) 
        {
            if (ptr.data == value) 
            {
                count++;
            }
            ptr = ptr.next;
        }
        System.out.println("Element " +value +" occurs " +count +" times in the list.");
    }
    public static void main(String[] args) 
    {
        Occurance_of_an_Element list = new Occurance_of_an_Element();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(2);
        list.addNode(3);
        list.addNode(1);
        list.addNode(3);
        list.addNode(3);
        list.addNode(2);
        list.addNode(1);
        list.display();
        System.out.print("Enter the element to count its occurrences:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        list.countOccurrences(n);
        sc.close();
    }
}