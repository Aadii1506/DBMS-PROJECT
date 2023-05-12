import java.awt.*;
import java.sql.*;
import javax.swing.*;

//for taking customer info!!
public class f3 extends javax.swing.JFrame {

    Connection Con = null;
    PreparedStatement pst = null;

    ResultSet rs = null;

    public f3() {
        initComponents();
        setTitle("Enter Your Details");
        setSize(1400, 1400);
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "root");
            //JOptionPane.showMessageDialog(null, "connected");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " not connected");
        }
    }

    private void initComponents() {
        ImageIcon image=new ImageIcon("C:\\Users\\MY HP\\Desktop\\java proj\\Online-Food-Delivery\\images\\food.jpg");
        setIconImage(image.getImage());

        // Create a panel to hold the input components
        JPanel inputPanel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);


        JLabel inputLabel1 = new JLabel("F-Name");
        JTextField inputField1 = new JTextField(20);


        inputPanel.add(inputLabel1,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField1,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel2 = new JLabel("L-Name");
        JTextField inputField2 = new JTextField(20);
        inputPanel.add(inputLabel2,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField2,constraints);
        constraints.gridx=0;
        constraints.gridy++;

        JLabel inputLabel3 = new JLabel("CUST-ID");
        JTextField inputField3= new JTextField(20);

        inputPanel.add(inputLabel3,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField3,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel4 = new JLabel("EMAIL-ID");
        JTextField inputField4 = new JTextField(20);

        inputPanel.add(inputLabel4,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField4,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel5 = new JLabel("PASSWRD");
        JTextField inputField5 = new JTextField(20);

        inputPanel.add(inputLabel5,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField5,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel6 = new JLabel("ADDRESS");
        JTextField inputField6 = new JTextField(20);

        inputPanel.add(inputLabel6,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField6,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel7 = new JLabel("STREET");
        JTextField inputField7 = new JTextField(20);

        inputPanel.add(inputLabel7,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField7,constraints);
        constraints.gridx=0;
        constraints.gridy++;

        JLabel inputLabel8 = new JLabel("PINCODE");
        JTextField inputField8 = new JTextField(20);

        inputPanel.add(inputLabel8,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField8,constraints);
        constraints.gridx=0;
        constraints.gridy++;
        JLabel inputLabel9 = new JLabel("GENDER");
        JTextField inputField9 = new JTextField(20);

        inputPanel.add(inputLabel9,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField9,constraints);
        constraints.gridx=0;
        constraints.gridy++;

        JLabel inputLabel10 = new JLabel("PHONE NO.");
        JTextField inputField10 = new JTextField(20);

        inputPanel.add(inputLabel10,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField10,constraints);
        constraints.gridx=0;
        constraints.gridy++;

        JLabel inputLabel11 = new JLabel("ALLERGY");
        JTextField inputField11 = new JTextField(20);

        inputPanel.add(inputLabel11,constraints);
        constraints.gridx=1;
        inputPanel.add(inputField11,constraints);
        constraints.gridx=0;
        constraints.gridy++;

        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 0, 255));
        jButton3.setText("SUBMIT");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.setPreferredSize(new Dimension(60, 30));
        constraints.gridx=2;
        inputPanel.add(jButton3,constraints);
        jButton3.setBounds(248, 50, 176, 60);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Perform the desired action here
                String f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11;
                f1=inputField1.getText();
                f2=inputField2.getText();
                f3=inputField3.getText();
                f4=inputField4.getText();
                f5=inputField5.getText();
                f6=inputField6.getText();
                f7=inputField7.getText();
                f8=inputField8.getText();
                f9=inputField9.getText();
                f10=inputField10.getText();
                f11=inputField11.getText();


                if (inputField1.getText().isEmpty()||inputField2.getText().isEmpty()||inputField3.getText().isEmpty()||inputField4.getText().isEmpty()||inputField5.getText().isEmpty()||inputField6.getText().isEmpty()||inputField7.getText().isEmpty()||inputField8.getText().isEmpty()||inputField9.getText().isEmpty()||inputField10.getText().isEmpty()||inputField11.getText().isEmpty()) {
                    // Show an error message
                    JOptionPane.showMessageDialog(null, "Please enter all the Text-fields", "Error", JOptionPane.ERROR_MESSAGE);
                    new f3().setVisible(true);
                }
                else{
                    String str="insert into  CUSTOMER values('"+f1+"','"+f2+"','"+Integer.parseInt(f3)+"','"+f4+"','"+f5+"','"+f6+"','"+f7+"','"+Integer.parseInt(f8)+"','"+f9+"','"+Integer.parseInt(f10)+"','"+f11+"')";
                    try
                    {
                        Class.forName("oracle.jdbc.OracleDriver");
                        Con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
                        if(Con!=null){
                            Statement state=Con.createStatement();
                            state.executeUpdate(str);
                        }
                    }
                    catch(Exception excp)
                    {
                        System.out.println(excp);
                        JOptionPane.showMessageDialog(null, "Not connected please retry", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Now login with your id and password");
                    new f4().setVisible(true);
                }
            }
        });

        // Add the input panel to the frame
        add(inputPanel);

        // Make the frame visible
        setVisible(true);
        pack();
    }

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
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f3().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton3;
};