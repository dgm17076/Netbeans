public class Cola<T> {
    private LinkedList<T> lista;

    public Cola() {
        lista = new LinkedList<>(false, false);
    }

    public void enqueue(T data) {
        lista.insert(data);
    }

    public T dequeue() {
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