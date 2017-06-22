/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import modelo.Leitura;
import modelo.ModeloTabela;
import modelo.RegMem;
import visao.VisaoPrincipal;

/**
 *
 * @author gleider
 */
public class ControleVisaoPrincipal {
    Leitura leitor;
    RegMem dados;
    VisaoPrincipal vp;
    ModeloTabela mt;
    
    public ControleVisaoPrincipal(VisaoPrincipal vp){
        this.vp = vp;
    }
    
    public void lerArquivoPrincipal(String arq){
        leitor = new Leitura();
        try {
            leitor.lerEntrada(arq);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
        }
        
        dados = new RegMem();
        vp.setRegistrador(Short.toString(dados.getRegA()), Short.toString(dados.getRegD()));
        
        for(int i=0;i<dados.getIndice();i++){
            vp.setMemoria(Short.toString(dados.getMemDados(i)),linhaProgCont(i),colunaProgCont(i));
            vp.setInstrucoes(Integer.toString(i), i, 0);
            vp.setInstrucoes("A+D", i, 1);
            vp.setInstrucoes("Apenas exemplo", i, 2);
            
        }
        
        
    }
   
    public TableModel getModeloTabelaMemoria(ArrayList lin, String[] col){
        mt = new ModeloTabela(lin, col);
        return mt;
    }
    
    public int linhaProgCont(int progCont){
        return progCont/10;
    }
    
    public int colunaProgCont(int progCont){
        return progCont%10;
    }
    
}
