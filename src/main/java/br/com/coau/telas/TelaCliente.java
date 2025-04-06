/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.coau.telas;

import br.com.coau.persistence.Cliente;
import br.com.coau.persistence.JPADao;
import br.com.coau.telas.TelaAlugarLivro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Warley
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    private TelaAlugarLivro telaAlugarLivro;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        listarTabela();
        atualizarTblClientes();

    }

    public TelaCliente(TelaAlugarLivro telaAlugarLivro) { // Modifique o construtor
        this.telaAlugarLivro = telaAlugarLivro; // Armazene a referência
        initComponents();
        listarTabela();
        atualizarTblClientes();
    }

    private void atualizarTblClientes() {
        JPADao jpd = new JPADao();
        List<Cliente> clientes = jpd.listar();

        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.setRowCount(0);

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{
                cliente.getIdcli(),
                cliente.getNomecli(),
                cliente.getFonecli(),
                cliente.getFacucli(),
                cliente.getEmailcli()
            });
        }
    }

    private void listarTabela() {
        atualizarTblClientes();
    }

    private void pesquisarCliente() {
        String nome = txtCliPesquisar.getText();
        JPADao jpd = new JPADao();
        List<Cliente> clientes = jpd.pesquisarCliente(nome);
        DefaultTableModel tabela = (DefaultTableModel) tblClientes.getModel();
        tabela.setRowCount(0);
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente c : clientes) {
                tabela.addRow(new Object[]{
                    c.getIdcli(),
                    c.getNomecli(),
                    c.getFonecli(),
                    c.getFacucli(),
                    c.getEmailcli()
                });
            }
        } else {
            System.out.println("Nenhum Cliente encontrado para este Nome !");
        }

    }

    public void setar_campos() {
        int setar = tblClientes.getSelectedRow();
        txtNomeCli.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtFoneCli.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txtFacuCli.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        txtEmailcli.setText(tblClientes.getModel().getValueAt(setar, 4).toString());

        //desabilitar o botão adicionar
        btnAdicionarCli.setEnabled(false);
    }

    public long getClienteSelecionadoId() {
        int selectedRow = tblClientes.getSelectedRow();
        if (selectedRow != -1) {
            return (Long) tblClientes.getModel().getValueAt(selectedRow, 0); // ID do cliente
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeCli = new javax.swing.JTextField();
        txtFoneCli = new javax.swing.JTextField();
        txtFacuCli = new javax.swing.JTextField();
        txtEmailcli = new javax.swing.JTextField();
        btnAdicionarCli = new javax.swing.JButton();
        btnEditarCli = new javax.swing.JButton();
        btnExcluirCli = new javax.swing.JButton();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tela Cadastro Cliente");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Telefone");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Faculdade");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("E-mail");

        txtNomeCli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeCli.setToolTipText("Nome Cliente");

        txtFoneCli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFoneCli.setToolTipText("Telefone Cliente");

        txtFacuCli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFacuCli.setToolTipText("faculdade Cliente");

        txtEmailcli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailcli.setToolTipText("Email Cliente");

        btnAdicionarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/create.png"))); // NOI18N
        btnAdicionarCli.setToolTipText("Adicionar Cliente");
        btnAdicionarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarCli.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAdicionarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCliActionPerformed(evt);
            }
        });

        btnEditarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/update.png"))); // NOI18N
        btnEditarCli.setToolTipText("Editar dados Cliente");
        btnEditarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCli.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEditarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCliActionPerformed(evt);
            }
        });

        btnExcluirCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete.png"))); // NOI18N
        btnExcluirCli.setToolTipText("Excluir dados Cliente");
        btnExcluirCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirCli.setPreferredSize(new java.awt.Dimension(80, 80));
        btnExcluirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCliActionPerformed(evt);
            }
        });

        txtCliPesquisar.setToolTipText("Pesquisa por nome do Cliente");
        txtCliPesquisar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCliPesquisarCaretUpdate(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisa1.png"))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Faculdade", "E-mail"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        jLabel7.setText("Campos Obrigatórios");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFacuCli)
                            .addComponent(txtNomeCli)
                            .addComponent(txtFoneCli)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btnEditarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluirCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addComponent(txtEmailcli))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFacuCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 650, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCliActionPerformed
        if ( 
        txtNomeCli.getText().isEmpty() || 
        txtFoneCli.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
        return; 
    }
        
        Cliente c = new Cliente();
        try {

            c.setNomecli(txtNomeCli.getText());
            c.setFonecli(txtFoneCli.getText());
            c.setFacucli(txtFacuCli.getText());
            c.setEmailcli(txtEmailcli.getText());

            JPADao jpd = new JPADao();
            jpd.adicionarclientes(c);
            JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!");
            atualizarTblClientes();
            txtNomeCli.setText("");
            txtFoneCli.setText("");
            txtFacuCli.setText("");
            txtEmailcli.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarCliActionPerformed

    private void txtCliPesquisarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCliPesquisarCaretUpdate
        pesquisarCliente();
    }//GEN-LAST:event_txtCliPesquisarCaretUpdate

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        //evento para setar os campos da tabela assim que selecionado
        setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnEditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCliActionPerformed
        // TODO add your handling code here:
        int setar = tblClientes.getSelectedRow();
        if (setar != -1) {
            long id = (Long) tblClientes.getModel().getValueAt(setar, 0); // Assuming ID is in the first column
            String nome = txtNomeCli.getText();
            String fone = txtFoneCli.getText();
            String facu = txtFacuCli.getText();
            String email = txtEmailcli.getText();

            JPADao jpd = new JPADao();
            jpd.editarCliente(nome, fone, facu, email, id);
            JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
            atualizarTblClientes();
            txtNomeCli.setText("");
            txtFoneCli.setText("");
            txtFacuCli.setText("");
            txtEmailcli.setText("");
            btnAdicionarCli.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
        }
    }//GEN-LAST:event_btnEditarCliActionPerformed

    private void btnExcluirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCliActionPerformed
        // TODO add your handling code here:

        int setar = tblClientes.getSelectedRow(); // Obtém a linha selecionada na tabela
        if (setar != -1) {
            long id = (Long) tblClientes.getModel().getValueAt(setar, 0); // Obtém o ID do cliente da tabela

            // Cria uma instância do JPADao
            JPADao jpd = new JPADao();

            // Verifica se o cliente tem empréstimos ativos
            if (jpd.temEmprestimosAtivos(id)) {
                JOptionPane.showMessageDialog(this, "Este cliente não pode ser excluído porque ainda possui empréstimos de livros ativos.");
                return;
            }

            // Confirmação para exclusão
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    jpd.excluirCliente(id); // Tenta excluir o cliente
                    JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                    txtNomeCli.setText("");
                    txtFoneCli.setText("");
                    txtFacuCli.setText("");
                    txtEmailcli.setText("");

                    // Atualiza a tabela de clientes na tela de alugar livro
                    if (telaAlugarLivro != null) {
                        telaAlugarLivro.atualizarTabela();
                    }

                    atualizarTblClientes(); // Atualiza a tabela de clientes na tela atual
                } catch (Exception e) {
                    // Tratamento de exceção
                    JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.");
        }

    }//GEN-LAST:event_btnExcluirCliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCli;
    private javax.swing.JButton btnEditarCli;
    private javax.swing.JButton btnExcluirCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txtEmailcli;
    private javax.swing.JTextField txtFacuCli;
    private javax.swing.JTextField txtFoneCli;
    private javax.swing.JTextField txtNomeCli;
    // End of variables declaration//GEN-END:variables
}
