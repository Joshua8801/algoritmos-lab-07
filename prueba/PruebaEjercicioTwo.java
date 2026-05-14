package prueba;

import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicioTwo {

    public static void main(String[] args) {

        try {

            LinkedBST<Integer> arbol = new LinkedBST<>();

            arbol.insert(50);
            arbol.insert(30);
            arbol.insert(70);
            arbol.insert(20);
            arbol.insert(40);
            arbol.insert(60);
            arbol.insert(80);
            arbol.insert(10);
            arbol.insert(25);

            System.out.println("INORDEN");
            arbol.inOrder();

            System.out.println("PREORDEN");
            arbol.preOrder();

            System.out.println("POSTORDEN");
            arbol.postOrder();

            System.out.println("Buscar 40: " + arbol.search(40));

            System.out.println("Todos los nodos: " + arbol.countAllNodes());

            System.out.println("Nodos no hoja: " + arbol.countNodes());

            System.out.println("Altura desde 50: " + arbol.height(50));

            System.out.println("Altura desde 30: " + arbol.height(30));

            System.out.println("Amplitud nivel 0: " + arbol.amplitude(0));

            System.out.println("Amplitud nivel 1: " + arbol.amplitude(1));

            System.out.println("Amplitud nivel 2: " + arbol.amplitude(2));

            arbol.destroyNodes();

            System.out.println("Arbol destruido");

            System.out.println("Todos los nodos despues de destruir: "
                    + arbol.countAllNodes());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}