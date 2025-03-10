package com.example;

public class Main {
    public static void main(String[] args) {
        gerenciadoNomes gerenciador = new GerenciadorNomesBD();
        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar();
    }
}