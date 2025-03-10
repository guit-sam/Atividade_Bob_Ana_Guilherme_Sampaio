import java.util.*;


public class GerenciadorNomesMem implements gerenciadoNomes {
 private List<String> nomes = new ArrayList<String>();


 @Override
 public List<String> obterNomes() {
 return nomes;
 }

 @Override
 public void adicionarNome(String nome) {
 nomes.add(nome);
 }
}