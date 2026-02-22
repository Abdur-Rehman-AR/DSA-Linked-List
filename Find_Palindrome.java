import java.util.ArrayList;

public class Find_Palindrome {

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

    public Find_Palindrome()
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

    public void isPalindrome()
    {
        ArrayList<Integer> list = new ArrayList<>();

        Node ptr = head;
        while(ptr != null)
        {
            list.add(ptr.data);
            ptr = ptr.next;
        }

        int n = list.size() / 2;
        int left = 0;
        int right = list.size()-1;

        for(int i = 0; i < n; i++)
        {
            if(list.get(left) != list.get(right))
            {
                System.out.println("Palindrome Doesn't Exist.");
                return;
            }
            left++;
            right--;
        }
        System.out.println("Palindrome Exist.");
    }

    public static void main(String[] args) {
        
        Find_Palindrome obj = new Find_Palindrome();

        obj.addNode(2);
        obj.addNode(6);
        obj.addNode(4);
        obj.addNode(5);
        obj.addNode(5);
        obj.addNode(4);
        obj.addNode(6);
        obj.addNode(2);

        System.out.print("List: ");
        obj.display();
        System.out.println();
        obj.isPalindrome();
    }
}