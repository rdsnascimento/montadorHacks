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
        return memDados[indice];
    }

    public short getMemDados(int i) { //retorna determinada posicao da memória
        return memDados[i];
    }

    public void setMemDados(short valor) {
        memDados[indice] = valor;
        setIndice(getIndice() + 1); //indice++
    }

    /**
     * Getter e Setter Indice Memória de Dados
     */
    public int getIndice() {
        return RegMem.indice;
    }

    public void setIndice(int valor) {
        RegMem.indice = valor;
    }
    
    /**
     * Getter e Setter PC ROM
     */
    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        RegMem.pc = pc;
    }
    
    /**
     * Getter e Setter posição da memória
     */
    public short getMemROM() {
        return memDados[indice];
    }

    public short getMemROM(int i) { //retorna determinada posicao da memória
        return memDados[i];
    }

    public void setMemROM(String valor) {
        memROM[pc] = valor; //
        setPc(getPc()+1); //Pc++
    }
}
