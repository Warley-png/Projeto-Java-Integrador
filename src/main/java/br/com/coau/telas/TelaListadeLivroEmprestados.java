
package br.com.coau.telas;

import br.com.coau.persistence.AlugarLivro;
import br.com.coau.persistence.Cliente;
import br.com.coau.persistence.JPADao;
import br.com.coau.persistence.Livros;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class TelaListadeLivroEmprestados extends javax.swing.JInternalFrame {

    
    public TelaListadeLivroEmprestados() {
        initComponents();
        listarLivrosEmprestados();
        atualizarListaEmprestados();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaEmprestimo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tela Lista de Livros Emprestados");

        tblListaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Data Empréstimo", "Data Devolução", "Nome Cliente"
            }
        ));
        jScrollPane1.setViewportView(tblListaEmprestimo);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisa1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Livros Emprestados");

        txtPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPesquisa.setToolTipText("Pesquisa pelo Título do livro");
        txtPesquisa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesquisaCaretUpdate(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/C- azul .png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        setBounds(0, 0, 650, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisaCaretUpdate
        // TODO add your handling code here:
        pesquisarEmprestimo();
    }//GEN-LAST:event_txtPesquisaCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaEmprestimo;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

   private void listarLivrosEmprestados() {
    JPADao jpd = new JPADao();
    List<AlugarLivro> emprestimos = jpd.listarEmprestimos();
    DefaultTableModel model = (DefaultTableModel) tblListaEmprestimo.getModel();
    model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

    try {
        // Verifica se a lista de empréstimos não é nula
        if (emprestimos != null) {
            for (AlugarLivro emprestimo : emprestimos) {
                Livros livro = emprestimo.getLivro();
                Cliente cliente = jpd.buscarClientePorId(emprestimo.getCliente().getIdcli()); // Passa o ID do cliente

                if (livro != null && cliente != null) {
                    model.addRow(new Object[]{
                        emprestimo.getIdret(),
                        livro.getNomeliv(),
                        emprestimo.getDatasaida(),
                        emprestimo.getDataretorno(),
                        cliente.getNomecli()
                    });
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Imprime a pilha de erros para depuração
    }
}
    public void atualizarListaEmprestados() {
        listarLivrosEmprestados();
    }

  private void pesquisarEmprestimo() {
    String titulo = txtPesquisa.getText(); 
    JPADao jpd = new JPADao();
    List<AlugarLivro> emprestimos = jpd.pesquisarEmprestimo(titulo); 
    DefaultTableModel tabela = (DefaultTableModel) tblListaEmprestimo.getModel();
    tabela.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

    if (emprestimos != null && !emprestimos.isEmpty()) {
        for (AlugarLivro a : emprestimos) {
            // Obtém o cliente diretamente do objeto AlugarLivro
            Cliente cliente = a.getCliente(); // Obtenha o cliente diretamente
            String nomeCliente = (cliente != null) ? cliente.getNomecli() : "Cliente não encontrado";

            // Verifica se o livro não é nulo antes de acessar suas propriedades
            Livros livro = a.getLivro();
            String nomeLivro = (livro != null) ? livro.getNomeliv() : "Livro não encontrado";

            tabela.addRow(new Object[]{
                a.getIdret(),
                nomeLivro, 
                a.getDatasaida(),
                a.getDataretorno(),
                nomeCliente 
            });
        }
    } else {
        System.out.println("Nenhum Empréstimo encontrado para este Livro !");
    }
}
}
