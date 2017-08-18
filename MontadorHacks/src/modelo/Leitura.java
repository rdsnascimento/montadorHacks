/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;

/**
 *
 * @author Douglas Janovik Maliszewski
 */
public class Leitura extends Decodifica { // importa metodos do decodifica

    public Leitura() { // construtor vazio

    }

    public void lerEntrada(String arq) throws FileNotFoundException { // Essa exceção é lançada pra fora do método para parar o método se não existir arquivo de leitura ...

        Leitura auxLeitura = new Leitura(); // objeto auxiliar para usar métodos

        String receptor = new String(); // string utilizada para ler arquivo
      
        try { // Primeiro Try utilizado somente para capturar exceção de não existencia de arquivo fonte
            Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n"); // cria leitor de arquivo

            while (leitor.hasNext()) { // executa enquanto existem linhas a serem lidas no arquivo
                receptor = leitor.next(); // le arquivo
                try { // segundo try para tratar erros no formato de entrada da instrução

                    int tipo = auxLeitura.tipoInstrucao(receptor); // verifica qual tipo de instrução é baseado nos primeiros numeros

                    if (!auxLeitura.verificaNumero(receptor) || !auxLeitura.verificaTamanho(receptor) || (tipo == 2)) { // catch para capturar erros de formato de instrução
                        throw new Exception("Instrução invalida...\n"); // lança exceção para instrução inválida
                    }

                    auxLeitura.setMemROM(receptor); // passa string inteira para rom

                    //System.out.println("instrução adicionada a memória rom ..\n"); // Flag para avisar se instrução foi passada para rom comentar para não exibir

                } catch (Exception e) {
                    System.out.println(e.getMessage()); // captura exceção em caso de instrução não estiver de acordo com arquitetura e le a proxima
                }

            }

        } catch (FileNotFoundException e) {
            throw e; // captura exceação de não existencia de arquivo e para o método
        }

    }

    public void romToDecod(String receptor) {

        Leitura auxLeitura = new Leitura(); // cria metodo auxiliar da classe leitura

        String a = new String();    // strings utilizadas nas operações de separação de bits
        String comp = new String(); // são os parametros para o método decAssembler
        String dest = new String(); //
        String jump = new String(); //

        char[] aux = new char[16]; // vetor de caracteres auxiliar nas operações de strings

        int tipo = auxLeitura.tipoInstrucao(receptor); // verifica qual tipo de instrução é baseado nos primeiros numeros

        if (tipo == 0) { // testa tipo de instrução

            for (int i = 0, j = 1; j < 16; i++, j++) { // parte corrigida da entrada caso for 0, pega apenas 15 bits

                aux[i] = receptor.charAt(j); // copiando bits para vetor auxiliar

            }

            for (int i = 0; i < 15; i++) { // copiando de vetor auxiliar para string a
                a += aux[i];
            }

            //System.out.println(a);

            short adress = (short) Integer.parseInt(a, 2); // converte binario (do tipo string) para inteiro e usa cast para short

           // System.out.println(adress); // imprime valor imediato
            auxLeitura.decAssembler(adress); // se for do tipo 0, passa valor decimal para decAssembler

        } else if (tipo == 1) { // Se for do tipo 1, faz a separação dos bits conforme arquitetura

            aux[0] = receptor.charAt(3); // copiando para vetor auxiliar

            a += aux[0]; // copiar para string a respectivos bits

         //   System.out.println(a); // Exibe os bits na saída padrão, comentar para não exibir

            for (int i = 0, j = 4; j < 10; i++, j++) {

                aux[i] = receptor.charAt(j); // copiando bits para vetor auxiliar

            }

            comp += aux[0]; // copiando respectivos bits para comp
            comp += aux[1];
            comp += aux[2];
            comp += aux[3];
            comp += aux[4];
            comp += aux[5];

            //System.out.println(comp); // exibe comp na saida padrão, comentar para não exibir

            for (int i = 0, j = 10; j < 13; i++, j++) {

                aux[i] = receptor.charAt(j); // copiando bits para vetor auxiliar

            }

            dest += aux[0]; // copiando de vetor auxiliar para dest
            dest += aux[1];
            dest += aux[2];

            //System.out.println(dest); // exibe dest, comentar para não exibir

            for (int i = 0, j = 13; j < 16; i++, j++) {

                aux[i] = receptor.charAt(j); // copiando de receptor para vetor auxiliar

            }

            jump += aux[0]; // copiando de vetor auxiliar para jump
            jump += aux[1];
            jump += aux[2];

           // System.out.println(jump); // exibe jump, comentar para não exibir

            auxLeitura.decAssembler(a, comp, dest, jump); // passa bits separados conforme arquitetura para decAssembler

        }

       // System.out.println("Passagem de bits para dec ok!"); // exibe flag para informar que passagem e separação de bits foi ok // comentar para não exibir

    }

    private boolean verificaNumero(String a) { // verifica se existe algo alem de 0 e 1 na string. Se existir retorna false. Caso contrario retorna true.

        int i = 0;

        for (i = 0; i < a.length(); i++) {

            if ((a.charAt(i) != 48) && (a.charAt(i) != 49)) {
                return false;
            }

        }

        return true;
    }

    private boolean verificaTamanho(String a) { // verifica tamanho da instrução. Se não tiver exatos 16 bits retorna falso

        if (a.length() != 16) {
            return false;
        } else {
            return true;
        }
    }

    private int tipoInstrucao(String a) { // verifica o tipo de instrução. Se inicia com 0 retorna 0. Se iniciar com 3 1s retorna 1. Senão retorna 2.

        if (a.charAt(0) == 48) {
            return 0;
        } else if ((a.charAt(0) == 49) && (a.charAt(1) == 49) && (a.charAt(2) == 49)) {
            return 1;
        } else {
            return 2;
        }
    }
    

    /*public static void main(String[] args){ // metodo main para teste
        
        Leitura leitor = new Leitura();
        
        try{
            leitor.lerEntrada();
        }
       
        
        catch(FileNotFoundException e){
            System.out.println("Não tem arquivo ...");
        }
        
    }*/
}
