public class Main {
    public static void main(String[] args) {
        Pila<String> historial = new Pila<>();
        Cola<String> procesos = new Cola<>();

        while (true) {
            System.out.println("\n=== SISTEMA OPERATIVO SIMULADO ===");
            System.out.println("1. Ejecutar comando ");
            System.out.println("2. Deshacer ultimo comando ");
            System.out.println("3. Ver ultimo comando ejecutado ");
            System.out.println("4. Agregar programa a la cola de ejecucion ");
            System.out.println("5. Ejecutar siguiente programa ");
            System.out.println("6. Ver programa actual ");
            System.out.println("7. Mostrar historial de comandos");
            System.out.println("8. Mostrar cola de programas");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");

            int opcion;
            try {
                String linea = leerLinea();
                opcion = Integer.parseInt(linea.trim());
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingresa el comando a ejecutar: ");
                    String cmd = leerLinea();
                    historial.push(cmd);
                    System.out.println("Comando '" + cmd + "' ejecutado.");
                }
                case 2 -> {
                    if (!historial.estaVacia()) {
                        System.out.println("Comando deshecho: " + historial.pop());
                    } else {
                        System.out.println("No hay comandos en el historial.");
                    }
                }
                case 3 -> {
                    if (!historial.estaVacia()) {
                        System.out.println("Ultimo comando: " + historial.peek());
                    } else {
                        System.out.println("Historial vacio.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingresa el nombre del programa: ");
                    String programa = leerLinea();
                    procesos.enqueue(programa);
                    System.out.println("Programa agregado a la cola: " + programa);
                }
                case 5 -> {
                    if (!procesos.estaVacia()) {
                        System.out.println("Ejecutando programa: " + procesos.dequeue());
                    } else {
                        System.out.println("No hay programas en ejecucion.");
                    }
                }
                case 6 -> {
                    if (!procesos.estaVacia()) {
                        System.out.println("Programa actual: " + procesos.peek());
                    } else {
                        System.out.println("Cola vacia.");
                    }
                }
                case 7 -> {
                    System.out.println("Historial de comandos:");
                    historial.mostrar();
                }
                case 8 -> {
                    System.out.println("Cola de programas:");
                    procesos.mostrar();
                }
                case 9 -> {
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("Opcion no valida.");
            }
        }
    }

    // Método para leer una línea desde la consola sin usar imports
    private static String leerLinea() {
        StringBuilder sb = new StringBuilder();
        try {
            int c;
            while ((c = System.in.read()) != -1) {
                if (c == '\n' || c == '\r') {
                    break;
                }
                sb.append((char) c);
            }
        } catch (Exception e) {
            // Si hay un error, devuelve línea vacía
        }
        return sb.toString();
    }
}
