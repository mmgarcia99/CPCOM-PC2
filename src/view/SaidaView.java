package view;

import controller.ClienteController;
import controller.ProdutosController;
import controller.SaidaController;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Produtos;
import model.bean.Saida;

public class SaidaView extends javax.swing.JFrame {

    private boolean alterar = false;
    private int idsaida = 0;
    private Saida saida;

    SaidaController saidaController;

    public SaidaView(Saida saida) {
        initComponents();

        saidaController = new SaidaController();

        this.getListaCliente();
        if (saida != null) {
            preencheCampos(saida);
            this.saida = saida;
        } else {
            jTextQtdSaida.requestFocus();
        }
        this.getListaProduto();
        if (saida != null) {
            preencheCampos(saida);
            this.saida = saida;
        } else {
            jTextQtdSaida.requestFocus();
        }
    }

    private void preencheCampos(Saida saida) {
        this.idsaida = saida.getIdsaida();

        for (int i = 0; i < jComboCliente.getItemCount(); i++) {
            Cliente c = (Cliente) jComboCliente.getItemAt(i);
            if (c.getNome().equals(saida.getCliente().getNome())) {
                jComboCliente.setSelectedIndex(i);
            }
            
        }

        for (int i = 0; i < jComboProdutos.getItemCount(); i++) {
            Produtos p = (Produtos) jComboProdutos.getItemAt(i);
            if (p.getDescricao().equals(saida.getProdutos().getDescricao())) {
                jComboProdutos.setSelectedIndex(i);
            }
            jTextQtdSaida.setText(String.valueOf(saida.getQtdsaida()));
        }
        jTextQtdSaida.setText(String.valueOf(saida.getQtdsaida()));
        jButtonExcluir.setEnabled(true);
        jButtonIncluir.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        this.alterar = true;
    }

    public void limpaCampos() {
        jTextQtdSaida.setText("");
        jComboProdutos.setSelectedItem("");
        jComboCliente.setSelectedItem("");
        jTextQtdSaida.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jComboProdutos = new javax.swing.JComboBox<>();
        jComboCliente = new javax.swing.JComboBox<>();
        jTextQtdSaida = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Saida");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Saida de Produtos");

        jLabel2.setText("Produtos:");

        jLabel3.setText("Cliente");

        jLabel4.setText("Quantidade:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setEnabled(false);
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addGap(40, 40, 40)
                .addComponent(jButtonExcluir)
                .addGap(33, 33, 33)
                .addComponent(jButtonCancelar)
                .addGap(37, 37, 37)
                .addComponent(jButtonSair)
                .addGap(30, 30, 30)
                .addComponent(jButtonImprimir)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTextQtdSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextQtdSaidaActionPerformed(evt);
            }
        });
        jTextQtdSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQtdSaidaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel2)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jComboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextQtdSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextQtdSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        Produtos produtos = (Produtos) jComboProdutos.getSelectedItem();
        Cliente cliente = (Cliente) jComboCliente.getSelectedItem();
        if (saidaController.create(produtos, cliente,
                Integer.parseInt(jTextQtdSaida.getText()))) {
            JOptionPane.showMessageDialog(this, "Produto Salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o produto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaSaida();

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (saidaController.update(idsaida, Integer.parseInt(jTextQtdSaida.getText()), (Produtos) jComboProdutos.getSelectedItem(), (Cliente) jComboCliente.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Produto Salvo!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o produto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.getListaSaida();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (saidaController.delete(this.saida.getIdsaida())) {

        } else {
            JOptionPane.showMessageDialog(this, "Saida Deletada!");
        }
        this.getListaSaida();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonIncluir.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        alterar = false;
        limpaCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.getListaSaida();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextQtdSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextQtdSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextQtdSaidaActionPerformed

    private void jTextQtdSaidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQtdSaidaKeyTyped
        if (alterar) {
            jButtonExcluir.setEnabled(false);
            jButtonSalvar.setEnabled(true);
        }
        jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jTextQtdSaidaKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ConsultaSaidaView consultaSaidaView = new ConsultaSaidaView();
        consultaSaidaView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public void getListaCliente() {
        jComboCliente.removeAllItems();
        ClienteController clienteController = new ClienteController();

        for (Cliente c : clienteController.read()) {

            jComboCliente.addItem(c);
        }
    }

    public void getListaProduto() {
        jComboProdutos.removeAllItems();
        ProdutosController produtosController = new ProdutosController();

        for (Produtos p : produtosController.read()) {

            jComboProdutos.addItem(p);
        }
    }

    public void getListaSaida() {
        ConsultaSaidaView consultaSaidaView = new ConsultaSaidaView();
        consultaSaidaView.setVisible(true);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(SaidaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaidaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaidaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaidaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaidaView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<Object> jComboCliente;
    private javax.swing.JComboBox<Object> jComboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextQtdSaida;
    // End of variables declaration//GEN-END:variables
}
