public class Pila<T> {
    private LinkedList<T> lista;

    public Pila() {
        lista = new LinkedList<>(false, false);
    }

    public void push(T data) {
        Node<T> nuevoNodo = new Node<>(data);
        nuevoNodo.setNext(lista.getHead());
        lista.setHead(nuevoNodo);
    }

    public T pop() {
        return lista.deleteFirst();
    }

    public T peek() {
        return lista.getFirst();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public void mostrar() {
        lista.display();
    }
}