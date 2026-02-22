public class Merge_Sort {
    
    static class Node {

        int data;
        Node next;

        public Node(int data) {

            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    public Merge_Sort() {
        
        head = null;
        tail = null;
    }

    public void addNode(int data) {

        Node temp = new Node(data);

        if(head == null) {

            head = temp;
            tail = temp;
        }
        else {

            tail.next = temp;
            tail = tail.next;
        }

    }

    public void display(Node res) {

        Node ptr = res;
        while (ptr != null) {

            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public Node mergeSort(Node head) {

        if (head == null || head.next == null) {

            return head;
        }

        Node slow = head;
        Node fast = head; 
        Node miNode = null;

        while (fast != null && fast.next != null) {

            miNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        miNode.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(slow);

        return merge(left, right);
    }

    public Node merge(Node left, Node right) {

        Node ptr = new Node(-1);
        Node head = ptr;

        while(left != null && right != null)
        {
            if(left.data > right.data)
            {
                ptr.next = right;
                ptr = right;
                right = right.next;
            }
            else
            {
                ptr.next = left;
                ptr = left;
                left = left.next;
            }
        }

        if(left != null)
        {
            ptr.next = left;
        }
        else
        {
            ptr.next = right;
        }

        return head.next;
    }

    public static void main(String[] args) {
        
        Merge_Sort m = new Merge_Sort();

        m.addNode(5);
        m.addNode(4);
        m.addNode(9);
        m.addNode(3);
        m.addNode(4);
        m.addNode(6);
        m.addNode(1);
        m.addNode(2);

        System.out.println("UnSorted List:");
        m.display(head);
        System.out.println();

        System.out.println("Sorted List:");
        Node result = m.mergeSort(head);
        m.display(result);
    }
}