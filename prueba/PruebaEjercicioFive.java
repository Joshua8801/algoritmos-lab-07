package prueba;

import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.*;
import model.Producto;

/*========================================
---------------EJERCICIO 5----------------
========================================*/

public class PruebaEjercicioFive {
    public static void main(String[] args) {

		LinkedBST<Producto> tree = new LinkedBST<>();
		
		try {
		    tree.insert(new Producto(15, "Laptop"));
		    tree.insert(new Producto(8, "Mouse"));
		    tree.insert(new Producto(22, "Teclado"));
		    tree.insert(new Producto(5, "Monitor"));
		    tree.insert(new Producto(12, "USB"));
		    tree.insert(new Producto(18, "Impresora"));
		    tree.insert(new Producto(30, "Router"));
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		

		System.out.println("\nProductos en rango 10–25:");
		tree.searchRange(10, 25);
		
		System.out.println("\nCantidad de hojas:");
		System.out.println(tree.countLeaves());
		
		System.out.println("\nProductos en orden descendente:");
		tree.printDescending();


    }
}
