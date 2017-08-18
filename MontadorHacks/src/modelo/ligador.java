/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author djm
 */
public class ligador {
    
    public ArrayList <String> code;
    public ArrayList <String> codeIntermediario;
    public ArrayList <String> codeFinal;
    
    public int linhas1;
    public int linhas2;
    public TabelaDefSimbol tabelaDefGlobais[];
    public TabelaDefSimbol tabelaGlobal[];
    public int tamTabelaDefGlobais;
    public int tamTabelaGlobal;
    
    public ligador(){
        
        this.code = new ArrayList();
        this.codeIntermediario = new ArrayList();
        this.codeFinal = new ArrayList();
        
        this.linhas1 = 0;
        this.linhas2 = 0;
        
        this.tamTabelaDefGlobais = 0;
        this.tabelaDefGlobais = new TabelaDefSimbol[100];
        
        int i = 0;
        
        for(i = 0; i < 100; i++){
            
            tabelaDefGlobais[i] = new TabelaDefSimbol();
            
        }
        
        this.tamTabelaGlobal = 0;
        this.tabelaGlobal = new TabelaDefSimbol[100];
        
         i = 0;
        
        for(i = 0; i < 100; i++){
            
            this.tabelaGlobal[i] = new TabelaDefSimbol();
            
        }
        
    }
    
    public void read(String arq, String arq2) throws FileNotFoundException{
            
            Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n");
            Scanner leitor2 = new Scanner(new FileReader(arq2)).useDelimiter("\n");
            
            while(leitor.hasNext()){
                
                this.code.add(leitor.nextLine());
                
            }
            
            while(leitor2.hasNext()){
                
                this.code.add(leitor2.nextLine());
                
            }
             
    }
    
    public void getLinhas(String lineOne, String lineTwo)throws FileNotFoundException{
        
        Scanner leitor = new Scanner(new FileReader(lineOne)).useDelimiter("\n");
        Scanner leitor2 = new Scanner(new FileReader(lineTwo)).useDelimiter("\n");
        
        while(leitor.hasNext()){
                
                this.linhas1 = Integer.parseInt(leitor.nextLine());
                
            }
            
            while(leitor2.hasNext()){
                
                this.linhas2 = Integer.parseInt(leitor2.nextLine());
                
            }
        
    }
    
    public void getTabelaDefSimbol(String tabela1, String tabela2)throws FileNotFoundException{
        
        Scanner leitor = new Scanner(new FileReader(tabela1)).useDelimiter("\n");
        Scanner leitor2 = new Scanner(new FileReader(tabela2)).useDelimiter("\n");
        
        String strAux =  new String();
        String strAux2 =  new String();
        String strAux3 =  new String();
        String strAux4 =  new String();
        
        while(leitor.hasNext()){
            
            int v = 0;
            
             strAux =  "";
            strAux2 =  "";
            strAux3 = "";
            strAux4 =  "";
            
            strAux = leitor.next();
            
            while(strAux.charAt(v) != ' '){
                
                strAux2 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(strAux.charAt(v) != ' '){
                
                strAux3 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(v < strAux.length()){
                
                strAux4 += strAux.charAt(v);
                
                v++;
            }
            
            if(strAux4.charAt(0) == 'r'){
            
                int inteiroAuxiliar = 0;
                
                inteiroAuxiliar = Integer.parseInt(strAux3);
                
                inteiroAuxiliar--;
                
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].simbolo = strAux2;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].endereco = Integer.toString(inteiroAuxiliar);
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].mod = strAux4;
            
                this.tamTabelaDefGlobais++;
            
            }else{
                
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].simbolo = strAux2;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].endereco = strAux3;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].mod = strAux4;
            
                this.tamTabelaDefGlobais++;
                
            }
            
        }
        
        while(leitor2.hasNext()){
            
            int v = 0;
            
             strAux =  "";
            strAux2 =  "";
            strAux3 = "";
            strAux4 =  "";
            
            strAux = leitor2.next();
            
            while(strAux.charAt(v) != ' '){
                
                strAux2 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(strAux.charAt(v) != ' '){
                
                strAux3 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(v < strAux.length()){
                
                strAux4 += strAux.charAt(v);
                
                v++;
            }
            
            if(strAux4.charAt(0) == 'r'){
                
                int inteiroAuxiliar = 0;
                
                inteiroAuxiliar = Integer.parseInt(strAux3);
                
                inteiroAuxiliar += (this.linhas1 - 1);
                
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].simbolo = strAux2;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].endereco = Integer.toString(inteiroAuxiliar);
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].mod = strAux4;
            
                this.tamTabelaDefGlobais++;
                
            } else{
                
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].simbolo = strAux2;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].endereco = strAux3;
                this.tabelaDefGlobais[this.tamTabelaDefGlobais].mod = strAux4;
            
                this.tamTabelaDefGlobais++;
                
            }
            
        }
        
    }
    
    public void getTabelaGlobal(String tabela1, String tabela2)throws FileNotFoundException{
        
        Scanner leitor = new Scanner(new FileReader(tabela1)).useDelimiter("\n");
        Scanner leitor2 = new Scanner(new FileReader(tabela2)).useDelimiter("\n");
        
        String strAux =  new String();
        String strAux2 =  new String();
        String strAux3 =  new String();
        String strAux4 =  new String();
        
        while(leitor.hasNext()){
            
            int v = 0;
            
             strAux =  "";
            strAux2 =  "";
            strAux3 = "";
            strAux4 =  "";
            
            strAux = leitor.next();
            
            while(strAux.charAt(v) != ' '){
                
                strAux2 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(strAux.charAt(v) != ' '){
                
                strAux3 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(v < strAux.length()){
                
                strAux4 += strAux.charAt(v);
                
                v++;
            }
            
            if(strAux4.charAt(0) == 'r'){
            
                int inteiroAuxiliar = 0;
                
                inteiroAuxiliar = Integer.parseInt(strAux3);
                
                inteiroAuxiliar--;
                
                this.tabelaGlobal[this.tamTabelaGlobal].simbolo = strAux2;
                this.tabelaGlobal[this.tamTabelaGlobal].endereco = Integer.toString(inteiroAuxiliar);
                this.tabelaGlobal[this.tamTabelaGlobal].mod = strAux4;
            
                this.tamTabelaGlobal++;
            
            }else{
                
                this.tabelaGlobal[this.tamTabelaGlobal].simbolo = strAux2;
                this.tabelaGlobal[this.tamTabelaGlobal].endereco = strAux3;
                this.tabelaGlobal[this.tamTabelaGlobal].mod = strAux4;
            
                this.tamTabelaGlobal++;
                
            }
            
        }
        
        while(leitor2.hasNext()){
            
            int v = 0;
            
             strAux =  "";
            strAux2 =  "";
            strAux3 = "";
            strAux4 =  "";
            
            strAux = leitor2.next();
            
            while(strAux.charAt(v) != ' '){
                
                strAux2 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(strAux.charAt(v) != ' '){
                
                strAux3 += strAux.charAt(v);
                
                v++;
            }
            
            v++;
            
            while(v < strAux.length()){
                
                strAux4 += strAux.charAt(v);
                
                v++;
            }
            
            if(strAux4.charAt(0) == 'r'){
                
                int inteiroAuxiliar = 0;
                
                inteiroAuxiliar = Integer.parseInt(strAux3);
                
                inteiroAuxiliar += (this.linhas1-1);
                
                this.tabelaGlobal[this.tamTabelaGlobal].simbolo = strAux2;
                this.tabelaGlobal[this.tamTabelaGlobal].endereco = Integer.toString(inteiroAuxiliar);
                this.tabelaGlobal[this.tamTabelaGlobal].mod = strAux4;
            
                this.tamTabelaGlobal++;
                
            } else{
                
                this.tabelaGlobal[this.tamTabelaGlobal].simbolo = strAux2;
                this.tabelaGlobal[this.tamTabelaGlobal].endereco = strAux3;
                this.tabelaGlobal[this.tamTabelaGlobal].mod = strAux4;
            
                this.tamTabelaGlobal++;
                
            }
            
        }
        
    }
    
    public void replaceSimbols(){
        
        int i = 0;
        
        String strAux = new String();
        
        for(i = 0; i < this.code.size(); i++){
            
            int k = 0;
            
            strAux = this.code.get(i);
            
            for(k = 0; k < this.tamTabelaDefGlobais; k++){
                
                if(strAux.contains(this.tabelaDefGlobais[k].simbolo)){
                    
                    strAux = strAux.replace(this.tabelaDefGlobais[k].simbolo, this.tabelaDefGlobais[k].endereco);
                    
                }
                
            }
            
            for(k = 0; k < this.tamTabelaGlobal; k++){
                
                if(strAux.contains(this.tabelaGlobal[k].simbolo)){
                    
                    strAux = strAux.replace(this.tabelaGlobal[k].simbolo, this.tabelaGlobal[k].endereco);
                    
                }
            }
            
            this.codeIntermediario.add(strAux);
            
        }
        
        
    }
    
    public void passagemFinal(){
        
        int i = 0;
        
        String strAux = new String();
        String strAux2 = new String();
        String strAux3 = new String();
        
        strAux = "";
        strAux2 = "";
        strAux3 = "";
        
        for(i = 0; i < this.codeIntermediario.size(); i++){
            
            strAux = "";
            strAux2 = "";
            strAux3 = "";
            
            strAux = this.codeIntermediario.get(i);
            
            if(strAux.charAt(0) == '@'){
                
                int k = 1;
                
                while(k < strAux.length() ){
                    
                    strAux2 += strAux.charAt(k);
                    
                    k++;
                    
                }
                
                int inteiroAuxiliar = Integer.parseInt(strAux2);
                
                strAux2 = Integer.toBinaryString(inteiroAuxiliar);
                
                int q = strAux2.length();
                
                while(q < 16){
                    
                    strAux3 += "0";
                    
                    q++;
                    
                }
                
                String copyAux = new String();
                
                copyAux = strAux3 + strAux2;
                
                this.codeFinal.add(copyAux);
                
            } else{
                
                this.codeFinal.add(strAux);
                
            }
            
        }
        
        
    }
    
    public void imprimeTabelaSimbolGlobal(){
        
        
        int i = 0;
        
        for(i = 0; i < this.tamTabelaDefGlobais; i++){
            
            System.out.println(this.tabelaDefGlobais[i].simbolo + " " + this.tabelaDefGlobais[i].endereco + " " + this.tabelaDefGlobais[i].mod  );
            
        }
        
    }
    
    public void imprimeTabelaGloball(){
        
        
        int i = 0;
        
        for(i = 0; i < this.tamTabelaGlobal; i++){
            
            System.out.println(this.tabelaGlobal[i].simbolo + " " + this.tabelaGlobal[i].endereco + " " + this.tabelaGlobal[i].mod  );
            
        }
        
    }
    
    public void imprimeCodeIntermediario(){
        
        int i = 0;
        
        for(i = 0; i < this.codeIntermediario.size(); i++){
            
            System.out.println(this.codeIntermediario.get(i));
            
        }
    }
    
    public void imprimeFinalCode(){
        
        int i = 0;
        
        for(i = 0; i < this.codeFinal.size(); i++){
            
            System.out.println(this.codeFinal.get(i));
            
        }
        
    }
    
    public void imprimeCodigoFinal(String codigoFinal)throws IOException{
        
        FileWriter arquivo = new FileWriter(codigoFinal);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        int i = 0;
        
        for(i = 0; i < this.codeFinal.size(); i++){
            
            archiveFinal.write(this.codeFinal.get(i));
            archiveFinal.newLine();
            
        }
        
        archiveFinal.close();
        
    }
    
    public static void main(String[] args){ // metodo main para teste
        
        
        ligador ligador = new ligador();
        
        
    
        try{
            
            ligador.read("codeMontado.txt", "codeMontado2.txt");
            ligador.getLinhas("linhas1.txt", "linhas2.txt");
            
            ligador.getTabelaDefSimbol("tabelaSimbol.txt", "tabelaSimbol2.txt");
            ligador.getTabelaGlobal("tabelaDef.txt", "tabelaDef2.txt");
            
            //ligador.imprimeTabelaSimbolGlobal();
            
            ligador.replaceSimbols();
            //ligador.imprimeCodeIntermediario();
            ligador.passagemFinal();
            
            ligador.imprimeFinalCode();
            ligador.imprimeCodigoFinal("codigoFinal.txt");
        
            
        } catch( FileNotFoundException e){
            System.out.println("Arquivo não encontrado ...");
        } catch( IOException e){
            System.out.println("Arquivo não encontrado ...");
        }
        
        
        System.out.println( ligador.linhas1 + " " + ligador.linhas2 );
        //montador.printcode();
        
        
    }
    
}