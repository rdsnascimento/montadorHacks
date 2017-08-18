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
public class AssemblyToBinary{

    private String c;
    private String a;
    private String comp;
    private String dest;
    private String jump;
    private String saida;
    
    private final RegMem saidaRom = new RegMem();
    
    //Para @ de imediato ou da tabela de simbolos
    public void decodBinario(int decimal){
        saida = Integer.toBinaryString(decimal); 
        while(saida.length()<16){
            saida = "0" + saida;
        }
//        System.out.println(saida);
        saidaRom.setMemROM(saida);
    }

    //Para Jump, atribuição e negação
    public void decodBinario(String tipo, String destino, String argumento) {
        //INSTRUÇÃO DE ATRIBUIÇÃO
        if ("atribuicao".equals(tipo)) {
            jump = "000";
            switch (argumento) {
                case "D":
                    a = "0";
                    c = "001100";
                    break;
                case "A":
                    a = "0";
                    c = "110000";
                    break;
                case "M":
                    a = "1";
                    c = "110000";
                    break;
                case "0":
                    a = "0";
                    c = "101010";
                    break;
                case "1":
                    a = "0";
                    c = "111111";
                    break;
                default:
                    break;
            }
            comp = a + c;
        } else if ("negacao".equals(tipo)) { //INSTRUÇÃO DE NEGAÇÃO

            jump = "000";
            switch (argumento) {
                case "D": //!D
                    a = "0";
                    c = "001101";
                    break;
                case "A": //!A
                    a = "0";
                    c = "110001";
                    break;
                case "M": //!M
                    a = "1";
                    c = "110001";
                    break;
                default:
                    break;
            }
            comp = a + c;
        } else if ("jump".equals(tipo)) {

            switch (destino) { //INSTRUÇÃO DE JUMP
                case "0":
                    a = "0";
                    c = "101010";
                    break;
                case "D":
                    a = "0";
                    c = "001100";
                    break;
                case "A":
                    a = "0";
                    c = "110000";
                    break;
                default:
                    break;
            }
            comp = a + c;

            switch (argumento) {
                case "JGT":
                    jump = "001";
                    break;
                case "JEQ":
                    jump = "010";
                    break;
                case "JGE":
                    jump = "011";
                    break;
                case "JLT":
                    jump = "100";
                    break;
                case "JNE":
                    jump = "101";
                    break;
                case "JLE":
                    jump = "110";
                    break;
                case "JMP":
                    jump = "111";
                    break;
                default:
                    break;
            }

        }

        //SABER ONDE VAI ESCREVER
        if ("jump".equals(tipo)) { //Se for jump não escreve em nada
            dest = "000";
        } else {
            switch (destino) {
                case "M":
                    dest = "001";
                    break;
                case "D":
                    dest = "010";
                    break;
                case "MD":
                    dest = "011";
                    break;
                case "A":
                    dest = "100";
                    break;
                case "AM":
                    dest = "101";
                    break;
                case "AD":
                    dest = "110";
                    break;
                case "AMD":
                    dest = "111";
                    break;
                default:
                    break;
            }
        }
        saida = "111" + comp + dest + jump;
//        System.out.println(saida);
        saidaRom.setMemROM(saida);
    }

    //Para Jump, atribuição e negação
    public void decodBinario(String tipo, String destino, String argumento1, String argumento2) {

        jump = "000";

        switch (destino) {
            case "M":
                dest = "001";
                break;
            case "D":
                dest = "010";
                break;
            case "MD":
                dest = "011";
                break;
            case "A":
                dest = "100";
                break;
            case "AM":
                dest = "101";
                break;
            case "AD":
                dest = "110";
                break;
            case "AMD":
                dest = "111";
                break;
            default:
                break;
        }

        //AND
        if ("and".equals(tipo)) {
            if ("D".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "000000";
            } else if ("D".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "000000";
            } else if ("A".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "000000";
            } else if ("M".equals(argumento1) && "D".equals(argumento2)) {
                a = "1";
                c = "000000";
            }
            comp = a + c;
        } else if ("or".equals(tipo)) {
            //OR
            if ("D".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "010101";
            } else if ("D".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "010101";
            } else if ("A".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "010101";
            } else if ("M".equals(argumento1) && "D".equals(argumento2)) {
                a = "1";
                c = "010101";
            }
            comp = a + c;

        } else if ("soma".equals(tipo)) {
            //SOMA
            if ("A".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "110000";
            } else if ("A".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "110111";
            } else if ("A".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "000010";
            } else if ("D".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "001100";
            } else if ("D".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "011111";
            } else if ("D".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "000010";
            } else if ("D".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "000010";
            } else if ("M".equals(argumento1) && "0".equals(argumento2)) {
                a = "1";
                c = "110000";
            } else if ("M".equals(argumento1) && "1".equals(argumento2)) {
                a = "1";
                c = "110111";
            } else if ("M".equals(argumento1) && "D".equals(argumento2)) {
                a = "1";
                c = "000010";
            } else if ("0".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "101010";
            } else if ("0".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "111111";
            } else if ("0".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "001100";
            } else if ("0".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "110000";
            } else if ("0".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "110000";
            } else if ("1".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "111111";
            } else if ("1".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "011111";
            } else if ("1".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "110111";
            } else if ("1".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "110111";
            }
            comp = a + c;
        } else if("subtracao".equals(tipo)){
            if ("A".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "110000";
            } else if ("A".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "110010";
            } else if ("A".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "000111";
            } else if ("A".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "101010";
            } else if ("D".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "001100";
            } else if ("D".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "001110";
            } else if ("D".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "010011";
            } else if ("D".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "010011";
            } else if ("D".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "101010";
            } else if ("M".equals(argumento1) && "0".equals(argumento2)) {
                a = "1";
                c = "110000";
            } else if ("M".equals(argumento1) && "1".equals(argumento2)) {
                a = "1";
                c = "110010";
            } else if ("M".equals(argumento1) && "D".equals(argumento2)) {
                a = "1";
                c = "000111";
            } else if ("M".equals(argumento1) && "M".equals(argumento2)) {
                a = "0";
                c = "101010";
            } else if ("0".equals(argumento1) && "0".equals(argumento2)) {
                a = "0";
                c = "101010";
            } else if ("0".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "111010";
            } else if ("0".equals(argumento1) && "D".equals(argumento2)) {
                a = "0";
                c = "001111";
            } else if ("0".equals(argumento1) && "A".equals(argumento2)) {
                a = "0";
                c = "110011";
            } else if ("0".equals(argumento1) && "M".equals(argumento2)) {
                a = "1";
                c = "110011";
            } else if ("1".equals(argumento1) && "1".equals(argumento2)) {
                a = "0";
                c = "101010";
            }
            comp = a + c;
        }
        saida = "111" + comp + dest + jump;
//        System.out.println(saida);
        saidaRom.setMemROM(saida);
    }

}
