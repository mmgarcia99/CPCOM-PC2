package view;

import connection.ConnectionFactory;
import controller.FornecedorController;
import java.sql.Connection;
import model.bean.Fornecedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tablemodel.FornecedorTableModel;

public class ConsultaFornecedorView extends javax.swing.JFrame {

    FornecedorTableModel tableModel;
    FornecedorController fornecedorController = new FornecedorController();

    public ConsultaFornecedorView() {
        initComponents();
        tableModel = new FornecedorTableModel(fornecedorController.read());

        jTableFornecedor.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonImprimirImg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComoOpcoesFornecedor = new javax.swing.JComboBox<>();
        jTextBuscaFornecedor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFornecedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Funcionários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Consulta de Fornecedor");

        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar-32.png"))); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonImprimirImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimir-32.png"))); // NOI18N
        jButtonImprimirImg.setText("Imprimir Imagem");
        jButtonImprimirImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirImgActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Selecione o campo para busca:");

        jComoOpcoesFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome", " " }));
        jComoOpcoesFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComoOpcoesFornecedorActionPerformed(evt);
            }
        });

        jTextBuscaFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBuscaFornecedorKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFornecedor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButtonAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonImprimirImg))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComoOpcoesFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimirImg, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComoOpcoesFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        FornecedorView fornecedorView = new FornecedorView(null);
        fornecedorView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jComoOpcoesFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComoOpcoesFornecedorActionPerformed
        jTextBuscaFornecedor.setText("");
        if (jComoOpcoesFornecedor.getSelectedIndex() == 0) {
            tableModel = new FornecedorTableModel(fornecedorController.read());
            jTableFornecedor.setModel(tableModel);
        }
        jTextBuscaFornecedor.requestFocus();
    }//GEN-LAST:event_jComoOpcoesFornecedorActionPerformed

    private void jTextBuscaFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscaFornecedorKeyTyped
        String chave = jTextBuscaFornecedor.getText();
        if (evt.getKeyChar() != '\b') {
            chave = chave + evt.getKeyChar();
        }
        switch (jComoOpcoesFornecedor.getSelectedIndex()) {
            case 1:
                tableModel = new FornecedorTableModel(fornecedorController.getListaFornecedorNome(chave));
                break;
        }
        jTableFornecedor.setModel(tableModel);
    }//GEN-LAST:event_jTextBuscaFornecedorKeyTyped

    private void jTableFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFornecedorMouseClicked
        tableModel = (FornecedorTableModel) jTableFornecedor.getModel();
        Fornecedor fornecedor = tableModel.getFornecedor(jTableFornecedor.getSelectedRow());
        FornecedorView fornecedorView = new FornecedorView(fornecedor);
        fornecedorView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTableFornecedorMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        PrincipalView principalView = new PrincipalView();
        principalView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonImprimirImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirImgActionPerformed
       Connection con = ConnectionFactory.getConnection();
         
         String src = "src/reports/registroFornecedor.jasper";
         
         JasperPrint jasperPrint = null;
         
         try {
            jasperPrint = JasperFillManager.fillReport(src, null, con);
        } catch (JRException ex) {
             System.out.println("Erro ao gerar o relatorio de Fornecedores"
                     + ": " + ex);
        }
         
         JasperViewer view = new JasperViewer(jasperPrint, false);
         view.setVisible(true);
         
    }//GEN-LAST:event_jButtonImprimirImgActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaFornecedorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonImprimirImg;
    private javax.swing.JComboBox<String> jComoOpcoesFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFornecedor;
    private javax.swing.JTextField jTextBuscaFornecedor;
    // End of variables declaration//GEN-END:variables
}
