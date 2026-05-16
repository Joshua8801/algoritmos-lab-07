package arbolesbinarios;

import java.util.Queue;
import java.util.LinkedList;

class LinkedBST<E extends Comparable<E>> {

    private Nodo<E> raiz;

    // INSERTAR
    public void insertar(E dato) {
        raiz = insertar(raiz, dato);
    }

    private Nodo<E> insertar(Nodo<E> nodo, E dato) {

        if(nodo == null)
            return new Nodo<>(dato);

        int comp = dato.compareTo(nodo.dato);

        if(comp < 0)
            nodo.izq = insertar(nodo.izq, dato);

        else if(comp > 0)
            nodo.der = insertar(nodo.der, dato);

        return nodo;
    }

    // BUSCAR
    public boolean buscar(E dato) {

        Nodo<E> actual = raiz;

        while(actual != null) {

            int comp = dato.compareTo(actual.dato);

            if(comp == 0)
                return true;

            actual = (comp < 0) ? actual.izq : actual.der;
        }

        return false;
    }

    // RECORRIDO INORDEN
    public void inOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo<E> nodo) {

        if(nodo != null) {

            inOrden(nodo.izq);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.der);
        }
    }

    // RECORRIDO PREORDEN
    public void preOrden() {
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo<E> nodo) {

        if(nodo != null) {

            System.out.print(nodo.dato + " ");
            preOrden(nodo.izq);
            preOrden(nodo.der);
        }
    }

    // RECORRIDO POSTORDEN
    public void postOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo<E> nodo) {

        if(nodo != null) {

            postOrden(nodo.izq);
            postOrden(nodo.der);
            System.out.print(nodo.dato + " ");
        }
    }

    // DESTROY NODES
    public void destroyNodes() {

        if(raiz == null) {

            System.out.println("Arbol vacio");
            return;
        }

        destruir(raiz);
        raiz = null;
    }

    private void destruir(Nodo<E> nodo) {

        if(nodo != null) {

            destruir(nodo.izq);
            destruir(nodo.der);

            nodo.izq = null;
            nodo.der = null;
        }
    }

    // CONTAR TODOS LOS NODOS
    public int countAllNodes() {
        return countAllNodes(raiz);
    }

    private int countAllNodes(Nodo<E> nodo) {

        if(nodo == null)
            return 0;

        return 1 + countAllNodes(nodo.izq)
                 + countAllNodes(nodo.der);
    }

    // CONTAR NODOS NO HOJA
    public int countNodes() {
        return countNodes(raiz);
    }

    private int countNodes(Nodo<E> nodo) {

        if(nodo == null)
            return 0;

        if(nodo.izq == null && nodo.der == null)
            return 0;

        return 1 + countNodes(nodo.izq)
                 + countNodes(nodo.der);
    }

    // HEIGHT
    public int height(E dato) {

        Nodo<E> actual = raiz;

        while(actual != null) {

            int comp = dato.compareTo(actual.dato);

            if(comp == 0)
                return calcularAltura(actual);

            actual = (comp < 0) ? actual.izq : actual.der;
        }

        return -1;
    }

    private int calcularAltura(Nodo<E> nodo) {

        if(nodo == null)
            return -1;

        Queue<Nodo<E>> cola = new LinkedList<>();
        cola.add(nodo);

        int altura = -1;

        while(!cola.isEmpty()) {

            int size = cola.size();
            altura++;

            for(int i = 0; i < size; i++) {

                Nodo<E> temp = cola.poll();

                if(temp.izq != null)
                    cola.add(temp.izq);

                if(temp.der != null)
                    cola.add(temp.der);
            }
        }

        return altura;
    }

    // AMPLITUDE
    public int amplitude() {

        if(raiz == null)
            return 0;

        Queue<Nodo<E>> cola = new LinkedList<>();
        cola.add(raiz);

        int max = 0;

        while(!cola.isEmpty()) {

            int size = cola.size();

            if(size > max)
                max = size;

            for(int i = 0; i < size; i++) {

                Nodo<E> temp = cola.poll();

                if(temp.izq != null)
                    cola.add(temp.izq);

                if(temp.der != null)
                    cola.add(temp.der);
            }
        }

        return max;
    }
}