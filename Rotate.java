import java.util.Scanner;

public class Rotate {
    
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

    public Rotate()
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

    public void leftRotation(int k)
    {
        if(k == 0)
        {
            return;
        }

        tail.next = head;
        Node ptr = head;
        for(int i = 0; i < k-1; i++)
        {
            ptr = ptr.next;
        }
        tail = ptr;
        head = ptr.next;
        ptr.next = null;
    }
    
    public void rightRotation(int k)
    {
        if(k == 0)
        {
            return;
        }
        
        tail.next = head;
        Node a = head;
        Node b = head;

        for(int i = 0; i < k; i++)
        {
            a = a.next;
        }
        while(a != tail)
        {
            a = a.next;
            b = b.next;
        }
        tail = b;
        head = b.next;
        b.next = null;
    }

    public static void main(String[] args) {
        
        Rotate obj = new Rotate();

        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);

        System.out.print("List: ");
        obj.display();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 for Left Rotation");
        System.out.println("         OR");
        System.out.println("Enter 1 for Right Rotation");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter value of K: ");
        int k = sc.nextInt();

        if(n == 0)
        {
            obj.leftRotation(k);
            System.out.print("List after Left Rotation: ");
            obj.display();
        }
        else if(n == 1)
        {
            obj.rightRotation(k);
            System.out.print("List after Right Rotation: ");
            obj.display();
        }
        else
        {
            System.out.println("Wrong option choosen.");
        }
        sc.close();
    }
}