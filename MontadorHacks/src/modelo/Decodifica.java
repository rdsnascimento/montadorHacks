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
public class Decodifica extends RegMem {

    private short temp; //variável temporária que recebe o valor a ser colocado no registrador ou na memória;

    public void decAssembler(String a, String comp, String dest, String jump) {
        //Switch baseado nos Bits do Comp
        switch (comp) {
            case "101010":
                if ("0".equals(a)) {
                    this.temp = 0; //0 no temp
                }
                break;

            case "111111":
                if ("0".equals(a)) {
                    this.temp = 1; //1 no temp
                }
                break;

            case "111010":
                if ("0".equals(a)) {
                    this.temp = -1; //-1 no temp
                }
                break;

            case "001100":
                if ("0".equals(a)) {
                    this.temp = getRegD(); //D no temp
                }
                break;

            case "110000":
                if ("0".equals(a)) {
                    this.temp = getRegA(); //A no temp
                    break;
                } else {
                    this.temp = getMemoria(); //Valor de memória no temp
                    break;
                }

            case "001101":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegD(); //!D 
                }
                break;

            case "110001":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegA(); //!A (nega bit a bit) 
                    break;
                } else {
                    this.temp = (short) ~getMemoria(); //!M (nega bit a bit) 
                    break;
                }

            case "001111":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegD()); //0 - D
                }
                break;

            case "110011":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegA()); //-A
                    break;
                } else {
                    this.temp = (short) (0 - getMemoria()); //-M 
                    break;
                }

            case "011111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() + 1); //D++
                }
                break;

            case "110111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() + 1); //A++
                    break;
                } else {
                    this.temp = (short) ((short) getMemoria() + 1); //M++
                    break;
                }

            case "001110":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() - 1); //D--
                }
                break;

            case "110010":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() - 1); //A--
                    break;
                } else {
                    this.temp = (short) ((short) getMemoria() - 1); //M--
                    break;
                }

            case "000010":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() + getRegA()); //D+A
                    break;
                } else {
                    this.temp = (short) (getRegD() + (short) getMemoria()); //D+M                }
                    break;
                }

            case "010011":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() - getRegA()); //D-A
                    break;
                } else {
                    this.temp = (short) (getRegD() - (short) getMemoria()); //D-M
                    break;
                }

            case "000111":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegA() - getRegD()); //A-D
                    break;
                } else {
                    this.temp = (short) ((short) getMemoria() - getRegD()); //M-D
                    break;
                }

            case "000000":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() & getRegA()); //D and A
                    break;
                } else {
                    this.temp = (short) (getRegD() & (short) getMemoria()); //D and M
                    break;
                }

            case "010101":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() | getRegA()); //D or A
                    break;
                } else {
                    this.temp = (short) (getRegD() | (short) getMemoria()); //D or M
                    break;
                }

            default:
                //ERRO;     
                System.out.println("Erro: cmop não encontrado");
        }

        //Switch para descobrir o destino dos registradores ou do valor da memória
        switch (dest) {
            case "000":
                break; //null
            case "001": //Memória <- temp
                setMemoria(this.temp);
                break;
            case "010": //Registrador D <- temp
                setRegD(this.temp);
                break;
            case "011": //Memória e Registrador D <- temp
                setMemoria(this.temp);
                setRegD(this.temp);
                break;
            case "100": //Registrador A <- temp
                setRegA(this.temp);
                break;
            case "101": //Registrador A e Memória <- temp
                setMemoria(this.temp);
                setRegA(this.temp);
                break;
            case "110": //Registrador A e Registrador D <- temp
                setRegA(this.temp);
                setRegD(this.temp);
                break;
            case "111": //Registrador A, Registrador D e Memória <- temp
                setRegA(this.temp);
                setRegD(this.temp);
                setMemoria(this.temp);
                break;
            default:
                //Erro
                System.out.println("Erro: destino inválido");
        }

        //Switch para descobrir o tipo de JUMP
        switch (jump) {
            case "000":
                break; //NULL
            case "001":
                setJGT(true); //jump é JGT
                break;
            case "010":
                setJEQ(true); //jump é JEQ
                break;
            case "011":
                setJGE(true); //jump é JGE
                break;
            case "100":
                setJLT(true); //jump é JLT
                break;
            case "101":
                setJNE(true); //jump é JNE
                break;
            case "110":
                setJLE(true); //jump é JLE
                break;
            case "111":
                setJLE(true); //jump é JMP
                break;
            default:
                //Erro
                System.out.println("Erro: jump inválido");
        }

    }
}
