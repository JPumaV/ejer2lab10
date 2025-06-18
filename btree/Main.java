package btree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4); // Orden 4, puede contener 3 claves por nodo

        // Inserciones
        int[] valores = {52, 30, 70, 10, 40, 60, 80, 25, 35, 55, 65, 75, 85};
        for (int v : valores) {
            btree.insert(v);
        }

        System.out.println("Árbol después de insertar:");
        System.out.println(btree);

        // Búsqueda
        System.out.println("¿Existe 52?: " + btree.search(52));
        System.out.println("¿Existe 100?: " + btree.search(100));

        // Eliminación
        System.out.println("\nEliminando 52...");
        btree.remove(52);

        System.out.println("Árbol después de eliminar 52:");
        System.out.println(btree);

        System.out.println("¿Existe 52?: " + btree.search(52));
    }
}
