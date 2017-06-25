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
    private String operacao;
    private String destino;
    private String jumpString;

    public void decAssembler(String a, String comp, String dest, String jump) {
        //Switch baseado nos Bits do Comp
        switch (comp) {
            case "101010":
                if ("0".equals(a)) {
                    this.temp = 0; //0 no temp
                    this.operacao = "0";
                }
                break;

            case "111111":
                if ("0".equals(a)) {
                    this.temp = 1; //1 no temp
                    this.operacao = "1";
                }
                break;

            case "111010":
                if ("0".equals(a)) {
                    this.temp = -1; //-1 no temp
                    this.operacao = "-1";
                    
                }
                break;

            case "001100":
                if ("0".equals(a)) {
                    this.temp = getRegD(); //D no temp
                    this.operacao = "D";
                }
                break;

            case "110000":
                if ("0".equals(a)) {
                    this.temp = getRegA(); //A no temp
                    this.operacao = "A";
                    break;
                } else {
                    this.temp = getMemDados(); //Valor de memória no temp
                    this.operacao = "M[A]";
                    break;
                }

            case "001101":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegD(); //!D 
                    this.operacao = "!D";
                }
                break;

            case "110001":
                if ("0".equals(a)) {
                    this.temp = (short) ~getRegA(); //!A (nega bit a bit) 
                    this.operacao = "!A";
                    break;
                } else {
                    this.temp = (short) ~getMemDados(); //!M (nega bit a bit) 
                    this.operacao = "!M[A]";
                    break;
                }

            case "001111":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegD()); //0 - D
                    this.operacao = "-D";
                }
                break;

            case "110011":
                if ("0".equals(a)) {
                    this.temp = (short) (0 - getRegA()); //-A
                    this.operacao = "-A";
                    break;
                } else {
                    this.temp = (short) (0 - getMemDados()); //-M
                    this.operacao = "-M[A]";
                    break;
                }

            case "011111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() + 1); //D++
                    this.operacao = "D+1";
                }
                break;

            case "110111":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() + 1); //A++
                    this.operacao = "A+1";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() + 1); //M++
                    this.operacao = "M[A]+1";
                    break;
                }

            case "001110":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegD() - 1); //D--
                    this.operacao = "D-1";
                }
                break;

            case "110010":
                if ("0".equals(a)) {
                    this.temp = (short) ((short) getRegA() - 1); //A--
                    this.operacao = "A-1";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() - 1); //M--
                    this.operacao = "M[A]-1";
                    break;
                }

            case "000010":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() + getRegA()); //D+A
                    this.operacao = "D+A";
                    break;
                } else {
                    this.temp = (short) (getRegD() + (short) getMemDados()); //D+M                }
                    this.operacao = "D+M[A]";
                    break;
                }

            case "010011":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() - getRegA()); //D-A
                    this.operacao = "D-A";
                    break;
                } else {
                    this.temp = (short) (getRegD() - (short) getMemDados()); //D-M
                    this.operacao = "D-M[A]";
                    break;
                }

            case "000111":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegA() - getRegD()); //A-D
                    this.operacao = "A-D";
                    break;
                } else {
                    this.temp = (short) ((short) getMemDados() - getRegD()); //M-D
                    this.operacao = "M[A]-D";
                    break;
                }

            case "000000":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() & getRegA()); //D and A
                    this.operacao = "D&A";
                    break;
                } else {
                    this.temp = (short) (getRegD() & (short) getMemDados()); //D and M
                    this.operacao = "D&M[A]";
                    break;
                }

            case "010101":
                if ("0".equals(a)) {
                    this.temp = (short) (getRegD() | getRegA()); //D or A
                    this.operacao = "D|A";
                    break;
                } else {
                    this.temp = (short) (getRegD() | (short) getMemDados()); //D or M
                    this.operacao = "D|M[A]";
                    break;
                }

            default:
                //ERRO;     
                System.out.println("Erro: comp inválido");
        }

        //Switch para descobrir o destino dos registradores ou do valor da memória
        switch (dest) {
            case "000":
                this.destino="null";
                break; //null
            case "001": //Memória <- temp
                this.destino="M[A]";
                setMemDados(this.temp);
                break;
            case "010": //Registrador D <- temp
                this.destino="D";
                setRegD(this.temp);
                break;
            case "011": //Memória e Registrador D <- temp
                this.destino="MD";
                setMemDados(this.temp);
                setRegD(this.temp);
                break;
            case "100": //Registrador A <- temp
                this.destino="A";
                setRegA(this.temp);
                break;
            case "101": //Registrador A e Memória <- temp
                this.destino="AM";
                setMemDados(this.temp);
                setRegA(this.temp);
                break;
            case "110": //Registrador A e Registrador D <- temp
                this.destino="AD";
                setRegA(this.temp);
                setRegD(this.temp);
                break;
            case "111": //Registrador A, Registrador D e Memória <- temp
                this.destino="AMD";
                setRegA(this.temp);
                setRegD(this.temp);
                setMemDados(this.temp);
                break;
        }
        
        //Switch para saber se tem JUMP e pra onde pular
        switch(jump){
            case "000":
                this.jumpString = "null";
                break; //NULL
            case "001":  //setPc(getRegA()-1). Esse -1 é porque pc é incrementado logo a seguir de quando é chamado esse setPc. Então -1+1=0.
                if(this.temp>0){ //this.temp é o atributo que contém o valor decodificado pelos bits de comp
                    this.jumpString = "JGT rom[A]";
                    setPc(getRegA()-1); //Se (comp>0) então PC passa apontar para memRom[regA]. MEMÓRIA ROM é a MEMÓRIA QUE CONTÉM AS INTRUÇÕES. 
                }
                break;
            case "010":
                if(this.temp==0){
                    this.jumpString = "JEQ rom[A]";
                    setPc(getRegA()-1); //Se (comp==0) então PC passa apontar para memRom[regA]
                }
                break;
            case "011":
                if(this.temp>=0){
                    this.jumpString = "JGE rom[A]";
                    setPc(getRegA()-1); //Se (comp>=0) então PC passa apontar para memRom[regA]
                }
                break;
            case "100":
                if(this.temp<0){ 
                    this.jumpString = "JLT rom[A]";
                    setPc(getRegA()-1); //Se (comp<0) então PC passa apontar para memRom[regA]
                }
                break;
            case "101":
                if(this.temp!=0){
                    this.jumpString = "JNE rom[A]";
                    setPc(getRegA()-1); //Se (comp!=0) então PC passa apontar para memRom[regA]
                }
                break;
            case "110":
                if(this.temp<=0){
                    this.jumpString = "JLE rom[A]";
                    setPc(getRegA()-1); //Se (comp><=0) então PC passa apontar para memRom[regA]
                }
                break;
            case "111":
                this.jumpString = "JMP rom[A]";
                setPc(getRegA()-1); //PC passa apontar para instrução que está na memRom[regA]
                break;
        }

    }
    
    //Coloca valor imediato no Registrador A
    public void decAssembler(short a){
        this.operacao = Integer.toString(a);
        this.destino = "A";
        this.jumpString = "null";
        setRegA(a);
    }
    
    //Devolve qual o tipo de operação está fazendo.
    public String operacao(){
        return this.operacao;
    }
    
    public String destino(){
        return this.destino;
    }
    
    public String jump(){
        return this.jumpString;
    }
}
