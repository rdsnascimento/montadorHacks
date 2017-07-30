/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rafael
 */
public class TesteTableSymbol {
    public static void main(String[] args) {
        SymbolTable tabela = new SymbolTable();
        
        //Simbolo sum
        String texto = "sum";
        int PCROM = 16;
        System.out.println("1. Testando símbolos");
        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
            tabela.addSymbol(texto);
            System.out.println("Adicionado na tabela de símbolos");
        }
        
        if (tabela.verificarSymbol(texto)==true){
            System.out.println("Já está na tabela de símbolos");
        } 
        
        //SIMBOLO i
        texto = "i";
        System.out.println("\n2. Testando símbolos");
        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
            tabela.addSymbol(texto);
            System.out.println("Adicionado na tabela de símbolos");
        }
        if (tabela.verificarSymbol(texto)==true){
            System.out.println("Já está na tabela de símbolos");
        }
        
        //LABEL LOOP
        texto = "LOOP";
        System.out.println("\n2. Testando símbolos");
        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
            tabela.addSymbol(texto);
            System.out.println("Adicionado na tabela de símbolos");
        }
        if (tabela.verificarSymbol(texto)==true){
            System.out.println("Já está na tabela de símbolos");
        }
        tabela.imprimeTable();
        System.out.println("\n\n2. Testando label");
        tabela.verificarLabel(texto, PCROM);
        System.out.println("\nAdicionado label na tabela de símbolos");
        tabela.imprimeTable();
        
        //LABEL END
        texto = "END";
        
        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
            tabela.addSymbol(texto);
            System.out.println("Adicionado na tabela de símbolos");
        }
        if (tabela.verificarSymbol(texto)==true){
            System.out.println("Já está na tabela de símbolos");
        }
        tabela.imprimeTable();
        
        PCROM = 18;
        tabela.verificarLabel(texto, PCROM);
        System.out.println("\nAdicionado label na tabela de símbolos");
        
        //Imprimindo tabela de símbolos
        tabela.imprimeTable();
        
        //Imprimindo i
        System.out.println ("\n\n\nO valor na tabela é: "+tabela.enderecoApontado("LOOP"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("END"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("i"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("sum"));
        
        
        //SIMBOLO j
        texto = "j";
        System.out.println("\n2. Testando símbolos");
        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
            tabela.addSymbol(texto);
            System.out.println("Adicionado na tabela de símbolos");
        }
        if (tabela.verificarSymbol(texto)==true){
            System.out.println("Já está na tabela de símbolos");
        }
        
        //Imprimindo tabela de símbolos
        tabela.imprimeTable();
        
        //Imprimindo j
        System.out.println ("\n\n\nO valor na tabela é: "+tabela.enderecoApontado("LOOP"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("END"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("i"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("sum"));
        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("j"));
        
    }
}
