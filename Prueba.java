package arbolesbinarios;

public class Prueba {

    public static void main(String[] args) {

        LinkedBST<Integer> arbol = new LinkedBST<>();

        // OTRO ÁRBOL DIFERENTE
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        arbol.insertar(10);
        arbol.insertar(25);

        System.out.println("INORDEN");
        arbol.inOrden();

        System.out.println("PREORDEN");
        arbol.preOrden();

        System.out.println("POSTORDEN");
        arbol.postOrden();

        System.out.println("Buscar 40: " + arbol.buscar(40));

        System.out.println("Todos los nodos: " + arbol.countAllNodes());

        System.out.println("Nodos no hoja: " + arbol.countNodes());

        System.out.println("Altura desde 50: " + arbol.height(50));

        System.out.println("Altura desde 30: " + arbol.height(30));

        System.out.println("Amplitud: " + arbol.amplitude());

        arbol.destroyNodes();

        System.out.println("Arbol destruido");

        System.out.println("Todos los nodos despues de destruir: "
                + arbol.countAllNodes());
    }
}