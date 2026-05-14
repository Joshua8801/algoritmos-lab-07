package prueba;

import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicioFourB {

    public static void main(String[] args) {

        LinkedBST<Integer> tree3 = new LinkedBST<>();

        try {

            tree3.insert(15);
            tree3.insert(8);
            tree3.insert(22);
            tree3.insert(5);
            tree3.insert(12);
            tree3.insert(18);
            tree3.insert(30);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n¿El árbol es BST válido?: "
                + tree3.isValidBST());
    }
}