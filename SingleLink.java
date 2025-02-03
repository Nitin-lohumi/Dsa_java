class SingleLink {
    private Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node removeNodes() {
        if (head == null) return null;
        head = reverseList(head);
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data < temp.data) {
                temp.next = temp.next.next; 
            } else {
                temp = temp.next;
            }
        }
        head = reverseList(head);
        return head;
    }
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SingleLink list = new SingleLink();
        list.insert(8);
        list.insert(3);
        list.insert(13);
        list.insert(2);
        list.insert(5);
        list.insert(Integer.MAX_VALUE); // Just for comparison

        System.out.println("Original Linked List:");
        list.display();

        list.removeNodes();

        System.out.println("After removing nodes:");
        list.display();
    }
}
