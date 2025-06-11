import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Produto> carregarProdutos(String path) throws IOException {
        List<Produto> produtos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(",");
            int id = Integer.parseInt(partes[0].trim());
            String nome = partes[1].trim();
            String categoria = partes[2].trim();
            produtos.add(new Produto(id, nome, categoria));
        }
        br.close();
        return produtos;
    }
}


