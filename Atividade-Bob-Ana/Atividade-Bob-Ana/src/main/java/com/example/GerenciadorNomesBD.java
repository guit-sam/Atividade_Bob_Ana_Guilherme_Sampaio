package com.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements gerenciadoNomes {
    private Connection conexao;
    private final String url = "jdbc:postgresql://db.vfxmracpmrcfkwbhmfzr.supabase.co:5432/postgres";
    private final String usuario = "postgres";
    private final String senha = "5xLafJYCCjtykP1W";

    public GerenciadorNomesBD() {
        try {
         
            Class.forName("org.postgresql.Driver");

            
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println(" Conexão bem-sucedida!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro: Driver do PostgreSQL não encontrado!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nome FROM nomes")) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() > MAX_CARACTERES_NOMES) {
            System.out.println("Erro: Nome excede o limite de " + MAX_CARACTERES_NOMES + " caracteres.");
            return;
        }
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO nomes (nome) VALUES (?)")) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}