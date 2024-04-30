import java.io.*;

class ListaCola {
    Nodo cab;
    Nodo movil;
    Nodo fin;
    int totalAutosLavados;

    public ListaCola() {
        totalAutosLavados = 0;
    }

    public void iniciar_cola() {
        cab = null;
        fin = null;
    }

    public void insertar_nodo_cola() throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo();
        System.out.println("Un auto ha llegado para lavarse. Digite el número de placa: ");
        nuevo.dato = Integer.parseInt(Teclado.readLine());
        if (cab == null) {
            nuevo.sig = cab;
            cab = nuevo;
            fin = cab;
        } else {
            fin.sig = nuevo;
            nuevo.sig = null;
            fin = nuevo;
        }
    }

    public void borrar_nodo_cola() {
        if (cab == null) {
            System.out.println("No hay autos en la cola.");
            return;
        }
        Nodo borra = cab;
        cab = cab.sig;
        borra = null; // eliminar nodo
        totalAutosLavados++;
    }

    public void imprimir_cola() {
        movil = cab;
        if (movil == null) {
            System.out.println("No hay autos esperando para lavarse.");
            return;
        }
        System.out.println("Autos en la cola para lavarse:");
        while (movil != null) {
            System.out.println("Número de placa: " + movil.dato);
            movil = movil.sig;
        }
    }

    public void destruir_cola() {
        while (cab != null) {
            Nodo borra = cab;
            cab = cab.sig;
            borra = null;
        }
        totalAutosLavados = 0;
    }

    public int getTotalAutosLavados() {
        return totalAutosLavados;
    }
}

class EjemploColaAutolavado {
    public static void main(String[] args) throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaCola listaC = new ListaCola();
        listaC.iniciar_cola();
        do {
            System.out.println("Bienvenido al autoservicio de lavado de autos:");
            System.out.println("1. Llega un auto para lavarse");
            System.out.println("2. Un auto ha completado el lavado");
            System.out.println("3. Mostrar autos en la cola");
            System.out.println("4. Mostrar total de autos lavados");
            System.out.println("5. Salir");

            System.out.println("Digite la opción:");
            opc = Integer.parseInt(Teclado.readLine());
            switch (opc) {
                case 1:
                    listaC.insertar_nodo_cola();
                    break;
                case 2:
                    listaC.borrar_nodo_cola();
                    System.out.println("El auto ha sido lavado y se ha ido.");
                    break;
                case 3:
                    listaC.imprimir_cola();
                    break;
                case 4:
                    System.out.println("Total de autos lavados: " + listaC.getTotalAutosLavados());
                    break;
            }
        } while (opc != 5);
        listaC.destruir_cola();
    }
}
