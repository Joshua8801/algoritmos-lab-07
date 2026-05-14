package prueba;

import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.*;

public class PruebaEjercicioThree {

    public static void main(String[] args) {

        LinkedBST<Integer> tree1 = new LinkedBST<>();

        try {

            tree1.insert(15);
            tree1.insert(8);
            tree1.insert(22);
            tree1.insert(5);
            tree1.insert(12);
            tree1.insert(18);
            tree1.insert(30);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\nÁrbol 1:");

        tree1.drawBST();

        System.out.println("Área del árbol 1: "
                + tree1.areaBST());

        LinkedBST<Integer> tree2 = new LinkedBST<>();

        try {

            tree2.insert(10);
            tree2.insert(6);
            tree2.insert(20);
            tree2.insert(3);
            tree2.insert(8);
            tree2.insert(15);
            tree2.insert(25);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\nÁrbol 2:");

        tree2.drawBST();

        System.out.println("Área del árbol 2: "
                + tree2.areaBST());

        System.out.println("\n¿Ambos árboles tienen la misma área?: "
                + LinkedBST.sameArea(tree1, tree2));
    }
}