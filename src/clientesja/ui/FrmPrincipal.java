package clientesja.ui;

import clientesja.dao.clases.Cliente;
import java.sql.Connection;
import clientesja.jdbc.ConexionSingleton;
import java.sql.PreparedStatement;
import clientesja.dao.clases.Cuenta;
import clientesja.dao.implement.CuentaImplement;
import clientesja.dao.interfaces.CuentaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmPrincipal extends javax.swing.JFrame {

    public static final int CREAR = 0;
    public static final int MODIFICAR = 1;
    private int operacion;
    //Creamos una variable para listar
    private CuentaDAO cuentaDAO;
    
    public FrmPrincipal() {
        initComponents();
        
        cuentaDAO = new CuentaImplement();
        cargarCuentas();
        //
        this.operacion = operacion;
        
        //Llenar combo
        Cliente cliente = new Cliente();
        cliente.llenarClientes(cbxClientes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        cbxClientes = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        btnMovimientos = new javax.swing.JButton();
        btnGestionarClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NroCuenta :");

        jLabel2.setText("Cliente :");

        jLabel3.setText("Tipo :");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "NroCuenta", "Cliente", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCuentas);

        btnMovimientos.setText("Movimientos");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnGestionarClientes.setText("Gestionar Clientes");
        btnGestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 326, Short.MAX_VALUE)
                        .addComponent(btnGestionarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar)
                    .addComponent(btnMovimientos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGestionarClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(operacion == CREAR){
            String cli = cbxClientes.getItemAt(cbxClientes.getSelectedIndex()).getDni();
            try {
                Connection connection = ConexionSingleton.getConnection();
                PreparedStatement pst = connection.prepareStatement("INSERT INTO Cuenta VALUES (?,?,?)");
                pst.setString(1, txtNroCuenta.getText());
                pst.setString(2, txtTipo.getText());
                pst.setString(3, cli);

            } catch (Exception e) {
            }
        }
        
/////
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (operacion != MODIFICAR) {
            Cuenta cuenta = new Cuenta(txtNroCuenta.getText(), cbxClientes.getSelectedItem().toString(), txtTipo.getText());
            CuentaDAO cuentaDAO = new CuentaImplement();
            cuentaDAO.modificar(cuenta);
        }
        cargarCuentas();
        Limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {            
        Connection connection = ConexionSingleton.getConnection();
        int fila = tblCuentas.getSelectedRow();
        String n = "";
        n = tblCuentas.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = connection.prepareStatement("DELETE FROM Cuenta WHERE nroCuenta='"+n+"'");
                pst.executeUpdate();
                cargarCuentas();
            } catch (Exception e) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
////
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        int fila = tblCuentas.getSelectedRow();
        if(fila >= 0){
            DlgMovimiento dlgMovimiento = new DlgMovimiento(this, true, operacion);
            dlgMovimiento.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono ninguna fila");
        }
        
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnGestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarClientesActionPerformed
         DlgCliente dlgCliente = new DlgCliente(this, true, operacion);
         dlgCliente.setVisible(true);
    }//GEN-LAST:event_btnGestionarClientesActionPerformed

    private void tblCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentasMouseClicked
        int Seleccion = tblCuentas.rowAtPoint(evt.getPoint());
        txtNroCuenta.setText(String.valueOf(tblCuentas.getValueAt(Seleccion, 0)));
        txtTipo.setText(String.valueOf(tblCuentas.getValueAt(Seleccion, 2)));
        
    }//GEN-LAST:event_tblCuentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGestionarClientes;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JComboBox<Cliente> cbxClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuentas;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    private void cargarCuentas() {
        List<Cuenta> cuenta = cuentaDAO.listar();
        DefaultTableModel modelo =(DefaultTableModel)tblCuentas.getModel();
        
        modelo.getDataVector().clear();
        for (int i = 0; i < cuenta.size(); i++) {
            modelo.addRow(new Object[] {cuenta.get(i).getNroCuenta(), cuenta.get(i).getDni(), cuenta.get(i).getTipo()});
        }
    }

    public void Limpiar(){
        txtNroCuenta.setText("");
        txtTipo.setText("");
    }
}
