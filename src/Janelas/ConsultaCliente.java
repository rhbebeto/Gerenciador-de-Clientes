package Janelas;

import connect.Conector;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConsultaCliente extends javax.swing.JFrame {

    public ConsultaCliente() {

        initComponents();
        carregarDados("");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void carregarDados(String filtroNome) {
        DefaultTableModel modelo = (DefaultTableModel) TabelaConsulta.getModel();
        modelo.setRowCount(0);

        Conector conector = new Conector();
        try (Connection conn = conector.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM ListaClientes";
            if (!filtroNome.isEmpty()) {
                sql += " WHERE nome LIKE '%" + filtroNome + "%'";
            }
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("data_nascimento")

                });
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaConsulta = new javax.swing.JTable();
        FieldPesquisa = new javax.swing.JTextField();
        BntBuscar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Consulta ao Cliente:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        TabelaConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"50", "150", "200", "100", "120"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "Telefone", "Data de Nascmento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaConsulta.setToolTipText("");
        TabelaConsulta.setShowHorizontalLines(true);
        TabelaConsulta.setShowVerticalLines(true);
        jScrollPane1.setViewportView(TabelaConsulta);
        if (TabelaConsulta.getColumnModel().getColumnCount() > 0) {
            TabelaConsulta.getColumnModel().getColumn(2).setResizable(false);
            TabelaConsulta.getColumnModel().getColumn(3).setResizable(false);
            TabelaConsulta.getColumnModel().getColumn(4).setResizable(false);
        }

        FieldPesquisa.setToolTipText("Digite o nome do cliente");
        FieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldPesquisaActionPerformed(evt);
            }
        });
        FieldPesquisa.setToolTipText("Digite o nome do cliente para pesquisar");

        BntBuscar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        BntBuscar.setText("Buscar🔍");
        BntBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntBuscarActionPerformed(evt);
            }
        });

        BtnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        BtnExcluir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        BtnAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnAlterar.setText("Alterar");
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(FieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntBuscarActionPerformed
        String filtroNome = FieldPesquisa.getText();
        carregarDados(filtroNome);
    }//GEN-LAST:event_BntBuscarActionPerformed

    private void FieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldPesquisaActionPerformed
        
    }//GEN-LAST:event_FieldPesquisaActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        int linhaSelecionada = TabelaConsulta.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente para excluir.");
            return;
        }

        int id = (int) TabelaConsulta.getValueAt(linhaSelecionada, 0);

        int confirm = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir este cliente?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = new Conector().getConnection()) {
                String sql = "DELETE FROM ListaClientes WHERE id = ?";
                var pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");

                carregarDados(""); // Atualizar tabela
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        int linhaSelecionada = TabelaConsulta.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente para alterar.");
            return;
        }

        // Obtendo os dados da linha selecionada
        int id = (int) TabelaConsulta.getValueAt(linhaSelecionada, 0);
        String nomeAtual = (String) TabelaConsulta.getValueAt(linhaSelecionada, 1);
        String emailAtual = (String) TabelaConsulta.getValueAt(linhaSelecionada, 2);
        String telefoneAtual = (String) TabelaConsulta.getValueAt(linhaSelecionada, 3);

        // Pedindo novos valores ao usuário
        String novoNome = JOptionPane.showInputDialog(this, "Alterar Nome:", nomeAtual);
        String novoEmail = JOptionPane.showInputDialog(this, "Alterar Email:", emailAtual);
        String novoTelefone = JOptionPane.showInputDialog(this, "Alterar Telefone:", telefoneAtual);

        // Validações
        if (novoNome == null || novoNome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome não pode estar vazio.");
            return;
        }

        if (novoEmail == null || novoEmail.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O e-mail não pode estar vazio.");
            return;
        }

        if (!novoEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "E-mail inválido. Por favor, insira um e-mail válido.");
            return;
        }

        if (novoTelefone == null || novoTelefone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O telefone não pode estar vazio.");
            return;
        }

        if (!novoTelefone.matches("^\\(\\d{2}\\) \\d{4,5}-\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Telefone inválido. Use o formato (XX) XXXXX-XXXX.");
            return;
        }

        // Confirmação do usuário
        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja realmente alterar os dados do cliente?",
                "Confirmação de Alteração",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = new Conector().getConnection()) {
                String sql = "UPDATE ListaClientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";
                var pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, novoNome);
                pstmt.setString(2, novoEmail);
                pstmt.setString(3, novoTelefone);
                pstmt.setInt(4, id);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");

                carregarDados(""); // Atualizar tabela
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao alterar cliente: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_BtnAlterarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntBuscar;
    private javax.swing.JButton BtnAlterar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JTextField FieldPesquisa;
    private javax.swing.JTable TabelaConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
