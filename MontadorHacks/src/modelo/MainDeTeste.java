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
    
    /**
    public void execucao(){
        RegMem dados = new RegMem();
        dados.setPc(0); //zera o PC
    
        while( dados.getMemROM(dados.getPc()) !=0 ){ //Enquanto tiver conteúdo na Memória de Instruções "memRom[PC]"
           
             
            dados.setPc(dados.getPc()+1); //incrementa PC
        }
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
        System.out.println("Memória["+0+"]: "+dados.getMemDados(0));
        System.out.println("Memória["+1+"]: "+dados.getMemDados(1));
        System.out.println("Memória["+2+"]: "+dados.getMemDados(2));
        
        dados.setPc(0); //zera o PC
        while( dados.getMemROM(dados.getPc()) !=0 ){ //Enquanto tiver conteúdo na Memória de Instruções "memRom[PC]"
            /**
             * Codigo aqui
             */
             
            //incrementa pc
            dados.setPc(dados.getPc()+1); //incrementa PC
        }
    }   
}
