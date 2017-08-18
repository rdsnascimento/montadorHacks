/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Decodifica extends RegMem {

    private short temp; //variável temporária que recebe o valor a ser colocado no registrador ou na memória;
    private static String operacao;
    private static String destino;
    private static String jumpString;
    private static boolean incrementaPC; //se tiver não tiver jump incrementa pc, senão não incrementa

    public void decAssembler(String a, String comp, String dest, String jump) {
        //Switch baseado nos Bits do Comp

        switch (comp) {
            case "101010":
                if ("0".equals(a)) {
                    this.temp = 0; //0 no temp
                    operacao = "0";
                }
                break;

            case "111111":
                if ("0".equals(a)) {
                    this.temp = 1; //1 no temp
                    operacao = "1";
                }
                break;

            case "111010":
                if ("0".equals(a)) {
                    this.temp = -1; //-1 no temp
                    operacao = "-1";

                }
                break;

            case "001100":
                if ("0".equals(a)) {
                    this.temp = getRegD(); //D no temp
                    operacao = "D";
                }
                break;

            case "110000":
                if ("0".equals(a)) {
                    this.temp = getRegA(); //A no temp
                    operacao = "A";
                    break;
                } else {
                    this.temp = getMemDados(); //Valor de memória no temp
                    operacao = "M[A]";
                    break;
                }

            case "001101":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegD(); //!D 
                    operacao = "!D";
                }
                break;

            case "110001":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegA(); //!A (nega bit a bit) 
                    operacao = "!A";
                    break;
                } else {
                    this.temp = (short) ~getMemDados(); //!M (nega bit a bit) 
                    operacao = "!M[A]";
                    break;
                }

            case "001111":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegD()); //0 - D
                    operacao = "-D";
                }
                break;

            case "110011":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegA()); //-A
                    operacao = "-A";
                    break;
                } else {
                    this.temp = (short) (0 - getMemDados()); //-M
                    operacao = "-M[A]";
                    break;
                }

            case "011111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() + 1); //D++
                    operacao = "D+1";
                }
                break;

            case "110111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() + 1); //A++
                    operacao = "A+1";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() + 1); //M++
                    operacao = "M[A]+1";
                    break;
                }

            case "001110":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() - 1); //D--
                    operacao = "D-1";
                }
                break;

            case "110010":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() - 1); //A--
                    operacao = "A-1";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() - 1); //M--
                    operacao = "M[A]-1";
                    break;
                }

            case "000010":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() + getRegA()); //D+A
                    operacao = "D+A";
                    break;
                } else {
                    this.temp = (short) (getRegD() + (short) getMemDados()); //D+M                }
                    operacao = "D+M[A]";
                    break;
                }

            case "010011":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() - getRegA()); //D-A
                    operacao = "D-A";
                    break;
                } else {
                    this.temp = (short) (getRegD() - (short) getMemDados()); //D-M
                    operacao = "D-M[A]";
                    break;
                }

            case "000111":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegA() - getRegD()); //A-D
                    operacao = "A-D";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() - getRegD()); //M-D
                    operacao = "M[A]-D";
                    break;
                }

            case "000000":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() & getRegA()); //D and A
                    operacao = "D&A";
                    break;
                } else {
                    this.temp = (short) (getRegD() & (short) getMemDados()); //D and M
                    operacao = "D&M[A]";
                    break;
                }

            case "010101":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() | getRegA()); //D or A
                    operacao = "D|A";
                    break;
                } else {
                    this.temp = (short) (getRegD() | (short) getMemDados()); //D or M
                    operacao = "D|M[A]";
                    break;
                }

            default:
                //ERRO;     
                System.out.println("Erro: comp inválido");
        }

        //Switch para descobrir o destino dos registradores ou do valor da memória
        switch (dest) {
            case "000":
                destino = "null";
                break; //null
            case "001": //Memória <- temp
                destino = "M[A]";
                setMemDados(this.temp);
                break;
            case "010": //Registrador D <- temp
                destino = "D";
                setRegD(this.temp);
                break;
            case "011": //Memória e Registrador D <- temp
                destino = "MD";
                setMemDados(this.temp);
                setRegD(this.temp);
                break;
            case "100": //Registrador A <- temp
                destino = "A";
                setRegA(this.temp);
                break;
            case "101": //Registrador A e Memória <- temp
                destino = "AM";
                setMemDados(this.temp);
                setRegA(this.temp);
                break;
            case "110": //Registrador A e Registrador D <- temp
                destino = "AD";
                setRegA(this.temp);
                setRegD(this.temp);
                break;
            case "111": //Registrador A, Registrador D e Memória <- temp
                destino = "AMD";
                setRegA(this.temp);
                setRegD(this.temp);
                setMemDados(this.temp);
                break;
        }

        //Switch para saber se tem JUMP e pra onde pular
        switch (jump) {
            case "000":
                jumpString = "null";
                break; //NULL
            case "001":
                if (this.temp > 0) { //this.temp é o atributo que contém o valor decodificado pelos bits de comp
                    incrementaPC = false;
                }
                jumpString = "JGT rom[A]";
                break;
            case "010":
                if (this.temp == 0) {
                    incrementaPC = false;
                }
                jumpString = "JEQ rom[A]";
                break;
            case "011":
                if (this.temp >= 0) {
                    incrementaPC = false;
                }
                jumpString = "JGE rom[A]";
                break;
            case "100":
                if (this.temp < 0) {
                    incrementaPC = false;
                }
                jumpString = "JLT rom[A]";
                break;
            case "101":
                if (this.temp != 0) {
                    incrementaPC = false;
                }
                jumpString = "JNE rom[A]";
                break;
            case "110":
                if (this.temp <= 0) {
                    incrementaPC = false;
                }
                jumpString = "JLE rom[A]";
                break;
            case "111":
                jumpString = "JMP rom[A]";
                incrementaPC = false;
                break;
        }

    }

    //Coloca valor imediato no Registrador A
    public void decAssembler(short a) {
        operacao = Integer.toString(a);
        destino = "A";
        jumpString = "null";
        setRegA(a);
    }

    //Devolve qual o tipo de operação está fazendo.
    public String operacao() {
        return operacao;
    }

    public String destino() {
        return destino;
    }

    public String jump() {
        return jumpString;
    }

    public boolean getIncrementaPC() {
        return incrementaPC;
    }

    public void setIncrementaPC(boolean PC) {
        incrementaPC = PC;
    }
}
