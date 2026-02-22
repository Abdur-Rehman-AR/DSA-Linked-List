import java.util.Scanner;

public class Implement_stack {

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

    public Implement_stack() 
    {
        head = null;
        tail = null;
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

    public void push(int data) 
    {
        Node temp = new Node(data);
        if (head == null) 
        {
            head = temp;
            tail = temp;
        } 
        else 
        {
            temp.next = head;
            head = temp;
        }
    }

    public void pop()
    {
        if(head == null)
        {
            System.out.println("Stack Underflow");
            return;
        }
        else if(head == tail)
        {
            System.out.println("Element Popped");
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
        }
    }
    public void peek()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return;
        }
        else
        {
            System.out.println("Top element is: " + head.data);
        }
    }
    public void isEmpty()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty.");
        }
        else
        {
            System.out.println("Stack is not Empty.");
        }
    }
    public static void main(String[] args) 
    {
        Implement_stack list = new Implement_stack();
         
        System.out.println("Which action do you want to perform on stack?");
        System.out.println("Enter 1 for push");
        System.out.println("Enter 2 for pop");
        System.out.println("Enter 3 for peek");
        System.out.println("Enter 4 to check if stack is empty");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1)
        {
            System.out.println("Enter the value to be pushed:");
            int data = sc.nextInt();
            list.push(data);
        }
        else if(n == 2)
        {
            list.pop();
        }
        else if(n == 3)
        {
            list.peek();
        }
        else if(n == 4)
        {
            list.isEmpty();
        }
        else
        {
            System.out.println("Invalid input");
        }
        list.display();
        sc.close();
    }
}