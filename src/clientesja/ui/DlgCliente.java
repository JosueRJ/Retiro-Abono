package clientesja.ui;

import clientesja.dao.clases.Cliente;
import clientesja.dao.implement.ClienteImplement;
import clientesja.dao.interfaces.ClienteDAO;
import clientesja.jdbc.ConexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DlgCliente extends javax.swing.JDialog {

    public static final int CREAR = 0;
    public static final int MODIFICAR = 1;
    private int operacion;
    //variable para listar
    private ClienteDAO clienteDAO;
    
    public DlgCliente(java.awt.Frame parent, boolean modal, int operacion) {
        super(parent, modal);
        initComponents();
        
        clienteDAO = new ClienteImplement();
        cargarClientes();
        //
        this.operacion = operacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApPaterno = new javax.swing.JTextField();
        txtApMaterno = new javax.swing.JTextField();
        txtAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DNI :");

        jLabel2.setText("Nombres :");

        jLabel3.setText("ApPaterno :");

        jLabel4.setText("ApMaterno :");

        txtAgregar.setText("Agregar");
        txtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "ApPaterno", "ApMaterno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                    .addComponent(txtApPaterno)
                                    .addComponent(txtApMaterno))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarActionPerformed
        if (operacion == CREAR) {
            Cliente cliente = new Cliente(txtDni.getText(), txtNombres.getText(), txtApPaterno.getText(), txtApMaterno.getText());
            ClienteDAO clienteDao = new ClienteImplement();
            clienteDao.guardar(cliente);
        }
        cargarClientes();
        Limpiar();
    }//GEN-LAST:event_txtAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            Connection connection = ConexionSingleton.getConnection();
            int fila = tblClientes.getSelectedRow();
            String dni = "";
            dni = tblClientes.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = connection.prepareStatement("DELETE FROM Cliente WHERE Dni='"+dni+"'");
                pst.executeUpdate();
                cargarClientes();
            } catch (Exception e) {
            }

        } catch (SQLException ex) {
            Logger.getLogger(DlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
////
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(operacion != MODIFICAR){
            Cliente cliente = new Cliente(txtDni.getText(), txtNombres.getText(), txtApPaterno.getText(),txtApMaterno.getText());
            ClienteDAO clienteDAO = new ClienteImplement();
            clienteDAO.modificar(cliente);
        }
        cargarClientes();
        Limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int Seleccion = tblClientes.rowAtPoint(evt.getPoint());
        txtDni.setText(String.valueOf(tblClientes.getValueAt(Seleccion, 0)));
        txtNombres.setText(String.valueOf(tblClientes.getValueAt(Seleccion, 1)));
        txtApPaterno.setText(String.valueOf(tblClientes.getValueAt(Seleccion, 2)));
        txtApMaterno.setText(String.valueOf(tblClientes.getValueAt(Seleccion, 3)));
        
    }//GEN-LAST:event_tblClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JButton txtAgregar;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void cargarClientes() {
        List<Cliente> cliente = clienteDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tblClientes.getModel();
        
        modelo.getDataVector().clear();
        for (int i = 0; i < cliente.size(); i++) {
            modelo.addRow(new Object[] {cliente.get(i).getDni(), cliente.get(i).getNombres(), cliente.get(i).getApPaterno(), cliente.get(i).getApMaterno()});
        }
    }
    
    void Limpiar(){
        txtDni.setText("");
        txtNombres.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
    }
}
