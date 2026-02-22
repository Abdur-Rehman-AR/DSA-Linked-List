import java.util.Scanner;

public class Searching {
    
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

    public Searching()
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

    public void searching(int n)
    {
        int i = 0;
        Node ptr = head;
        while(ptr != null)
        {
            i = i+1;
            if(ptr.data == n)
            {
                System.out.println("Number found at position: " +i);
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("Number not found in list.");
    }

    public static void main(String[] args) {
        
        Searching obj = new Searching();

        obj.addNode(5);
        obj.addNode(7);
        obj.addNode(12);
        obj.addNode(23);

        System.out.println("List:");
        obj.display();
        System.out.println();

        System.out.print("Enter the number you want to search: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        obj.searching(n);
        sc.close();
    }
}