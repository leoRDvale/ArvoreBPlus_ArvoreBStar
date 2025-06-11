import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Produto> produtos = FileLoader.carregarProdutos("src/produtos_corrigido.txt");

        ArvoreBPlus bPlus = new ArvoreBPlus();
        ArvoreBStar bStar = new ArvoreBStar();


        long startBPlus = System.nanoTime();
        for (Produto p : produtos) bPlus.inserir(p);
        long endBPlus = System.nanoTime();
        System.out.println("Tempo inserção B+: " + (endBPlus - startBPlus) + " ns");


        long startBStar = System.nanoTime();
        for (Produto p : produtos) bStar.inserir(p);
        long endBStar = System.nanoTime();
        System.out.println("Tempo inserção B*: " + (endBStar - startBStar) + " ns");

        Random rand = new Random();
        Set<Integer> chaves = new HashSet<>();
        while (chaves.size() < 10)
            chaves.add(rand.nextInt(1001) + 1000); // 1000 a 2000

        System.out.println("\nChaves sorteadas: " + chaves);


        long startRemoveBPlus = System.nanoTime();
        for (int chave : chaves) {
            Produto p = bPlus.buscar(chave);
            if (p != null) {
                bPlus.remover(chave);
                System.out.println("B+: Removido " + p);
            } else {
                System.out.println("B+: Produto ID " + chave + " não encontrado.");
            }
        }
        long endRemoveBPlus = System.nanoTime();
        System.out.println("Tempo remoção B+: " + (endRemoveBPlus - startRemoveBPlus) + " ns");


        long startRemoveBStar = System.nanoTime();
        for (int chave : chaves) {
            Produto p = bStar.buscar(chave);
            if (p != null) {
                bStar.remover(chave);
                System.out.println("B*: Removido " + p);
            } else {
                System.out.println("B*: Produto ID " + chave + " não encontrado.");
            }
        }
        long endRemoveBStar = System.nanoTime();
        System.out.println("Tempo remoção B*: " + (endRemoveBStar - startRemoveBStar) + " ns");
    }
}
