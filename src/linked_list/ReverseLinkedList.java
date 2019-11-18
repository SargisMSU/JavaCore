package linked_list;



public class ReverseLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(1);
        SinglyLinkedList linkedlist = new SinglyLinkedList(head);

        // adding node into singly linked list
        linkedlist.add(new SinglyLinkedList.Node(2));
        linkedlist.add(new SinglyLinkedList.Node(3));
        // printing a singly linked list
        linkedlist.print();

        // reversing the singly linked list
        linkedlist.reverse();

        // printing the singly linked list again
        linkedlist.print();
    }

    static class SinglyLinkedList {

        static class Node {
            private int data;
            private Node next;

            Node(int data) {
                this.data = data;
            }

            int data() {
                return data;
            }

            Node next() {
                return next;
            }
        }

        private Node head;

        SinglyLinkedList(Node head) {
            this.head = head;
        }

        void add(Node node) {
            Node current = head;
            while (current != null) {
                if (current.next == null) {
                    current.next = node;
                    break;
                }
                current = current.next;
            }
        }

        void print() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data() + " ");
                node = node.next();
            }
            System.out.println("");
        }

        void reverse() {
            Node pointer = head;
            Node previous = null, current = null;

            while (pointer != null) {
                current = pointer;
                pointer = pointer.next;

                // reverse the link
                current.next = previous;
                previous = current;
                head = current;
            }
        }
    }
}
