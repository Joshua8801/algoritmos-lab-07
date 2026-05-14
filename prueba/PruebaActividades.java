package prueba;

import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaActividades {

    public static void main(String[] args) {

        LinkedBST<Integer> bst = new LinkedBST<>();

        try {

            bst.insert(400);
            bst.insert(100);
            bst.insert(700);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);

            System.out.println("ARBOL BST:");
            System.out.println(bst);

            System.out.println("Buscar 75:");
            System.out.println(bst.search(75));

            bst.delete(50);

            System.out.println("ARBOL DESPUES DE ELIMINAR 50:");
            System.out.println(bst);

            System.out.println("RECORRIDO INORDEN:");
            bst.inOrder();

            System.out.println("RECORRIDO PREORDEN:");
            bst.preOrder();

            System.out.println("RECORRIDO POSTORDEN:");
            bst.postOrder();

            System.out.println("MINIMO:");
            System.out.println(bst.findMinNode());

            System.out.println("MAXIMO:");
            System.out.println(bst.findMaxNode());

        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());

        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}