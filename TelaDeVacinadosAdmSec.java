
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaDeVacinadosAdmSec extends javax.swing.JFrame {

    public TelaDeVacinadosAdmSec() {
        initComponents();
        try {
            Connection cn = SqlConnection.obterConexao();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM  p_vacinadas");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) vacSecjTable1.getModel();
            tm.setRowCount(0);

            while (rs.next()) {
                Object o[] = {rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"), rs.getInt("prioridade")};

                tm.addRow(o);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vacSecjTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        cpfFormatTextField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vacSecjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Data de Vacinação", "Prioridade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vacSecjTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 610, 300));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(7, 12, 61));
        label1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("LISTA DE VACINADOS");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 630, -1));

        button1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        button1.setLabel("Voltar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 60, 30));

        button2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        button2.setLabel("Pesquisar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 90, 30));

        cpfFormatTextField.setBackground(new java.awt.Color(255, 255, 255));
        try {
            cpfFormatTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfFormatTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfFormatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFormatTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(cpfFormatTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\guilh\\OneDrive\\Projetos Netbeans\\Projeto3\\src\\main\\java\\Imagens\\PlanoDeFundoFilaDeVacinacao.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 449));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpfFormatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFormatTextFieldActionPerformed

    }//GEN-LAST:event_cpfFormatTextFieldActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        TelaAdmSec voltarVaciAdmSec = new TelaAdmSec();
        voltarVaciAdmSec.setVisible(true);
        setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        int idade=0, prioridade=0;
        String cpf = cpfFormatTextField.getText();
        String nome = null, cpf2 = null, endereco = null, cep = null, numero = null, bairro = null, complemento = null,
                telefone = null, sexo = null, data = null;
        try {
            Connection cn = SqlConnection.obterConexao();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM  p_vacinadas where cpf= ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {   //Talvez o objeto "o" possa ser retirado

                nome = rs.getString("Nome");
                idade = rs.getInt("Idade");
                cpf2 = rs.getString("cpf");
                prioridade = rs.getInt("prioridade");
                endereco = rs.getString("Endereço");
                cep = rs.getString("cep");
                numero = rs.getString("numero");
                bairro = rs.getString("bairro");
                complemento = rs.getString("complemento");
                telefone = rs.getString("telefone");
                sexo = rs.getString("sexo");
                data = rs.getString("Data_da_Vacinação");
            }
            Pessoa paciente = new Pessoa(nome, idade, cpf, prioridade, endereco, cep, numero, bairro, complemento, telefone, sexo, data);

            TelaPesquisaPessoaAS pesquisa = new TelaPesquisaPessoaAS(paciente);
            pesquisa.setVisible(true);
            setLocationRelativeTo(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente, tente novamente. Se o erro persistir, entre em contato com o suporte");
        }
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeVacinadosAdmMestre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeVacinadosAdmMestre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeVacinadosAdmMestre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeVacinadosAdmMestre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeVacinadosAdmSec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JFormattedTextField cpfFormatTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable vacSecjTable1;
    // End of variables declaration//GEN-END:variables
}
