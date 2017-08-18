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
//import modelo.ligador;
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
    int contadorMemoria = 0;
    boolean rodarTudo = false;
    RegMem exec = new RegMem();
    
    public ControleVisaoPrincipal(VisaoPrincipal vp) {
        this.vp = vp;
    }
    
    public void setRodarTudo(boolean rodarTudo){
        this.rodarTudo = rodarTudo;
    }
    
    public void lerArquivoPrincipal(String arq) {
        //ligador ligador = new ligador();
        
        leitor = new Leitura();
        try {
            //ZERANDO TUDO ANTES DA LEITURA
            exec.setMemROM();
            exec.setMemDados();
            exec.setRegA();
            exec.setRegD();
            exec.setIndice();
            exec.setPc(0);
            vp.setPC(Integer.toString(exec.getPc()));
            vp.preencherTabelaInstrucoes();
            vp.preencherTabelaMemoria();
            vp.setRegistrador(Short.toString(exec.getRegA()), Short.toString(exec.getRegD()));
            
            leitor.lerEntrada(arq);
            //ligador.saida();
            
            vp.setAreaSaida("Arquivo lido com sucesso.");
            setRodarTudo(false);
            exec.setPc(0);
        } catch (FileNotFoundException e) {
            vp.setAreaSaida("Arquivo não encontrado.\nErro: " + e.getMessage());
        }
        
        

        /*dados = new RegMem();
        vp.setRegistrador(Short.toString(dados.getRegA()), Short.toString(dados.getRegD()));*/
        
       

    }
    
    public void rodar(){
       
         if(rodarTudo){
            exec.setMemDados();
            exec.setRegA();
            exec.setRegD();
             
            exec.setPc(0); //zerando o Pc
            while (exec.getMemROM(exec.getPc()) != null) { //while (memRom[pc] != null)
                executar(); 
                
                //System.out.println(exec.getPc());
                //vp.setMemoria(Short.toString(exec.getMemDados(i)), linhaProgCont(getContadorMemoria()), colunaProgCont(getContadorMemoria()));
                //setContadorMemoria(getContadorMemoria() + 1);
                //i++;
            }
            rodarTudo = false;
        } 
         
        else{
   
            if (exec.getMemROM(exec.getPc()) != null) { //while (memRom[pc] != null)
                executar();
              
            }
        }

        
        /*for (int i = 0; i < exec.getPc(); i++) {
            vp.setMemoria(Short.toString(exec.getMemDados(i)), linhaProgCont(getContadorMemoria()), colunaProgCont(getContadorMemoria()));
            setContadorMemoria(getContadorMemoria() + 1);
            
        }*/
        
        
       vp.setPC(Integer.toString(exec.getPc()));
       vp.setProgramCont(exec.getPc());
        
    }

    public TableModel getModeloTabelaMemoria(ArrayList lin, String[] col) {
        mt = new ModeloTabela(lin, col);
        return mt;
    }

    public int linhaProgCont(int progCont) {
        return progCont / 10;
    }

    public int colunaProgCont(int progCont) {
        return progCont % 10;
    }   

    private int getContadorMemoria() {
        return contadorMemoria;
    }

    private void setContadorMemoria(int contadorMemoria) {
        this.contadorMemoria = contadorMemoria;
    }
  
        public void executar(){
            vp.setInstrucoes(Integer.toString(exec.getPc()), exec.getPc(), 0);
            vp.setInstrucoes(exec.getMemROM(exec.getPc()), exec.getPc(), 1);

            leitor.romToDecod(exec.getMemROM(exec.getPc())); //romToDecod (memRom[pc]) ou seja mandando cada instrução da rom pra decodificação

            vp.setInstrucoes(leitor.destino(), exec.getPc(), 2);
            vp.setInstrucoes(leitor.operacao(), exec.getPc(), 3);
            vp.setInstrucoes(leitor.jump(), exec.getPc(), 4);
            vp.setRegistrador(Short.toString(exec.getRegA()), Short.toString(exec.getRegD()));
            // JOptionPane.showMessageDialog(null, exec.getPc() + " " + leitor.jump());
            vp.setPC(Integer.toString(exec.getPc()));

            if (leitor.getIncrementaPC() == true) { //Se não tiver jump então
                exec.setPc(exec.getPc() + 1); //pc++
            } else { //senão
                exec.setPc(exec.getRegA()); //pc recebe Registrador A
            }

            leitor.setIncrementaPC(true); //IncrementaPC fica verdadeiro pra próxima instrução
            vp.setProgramCont(exec.getPc()); 
            
           for (int i = 0; i < exec.getPc(); i++) {
               vp.setMemoria(Short.toString(exec.getMemDados(i)), linhaProgCont(getContadorMemoria()), colunaProgCont(getContadorMemoria()));
                setContadorMemoria(getContadorMemoria() + 1);
            }
           setContadorMemoria(0);
            

        }
        

}
