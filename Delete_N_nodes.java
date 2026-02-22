import java.util.Scanner;

public class Delete_N_nodes {

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

    public Delete_N_nodes() 
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

    public void deleteNNodesAfterMNodes(int m, int n) {
    Node curr = head;

    while (curr != null) {

        for (int i = 1; i < m && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) return;

        Node temp = curr.next;
        for (int i = 0; i < n && temp != null; i++) {
            temp = temp.next;
        }

        curr.next = temp;
        curr = temp;
    }
}   
    public static void main(String[] args) 
    {
        Delete_N_nodes list = new Delete_N_nodes();
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
        System.out.print("Enter value of N(How many to delete): ");
        int n = sc.nextInt();
        System.out.print("Enter value of M(After how many nodes): ");
        int m = sc.nextInt();

        list.deleteNNodesAfterMNodes(n, m);
        System.out.println("Linked List after deletion:");
        list.display();
        sc.close();
    }
}