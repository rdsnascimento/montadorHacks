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
public class Testes {
    public String[] entrada(){
        String[] instrucao = new String[40];
        
        instrucao[0] = "0000000000000000";
        instrucao[1] = "1110111111001000";
        instrucao[2] = "0000000000000001";
        instrucao[3] = "1110101010001000";
        instrucao[4] = "0000000000000000";
        instrucao[5] = "1111110000010000";
        instrucao[6] = "0000000000110010";
        instrucao[7] = "1110010011010000";
        instrucao[8] = "0000000000010010";
        instrucao[9] = "1110001100000001";
        instrucao[10] = "0000000000000000";
        instrucao[11] = "1111110000010000";
        instrucao[12] = "0000000000000001";
        instrucao[13] = "1111000010001000";
        instrucao[14] = "0000000000000000";
        instrucao[15] = "1111110111001000";
        instrucao[16] = "0000000000000100";
        instrucao[17] = "1110101010000111";
        instrucao[18] = "0000000000000001";
        instrucao[19] = "1111110000010000";
        instrucao[20] = "0000000000000010";
        instrucao[21] = "1110001100001000";
        instrucao[22] = "0000000000000000";
        instrucao[23] = "1110110000010000";
        instrucao[24] = "0000000000000011";
        instrucao[25] = "1110001100001000";
        instrucao[26] = "0000000000000011";
        instrucao[27] = "1111110000010000";
        instrucao[28] = "0000000000000010";
        instrucao[29] = "1110010011010000";
        instrucao[30] = "0000000000100111";
        instrucao[31] = "1110001100000001";
        instrucao[32] = "0000000000000010";
        instrucao[33] = "1111110000010000";
        instrucao[34] = "1111000010001000";
        instrucao[35] = "0000000000000011";
        instrucao[36] = "1111110111001000";
        instrucao[37] = "0000000000011010";
        instrucao[38] = "1110101010000111";    
       
        return instrucao;
    }
    
    public static void main(String[] args) {
//        SymbolTable tabela = new SymbolTable();
//        
//        //Simbolo sum
//        String texto = "sum";
//        int PCROM = 16;
//        System.out.println("1. Testando símbolos");
//        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
//            tabela.addSymbol(texto);
//            System.out.println("Adicionado na tabela de símbolos");
//        }
//        
//        if (tabela.verificarSymbol(texto)==true){
//            System.out.println("Já está na tabela de símbolos");
//        } 
//        
//        //SIMBOLO i
//        texto = "i";
//        System.out.println("\n2. Testando símbolos");
//        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
//            tabela.addSymbol(texto);
//            System.out.println("Adicionado na tabela de símbolos");
//        }
//        if (tabela.verificarSymbol(texto)==true){
//            System.out.println("Já está na tabela de símbolos");
//        }
//        
//        //LABEL LOOP
//        texto = "LOOP";
//        System.out.println("\n2. Testando símbolos");
//        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
//            tabela.addSymbol(texto);
//            System.out.println("Adicionado na tabela de símbolos");
//        }
//        if (tabela.verificarSymbol(texto)==true){
//            System.out.println("Já está na tabela de símbolos");
//        }
//        tabela.imprimeTable();
//        System.out.println("\n\n2. Testando label");
//        tabela.verificarLabel(texto, PCROM);
//        System.out.println("\nAdicionado label na tabela de símbolos");
//        tabela.imprimeTable();
//        
//        //LABEL END
//        texto = "END";
//        
//        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
//            tabela.addSymbol(texto);
//            System.out.println("Adicionado na tabela de símbolos");
//        }
//        if (tabela.verificarSymbol(texto)==true){
//            System.out.println("Já está na tabela de símbolos");
//        }
//        tabela.imprimeTable();
//        
//        PCROM = 18;
//        tabela.verificarLabel(texto, PCROM);
//        System.out.println("\nAdicionado label na tabela de símbolos");
//        
//        //Imprimindo tabela de símbolos
//        tabela.imprimeTable();
//        
//        //Imprimindo i
//        System.out.println ("\n\n\nO valor na tabela é: "+tabela.enderecoApontado("LOOP"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("END"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("i"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("sum"));
//        
//        
//        //SIMBOLO j
//        texto = "j";
//        System.out.println("\n2. Testando símbolos");
//        if (tabela.verificarSymbol(texto)==false){ //se não estiver na tabela de símbolo, adiciona na tabela
//            tabela.addSymbol(texto);
//            System.out.println("Adicionado na tabela de símbolos");
//        }
//        if (tabela.verificarSymbol(texto)==true){
//            System.out.println("Já está na tabela de símbolos");
//        }
//        
//        //Imprimindo tabela de símbolos
//        tabela.imprimeTable();
//        
//        //Imprimindo j
//        System.out.println ("\n\n\nO valor na tabela é: "+tabela.enderecoApontado("LOOP"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("END"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("i"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("sum"));
//        System.out.println ("O valor na tabela é: "+tabela.enderecoApontado("j"));
    
        AssemblyToBinary teste = new AssemblyToBinary();
        Decodifica teste2 = new Decodifica ();
        
        teste.decodBinario("soma", "M", "M", "1");
        teste.decodBinario(32);
        teste.decodBinario("soma", "M", "M", "1");
        teste.decodBinario(4);
        
        teste2.setPc(0);
        while(teste2.getMemROM(teste2.getPc())!=null){
            System.out.println(teste2.getMemROM(teste2.getPc()));
            teste2.setPc(teste2.getPc()+1);
        }
    }
}
