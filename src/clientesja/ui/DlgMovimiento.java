package clientesja.ui;

import clientesja.dao.clases.Movimiento;
import clientesja.dao.implement.MovimientoImplement;
import clientesja.dao.interfaces.MovimientoDAO;
import clientesja.jdbc.ConexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DlgMovimiento extends javax.swing.JDialog {

    public static final int CREAR = 0;
    public static final int MODIFICAR = 1;
    private final int operacion1;
    //variable para listar
    private final MovimientoDAO movimientoDAO;
    
    public DlgMovimiento(java.awt.Frame parent, boolean modal, int operacion) {
        super(parent, modal);
        initComponents();
        
        movimientoDAO = new MovimientoImplement();
        cargarMovimientos();
        //
        this.operacion1 = operacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroMovimiento = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        cbxTipoMovimiento = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("NroMovimiento :");

        jLabel2.setText("Tipo Movimiento :");

        jLabel3.setText("Monto");

        cbxTipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retiro", "Abono" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "NroMovimiento", "TipoMovimiento", "Monto"
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
        tblMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovimientos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMonto)
                                    .addComponent(txtNroMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipoMovimiento, 0, 132, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
////
        if (operacion1 == CREAR) {
            Movimiento movimiento = new Movimiento(txtNroMovimiento.getText(),cbxTipoMovimiento.getSelectedItem().toString(),txtMonto.getText(),null);
            MovimientoDAO movimientoDAO = new MovimientoImplement();
            movimientoDAO.guardar(movimiento);
        }
        cargarMovimientos();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
////
        int resultado = JOptionPane.showConfirmDialog(this, "Desea borrar?", "Condirmacion", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION){
            String posicion = txtNroMovimiento.getText();
            DefaultTableModel modelo = (DefaultTableModel)tblMovimientos.getModel();
            Movimiento movimiento = new Movimiento(posicion);
            movimientoDAO.borrar(movimiento);
            cargarMovimientos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (operacion1 != MODIFICAR) {
            Movimiento movimiento = new Movimiento(txtNroMovimiento.getText(), cbxTipoMovimiento.getItemAt(cbxTipoMovimiento.getSelectedIndex()), txtMonto.getText(),null);
            MovimientoDAO movimientoDAO = new MovimientoImplement();
            movimientoDAO.modificar(movimiento);
        }
        cargarMovimientos();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovimientosMouseClicked
        int Seleccion = tblMovimientos.rowAtPoint(evt.getPoint());
        txtNroMovimiento.setText(String.valueOf(tblMovimientos.getValueAt(Seleccion, 0)));
        txtMonto.setText(String.valueOf(tblMovimientos.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tblMovimientosMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxTipoMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMovimientos;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNroMovimiento;
    // End of variables declaration//GEN-END:variables

    private void cargarMovimientos() {
        List<Movimiento> movimiento = movimientoDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tblMovimientos.getModel();
        modelo.getDataVector().clear();
        for (int i = 0; i < movimiento.size(); i++) {
            modelo.addRow(new Object[] {movimiento.get(i).getNroMovimiento(), movimiento.get(i).getTipoMovimiento(), movimiento.get(i).getMonto()});
        }
    }
    
    void limpiar(){
        txtNroMovimiento.setText("");
        txtMonto.setText("");
    }    
}
