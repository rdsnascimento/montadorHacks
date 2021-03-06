/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleVisaoPrincipal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.ws.soap.MTOM;
import modelo.Ligador;
import modelo.Macro;
import modelo.Mc;
import modelo.ModeloTabela;
import modelo.Montador;

/**
 *
 * @author gleider
 */
public class VisaoPrincipal extends javax.swing.JFrame {
    final int TAM_LINHA = 200;
    ControleVisaoPrincipal cvp;
    ArrayList dados;
    ModeloTabela mtMemoria;
    ModeloTabela mtInstrucoes;
    int programCont;
    Macro mc = new Macro();
    Macro mc2 = new Macro();

    Montador montador = new Montador();
    Montador montador2 = new Montador();
    Ligador ligador = new Ligador();
 
    public void mensagemErro(){
        JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo");
    }
    public int getProgramCont() {
        return programCont;
    }

    public void setProgramCont(int programCont) {
        this.programCont = programCont;
    }
    /**
     * Creates new form VisaoPrincipal
     */
    public VisaoPrincipal() {
        
        
        montador.setInstrucoesComp();
        montador.setInstrucoesDest();
        montador.setInstrucoesJmp();
        
   
        
        montador2.setInstrucoesComp();
        montador2.setInstrucoesDest();
        montador2.setInstrucoesJmp();
        
       
        initComponents();
        
        cvp = new ControleVisaoPrincipal(this);
        ajustes();
        
    }
    
    private void ajustes(){
        preencherTabelaMemoria();
        preencherTabelaInstrucoes();
        jTextFieldRegA.setEditable(false);
        jTextFieldRegD.setEditable(false);
    }
    
    public void setAreaSaida(String text){
        jTextAreaSaida.setText(jTextAreaSaida.getText() + text + "\n----------------------------------------------------------------------------------\n");
    }
    
    public void setRegistrador(String regA, String regD){
        jTextFieldRegA.setText(regA);
        jTextFieldRegD.setText(regD);
    }
    
    public void setPC(String text){
        jTextFieldPC.setText(text);
    }
    public void setMemoria(String valor, int linha, int coluna){
        mtMemoria.setValueAt(valor, linha, coluna+1);
        repaint();
    }
    
    public void setInstrucoes(String valor, int linha, int coluna){
        mtInstrucoes.setValueAt(valor, linha, coluna);
        repaint();
    }
    
    public void preencherTabelaMemoria(){
        dados = new ArrayList();
        
        String[] colunas = new String[] {"Endreço", "Valor(+0)","Valor(+1)", "Valor(+2)", "Valor(+3)"
                , "Valor(+4)", "Valor(+5)", "Valor(+6)", "Valor(+7)", "Valor(+8)", "Valor(+9)"};
        int cnt = 0;
        for(int i=0;i<TAM_LINHA;i++){
            dados.add(new String[]{Integer.toString(cnt), "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"});
            cnt += 10;
        }
        mtMemoria = new ModeloTabela(dados, colunas);
        jTableMemoria.setModel(mtMemoria);
        for(int i=0;i<11;i++){
            jTableMemoria.getColumnModel().getColumn(i).setPreferredWidth(90);
            jTableMemoria.getColumnModel().getColumn(i).setResizable(false);
            
        }
        jTableMemoria.getTableHeader().setReorderingAllowed(false);
        jTableMemoria.setAutoResizeMode(jTableMemoria.AUTO_RESIZE_OFF);
        jTableMemoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
    }
    
    public void preencherTabelaInstrucoes(){
        ArrayList instDados = new ArrayList();
        String[] instColunas = new String[] {"Rom", "Instruções", "Dest", "Comp", "Jump"};
        mtInstrucoes = new ModeloTabela(instDados, instColunas);
        
        for(int i=0;i<50;i++){
            instDados.add(new String[]{Integer.toString(i), " ", " ", " ", " "});
        }
        jTableInstrucoes.setModel(mtInstrucoes);
        jTableInstrucoes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableInstrucoes.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableInstrucoes.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTableInstrucoes.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTableInstrucoes.getColumnModel().getColumn(4).setPreferredWidth(98);
       
        jTableInstrucoes.getColumnModel().getColumn(0).setResizable(false);
        jTableInstrucoes.getColumnModel().getColumn(1).setResizable(false);   
        jTableInstrucoes.getColumnModel().getColumn(2).setResizable(false);
        jTableInstrucoes.getColumnModel().getColumn(3).setResizable(false);
        jTableInstrucoes.getColumnModel().getColumn(4).setResizable(false);
        
        jTableInstrucoes.getTableHeader().setReorderingAllowed(false);
        jTableInstrucoes.setAutoResizeMode(jTableMemoria.AUTO_RESIZE_OFF);
        jTableInstrucoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRegA = new javax.swing.JTextField();
        jTextFieldRegD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInstrucoes = new javax.swing.JTable();
        jButtonProximo = new javax.swing.JButton();
        jButtonPorInstrucao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMemoria = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonMacro1 = new javax.swing.JButton();
        jButtonMontador1 = new javax.swing.JButton();
        jButtonAbrirMacro1 = new javax.swing.JButton();
        jButtonLigador = new javax.swing.JButton();
        jButtonAbrirMontador1 = new javax.swing.JButton();
        jButtonMontador2 = new javax.swing.JButton();
        jButtonAbrirMontador2 = new javax.swing.JButton();
        jButtonMacro2 = new javax.swing.JButton();
        jButtonAbrirMacro2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaSaida = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldLerArquivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonLerArquivoPrincipal = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setText("Registradores");

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("A");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel3.setText("D");

        jLabel4.setText("Valor atual");

        jTextFieldRegA.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jTextFieldRegA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextFieldRegD.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel10.setText("PC");

        jTextFieldPC.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldRegA, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(jTextFieldRegD)))
                                .addGap(64, 64, 64))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRegA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldRegD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel5.setText("Instruções");

        jTableInstrucoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableInstrucoes);
        if (jTableInstrucoes.getColumnModel().getColumnCount() > 0) {
            jTableInstrucoes.getColumnModel().getColumn(0).setPreferredWidth(6);
            jTableInstrucoes.getColumnModel().getColumn(1).setResizable(false);
            jTableInstrucoes.getColumnModel().getColumn(1).setPreferredWidth(6);
        }

        jButtonProximo.setText("Próximo");
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        jButtonPorInstrucao.setText("Executar");
        jButtonPorInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPorInstrucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButtonProximo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPorInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProximo)
                    .addComponent(jButtonPorInstrucao))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel6.setText("Memória");

        jTableMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableMemoria);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel7.setText("Gerador de arquivos");

        jLabel11.setText("Macro");

        jLabel12.setText("Ligador");

        jLabel13.setText("Montador");

        jButtonMacro1.setText("Gerar 1");
        jButtonMacro1.setEnabled(false);
        jButtonMacro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMacro1ActionPerformed(evt);
            }
        });

        jButtonMontador1.setText("Montar 1");
        jButtonMontador1.setEnabled(false);
        jButtonMontador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMontador1ActionPerformed(evt);
            }
        });

        jButtonAbrirMacro1.setText("Abrir 1");
        jButtonAbrirMacro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirMacro1ActionPerformed(evt);
            }
        });

        jButtonLigador.setText("Ligar");
        jButtonLigador.setEnabled(false);
        jButtonLigador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLigadorActionPerformed(evt);
            }
        });

        jButtonAbrirMontador1.setText("Abrir 1");
        jButtonAbrirMontador1.setEnabled(false);
        jButtonAbrirMontador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirMontador1ActionPerformed(evt);
            }
        });

        jButtonMontador2.setText("Montar 2");
        jButtonMontador2.setEnabled(false);
        jButtonMontador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMontador2ActionPerformed(evt);
            }
        });

        jButtonAbrirMontador2.setText("Abrir 2");
        jButtonAbrirMontador2.setEnabled(false);
        jButtonAbrirMontador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirMontador2ActionPerformed(evt);
            }
        });

        jButtonMacro2.setText("Gerar 2");
        jButtonMacro2.setEnabled(false);
        jButtonMacro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMacro2ActionPerformed(evt);
            }
        });

        jButtonAbrirMacro2.setText("Abrir 2");
        jButtonAbrirMacro2.setEnabled(false);
        jButtonAbrirMacro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirMacro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonMacro1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jButtonAbrirMacro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonMacro2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jButtonAbrirMacro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(65, 65, 65))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonMontador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAbrirMontador1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonMontador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAbrirMontador2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLigador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)))
                        .addGap(86, 86, 86))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonMacro1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAbrirMacro1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonMacro2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAbrirMacro2))
                            .addComponent(jButtonLigador)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMontador2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonMontador1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAbrirMontador2)
                            .addComponent(jButtonAbrirMontador1))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel8.setText("Saída");

        jTextAreaSaida.setEditable(false);
        jTextAreaSaida.setColumns(20);
        jTextAreaSaida.setRows(5);
        jScrollPane4.setViewportView(jTextAreaSaida);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldLerArquivo.setText("codigoFinal.txt");

        jLabel9.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel9.setText("Carregador");

        jButtonLerArquivoPrincipal.setText("Carregar");
        jButtonLerArquivoPrincipal.setEnabled(false);
        jButtonLerArquivoPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLerArquivoPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldLerArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLerArquivoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLerArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLerArquivoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLerArquivoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLerArquivoPrincipalActionPerformed
        
        cvp.lerArquivoPrincipal(jTextFieldLerArquivo.getText());
        jButtonMacro1.setEnabled(true);
        jButtonMacro2.setEnabled(true);
        jButtonAbrirMacro1.setEnabled(true);
        jButtonAbrirMacro2.setEnabled(true);
        
 
        
    }//GEN-LAST:event_jButtonLerArquivoPrincipalActionPerformed

    private void jButtonPorInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPorInstrucaoActionPerformed

        jButtonProximo.setEnabled(true);
        
        jTableInstrucoes.setRowSelectionInterval(0, 0);
        cvp.setRodarTudo(true);
        cvp.rodar();
    }//GEN-LAST:event_jButtonPorInstrucaoActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        //if(jTableInstrucoes.getSelectedRow() < getProgramCont()-1){
            cvp.rodar();
            //jTableInstrucoes.setRowSelectionInterval(jTableInstrucoes.getSelectedRow()+1, jTableInstrucoes.getSelectedRow()+1);
        //}
        
    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonMacro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMacro1ActionPerformed
        jButtonAbrirMacro2.setEnabled(true);
        jTextAreaSaida.setText(jTextAreaSaida.getText() + "Macro gerada com sucesso" + "\n----------------------------------------------------------------------------------\n");
        
        mc.getMacro();
        mc.expandMacro();
        try {
            mc.writeArchive("codemcr.txt");
        } catch (IOException ex) {
            mensagemErro();
        }
        mc.print();

    }//GEN-LAST:event_jButtonMacro1ActionPerformed

    private void jButtonMontador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMontador1ActionPerformed
        
        montador.getTabelaDef();
        montador.getTabelaUso();
        montador.getTabelaSimbol();        
        try {
            montador.printftabelaDef("tabelaDef.txt");
            montador.printftabelaUso("tabelaUso.txt");
            montador.printftabelaSimbol("tabelaSimbol.txt");
            montador.geraSaidaMontador("codeMontado.txt","linhas1.txt");
            jButtonAbrirMontador2.setEnabled(true);
            jTextAreaSaida.setText(jTextAreaSaida.getText() + "Ligador gerado com sucesso" + "\n----------------------------------------------------------------------------------\n");
 
        } catch (IOException ex) {
            mensagemErro();
        }
        
       
    }//GEN-LAST:event_jButtonMontador1ActionPerformed

    private void jButtonAbrirMacro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirMacro1ActionPerformed
        try {
            mc.read("code.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
        }
        jButtonMacro1.setEnabled(true);
        //Mc mc = new Mc();
       // mc.read("code.txt");
    }//GEN-LAST:event_jButtonAbrirMacro1ActionPerformed

    private void jButtonMontador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMontador2ActionPerformed
 
        montador2.getTabelaDef();
        montador2.getTabelaUso();
        montador2.getTabelaSimbol();        
        try {
            montador2.printftabelaDef("tabelaDef2.txt");
            montador2.printftabelaUso("tabelaUso2.txt");
            montador2.printftabelaSimbol("tabelaSimbol2.txt");
            montador2.geraSaidaMontador("codeMontado2.txt","linhas2.txt");
            jButtonLigador.setEnabled(true);
            jTextAreaSaida.setText(jTextAreaSaida.getText() + "Ligador gerado com sucesso" + "\n----------------------------------------------------------------------------------\n");
 
        } catch (IOException ex) {
            mensagemErro();
        }
        
       
        
    }//GEN-LAST:event_jButtonMontador2ActionPerformed

    private void jButtonMacro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMacro2ActionPerformed
        //jButtonMontador1.setEnabled(true);
        jButtonAbrirMontador1.setEnabled(true);
        jTextAreaSaida.setText(jTextAreaSaida.getText() + "Macro gerada com sucesso" + "\n----------------------------------------------------------------------------------\n");
        
        
        mc2.getMacro();
        mc2.expandMacro();
        try {
            mc2.writeArchive("codemcr2.txt");
        } catch (IOException ex) {
            mensagemErro();
        }
        mc2.print();
    }//GEN-LAST:event_jButtonMacro2ActionPerformed

    private void jButtonAbrirMacro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirMacro2ActionPerformed
        jButtonMacro2.setEnabled(true);
        
        try {
            mc2.read("code2.txt");
        } catch (FileNotFoundException ex) {
            mensagemErro();
        }
    }//GEN-LAST:event_jButtonAbrirMacro2ActionPerformed

    private void jButtonLigadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLigadorActionPerformed
       
        
        try {
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
            jButtonLerArquivoPrincipal.setEnabled(true);
        
            
        } catch (FileNotFoundException ex) {
            mensagemErro();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ligar os módulos");
        }
        
        
    }//GEN-LAST:event_jButtonLigadorActionPerformed

    private void jButtonAbrirMontador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirMontador1ActionPerformed
 
        try {
            montador.read("codemcr.txt");
            jButtonMontador1.setEnabled(true);
        } catch (FileNotFoundException ex) {
            mensagemErro();
        }
    }//GEN-LAST:event_jButtonAbrirMontador1ActionPerformed

    private void jButtonAbrirMontador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirMontador2ActionPerformed
        
        
        try {
            montador2.read("codemcr2.txt");
            jButtonMontador2.setEnabled(true); 
        } catch (FileNotFoundException ex) {
            mensagemErro();
        }
    }//GEN-LAST:event_jButtonAbrirMontador2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirMacro1;
    private javax.swing.JButton jButtonAbrirMacro2;
    private javax.swing.JButton jButtonAbrirMontador1;
    private javax.swing.JButton jButtonAbrirMontador2;
    private javax.swing.JButton jButtonLerArquivoPrincipal;
    private javax.swing.JButton jButtonLigador;
    private javax.swing.JButton jButtonMacro1;
    private javax.swing.JButton jButtonMacro2;
    private javax.swing.JButton jButtonMontador1;
    private javax.swing.JButton jButtonMontador2;
    private javax.swing.JButton jButtonPorInstrucao;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableInstrucoes;
    private javax.swing.JTable jTableMemoria;
    private javax.swing.JTextArea jTextAreaSaida;
    private javax.swing.JTextField jTextFieldLerArquivo;
    private javax.swing.JTextField jTextFieldPC;
    private javax.swing.JTextField jTextFieldRegA;
    private javax.swing.JTextField jTextFieldRegD;
    // End of variables declaration//GEN-END:variables
}
