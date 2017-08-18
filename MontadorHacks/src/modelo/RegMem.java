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
public class RegMem {

    private static short regA; //Registrador A
    private static short regD; //Registrador D
    private static short[] memDados = new short[32768]; //Memória de Dados
    private static String[] memROM = new String[32768]; //Memória de Instruções
    private static int indice = 0; //Índice do vetor da Memória de Dados
    private static int pc = 0; //PC sempre vai apontar para a posição da Memória de Instruções (ROM)

    //Zerando memória de Dados
    public void setMemDados() {
        for (int i=0; i<32768; i++){
            memDados[i]=0;
        }
    }

    //Zerando memória rom
    public void setMemROM() {
        for (int i=0; i<32768; i++){
            memROM[i]=null;
        }
    }
    
    //Zerando registrador A
    public void setRegA() {
        RegMem.regA = 0;
    }
    
    //Zerando registrador D
    public void setRegD() {
        RegMem.regD = 0;
    }
    
    //Zerando indice
    public void setIndice() {
        RegMem.indice = 0;
    }
    
    
    
    /**
     * Getter e Setter Registrador A
     */
    public short getRegA() {
        return RegMem.regA;
    }

    public void setRegA(short regA) {
        RegMem.regA = regA;
    }

    /**
     * Getter e Setter Registrador B
     */
    public short getRegD() {
        return RegMem.regD;
    }

    public void setRegD(short regD) {
        RegMem.regD = regD;
    }

    /**
     * Getter e Setter posição da memória
     */
    public short getMemDados() {
        return memDados[getRegA()]; //retorna Memory [A]
    }

    public short getMemDados(int i) { //retorna determinada posicao da memória
        return memDados[i]; 
    }
    
    public void setMemDados(short valor) {
        memDados[getRegA()] = valor; //Memory [A] = valor
    }

//    public void setMemDados(short valor) {
//        memDados[indice] = valor;
//        setIndice(getIndice() + 1); //indice++
//    }

    
    /**
     * Getter e Setter PC ROM
     */
    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        RegMem.pc = pc;
    }
    
    /**
     * Getter e Setter posição da memória
     */
    public String getMemROM() {
        return memROM[pc];
    }

    public String getMemROM(int i) { //retorna determinada posicao da memória
        return memROM[i];
    }

    public void setMemROM(String valor) {
        memROM[pc] = valor; //
        setPc(getPc()+1); //Pc++
    }
    
}
