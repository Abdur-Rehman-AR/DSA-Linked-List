import java.util.Scanner;

public class Nth_element_from_last {
 
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

    public Nth_element_from_last()
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

    public void getNthElement(int n)
    {
        if(n <= 0)
        {
            System.out.println("Invalid Position.");
            return;
        }
        else
        {
            Node a = head;
            Node b = head;
            int c = 0;

            while(a != null)
            {
                a = a.next;
                c = c+1;
                if(c > n)
                {
                    b = b.next;
                }
            }
            if(c < n)
            {
                System.out.println("Invalid position.");
            }
            else
            {
                System.out.println("Number found at position "+n +" is: " +b.data);
            }
        }
    }


        public static void main(String[] args) {
        
        Nth_element_from_last obj = new Nth_element_from_last();

        obj.addNode(2);
        obj.addNode(4);
        obj.addNode(6);
        obj.addNode(8);
        obj.addNode(10);
        obj.addNode(12);

        System.out.print("List: ");
        obj.display();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Element position you wanna see: ");
        int n = sc.nextInt();
        obj.getNthElement(n);
        sc.close();
    }
}