import java.util.Scanner;

public class Rotation {
    
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

    public Rotation()
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

    public void leftRotation(int p)
    {
        if(p <= 0)
        {
            return;
        }
        else
        {
            tail.next = head;
            Node ptr = head;

            for(int i = 0; i < p-1; i++)
            {
                ptr = ptr.next;
            }
            head = ptr.next;
            tail = ptr; 
            ptr.next = null;
        }
    }

    public void rightRotation(int p)
    {
        Node slow = head;
        Node fast = head; 
        for(int i = 0; i < p; i++)
        {
            fast = fast.next;
        }
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        tail.next = head;
        head = slow.next;
        slow.next = null;
        tail = slow;
    }

    public static void main(String[] args) {
        
        Rotation obj = new Rotation();

        obj.addNode(1);
        obj.addNode(2);
        obj.addNode(3);
        obj.addNode(4);
        obj.addNode(5);

        System.out.print("List: ");
        obj.display();

        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter '1' for Left and '0' for Right Rotation: ");
        int n = sc.nextInt();
        System.out.print("Tell how many position you want in Rotation: ");
        int p = sc.nextInt();

        if(n == 1)
        {
            obj.leftRotation(p);
            System.out.print("List: ");
            obj.display();
        }
        else
        {
            obj.rightRotation(p);
            System.out.print("List: ");
            obj.display();
        }
        sc.close();
    }
}