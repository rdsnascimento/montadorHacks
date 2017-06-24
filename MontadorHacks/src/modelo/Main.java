/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;

/**
 *
 * @author Rafael
 */
public class Main {

    public static void main(String[] args) { // metodo main para teste

        Leitura leitor = new Leitura();

        try {
            leitor.lerEntrada("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Não tem arquivo ...");
        }

        RegMem exec = new RegMem();

        exec.setPc(0); //zerando o Pc
        while (exec.getMemROM(exec.getPc()) != null) {
            leitor.romToDecod(exec.getMemROM(exec.getPc())); //mandando cada instrução da rom pra decodificação
            exec.setPc(exec.getPc() + 1); //Pc++
        }

        System.out.println("\nImprimindo:");
        System.out.println("Registrador D: " + exec.getRegD());
        System.out.println("Registrador A: " + exec.getRegA());
        System.out.println("Memória[" + 0 + "]: " + exec.getMemDados(0));
        System.out.println("Memória[" + 1 + "]: " + exec.getMemDados(1));
    }
}
