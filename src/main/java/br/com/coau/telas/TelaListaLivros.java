
package br.com.coau.telas;

import br.com.coau.persistence.JPADao;
import br.com.coau.persistence.Livros;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaListaLivros extends javax.swing.JInternalFrame {

    JPADao jpd = new JPADao();

    public TelaListaLivros() {
        initComponents();
        listaLivros();
        atualizarTabela();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlugar = new javax.swing.JButton();
        btnListaAlugados = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();

        btnAlugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Alugar.png"))); // NOI18N
        btnAlugar.setToolTipText("Alugar Livro");
        btnAlugar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        btnListaAlugados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/maximize_lista de alugados.png"))); // NOI18N
        btnListaAlugados.setToolTipText("Lista Livros Alugados");
        btnListaAlugados.setPreferredSize(new java.awt.Dimension(80, 80));

        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Devolver.png"))); // NOI18N
        btnDevolver.setToolTipText("Devolver Livro");
        btnDevolver.setPreferredSize(new java.awt.Dimension(80, 80));

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Livros Coau");
        setPreferredSize(new java.awt.Dimension(650, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Livros Coau");

        tblLivros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor", "Editora", "Assunto"
            }
        ));
        jScrollPane1.setViewportView(tblLivros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBounds(0, 0, 650, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnAlugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnListaAlugados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLivros;
    // End of variables declaration//GEN-END:variables

    private void listaLivros() {
        List<Livros> listar = jpd.listarLivros();
        DefaultTableModel tabela = (DefaultTableModel) tblLivros.getModel();
        tabela.setRowCount(0);
        if (listar != null) {
            for (Livros l : listar) {
                tabela.addRow(new Object[]{
                    l.getIdliv(),
                    l.getNomeliv(),
                    l.getAutorliv(),
                    l.getEditoraliv(),
                    l.getAssuntoliv(),
                   
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Livro encontrado !");
        }
    }

    void atualizarTabela() {
        listaLivros();
    }
}