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
 * @author Douglas Janovik Maliszewski
 */
public class Montador {
    public ArrayList<String> code;
    public TabelaDefSimbol TabelaDefinicoes[];
    public TabelaDefSimbol TabelaSimbol[];
    public tabelaUSo TabelaUso[];
    public int tamTabelaDef;
    public int tamTabelaUso;
    public int tamTabelaSimbol;
    
    public ListaMontador listaInstrucoesComp[];
    public ListaMontador listaInstrucoesDest[];
    public ListaMontador listaInstrucoesJmp[];
    
    public Montador(){
        this.code = new ArrayList();
        
        int i = 0;
        
        this.TabelaDefinicoes = new TabelaDefSimbol[100];
        
        for(i = 0; i < 100; i++){
            
            this.TabelaDefinicoes[i] = new TabelaDefSimbol();
            
        }
        
        this.tamTabelaDef = 0;
        
        this.TabelaSimbol = new TabelaDefSimbol[100];
        
        for(i = 0; i < 100; i++){
            
            this.TabelaSimbol[i] = new TabelaDefSimbol();
            
        }
        
        this.tamTabelaSimbol = 0;
        
        this.TabelaUso = new tabelaUSo[100];
        
        for(i = 0; i < 100; i++){
            
            this.TabelaUso[i] = new tabelaUSo();
            
        }
        
        this.tamTabelaUso = 0;
        
        this.listaInstrucoesComp = new ListaMontador[30];
        
        for(i = 0; i < 30; i++){
        
            this.listaInstrucoesComp[i] = new ListaMontador();
        
        }
        
        this.listaInstrucoesDest = new ListaMontador[8];
        
        for(i = 0; i < 8; i++){
        
            this.listaInstrucoesDest[i] = new ListaMontador();
        
        }
        
        this.listaInstrucoesJmp = new ListaMontador[8];
        
        for(i = 0; i < 8; i++){
        
            this.listaInstrucoesJmp[i] = new ListaMontador();
        
        }
   
        
    }
    
    public void setInstrucoesJmp(){
        
        this.listaInstrucoesJmp[0].simbolo += "JGT";
        this.listaInstrucoesJmp[0].binario += "001";
        
        this.listaInstrucoesJmp[1].simbolo += "JEQ";
        this.listaInstrucoesJmp[1].binario += "010";
        
        this.listaInstrucoesJmp[2].simbolo += "JEG";
        this.listaInstrucoesJmp[2].binario += "011";
        
        this.listaInstrucoesJmp[3].simbolo += "JLT";
        this.listaInstrucoesJmp[3].binario += "100";
        
        this.listaInstrucoesJmp[4].simbolo += "JNE";
        this.listaInstrucoesJmp[4].binario += "101";
        
        this.listaInstrucoesJmp[5].simbolo += "JLE";
        this.listaInstrucoesJmp[5].binario += "110";
        
        this.listaInstrucoesJmp[6].simbolo += "JMP";
        this.listaInstrucoesJmp[6].binario += "111";
        
    }
    
    public void setInstrucoesDest(){
        
        this.listaInstrucoesDest[0].simbolo += "M";
        this.listaInstrucoesDest[0].binario += "001";
        
        this.listaInstrucoesDest[1].simbolo += "D";
        this.listaInstrucoesDest[1].binario += "010";
                
        this.listaInstrucoesDest[2].simbolo += "MD";
        this.listaInstrucoesDest[2].binario += "011";   
        
        this.listaInstrucoesDest[3].simbolo += "A";
        this.listaInstrucoesDest[3].binario += "100"; 
        
        this.listaInstrucoesDest[4].simbolo += "AM";
        this.listaInstrucoesDest[4].binario += "101";
        
        this.listaInstrucoesDest[5].simbolo += "AD";
        this.listaInstrucoesDest[5].binario += "110";
        
        this.listaInstrucoesDest[6].simbolo += "AM";
        this.listaInstrucoesDest[6].binario += "111";
        
    }
    
    public void setInstrucoesComp(){
        
        this.listaInstrucoesComp[0].simbolo += "0";
        this.listaInstrucoesComp[0].binario += "0101010";
        
        this.listaInstrucoesComp[1].simbolo += "1";
        this.listaInstrucoesComp[1].binario += "0111111";
        
        this.listaInstrucoesComp[2].simbolo += "-1";
        this.listaInstrucoesComp[2].binario += "0111010";
        
        this.listaInstrucoesComp[3].simbolo += "D";
        this.listaInstrucoesComp[3].binario += "0001100";
        
        this.listaInstrucoesComp[4].simbolo += "A";
        this.listaInstrucoesComp[4].binario += "0110000";
        
        this.listaInstrucoesComp[5].simbolo += "!D";
        this.listaInstrucoesComp[5].binario += "0001101";
        
        this.listaInstrucoesComp[6].simbolo += "!A";
        this.listaInstrucoesComp[6].binario += "0110001";
        
        this.listaInstrucoesComp[7].simbolo += "-D";
        this.listaInstrucoesComp[7].binario += "0001111";
        
        this.listaInstrucoesComp[8].simbolo += "-A";
        this.listaInstrucoesComp[8].binario += "0110011";
        
        this.listaInstrucoesComp[9].simbolo += "D+1";
        this.listaInstrucoesComp[9].binario += "0011111";
        
        this.listaInstrucoesComp[10].simbolo += "A+1";
        this.listaInstrucoesComp[10].binario += "0110111";
        
        this.listaInstrucoesComp[11].simbolo += "D-1";
        this.listaInstrucoesComp[11].binario += "0100111";
        
        this.listaInstrucoesComp[12].simbolo += "A-1";
        this.listaInstrucoesComp[12].binario += "0110010";
        
        this.listaInstrucoesComp[13].simbolo += "A-1";
        this.listaInstrucoesComp[13].binario += "0110010";
        
        this.listaInstrucoesComp[14].simbolo += "D+A";
        this.listaInstrucoesComp[14].binario += "0000010";
        
        this.listaInstrucoesComp[15].simbolo += "D-A";
        this.listaInstrucoesComp[15].binario += "0010011";
        
        this.listaInstrucoesComp[16].simbolo += "A-D";
        this.listaInstrucoesComp[16].binario += "0000111";
        
        this.listaInstrucoesComp[17].simbolo += "D&A";
        this.listaInstrucoesComp[17].binario += "0000000";
        
        this.listaInstrucoesComp[18].simbolo += "D|A";
        this.listaInstrucoesComp[18].binario += "0010101";
        
        this.listaInstrucoesComp[19].simbolo += "M";
        this.listaInstrucoesComp[19].binario += "1110000";
        
        this.listaInstrucoesComp[20].simbolo += "!M";
        this.listaInstrucoesComp[20].binario += "1110001";
        
        this.listaInstrucoesComp[21].simbolo += "-M";
        this.listaInstrucoesComp[21].binario += "1110011";
        
        this.listaInstrucoesComp[22].simbolo += "M+1";
        this.listaInstrucoesComp[22].binario += "1110111";
        
        this.listaInstrucoesComp[23].simbolo += "M-1";
        this.listaInstrucoesComp[23].binario += "1110010";
        
        this.listaInstrucoesComp[24].simbolo += "D+M";
        this.listaInstrucoesComp[24].binario += "1000010";
        
        this.listaInstrucoesComp[25].simbolo += "D-M";
        this.listaInstrucoesComp[25].binario += "1010011";
        
        this.listaInstrucoesComp[26].simbolo += "M-D";
        this.listaInstrucoesComp[26].binario += "1000111";
        
        this.listaInstrucoesComp[27].simbolo += "D&M";
        this.listaInstrucoesComp[27].binario += "1000000";
        
        this.listaInstrucoesComp[28].simbolo += "D|M";
        this.listaInstrucoesComp[28].binario += "1010101";
        
    }
    
    public void read(String arq) throws FileNotFoundException{
            
            Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n");
            
            while(leitor.hasNext()){
                
                this.code.add(leitor.nextLine());
                
            }
             
    }
    
    public void getTabelaDef(){
        
        int i = 0;
        
        int contadorLinha = 0;
        
        String strAux = new String();
        
        strAux = "";
        
        for(i = 0; i < this.code.size(); i++){
            
            strAux = this.code.get(i);
           
            
            if(strAux.contains("EXTDEF")){
                
                int k = 0;
                
                while(strAux.charAt(k) != ' '){
                    
                    k++;
                    
                }
                
                k++;
                
                while(k < strAux.length()){
                
                    this.TabelaDefinicoes[this.tamTabelaDef].simbolo += strAux.charAt(k);
                    k++;
                }
                
                this.tamTabelaDef++;
                
            }
            
            if(strAux.contains("%")){
                
                int p = 1;
                
                String strAux2 = new String();
                strAux2 = "";
                
                while(strAux.charAt(p) != ' '){
                    
                    strAux2 += strAux.charAt(p);
                    p++;
                    
                }
                
                p++;
                
                int c = 0;
                
                for(c = 0; c < this.tamTabelaDef; c++){
                    
                    if(strAux2.equals(this.TabelaDefinicoes[c].simbolo)){
                        
                        if(strAux.charAt(p) == '='){
                            
                            p += 2;
                            
                            
                            while(p < strAux.length()){
                                this.TabelaDefinicoes[c].endereco += strAux.charAt(p);
                                p++;
                            }
                            
                            this.TabelaDefinicoes[c].mod += 'a';
                            
                        }
                        
                    }
                    
                }
                
            }
            
            if(strAux.contains("(")){
                
                String strAux2 = new String();
                
                strAux2 = "";
                
                int p = 1;
                
                while(strAux.charAt(p) != ')'){
                    
                    strAux2 += strAux.charAt(p);
                    p++;
                    
                }
                
                int c = 0;
                
                for(c = 0; c < this.tamTabelaDef; c++){
                    
                    if(strAux2.equals(this.TabelaDefinicoes[c].simbolo)){
                        
                        
                        this.TabelaDefinicoes[c].endereco = Integer.toString(contadorLinha+1);
                        this.TabelaDefinicoes[c].mod += 'r';
                        
                    }
                    
                }
                
            }
            
            if(!strAux.contains("(") && !strAux.contains("%") && !strAux.contains("EXTDEF") && !strAux.contains("EXTR"))
                contadorLinha++;
            
        }
        
    }
    
    public void getTabelaSimbol(){
        
        int i = 0;
        
        int contadorLinha = 0;
        
        String strAux = new String();
        
        boolean tabelaSimbol;
        
        
        strAux = "";
        
        for(i = 0; i < this.code.size(); i++){
            
            tabelaSimbol = true;
            
            strAux = this.code.get(i);
            
            
            int c = 0;
            
            for(c = 0; c < this.tamTabelaDef; c++){
                
                if(strAux.contains(this.TabelaDefinicoes[c].simbolo))
                    tabelaSimbol = false;
                
            }
            
            for(c = 0; c < this.tamTabelaUso; c++){
                
                if(strAux.contains(this.TabelaUso[c].simbolo))
                    tabelaSimbol = false;
                
            }
                
                
            if(tabelaSimbol){
                if(strAux.contains("%")){
                
                    int p = 1;
                
                    String strAux2 = new String();
                    strAux2 = "";
                
                    while(strAux.charAt(p) != ' '){
                    
                        strAux2 += strAux.charAt(p);
                        p++;
                    
                    }
                
                    p += 3;
                
                    this.TabelaSimbol[this.tamTabelaSimbol].simbolo += strAux2;
                    
                    while(p < strAux.length()){
                        
                        this.TabelaSimbol[this.tamTabelaSimbol].endereco += strAux.charAt(p);
                        p++;
                    }
                    
                    this.TabelaSimbol[this.tamTabelaSimbol].mod += 'a';
                    
                    this.tamTabelaSimbol++;
                    
                }
            
                if(strAux.contains("(")){
                
                    String strAux2 = new String();
                
                    strAux2 = "";
                
                    int p = 1;
                
                    while(strAux.charAt(p) != ')'){
                    
                        strAux2 += strAux.charAt(p);
                        p++;
                    
                    }
                    
                    this.TabelaSimbol[this.tamTabelaSimbol].simbolo += strAux2;
                    this.TabelaSimbol[this.tamTabelaSimbol].endereco += Integer.toString(contadorLinha+1);
                    this.TabelaSimbol[this.tamTabelaSimbol].mod += 'r';
                
                    this.tamTabelaSimbol++;
                    
                    }
                
                
            
            }
            
            if(!strAux.contains("(") && !strAux.contains("%") && !strAux.contains("EXTDEF") && !strAux.contains("EXTR"))
                contadorLinha++;
            
        }
        
    }
    
    public void getTabelaUso(){
        
        int i = 0;
        
        int contadorLinha = 0;
        
        String strAux = new String();
        String strAux2 = new String();
        
        ArrayList <String> listaUsos = new ArrayList();
        
        strAux = "";
        strAux2 = "";
        
        for(i = 0; i < this.code.size(); i++){
            
            strAux = this.code.get(i);
  
            
            if(strAux.contains("EXTR")){
                
                int k = 0;
                
                while(strAux.charAt(k) != ' '){
                    
                    k++;
                    
                }
                
                k++;
                
                while(k < strAux.length()){
                
                    strAux2 += strAux.charAt(k);
                    k++;
                }
                
                
                listaUsos.add(strAux2);
                
            }
            
            if(!strAux.contains("EXTR")){
                
                int k = 0;
            
                for(k = 0; k < listaUsos.size(); k++){
                    
                    if(strAux.contains(listaUsos.get(k))){
                        
                        this.TabelaUso[this.tamTabelaUso].simbolo = listaUsos.get(k);
                        this.TabelaUso[this.tamTabelaUso].endereco = Integer.toString(contadorLinha);
                        this.TabelaUso[this.tamTabelaUso].sinal+= '+';
                        
                        this.tamTabelaUso++;
                        
                    }
                    
                }
            }
            
            if(!strAux.contains("(") && !strAux.contains("%") && !strAux.contains("EXTDEF") && !strAux.contains("EXTR"))
                contadorLinha++;
        
    }
        
}
        

    
    
    public void printcode(){
        
        int i = 0;
        
        for(i = 0; i < this.code.size(); i++){
            
            System.out.println(this.code.get(i));
            
        }
        
    }
    
   public void printftabelaDef(String archive) throws IOException{
        
         FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        int i = 0;
        
        for(i = 0; i < this.tamTabelaDef; i++){
         
            archiveFinal.write(this.TabelaDefinicoes[i].simbolo + " " + this.TabelaDefinicoes[i].endereco + " " + this.TabelaDefinicoes[i].mod);
            archiveFinal.newLine();
         
        }
        
        archiveFinal.close();
        
    }
    
    public void printftabelaSimbol(String archive) throws IOException {
        
        FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        int i = 0;
        
        for(i = 0; i < this.tamTabelaSimbol; i++){
            
         archiveFinal.write(this.TabelaSimbol[i].simbolo + " " + this.TabelaSimbol[i].endereco + " " + this.TabelaSimbol[i].mod);
         archiveFinal.newLine();
         
        }
        
         archiveFinal.close();
        
    }
    
    public void printftabelaUso(String archive) throws IOException {
        
        FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        
        int i = 0;
        
        for(i = 0; i < this.tamTabelaUso; i++){
            
         archiveFinal.write(this.TabelaUso[i].simbolo + " " + this.TabelaUso[i].endereco + " " + this.TabelaUso[i].sinal);
         archiveFinal.newLine();
         
        }
        
        archiveFinal.close();
        
    }
    
    public void geraSaidaMontador(String archive, String archive2)throws IOException{
        
        String strAux = new String();
        String strAux2 = new String();
        String strAux3 = new String();
        int contadorLinhas = 0 ;
        
         FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        FileWriter arquivo2 = new FileWriter(archive2);
        
        BufferedWriter archiveFinal2 = new BufferedWriter(arquivo2);
        
        strAux = "";
        
        int i = 0;
        
        for(i = 0; i < this.code.size(); i++){
            
            strAux2 = "";
            strAux3 = "";
            
            strAux = this.code.get(i);
            
            
            if(!strAux.contains("EXTDEF") && !strAux.contains("EXTR") && !strAux.contains("%") && !strAux.contains("(")){
                
                if(strAux.contains("=") && !strAux.contains("%")){
                    
                    int c = 0;
                    
                    while(strAux.charAt(c) != ' '){
                        strAux2 += strAux.charAt(c);
                        c++; 
                    }
                    
                    
                    c += 3;
                    
                    while( c < strAux.length()){
                        
                        strAux3 += strAux.charAt(c);
                        c++; 
                        
                    }
                    
                    //System.out.println(strAux2 + " " + strAux3);
                    
                    String binDest = new String();
                    String binComp = new String();
                    
                    binComp = "";
                    binDest = "";
                    
                    int p = 0;
                    
                    for(p = 0; p < 28; p++){
                        
                        if(this.listaInstrucoesComp[p].simbolo.equals(strAux3))
                            binComp += this.listaInstrucoesComp[p].binario;
                    }
                    
                    for(p = 0; p < 8; p++){
                        
                        if(this.listaInstrucoesDest[p].simbolo.equals(strAux2))
                            binDest += this.listaInstrucoesDest[p].binario;
                    }
                    
                    archiveFinal.write("111" + binComp + binDest + "000");
                    archiveFinal.newLine();
                    contadorLinhas++;
                    
                } else if(strAux.contains(";")){
                    
                    int g = 0;
                    
                    while(strAux.charAt(g) != ';'){
                        
                        strAux2 += strAux.charAt(g);
                        g++;
                    }
                    
                    g++;
                    
                    while(g < strAux.length()){
                        
                        strAux3 += strAux.charAt(g);
                        g++;
                    }
                    
                    //System.out.println(strAux2 + " " + strAux3);
                    
                    String binJmp = new String();
                    String binComp = new String();
                    
                    binComp = "";
                    binJmp = "";
                    
                    int v = 0;
                    
                    for(v = 0; v < 28; v++){
                        
                        if(this.listaInstrucoesComp[v].simbolo.equals(strAux2))
                            binComp += this.listaInstrucoesComp[v].binario;
                        
                    }
                    
                    v = 0;
                    
                    for(v = 0; v < 8; v++){
                        
                        if(this.listaInstrucoesJmp[v].simbolo.equals(strAux3))
                            binJmp += this.listaInstrucoesJmp[v].binario;
                        
                    }
                    
                    archiveFinal.write("111" + binComp + "000" + binJmp);
                    archiveFinal.newLine();
                    contadorLinhas++;
                    
                    
                } else if (strAux.contains("@")){
                
                        int s = 1;
                        boolean soDigitos = true;
                   
                        while(s < strAux.length()){
                            strAux2 += strAux.charAt(s);
                            s++;
                        }    
                       
                      System.out.println(strAux2);  
                        
                      s = 0;
                      
                      while(s < strAux2.length()){
                      
                            if( !Character.isDigit(strAux2.charAt(s)) ){
                                soDigitos = false;
                             }
                       s++;
                      }
                      
                      System.out.println(soDigitos); 
                       
                       if(soDigitos){
                           
                           int inteiroAux = Integer.parseInt(strAux2);
                           strAux2 = Integer.toBinaryString(inteiroAux);
                           
                           
                           int u = strAux2.length();
                           
                           
                        
                           while(u < 16){
                               
                               strAux3 += '0';
                               u++;
                           }
                           
                           archiveFinal.write(strAux3 + strAux2);
                            archiveFinal.newLine();
                            contadorLinhas++;
                           
                       }else{
                           
                           archiveFinal.write(strAux);
                            archiveFinal.newLine();
                            contadorLinhas++;
                           
                       }
                       
                   }
                    
                else{
                    
                    archiveFinal.write(strAux);
                    archiveFinal.newLine();
                    contadorLinhas++;
                    
                }
                
            }
            
            
        }
        
        archiveFinal2.write(Integer.toString(contadorLinhas));
        
        
        archiveFinal.close();
        
        archiveFinal2.close();
        
    }
    




 public static void main(String[] args){ // metodo main para teste
        
        
        Montador montador = new Montador();
        
        montador.setInstrucoesComp();
        montador.setInstrucoesDest();
        montador.setInstrucoesJmp();
    
        try{
            
            montador.read("codemcr2.txt");
            
             montador.getTabelaDef();
            montador.getTabelaUso();
            montador.getTabelaSimbol();
        
            montador.printftabelaDef("tabelaDef2.txt");
            montador.printftabelaUso("tabelaUso2.txt");
            montador.printftabelaSimbol("tabelaSimbol2.txt");
            
            montador.geraSaidaMontador("codeMontado2.txt","linhas2.txt");
        
            
        } catch( FileNotFoundException e){
            System.out.println("Arquivo não encontrado ...");
        } catch( IOException e){
            System.out.println("Arquivo não encontrado ...");
        }
        
        
        //System.out.println( montador.listaInstrucoesDest[3].simbolo + " " + montador.listaInstrucoesDest[3].binario  );
        //montador.printcode();
        
        
    }
    
}