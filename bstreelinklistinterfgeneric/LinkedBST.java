package bstreelinklistinterfgeneric;

import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;
import model.Producto;

/*========================================
---------------ACTIVIDAD 6----------------
========================================*/

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {

        if (node == null) {
            return new Node(data);
        }

        int compare = data.compareTo(node.data);

        if (compare < 0) {
            node.left = insert(node.left, data);

        } else if (compare > 0) {
            node.right = insert(node.right, data);

        } else {
            throw new ItemDuplicated("El dato ya existe en el BST");
        }

        return node;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {

        if (isEmpty()) {
            throw new ExceptionIsEmpty("El BST está vacío");
        }

        root = delete(root, data);
    }

    private Node delete(Node node, E data) {

        if (node == null) {
            return null;
        }

        int compare = data.compareTo(node.data);

        if (compare < 0) {
            node.left = delete(node.left, data);

        } else if (compare > 0) {
            node.right = delete(node.right, data);

        } else {

            // Caso: un hijo o sin hijos
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Caso: dos hijos
            Node min = findMin(node.right);

            node.data = min.data;

            node.right = delete(node.right, min.data);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        return search(root, data);
    }

    private E search(Node node, E data) throws ItemNoFound {

        if (node == null) {
            throw new ItemNoFound("El dato no se encuentra en el BST");
        }

        int compare = data.compareTo(node.data);

        if (compare < 0) {
            return search(node.left, data);

        } else if (compare > 0) {
            return search(node.right, data);

        } else {
            return node.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "BST vacío";
        }

        return toString(root, "");
    }

    private String toString(Node node, String espacio) {

        if (node == null) {
            return "";
        }

        String resultado = "";

        resultado += toString(node.right, espacio + "   ");
        resultado += espacio + node.data + "\n";
        resultado += toString(node.left, espacio + "   ");

        return resultado;
    }
    
    /*========================================
    ---------------ACTIVIDAD 7----------------
    ========================================*/
    
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    /*========================================
    ---------------ACTIVIDAD 8----------------
    ========================================*/
    
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {

            System.out.print(node.data + " ");

            preOrder(node.left);

            preOrder(node.right);
        }
    }
    
    /*========================================
    ---------------ACTIVIDAD 9----------------
    ========================================*/
    
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {

            postOrder(node.left);

            postOrder(node.right);

            System.out.print(node.data + " ");
        }
    }

    /*========================================
    ---------------ACTIVIDAD 10----------------
    ========================================*/
    
    public E findMinNode() throws ItemNoFound {

        if (root == null) {
            throw new ItemNoFound("El BST está vacío");
        }

        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return search(current.data);
    }

    public E findMaxNode() throws ItemNoFound {

        if (root == null) {
            throw new ItemNoFound("El BST está vacío");
        }

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return search(current.data);
    }
    
    /*========================================
    ---------------EJERCICIO 2----------------
    ========================================*/
    
    public void destroyNodes() throws ExceptionIsEmpty {

        if (root == null) {
            throw new ExceptionIsEmpty("El BST está vacío");
        }

        destruir(root);
        root = null;
    }
    
    private void destruir(Node nodo) {

        if (nodo != null) {

            destruir(nodo.left);
            destruir(nodo.right);

            nodo.left = null;
            nodo.right = null;
        }
    }
    
    public int countAllNodes() {
        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return 0;
        }

        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }
    
    public int countNodes() {
        return countAllNodes();
    }
    
    public int height(E x) throws ItemNoFound {

        Node target = root;

        while (target != null && !target.data.equals(x)) {
            if (x.compareTo(target.data) < 0) {
                target = target.left;
            } else {
                target = target.right;
            }
        }

        if (target == null) return -1;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(target);

        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return height;
    }
    
    public int amplitude(int nivel) {

        if (root == null) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        int currentLevel = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (currentLevel == nivel) {
                return size;
            }

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            currentLevel++;
        }

        return 0;
    }
    
    /*========================================
    ---------------EJERCICIO 3----------------
    ========================================*/
    
    public int areaBST() {

        if (root == null) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();

        queue.add(root);

        int height = -1;
        int leaves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            height++;

            for (int i = 0; i < size; i++) {

                Node temp = queue.poll();

                // contar hoja
                if (temp.left == null && temp.right == null) {
                    leaves++;
                }

                if (temp.left != null) queue.add(temp.left);

                if (temp.right != null) queue.add(temp.right);
            }
        }

        return leaves * height;
    }

    public void drawBST() {

        System.out.println(this.toString());
    }

    public static boolean sameArea(LinkedBST<Integer> t1,
                                   LinkedBST<Integer> t2) {

        return t1.areaBST() == t2.areaBST();
    }
    
    /*========================================
    -----------EJERCICIO 4 PARTE A------------
    ========================================*/

    public void parenthesize() {

        parenthesizeRec(root, 0);
    }

    private void parenthesizeRec(Node node, int level) {

        if (node == null) return;

        // imprimir sangría
        for (int i = 0; i < level; i++) {

            System.out.print("    ");
        }

        // imprimir nodo
        System.out.println(node.data);

        if (node.left != null || node.right != null) {

            for (int i = 0; i < level; i++) {

                System.out.print("    ");
            }

            System.out.println("(");

            parenthesizeRec(node.left, level + 1);

            parenthesizeRec(node.right, level + 1);

            for (int i = 0; i < level; i++) {

                System.out.print("    ");
            }

            System.out.println(")");
        }
    }
    
    /*========================================
    -----------EJERCICIO 4 PARTE B------------
    ========================================*/

    public boolean isValidBST() {

        return isValidBSTRec(root, null, null);
    }

    private boolean isValidBSTRec(Node node, E min, E max) {

        if (node == null) return true;

        // verificar rango mínimo
        if (min != null && node.data.compareTo(min) <= 0) {

            return false;
        }

        // verificar rango máximo
        if (max != null && node.data.compareTo(max) >= 0) {

            return false;
        }

        // verificar subárbol izquierdo y derecho
        return isValidBSTRec(node.left, min, node.data) &&

               isValidBSTRec(node.right, node.data, max);
    }
    
    /*========================================
    ---------------EJERCICIO 5----------------
    ========================================*/

    public void searchRange(int min, int max) {

        searchRangeRec(root, min, max);
    }

    private void searchRangeRec(Node node, int min, int max) {

        if (node == null) return;

        Producto p = (Producto) node.data;

        if (p.getCodigo() > min) {

            searchRangeRec(node.left, min, max);
        }

        if (p.getCodigo() >= min && p.getCodigo() <= max) {

            System.out.println(p);
        }

        if (p.getCodigo() < max) {

            searchRangeRec(node.right, min, max);
        }
    }

    public int countLeaves() {

        return countLeavesRec(root);
    }

    private int countLeavesRec(Node node) {

        if (node == null) return 0;

        if (node.left == null && node.right == null) {

            return 1;
        }

        return countLeavesRec(node.left) +

               countLeavesRec(node.right);
    }

    public void printDescending() {

        printDescendingRec(root);
    }

    private void printDescendingRec(Node node) {

        if (node != null) {

            printDescendingRec(node.right);

            System.out.println(node.data);

            printDescendingRec(node.left);
        }
    }
    
}