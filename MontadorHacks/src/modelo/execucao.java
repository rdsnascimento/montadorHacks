/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Douglas Janovik Maliszewski
 * 
 */
public class execucao {
    
    public static void main(String[] args){
        
        Macro mc = new Macro();
        Macro mc2 = new Macro();
        
        Montador montador = new Montador();
        
        montador.setInstrucoesComp();
        montador.setInstrucoesDest();
        montador.setInstrucoesJmp();
        
        Montador montador2 = new Montador();
        
        montador2.setInstrucoesComp();
        montador2.setInstrucoesDest();
        montador2.setInstrucoesJmp();
        
        Ligador ligador = new Ligador();
        
        
        try{
            mc.read("code.txt");
            
            mc.getMacro();
        
            mc.expandMacro();
        
            mc.writeArchive("codemcr.txt");
            
            mc.print();
            
            mc2.read("code2.txt");
            
            mc2.getMacro();
        
            mc2.expandMacro();
        
            mc2.writeArchive("codemcr2.txt");
            
            mc2.print();
            
            montador.read("codemcr.txt");
            
            montador.getTabelaDef();
            montador.getTabelaUso();
            montador.getTabelaSimbol();
        
            montador.printftabelaDef("tabelaDef.txt");
            montador.printftabelaUso("tabelaUso.txt");
            montador.printftabelaSimbol("tabelaSimbol.txt");
            
            montador.geraSaidaMontador("codeMontado.txt","linhas1.txt");
            
            montador2.read("codemcr2.txt");
            
            montador2.getTabelaDef();
            montador2.getTabelaUso();
            montador2.getTabelaSimbol();
        
            montador2.printftabelaDef("tabelaDef2.txt");
            montador2.printftabelaUso("tabelaUso2.txt");
            montador2.printftabelaSimbol("tabelaSimbol2.txt");
            
            montador2.geraSaidaMontador("codeMontado2.txt","linhas2.txt");
            
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
        
    }
    
    
}