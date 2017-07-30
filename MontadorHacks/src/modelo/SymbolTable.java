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
public class SymbolTable {
    private int contTable = 0; //quantidade de elementos que tem na tabela de símbolos
    private String[] memoria = new String[50];
    private int [] valor = new int [50];

    public int getContTable() {
        return contTable;
    }

    public void setContTable(int contTable) {
        this.contTable = contTable;
    }
    
    //Verifica se o símbolo está na tabela de símbolos
    public boolean verificarSymbol(String a){
        int i = 0;
        while (i < contTable){
            if (memoria[i].equals(a)){ //se memória[i] == a
                return true;
            }
            i++;
        }
        return false;
    }
    
    //verifica se o label está na tabela de símbolos
    public void verificarLabel(String a, int PCROM){ 
        int i = 0;
        while (i < contTable){
            if (memoria[i].equals(a)){ //Se memória[i] == label
                valor[i]=PCROM; //apenas atualiza porque o label já está na Tabela de Símbolos
                return;
            }
            i++;
        }
        addLabel (a, PCROM); //se o label não estiver na tabela de símbolos adiciona o label
    }
    
    //Adicionando um símbolo na tabela de símbolos
    public void addSymbol(String symbol){ //adicionando um elemento na tabela de símbolos
        memoria[contTable]=symbol;
        valor[contTable]=contTable; //reservando um espaço na posicao de memória
        contTable++; //incrementa tamanho da tabela de símbolos
    }
    
    //Adicionando um label na tabela de símbolos
    public void addLabel(String symbol, int posicaoRom){
        memoria[contTable]=symbol;
        valor[contTable]=posicaoRom;
        contTable++;
    }
   
    //Imprimindo a tabela de símbolos
    public void imprimeTable(){
        for (int i=0; i<contTable; i++){
            System.out.println ("Table ["+i+"]: "+memoria[i]+" / "+ valor [i]);
        }
    }
    
    //Retorna o endereço apontado pela tabela de símbolos JÁ MONTADA!
    public int enderecoApontado(String symbol){
        int i=0;
        while(i<contTable){
            if (memoria[i].equals(symbol)){
                break;
            }
            i++;
        }
        return valor[i];
    }
}
