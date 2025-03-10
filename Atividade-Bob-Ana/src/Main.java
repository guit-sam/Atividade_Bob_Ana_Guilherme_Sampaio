public class Main {
    public static void main(String[] args) {
        gerenciadoNomes gNomes = new GerenciadorNomesMem();
        Ihm ihm = new Ihm(gNomes);
        ihm.dialogar();
        }
}
