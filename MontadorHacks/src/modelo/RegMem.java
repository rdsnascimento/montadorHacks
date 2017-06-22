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
    private static short[] memoria = new short[32768]; //Memória
    private static int pc = 0; //indice do vetor
    private static boolean JGT, JEQ, JGE, JLT, JNE, JLE, JMP; //Flags de jump

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
    public short getMemoria() {
        return memoria[pc];
    }
    
    public short getMemoria(int i) { //retorna determinada posicao da memória
        return memoria[i];
    }

    public void setMemoria(short valor) {
        memoria[pc] = valor;
        setPc(getPc() + 1); //pc++
    }    

    /**
     * Getter e Setter pc
     */
    public int getPc() {
        return RegMem.pc;
    }

    public void setPc(int valor) {
        RegMem.pc = valor;
    }

    /**
     * Getter e Setter flag jump JGT
     */
    public boolean getJGT() {
        return RegMem.JGT;
    }

    public void setJGT(boolean JGT) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JGT = JGT;
    }

    /**
     * Getter e Setter flag jump JEQ
     */
    public boolean getJEQ() {
        return RegMem.JEQ;
    }

    public void setJEQ(boolean JEQ) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JEQ = JEQ;
    }

    /**
     * Getter e Setter flag jump JGE
     */
    public boolean getJGE() {
        return this.JGE;
    }

    public void setJGE(boolean JGE) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JGE = JGE;
    }

    /**
     * Getter e Setter flag jump JLT
     */
    public boolean getJLT() {
        return RegMem.JLT;
    }

    public void setJLT(boolean JLT) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JLT = JLT;
    }

    /**
     * Getter e Setter flag jump JNE
     */
    public boolean getJNE() {
        return RegMem.JNE;
    }

    public void setJNE(boolean JNE) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JNE = JNE;
    }

    /**
     * Getter e Setter flag jump JLE
     */
    public boolean getJLE() {
        return RegMem.JLE;
    }

    public void setJLE(boolean JLE) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JLE = JLE;
    }

    /**
     * Getter e Setter flag jump JMP
     */
    public boolean getJMP() {
        return RegMem.JMP;
    }

    public void setJMP(boolean JMP) {
        zeraFlags(); //zera as flags antes de setar
        RegMem.JMP = JMP;
    }

    /**
     * Getter e Setter flag jump quando é NULL zera todas as flags
     */
    public void zeraFlags() {
        RegMem.JGT = false;
        RegMem.JEQ = false;
        RegMem.JGE = false;
        RegMem.JLT = false;
        RegMem.JNE = false;
        RegMem.JLE = false;
        RegMem.JMP = false;
    }
}
