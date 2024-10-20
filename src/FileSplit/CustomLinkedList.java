
package FileSplit;


class CustomLinkedList {
    private Node head;
    private Node tail;

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String poll() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
