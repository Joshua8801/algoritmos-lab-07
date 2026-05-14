package prueba;

import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicioFourA {

    public static void main(String[] args) {

        LinkedBST<String> tree2 = new LinkedBST<>();

        try {

            tree2.insert("Sales");
            tree2.insert("Domestic");
            tree2.insert("International");
            tree2.insert("Canada");
            tree2.insert("S_America");
            tree2.insert("Overseas");
            tree2.insert("Africa");
            tree2.insert("Europe");
            tree2.insert("Asia");
            tree2.insert("Australia");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("====== EJERCICIO 4 PARTE A ======");

        System.out.println("\nParenthesize:\n");

        tree2.parenthesize();
    }
}