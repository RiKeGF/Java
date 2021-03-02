
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormFuncionario extends javax.swing.JFrame {

    public MySQL mysql;

    public FormFuncionario() {
        initComponents();

        mysql = new MySQL();
        conectar("172.25.1.17", "3306", "supervisorio", "scada", "12345");

        popularLista();
    }

    public void conectar(String host, String port, String banco, String user, String password) {
        mysql = new MySQL();
        mysql.conectar(host, port, banco, user, password);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBLista = new javax.swing.JComboBox<>();
        jlblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Dispositivo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jCBLista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBListaItemStateChanged(evt);
            }
        });
        jCBLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBListaMouseClicked(evt);
            }
        });
        getContentPane().add(jCBLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 260, -1));

        jlblStatus.setText("Status:");
        getContentPane().add(jlblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popularLista() {
        jCBLista.addItem("Selecione");
        try {
            String query = "select * from dispositivo";
            ResultSet rs = mysql.consultar(query);

            if (rs != null) {
                while (rs.next()) {
                    //model.addRow(new String[]{rs.getString("ID"), rs.getString("descricao"), rs.getString("tipo"), rs.getString("valor_visitante"), rs.getString("valor_assinante"), rs.getString("status")});
                    jCBLista.addItem(rs.getString("nome"));
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }


    private void jCBListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBListaMouseClicked

    }//GEN-LAST:event_jCBListaMouseClicked

    private void jCBListaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBListaItemStateChanged
        try {
            String query = "select status from dispositivo where nome = '" + jCBLista.getSelectedItem().toString() + "'";
            ResultSet rs = mysql.consultar(query);
            if (rs != null) {
                while (rs.next()) {
                    String status = rs.getString("status");
                    jlblStatus.setText("Status: " + status);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        
        if (jCBLista.getSelectedItem().toString() == "Selecione") {
            jlblStatus.setText("Status: ");
        }
    }//GEN-LAST:event_jCBListaItemStateChanged

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
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlblStatus;
    // End of variables declaration//GEN-END:variables
}
