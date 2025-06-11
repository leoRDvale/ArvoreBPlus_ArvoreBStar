import java.util.*;

public class ArvoreBPlus {
    private TreeMap<Integer, Produto> map = new TreeMap<>();

    public void inserir(Produto p) {
        map.put(p.id, p);
    }

    public Produto buscar(int id) {
        return map.get(id);
    }

    public void remover(int id) {
        map.remove(id);
    }
}
