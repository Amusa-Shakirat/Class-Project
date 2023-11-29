

class DoublyLinkedList {
    Node head = null;

    public DoublyLinkedList() {
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current;
            for (current = this.head; current.next != null; current = current.next) {
            }
            //until it get to the current.next being null, and the current.next will be newNode
            current.next = newNode;
            newNode.prev = current;
        }

    }

    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (this.head != null) {
            this.head.prev = newNode;
            newNode.next = this.head;
        }

        this.head = newNode;
    }

    public void insertBefore(int data, int dataBefore) {
        if (this.head != null) {
            for(Node current = this.head; current != null; current = current.next) {
                if (current.data == dataBefore) {
                    Node toInsert = new Node(data);
                    current.prev.next = toInsert;
                    toInsert.next = current;
                    toInsert.prev = current.prev;
                }
            }

        }
    }

    public void removeData(int data) {
        if (this.head != null) {
            for(Node current = this.head; current != null; current = current.next) {
                if (current.data == data) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    } else {
                        this.head = current.next;
                        this.head.next = current.next.next;
                    }
                }
            }
        }
    }

    public void display() {
        for(Node current = this.head; current != null; current = current.next) {
            System.out.print(current.data + " <-> ");
        }

        System.out.println("null");
    }




    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertBeginning(10);
        list.display();
        list.insertEnd(20);
        list.display();
        list.insertEnd(30);
        list.display();
        list.insertBeginning(25);
        list.display();
        list.insertBefore(35, 30);
        list.display();
        System.out.println("Doubly Linked List:");
        list.removeData(20);
        list.display();
        System.out.println("Doubly Linked List:");
        list.removeData(25);
        list.display();
        System.out.println("Doubly Linked List:");
        list.display();
    }
}



