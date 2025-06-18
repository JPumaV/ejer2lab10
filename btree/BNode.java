package btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected static int idCounter = 0;
    protected int idNode;
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.idNode = idCounter++;
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1); // +1 para el hijo adicional en nodos internos
        this.count = 0;
        for (int i = 0; i < n - 1; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i < n; i++) {
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && key.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return (pos[0] < count && key.compareTo(keys.get(pos[0])) == 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Node ID: ").append(idNode).append(" | Keys: ");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i)).append(" ");
        }
        return sb.toString();
    }
}