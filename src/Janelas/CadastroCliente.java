package Janelas;
import JanelaPrincipal.JanelaPrincipal;
import connect.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CadastroCliente extends javax.swing.JFrame {
    
    private JanelaPrincipal JanelaPrincipal; 

    public CadastroCliente(JanelaPrincipal JanelaPrincipal) {
        this.JanelaPrincipal = JanelaPrincipal;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    private boolean validarData(String data) {
    // Verificar se a data está no formato correto
    SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
    formatoEntrada.setLenient(false); // Desabilitar o comportamento leniente que permite datas inválidas (como 31/02)
    
    try {
        // Tenta converter a data para o formato padrão
        Date dataConvertida = formatoEntrada.parse(data);
        
        // Verificar se a data é posterior à data atual
        Date dataAtual = new Date();
        if (dataConvertida.after(dataAtual)) {
            JOptionPane.showMessageDialog(null, "A data não pode ser no futuro.");
            return false;
        }

        // Dividir a data em componentes para validação adicional
        String[] partesData = data.split("/");
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);
        
        // Verificar se o mês é válido
        if (mes < 1 || mes > 12) {
            JOptionPane.showMessageDialog(null, "Mês inválido. O mês deve estar entre 01 e 12.");
            return false;
        }

        // Verificar se o dia é válido para o mês e ano informados
        if (!isDiaValido(dia, mes, ano)) {
            JOptionPane.showMessageDialog(null, "Dia inválido para o mês " + mes + " do ano " + ano + ".");
            return false;
        }

        // A data está correta e não é no futuro
        return true;
        
    } catch (ParseException e) {
        // Se o formato estiver errado ou houver erro de conversão
        JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/MM/yyyy.");
        return false;
    }
}

// Função auxiliar para validar o dia conforme o mês e ano
private boolean isDiaValido(int dia, int mes, int ano) {
    // Verifica os dias por mês
    switch (mes) {
        case 1: // Janeiro
        case 3: // Março
        case 5: // Maio
        case 7: // Julho
        case 8: // Agosto
        case 10: // Outubro
        case 12: // Dezembro
            return dia >= 1 && dia <= 31;
        case 4: // Abril
        case 6: // Junho
        case 9: // Setembro
        case 11: // Novembro
            return dia >= 1 && dia <= 30;
        case 2: // Fevereiro
            return dia >= 1 && dia <= 29;
          
            
        default:
            return false;
    }
}

    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        LabelNome = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelTelefone = new javax.swing.JLabel();
        LabelData = new javax.swing.JLabel();
        TituloCadastro = new javax.swing.JLabel();
        FieldData = new javax.swing.JFormattedTextField();
        FieldEmail = new javax.swing.JTextField();
        FieldNome = new javax.swing.JTextField();
        BtnSalvar = new javax.swing.JButton();
        FieldTelefone = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelNome.setText("Nome:");

        LabelEmail.setText("E-mail:");

        LabelTelefone.setText("Telefone:");

        LabelData.setText("Data de nascimento:");

        TituloCadastro.setText("Cadastro");

        FieldData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            FieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        FieldEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FieldNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnSalvar.setBackground(new java.awt.Color(102, 255, 153));
        BtnSalvar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BtnSalvar.setText("Salvar");
        BtnSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });

        FieldTelefone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            FieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(TituloCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelTelefone)
                                .addComponent(LabelEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelNome, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(LabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(FieldNome)
                            .addComponent(FieldData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FieldTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(TituloCadastro)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome)
                    .addComponent(FieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmail)
                    .addComponent(FieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTelefone)
                    .addComponent(FieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelData)
                    .addComponent(FieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed

        String nome = FieldNome.getText();
        String email = FieldEmail.getText();
        String telefone = FieldTelefone.getText();
        String data = FieldData.getText();

        // Validação para garantir que todos os campos foram preenchidos
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || data.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }
        
        //Validação de email
        if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(null, "Por favor, insira um email válido.");
            return;
        }
        
        String telefoneRegex = "\\(\\d{2}\\)\\d{5}-\\d{4}";
        if (!telefone.matches(telefoneRegex)) {
        JOptionPane.showMessageDialog(null, "Por favor, insira um telefone válido no formato (xx)xxxxx-xxxx.");
        return;
        }
        
        //Validar Data
        if(!validarData(data)){
            return;
        }
        
        // formatação da data
        String dataFormatada;
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            Date dataConvertida = formatoEntrada.parse(data);
            dataFormatada = formatoBanco.format(dataConvertida);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar a data.");
            return;
        }

        // Salvar os dados no banco
        Conector conexao = new Conector();
        try (Connection conn = conexao.getConnection()) {
            String sql = "INSERT INTO ListaClientes (nome, email, telefone, data_nascimento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setString(4, dataFormatada);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            
            // Não fecha a JanelaPrincipal, apenas fecha o CadastroCliente
            this.setVisible(false);  // Torna a janela de cadastro invisível, mas não a fecha
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + e.getMessage());
        }


    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void FieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldTelefoneActionPerformed


   public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            JanelaPrincipal janelaPrincipal = new JanelaPrincipal();  // Criar a JanelaPrincipal
            new CadastroCliente(janelaPrincipal).setVisible(true);  // Passar a JanelaPrincipal para CadastroCliente
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JFormattedTextField FieldData;
    private javax.swing.JTextField FieldEmail;
    private javax.swing.JTextField FieldNome;
    private javax.swing.JFormattedTextField FieldTelefone;
    private javax.swing.JLabel LabelData;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelTelefone;
    private javax.swing.JLabel TituloCadastro;
    private javax.swing.JDialog jDialog1;
    // End of variables declaration//GEN-END:variables
}