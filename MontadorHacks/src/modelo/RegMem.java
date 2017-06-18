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

    private short regA; //Registrador A
    private short regD; //Registrador D
    private short[] memoria = new short[32768]; //Memória
    private int pc = 0; //indice do vetor
    private boolean JGT, JEQ, JGE, JLT, JNE, JLE, JMP; //Flags de jump

    /**
     * Getter e Setter Registrador A
     */
    public short getRegA() {
        return this.regA;
    }

    public void setRegA(short regA) {
        this.regA = regA;
    }

    /**
     * Getter e Setter Registrador B
     */
    public short getRegD() {
        return this.regD;
    }

    public void setRegD(short regD) {
        this.regD = regD;
    }

    /**
     * Getter e Setter posição da memória
     */
    public short getMemoria() {
        return this.memoria[pc];
    }

    public void setMemoria(short valor) {
        this.memoria[pc] = valor;
        setPc(getPc() + 1); //pc++
    }

    /**
     * Getter e Setter pc
     */
    public int getPc() {
        return this.pc;
    }

    public void setPc(int valor) {
        this.pc = valor;
    }

    /**
     * Getter e Setter flag jump JGT
     */
    public boolean getJGT() {
        return this.JGT;
    }

    public void setJGT(boolean JGT) {
        zeraFlags(); //zera as flags antes de setar
        this.JGT = JGT;
    }

    /**
     * Getter e Setter flag jump JEQ
     */
    public boolean getJEQ() {
        return this.JEQ;
    }

    public void setJEQ(boolean JEQ) {
        zeraFlags(); //zera as flags antes de setar
        this.JEQ = JEQ;
    }

    /**
     * Getter e Setter flag jump JGE
     */
    public boolean getJGE() {
        return this.JGE;
    }

    public void setJGE(boolean JGE) {
        zeraFlags(); //zera as flags antes de setar
        this.JGE = JGE;
    }

    /**
     * Getter e Setter flag jump JLT
     */
    public boolean getJLT() {
        return this.JLT;
    }

    public void setJLT(boolean JLT) {
        zeraFlags(); //zera as flags antes de setar
        this.JLT = JLT;
    }

    /**
     * Getter e Setter flag jump JNE
     */
    public boolean getJNE() {
        return this.JNE;
    }

    public void setJNE(boolean JNE) {
        zeraFlags(); //zera as flags antes de setar
        this.JNE = JNE;
    }

    /**
     * Getter e Setter flag jump JLE
     */
    public boolean getJLE() {
        return this.JLE;
    }

    public void setJLE(boolean JLE) {
        zeraFlags(); //zera as flags antes de setar
        this.JLE = JLE;
    }

    /**
     * Getter e Setter flag jump JMP
     */
    public boolean getJMP() {
        return this.JMP;
    }

    public void setJMP(boolean JMP) {
        zeraFlags(); //zera as flags antes de setar
        this.JMP = JMP;
    }

    /**
     * Getter e Setter flag jump quando é NULL zera todas as flags
     */
    public void zeraFlags() {
        this.JGT = false;
        this.JEQ = false;
        this.JGE = false;
        this.JLT = false;
        this.JNE = false;
        this.JLE = false;
        this.JMP = false;
    }
}
