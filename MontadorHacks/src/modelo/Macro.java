/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Douglas Janovik Maliszewski
 */


public class Macro{
   
    public mc mc[];
    public int tamMacro;
    public ArrayList<String> code;
    public ArrayList<String> outPutCode;
    
    public Macro(){
        
        this.code = new ArrayList();
        this.outPutCode = new ArrayList();
        this.mc = new mc[100];
        
        int i = 0;
        
        for(i = 0; i < 100; i++){
            
            this.mc[i] = new mc();
            
        }
        
        this.tamMacro = 0;
      
    }
    
    public void read(String arq) throws FileNotFoundException{
            
            Scanner leitor = new Scanner(new FileReader(arq)).useDelimiter("\n");
            
            while(leitor.hasNext()){
                
                this.code.add(leitor.nextLine());
                
            }
             
    }
    
    public void getMacro(){
       
        int i = 0;
        String strAux = new String();
        String strAux2 = new String();
        
        for(i = 0; i < this.code.size(); i++){
            
            strAux = this.code.get(i);
            boolean t = true;
            
            if("mcdefn".equals(strAux)){
                i++;
                strAux = this.code.get(i); 
                if(!"mcend".equals(strAux)){
                    int j = 0;
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' '){
                            t = false;
                        }
                        
                        if(t){
                            this.mc[this.tamMacro].label += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ')
                            t = false;
                        if(t){
                            this.mc[this.tamMacro].TituloMacro += strAux.charAt(j);
                            
                            
                            
                        }
                        
                        j++;
                    }
                    
                    
                    while(strAux.length() > j){
                        
                        if(strAux.charAt(j) == ' '){
                            this.mc[this.tamMacro].Args.add(strAux2);
                            strAux2 = "";
                            this.mc[this.tamMacro].num++;
                            
                        }
                        
                        if(strAux.charAt(j) != ' ')
                            strAux2 += strAux.charAt(j);
                         
                      j++;
                    }
                    
                    this.mc[this.tamMacro].Args.add(strAux2);
                    strAux2 = "";
                    this.mc[this.tamMacro].num++;
                    
                }
                
                while(!"mcend".equals(strAux)){
                    
                    
                    i++;
                    strAux = this.code.get(i);
                    
                   if((!"mcend".equals(strAux)))
                        this.mc[this.tamMacro].tabelaMacros.add(strAux);
                    
                }
                
                this.tamMacro++;
                
            }
            
        }
        
        
    }
    
    public void expandMacro() {
        
        int i = 0;
        String strAux = new String();
        String strAux2 = new String();
        boolean macrFind = false;
        boolean t = true;
        
        String macroName = new String();
        String label = new String();
        ArrayList<String> args = new ArrayList();
        int numberArgs = 0;
        
        for(i = 0; i < this.code.size(); i++){
            
            macrFind = false;
            
            strAux = this.code.get(i);
            
            int p = 0;
            
            if("mcdefn".equals(strAux)){
                
                boolean mceend = false;
                while(!mceend && this.code.size() > i){
                    strAux = this.code.get(i);
                    if("mcend".equals(strAux))
                        mceend = true;
                    else i++;
                }
                
            }
            
            while(p < this.tamMacro){
                if(strAux.contains(this.mc[p].TituloMacro)){
                    macrFind = true;
                    
                    t = true;
                    
                    int j = 0;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' '){
                            t = false;
                        }
                        
                        if(t){
                            label += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    t = true;
                    
                    while(t){
                        if(strAux.charAt(j) == '\n' || strAux.charAt(j) == ' ')
                            t = false;
                        if(t){
                            macroName += strAux.charAt(j);
                            
                        }
                        
                        j++;
                    }
                    
                    
                    while(strAux.length() > j){
                        
                        if(strAux.charAt(j) == ' '){
                            args.add(strAux2);
                            strAux2 = "";
                            numberArgs++;
                            
                        }
                        
                        if(strAux.charAt(j) != ' ')
                            strAux2 += strAux.charAt(j);
                         
                      j++;
                    }
                    
                    args.add(strAux2);
                    strAux2 = "";
                    numberArgs++;
                    
                    if(this.mc[p].TituloMacro.equals(macroName)){
                        
                        if(!(this.mc[p].num == numberArgs)){
                            System.out.println("ERRO AO PROCESSAR MACRO, numero de argumentos invalido >>" + this.mc[p].TituloMacro);
                            return;
                        }
                            
                        int k = 0;
                        int v = 0;
                        
                        for(k = 0; k < this.mc[p].tabelaMacros.size(); k++){
                            v = 0;
                            
                            
                            strAux = this.mc[p].tabelaMacros.get(k);
                            strAux = strAux.replace(this.mc[p].label, label);
                            
                            while(v < this.mc[p].num){
                                strAux = strAux.replace(this.mc[p].Args.get(v), args.get(v));
                                v++;
                            }
                            
                            
                            this.outPutCode.add(strAux);
                        }
                        
                        
                    }
                    
                    
                }
               p++;    
             }
             
             numberArgs = 0;
             macroName = "";
             label = "";
                
             args.clear();
             
            if(!macrFind && !"mcend".equals(strAux))
                this.outPutCode.add(strAux);
            
          }
            
            
        
        
    }
    
    
    public void print(){
        
        int i = 0;
        
        for(i = 0; i < this.outPutCode.size(); i++){
            
            System.out.println(this.outPutCode.get(i));
            
        }
        
    }
    
    public void writeArchive(String archive) throws  IOException{
        
        
        FileWriter arquivo = new FileWriter(archive);
        
        BufferedWriter archiveFinal = new BufferedWriter(arquivo);
        
        int i = 0;
        
        for(i = 0; i < this.outPutCode.size(); i++){
            
            archiveFinal.write(this.outPutCode.get(i));
            archiveFinal.newLine();
            
        }
        
        archiveFinal.close();
        
        
    }
    
    
    public static void main(String[] args){ // metodo main para teste
        
        
        Macro mc = new Macro();
    
        try{
            mc.read("code2.txt");
            
            mc.getMacro();
        
            mc.expandMacro();
        
            mc.writeArchive("codemcr2.txt");
            
            mc.print();
            
            
        } catch( FileNotFoundException e){
            System.out.println("Arquivo não encontrado ...");
        } catch( IOException e){
            System.out.println("Arquivo não encontrado ...");
        }
        
        
    }
    
}