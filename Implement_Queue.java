import java.util.Scanner;

public class Implement_Queue {

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

    public Implement_Queue() 
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

    public void enqueue(int n)
    {
        addNode(n);
    }
    public void dequeue()
    {
        if(head == null)
        {
            System.out.println("Queue is Empty. Cannot Dequeue.");
        }
        else if(head == tail)
        {
            System.out.println("Element Dequeued");
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
        }
    }
    public void front()
    {
        if(head == null)
        {
            System.out.println("Queue is Empty.");
        }
        else
        {
            System.out.println("Front Element is : " +head.data);
        }
    }
    public void isEmpty()
    {
        if(head == null)
        {
            System.out.println("Queue is Empty.");
        }
        else
        {
            System.out.println("Queue is not Empty.");
        }
    }
    public static void main(String[] args) 
    {
        Implement_Queue list = new Implement_Queue();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter 1 to Enqueue.");
            System.out.println("Enter 2 to Dequeue.");
            System.out.println("Enter 3 to check Front.");
            System.out.println("Enter 4 to Check if Empty.");
            System.out.println("Enter 0 to Exit.");
            int n = sc.nextInt();

            if(n == 1)
            {
                System.out.print("Enter Value to Enqueue: ");
                int value = sc.nextInt();
                list.enqueue(value);
            }
            else if(n == 2)
            {
                list.dequeue();
            }
            else if(n == 3)
            {
                list.front();
            }
            else if(n == 4)
            {
                list.isEmpty();
            }
            else if(n == 0)
            {
                System.out.println("Exiting...");
                break;
            }
            else
            {
                System.out.println("Invalid Input.");
            }
        }
        list.display(); 
        sc.close();
    }
}