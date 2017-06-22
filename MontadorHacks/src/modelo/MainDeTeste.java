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
public class MainDeTeste {
    
    
    /**public static void main(String[] args) { // metodo main para teste

        //System.out.println("TESTE");

        Decodifica dados = new Decodifica();
        dados.decAssembler("0", "101010", "010", "000");
        dados.decAssembler("0", "111111", "100", "000");
        dados.decAssembler("0", "111010", "010", "000");
        dados.decAssembler("0", "001100", "100", "000");
        //System.out.println("Registrador D: " + dados.getRegA());
        //System.out.println("Registrador A: " + dados.getRegD());

    }**/
    
    public static void main(String[] args) { // metodo main para teste

        Leitura leitor = new Leitura();
        

        try {
            leitor.lerEntrada("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Não tem arquivo ...");
        }
        
        RegMem dados = new RegMem();
    
        System.out.println("Imprimindo:");
        System.out.println("Registrador D: " + dados.getRegA());
        System.out.println("Registrador A: " + dados.getRegD());
        System.out.println("Memória["+0+"]: "+dados.getMemoria(0));
        System.out.println("Memória["+1+"]: "+dados.getMemoria(1));
        System.out.println("Memória["+2+"]: "+dados.getMemoria(2));
    }   
}
