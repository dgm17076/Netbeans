public class LinkedList<T> {
    private Node<T> head;
    private final boolean isDoubly;
    private final boolean isCircular;

    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.head = null;
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            if (isCircular) head.setNext(head);
            return;
        }
        Node<T> temp = head;
        while (temp.getNext() != null && (!isCircular || temp.getNext() != head)) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        if (isDoubly) newNode.setPrev(temp);
        if (isCircular) newNode.setNext(head);
    }

    public T deleteFirst() {
        if (head == null) return null;
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node<T> temp = head;
        System.out.print("Elementos: ");
        do {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        } while (temp != null && (!isCircular || temp != head));
        System.out.println();
    }

    // Métodos encapsulados para acceso controlado
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}