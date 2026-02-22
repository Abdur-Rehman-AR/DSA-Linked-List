import java.util.Scanner;

public class Update_Value {
 
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

    public Update_Value()
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

    public void update(int p, int n)
    {
        if(p <= 0)
        {
            System.out.println("Invalid Position.");
            return;
        }
        Node ptr = head;
        int i = 1;
        while(ptr != null)
        {
            if(i == p)
            {
                ptr.data = n;
                return;
            }
            else
            {
                ptr = ptr.next;
                i++;
            }
        }
        System.out.println("Invalid Position.");
    }

    public static void main(String[] args) {
        
        Update_Value obj = new Update_Value();

        obj.addNode(5);
        obj.addNode(7);
        obj.addNode(12);
        obj.addNode(23);

        System.out.println("List:");
        obj.display();
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the position, where you want to change value: ");
        int p = sc.nextInt();
        System.out.print("Enter the value: ");
        int n = sc.nextInt();
        obj.update(p, n);

        System.out.println("New updated List:");
        obj.display();

        sc.close();
    }
}