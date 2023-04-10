/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import static Clases.Metodos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class Ventas extends javax.swing.JFrame {

    private float [] Sumatoria;
    private float [] Costos;
    private DefaultTableModel Tabla;
    private String Fecha;
    private float precioTotal = 0;
    private float ganancia = 0;
    private float costoTotal = 0;
    private String estado = "";
    private String empleado = "";
    
    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        ConectarBD();
        empleado = Interfaz.Login.Usuario;
        llenarTabla();
    }

    //metodo para validar el campo fecha
    private boolean ValidarFecha(){
        if(!txtFecha.getText().matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")){
            JOptionPane.showMessageDialog(jdRegVenta, txtFecha.getText()+" no es valido"
                    + "\n Ejemplo valido: 2023-04-20");
            txtFecha.requestFocus();
            return true;
        }//if
        return false;
    }//validacion del campo fecha
    
    private void llenarTabla(){
        //Inicializamos la tabla con un modelo
        Tabla = (DefaultTableModel) tblVentas.getModel();
        //arreglo para almacenar el resultado de cada campo
        Object [] row = new Object[7];
        try{
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            String query = "SELECT * FROM Ventas";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                row[0] = rs.getInt(1);
                row[1] = rs.getDate(2);
                row[2] = rs.getFloat(3);
                row[3] = rs.getFloat(4);
                row[4] = rs.getFloat(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                Tabla.addRow(row);
        }
        }catch (SQLException ex) {
            showMessageDialog(this, "Error: "+ex);
        }//error en la consulta
    }//metodo llenar tabla
    
    private void ocultar(){
        cbIng4.setVisible(false);
        sIng4.setVisible(false);
        cbIng5.setVisible(false);
        sIng5.setVisible(false);
        cbIng6.setVisible(false);
        sIng6.setVisible(false);
        cbIng7.setVisible(false);
        sIng7.setVisible(false);
        cbIng8.setVisible(false);
        sIng8.setVisible(false);
        cbIng9.setVisible(false);
        sIng9.setVisible(false);
        cbIng10.setVisible(false);
        sIng10.setVisible(false);
    }//metodo ocultar los elementos que no se utilizaran
    
    //recibe un combobox y un spinner
    private void mostrar(JComboBox JCB, JSpinner JS){
        JCB.setVisible(true);
        JS.setVisible(true);
    }//metodo para mostrar los elementos 

    private void llenarCBs(){
        int i = 0;
        try{
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            String query = "SELECT COUNT(*) FROM Insumos";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            rs.next();
            Costos = new float [rs.getInt(1)];
            query = "SELECT nombre_ins,costo_ins,unidadMed_ins FROM Insumos";
            rs = st.executeQuery(query);
            while(rs.next()){
                cbIng1.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng2.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng3.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng4.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng5.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng6.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng7.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng8.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng9.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                cbIng10.addItem(rs.getString(1)+" ("+rs.getString(3)+")");
                Costos[i++] = rs.getFloat(2);
        }
        }catch (SQLException ex) {
            showMessageDialog(this, "Error: "+ex);
        }//error en la consulta
    }//metodo para llenar los combobox
    
    //recibe el combobox a reiniciar
    private void reiniciarCB(JComboBox JCB){
        JCB.removeAllItems();
        JCB.addItem("Selecciona un ingrediente");
    }//metodo para reiniciar un combobox
    
    //recibe dos combobox 
    private void seleccionarCB(JComboBox JCB1, JComboBox JCB2){
        int i1 = JCB1.getSelectedIndex();
        int i2 = JCB2.getSelectedIndex();
        if(i1 != 0 & i2 != 0){
            if(i1 == i2){
                showMessageDialog(this, "Por favor seleccione otra opción");
                JCB1.setSelectedIndex(0);
            }//if i1 == i2
        }//if i1 != 0 Y i2 != 0
    }//metodo para validar la selección en un combobox
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdRegVenta = new javax.swing.JDialog();
        txtFecha = new javax.swing.JTextField();
        lblCancelar = new javax.swing.JLabel();
        lblRegVenta = new javax.swing.JLabel();
        btEstado = new javax.swing.JToggleButton();
        sCosto = new javax.swing.JSpinner();
        sPrecio = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdCotizacion = new javax.swing.JDialog();
        sIngredientes = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        cbIng1 = new javax.swing.JComboBox<>();
        sIng1 = new javax.swing.JSpinner();
        cbIng2 = new javax.swing.JComboBox<>();
        sIng2 = new javax.swing.JSpinner();
        cbIng3 = new javax.swing.JComboBox<>();
        sIng3 = new javax.swing.JSpinner();
        lblCancelar2C = new javax.swing.JLabel();
        lblCotizar = new javax.swing.JLabel();
        cbIng4 = new javax.swing.JComboBox<>();
        sIng4 = new javax.swing.JSpinner();
        cbIng5 = new javax.swing.JComboBox<>();
        sIng5 = new javax.swing.JSpinner();
        cbIng6 = new javax.swing.JComboBox<>();
        sIng6 = new javax.swing.JSpinner();
        cbIng7 = new javax.swing.JComboBox<>();
        sIng7 = new javax.swing.JSpinner();
        cbIng8 = new javax.swing.JComboBox<>();
        sIng8 = new javax.swing.JSpinner();
        sIng9 = new javax.swing.JSpinner();
        cbIng9 = new javax.swing.JComboBox<>();
        cbIng10 = new javax.swing.JComboBox<>();
        sIng10 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCotizacion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jdRegVenta.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jdRegVenta.setTitle("Registrar venta");

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(150, 150, 150));
        txtFecha.setText("Fecha:");
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFocusGained(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });

        lblCancelar.setText("Ic. Cancelar");
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });

        lblRegVenta.setText("Ic. Registrar");
        lblRegVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegVentaMouseClicked(evt);
            }
        });

        btEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEstado.setText("Venta");
        btEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstadoActionPerformed(evt);
            }
        });

        sCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sCosto.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 5.0f));

        sPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 5.0f));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Costo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");

        javax.swing.GroupLayout jdRegVentaLayout = new javax.swing.GroupLayout(jdRegVenta.getContentPane());
        jdRegVenta.getContentPane().setLayout(jdRegVentaLayout);
        jdRegVentaLayout.setHorizontalGroup(
            jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdRegVentaLayout.createSequentialGroup()
                .addComponent(lblCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(lblRegVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdRegVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdRegVentaLayout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdRegVentaLayout.createSequentialGroup()
                        .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jdRegVentaLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sPrecio))
                                .addGroup(jdRegVentaLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(132, 132, 132))))
        );
        jdRegVentaLayout.setVerticalGroup(
            jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdRegVentaLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sCosto)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdRegVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jdCotizacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jdCotizacion.setTitle("Cotización");

        sIngredientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIngredientes.setModel(new javax.swing.SpinnerNumberModel(3, 3, 10, 1));
        sIngredientes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIngredientesStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("¿Cuantos ingredientes necesita?");

        cbIng1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng1ActionPerformed(evt);
            }
        });

        sIng1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng1.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng1StateChanged(evt);
            }
        });

        cbIng2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng2ActionPerformed(evt);
            }
        });

        sIng2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng2.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng2StateChanged(evt);
            }
        });

        cbIng3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng3ActionPerformed(evt);
            }
        });

        sIng3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng3.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng3StateChanged(evt);
            }
        });

        lblCancelar2C.setText("Ic. Cancelar");
        lblCancelar2C.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelar2C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelar2CMouseClicked(evt);
            }
        });

        lblCotizar.setText("Ic. Cotizar");
        lblCotizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCotizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCotizarMouseClicked(evt);
            }
        });

        cbIng4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng4ActionPerformed(evt);
            }
        });

        sIng4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng4.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng4StateChanged(evt);
            }
        });

        cbIng5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng5ActionPerformed(evt);
            }
        });

        sIng5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng5.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng5StateChanged(evt);
            }
        });

        cbIng6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng6ActionPerformed(evt);
            }
        });

        sIng6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng6.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng6StateChanged(evt);
            }
        });

        cbIng7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng7ActionPerformed(evt);
            }
        });

        sIng7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng7.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng7StateChanged(evt);
            }
        });

        cbIng8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng8ActionPerformed(evt);
            }
        });

        sIng8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng8.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng8StateChanged(evt);
            }
        });

        sIng9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng9.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng9StateChanged(evt);
            }
        });

        cbIng9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng9ActionPerformed(evt);
            }
        });

        cbIng10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIng10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un ingrediente" }));
        cbIng10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIng10ActionPerformed(evt);
            }
        });

        sIng10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIng10.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        sIng10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sIng10StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jdCotizacionLayout = new javax.swing.GroupLayout(jdCotizacion.getContentPane());
        jdCotizacion.getContentPane().setLayout(jdCotizacionLayout);
        jdCotizacionLayout.setHorizontalGroup(
            jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdCotizacionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(sIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jdCotizacionLayout.createSequentialGroup()
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(lblCancelar2C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdCotizacionLayout.createSequentialGroup()
                                .addComponent(cbIng5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIng5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdCotizacionLayout.createSequentialGroup()
                                .addComponent(cbIng4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIng4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdCotizacionLayout.createSequentialGroup()
                                .addComponent(cbIng3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIng3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdCotizacionLayout.createSequentialGroup()
                                .addComponent(cbIng1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIng1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdCotizacionLayout.createSequentialGroup()
                                .addComponent(cbIng2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIng2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(cbIng6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sIng6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(cbIng7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sIng7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(cbIng8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sIng8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(cbIng9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sIng9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addComponent(cbIng10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sIng10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jdCotizacionLayout.setVerticalGroup(
            jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdCotizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addGroup(jdCotizacionLayout.createSequentialGroup()
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIng9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sIng9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbIng10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sIng10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbIng5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sIng5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jdCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCancelar2C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Fecha", "Total", "Ganancia", "Costo", "Estado", "Empleado"
            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        jLabel1.setText("Ic. Buscar");

        lblMenu.setText("Ic. Menú");
        lblMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });

        lblRegistrar.setText("Ic. Guardar");
        lblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarMouseClicked(evt);
            }
        });

        jLabel4.setText("Ic. Actualizar");

        lblCotizacion.setText("Ic. Cotización");
        lblCotizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCotizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCotizacionMouseClicked(evt);
            }
        });

        jLabel6.setText("Ic. Catalogo");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Criterio de búsqueda", "Producto", "Fecha", "Precio", "Costo", "Ganancia", "Estado", "Empleado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        // TODO add your handling code here:
        Abrir_Dialogo(jdRegVenta, this, 430, 270);
        estado = "Completada";
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void btEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstadoActionPerformed
        // TODO add your handling code here:
        if(btEstado.isSelected()){
            btEstado.setText("Pedido");
            estado = "Pendiente";
        }//if cambia el toogle a perido
        else{
            btEstado.setText("Venta");
            estado = "Completada";
        }//else cambia el toogle a venta
    }//GEN-LAST:event_btEstadoActionPerformed

    private void txtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusGained
        // TODO add your handling code here:
        usarTxt(txtFecha);
    }//GEN-LAST:event_txtFechaFocusGained

    private void lblRegVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegVentaMouseClicked
        // TODO add your handling code here:
        if(ValidarFecha())
            return;
        Fecha = txtFecha.getText();
        costoTotal = Float.parseFloat(sCosto.getValue().toString());
        precioTotal = Float.parseFloat(sPrecio.getValue().toString());
        ganancia = precioTotal - costoTotal;
        String INSERT = "INSERT INTO ventas VALUES (DEFAULT,'"+Fecha+"',"+precioTotal+","
                +ganancia+","+costoTotal+",'"+estado+"','"+empleado+"');";
        RUD(INSERT, this);
        vaciarTabla(Tabla, tblVentas);
        llenarTabla();
    }//GEN-LAST:event_lblRegVentaMouseClicked

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        // TODO add your handling code here:
        Principal menu = new Principal();
        Cambiar_Ventana(menu, this);
    }//GEN-LAST:event_lblMenuMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        // TODO add your handling code here:
        reiniciarTxt(txtFecha, "Fecha:");
        btEstado.setSelected(false);
        btEstado.setText("Venta");
        sCosto.setValue(0);
        sPrecio.setValue(0);
        jdRegVenta.dispose();
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        // TODO add your handling code here:
        if(txtFecha.getText().length() == 10){
            evt.consume();
        }//if
    }//GEN-LAST:event_txtFechaKeyTyped

    private void lblCotizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCotizacionMouseClicked
        // TODO add your handling code here:
        Sumatoria = new float[3];
        Abrir_Dialogo(jdCotizacion, this, 365, 375);
        ocultar();
        llenarCBs();
    }//GEN-LAST:event_lblCotizacionMouseClicked

    private void sIngredientesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIngredientesStateChanged
        // TODO add your handling code here:
        int i = (int) sIngredientes.getValue();
        switch (i){
            case 3:
                Sumatoria = new float[i];
                jdCotizacion.setSize(365, 375);
                ocultar();
                break;
            case 4:
                Sumatoria = new float[i];
                jdCotizacion.setSize(365, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                break;
            case 5:
                Sumatoria = new float[i];
                jdCotizacion.setSize(365, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                break;
            case 6:
                Sumatoria = new float[i];
                jdCotizacion.setSize(710, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                mostrar(cbIng6,sIng6);
                break;
            case 7:
                Sumatoria = new float[i];
                jdCotizacion.setSize(710, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                mostrar(cbIng6,sIng6);
                mostrar(cbIng7,sIng7);
                break;
            case 8:
                Sumatoria = new float[i];
                jdCotizacion.setSize(710, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                mostrar(cbIng6,sIng6);
                mostrar(cbIng7,sIng7);
                mostrar(cbIng8,sIng8);
                break;
            case 9:
                Sumatoria = new float[i];
                jdCotizacion.setSize(710, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                mostrar(cbIng6,sIng6);
                mostrar(cbIng7,sIng7);
                mostrar(cbIng8,sIng8);
                mostrar(cbIng9,sIng9);
                break;
            case 10:
                Sumatoria = new float[i];
                jdCotizacion.setSize(710, 375);
                ocultar();
                mostrar(cbIng4,sIng4);
                mostrar(cbIng5,sIng5);
                mostrar(cbIng6,sIng6);
                mostrar(cbIng7,sIng7);
                mostrar(cbIng8,sIng8);
                mostrar(cbIng9,sIng9);
                mostrar(cbIng10,sIng10);
                break;
        }//switch
    }//GEN-LAST:event_sIngredientesStateChanged

    private void lblCancelar2CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelar2CMouseClicked
        // TODO add your handling code here:
        jdCotizacion.dispose();
        sIngredientes.setValue(3);
        //regresa el spinner a su valor inicial
        reiniciarCB(cbIng1);
        reiniciarCB(cbIng2);
        reiniciarCB(cbIng3);
        reiniciarCB(cbIng4);
        reiniciarCB(cbIng5);
        reiniciarCB(cbIng6);
        reiniciarCB(cbIng7);
        reiniciarCB(cbIng8);
        reiniciarCB(cbIng9);
        reiniciarCB(cbIng10);
        //regresa los combobox a su indice inicial
    }//GEN-LAST:event_lblCancelar2CMouseClicked

    private void lblCotizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCotizarMouseClicked
        // TODO add your handling code here:
        int Ti = (int) sIngredientes.getValue();
        switch (Ti){
            case 3:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this))
                    break;
                else
                    return;
            case 4:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this))
                    break;
                else
                    return;
            case 5:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this))
                    break;
                else
                    return;
            case 6:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this) & validarComboBox(cbIng6, this))
                    break;
                else
                    return;
            case 7:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this) & validarComboBox(cbIng6, this)
                & validarComboBox(cbIng7, this))
                    break;
                else
                    return;
            case 8:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this) & validarComboBox(cbIng6, this)
                & validarComboBox(cbIng7, this) & validarComboBox(cbIng8, this))
                    break;
                else
                    return;
            case 9:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this) & validarComboBox(cbIng6, this)
                & validarComboBox(cbIng7, this) & validarComboBox(cbIng8, this) & validarComboBox(cbIng9, this))
                    break;
                else
                    return;
            case 10:
                if(validarComboBox(cbIng1, this) & validarComboBox(cbIng2, this) & validarComboBox(cbIng3, this)
                & validarComboBox(cbIng4, this) & validarComboBox(cbIng5, this) & validarComboBox(cbIng6, this)
                & validarComboBox(cbIng7, this) & validarComboBox(cbIng8, this) & validarComboBox(cbIng9, this)
                & validarComboBox(cbIng10, this))
                    break;
                else
                    return;    
        }//switch
        costoTotal = 0;
        for(int i = 0; i < Ti;i++){
            if(Sumatoria[i] == 0){
                switch (i){
                    case 0:
                        costoTotal = costoTotal + (Costos[cbIng1.getSelectedIndex()-1]/1000) 
                        * ((float) sIng1.getValue());
                        break;
                    case 1:
                        costoTotal = costoTotal + (Costos[cbIng2.getSelectedIndex()-1]/1000) 
                        * ((float) sIng2.getValue());
                        break;
                    case 2:
                        costoTotal = costoTotal + (Costos[cbIng3.getSelectedIndex()-1]/1000) 
                        * ((float) sIng3.getValue());
                        break;
                    case 3:
                        costoTotal = costoTotal + (Costos[cbIng4.getSelectedIndex()-1]/1000) 
                        * ((float) sIng4.getValue());
                        break;
                    case 4:
                        costoTotal = costoTotal + (Costos[cbIng5.getSelectedIndex()-1]/1000) 
                        * ((float) sIng5.getValue());
                        break;
                    case 5:
                        costoTotal = costoTotal + (Costos[cbIng6.getSelectedIndex()-1]/1000) 
                        * ((float) sIng6.getValue());
                        break;
                    case 6:
                        costoTotal = costoTotal + (Costos[cbIng7.getSelectedIndex()-1]/1000) 
                        * ((float) sIng7.getValue());
                        break;
                    case 7:
                        costoTotal = costoTotal + (Costos[cbIng8.getSelectedIndex()-1]/1000) 
                        * ((float) sIng8.getValue());
                        break;
                    case 8:
                        costoTotal = costoTotal + (Costos[cbIng9.getSelectedIndex()-1]/1000) 
                        * ((float) sIng9.getValue());
                        break;    
                    case 9:
                        costoTotal = costoTotal + (Costos[cbIng10.getSelectedIndex()-1]/1000) 
                        * ((float) sIng10.getValue());
                        break;    
                }//swithc
            }//if
            else    
                costoTotal = costoTotal + Sumatoria[i];
        }//for
        precioTotal = (float) (Math.round((2 * ((costoTotal + (costoTotal * .10)))) * 100.0) / 100.0);
        sPrecio.setValue(precioTotal);
        sCosto.setValue(costoTotal);
        showMessageDialog(jdCotizacion,"Precio de venta: $"+precioTotal);
    }//GEN-LAST:event_lblCotizarMouseClicked

    private void sIng1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng1StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng1, this))
            Sumatoria [0] = (Costos[cbIng1.getSelectedIndex()-1]/1000) * ((float) sIng1.getValue());
    }//GEN-LAST:event_sIng1StateChanged

    private void sIng2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng2StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng2, this))
            Sumatoria [1] = (Costos[cbIng2.getSelectedIndex()-1]/1000) * ((float) sIng2.getValue());
    }//GEN-LAST:event_sIng2StateChanged

    private void sIng3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng3StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng3, this))
            Sumatoria [2] = (Costos[cbIng3.getSelectedIndex()-1]/1000) * ((float) sIng3.getValue());
    }//GEN-LAST:event_sIng3StateChanged

    private void sIng4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng4StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng4, this))
            Sumatoria [3] = (Costos[cbIng4.getSelectedIndex()-1]/1000) * ((float) sIng4.getValue());
    }//GEN-LAST:event_sIng4StateChanged

    private void sIng5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng5StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng5, this))
            Sumatoria [4] = (Costos[cbIng5.getSelectedIndex()-1]/1000) * ((float) sIng5.getValue());
    }//GEN-LAST:event_sIng5StateChanged

    private void sIng6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng6StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng6, this))
            Sumatoria [5] = (Costos[cbIng6.getSelectedIndex()-1]/1000) * ((float) sIng6.getValue());
    }//GEN-LAST:event_sIng6StateChanged

    private void sIng7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng7StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng7, this))
            Sumatoria [6] = (Costos[cbIng7.getSelectedIndex()-1]/1000) * ((float) sIng7.getValue());
    }//GEN-LAST:event_sIng7StateChanged

    private void sIng8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng8StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng8, this))
            Sumatoria [7] = (Costos[cbIng8.getSelectedIndex()-1]/1000) * ((float) sIng8.getValue());
    }//GEN-LAST:event_sIng8StateChanged

    private void sIng9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng9StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng9, this))
            Sumatoria [8] = (Costos[cbIng9.getSelectedIndex()-1]/1000) * ((float) sIng9.getValue());
    }//GEN-LAST:event_sIng9StateChanged

    private void sIng10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sIng10StateChanged
        // TODO add your handling code here:
        if(validarComboBox(cbIng10, this))
            Sumatoria [9] = (Costos[cbIng10.getSelectedIndex()-1]/1000) * ((float) sIng10.getValue());
    }//GEN-LAST:event_sIng10StateChanged

    private void cbIng1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng1ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 3:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                break;
            case 4:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                break;
            case 5:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                break;
            case 6:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                seleccionarCB(cbIng1, cbIng6);
                break;
            case 7:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                seleccionarCB(cbIng1, cbIng6);
                seleccionarCB(cbIng1, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                seleccionarCB(cbIng1, cbIng6);
                seleccionarCB(cbIng1, cbIng7);
                seleccionarCB(cbIng1, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                seleccionarCB(cbIng1, cbIng6);
                seleccionarCB(cbIng1, cbIng7);
                seleccionarCB(cbIng1, cbIng8);
                seleccionarCB(cbIng1, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng1, cbIng2);
                seleccionarCB(cbIng1, cbIng3);
                seleccionarCB(cbIng1, cbIng4);
                seleccionarCB(cbIng1, cbIng5);
                seleccionarCB(cbIng1, cbIng6);
                seleccionarCB(cbIng1, cbIng7);
                seleccionarCB(cbIng1, cbIng8);
                seleccionarCB(cbIng1, cbIng9);
                seleccionarCB(cbIng1, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng1ActionPerformed

    private void cbIng2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng2ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 3:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                break;
            case 4:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                break;
            case 5:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                break;
            case 6:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                seleccionarCB(cbIng2, cbIng6);
                break;
            case 7:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                seleccionarCB(cbIng2, cbIng6);
                seleccionarCB(cbIng2, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                seleccionarCB(cbIng2, cbIng6);
                seleccionarCB(cbIng2, cbIng7);
                seleccionarCB(cbIng2, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                seleccionarCB(cbIng2, cbIng6);
                seleccionarCB(cbIng2, cbIng7);
                seleccionarCB(cbIng2, cbIng8);
                seleccionarCB(cbIng2, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng2, cbIng1);
                seleccionarCB(cbIng2, cbIng3);
                seleccionarCB(cbIng2, cbIng4);
                seleccionarCB(cbIng2, cbIng5);
                seleccionarCB(cbIng2, cbIng6);
                seleccionarCB(cbIng2, cbIng7);
                seleccionarCB(cbIng2, cbIng8);
                seleccionarCB(cbIng2, cbIng9);
                seleccionarCB(cbIng2, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng2ActionPerformed

    private void cbIng3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng3ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 3:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                break;
            case 4:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                break;
            case 5:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                break;
            case 6:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                seleccionarCB(cbIng3, cbIng6);
                break;
            case 7:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                seleccionarCB(cbIng3, cbIng6);
                seleccionarCB(cbIng3, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                seleccionarCB(cbIng3, cbIng6);
                seleccionarCB(cbIng3, cbIng7);
                seleccionarCB(cbIng3, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                seleccionarCB(cbIng3, cbIng6);
                seleccionarCB(cbIng3, cbIng7);
                seleccionarCB(cbIng3, cbIng8);
                seleccionarCB(cbIng3, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng3, cbIng2);
                seleccionarCB(cbIng3, cbIng1);
                seleccionarCB(cbIng3, cbIng4);
                seleccionarCB(cbIng3, cbIng5);
                seleccionarCB(cbIng3, cbIng6);
                seleccionarCB(cbIng3, cbIng7);
                seleccionarCB(cbIng3, cbIng8);
                seleccionarCB(cbIng3, cbIng9);
                seleccionarCB(cbIng3, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng3ActionPerformed

    private void cbIng4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng4ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 4:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                break;
            case 5:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                break;
            case 6:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                seleccionarCB(cbIng4, cbIng6);
                break;
            case 7:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                seleccionarCB(cbIng4, cbIng6);
                seleccionarCB(cbIng4, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                seleccionarCB(cbIng4, cbIng6);
                seleccionarCB(cbIng4, cbIng7);
                seleccionarCB(cbIng4, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                seleccionarCB(cbIng4, cbIng6);
                seleccionarCB(cbIng4, cbIng7);
                seleccionarCB(cbIng4, cbIng8);
                seleccionarCB(cbIng4, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng4, cbIng1);
                seleccionarCB(cbIng4, cbIng2);
                seleccionarCB(cbIng4, cbIng3);
                seleccionarCB(cbIng4, cbIng5);
                seleccionarCB(cbIng4, cbIng6);
                seleccionarCB(cbIng4, cbIng7);
                seleccionarCB(cbIng4, cbIng8);
                seleccionarCB(cbIng4, cbIng9);
                seleccionarCB(cbIng4, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng4ActionPerformed

    private void cbIng5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng5ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 5:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                break;
            case 6:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                seleccionarCB(cbIng5, cbIng6);
                break;
            case 7:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                seleccionarCB(cbIng5, cbIng6);
                seleccionarCB(cbIng5, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                seleccionarCB(cbIng5, cbIng6);
                seleccionarCB(cbIng5, cbIng7);
                seleccionarCB(cbIng5, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                seleccionarCB(cbIng5, cbIng6);
                seleccionarCB(cbIng5, cbIng7);
                seleccionarCB(cbIng5, cbIng8);
                seleccionarCB(cbIng5, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng5, cbIng1);
                seleccionarCB(cbIng5, cbIng2);
                seleccionarCB(cbIng5, cbIng3);
                seleccionarCB(cbIng5, cbIng4);
                seleccionarCB(cbIng5, cbIng6);
                seleccionarCB(cbIng5, cbIng7);
                seleccionarCB(cbIng5, cbIng8);
                seleccionarCB(cbIng5, cbIng9);
                seleccionarCB(cbIng5, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng5ActionPerformed

    private void cbIng6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng6ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 6:
                seleccionarCB(cbIng6, cbIng1);
                seleccionarCB(cbIng6, cbIng2);
                seleccionarCB(cbIng6, cbIng3);
                seleccionarCB(cbIng6, cbIng4);
                seleccionarCB(cbIng6, cbIng5);
                break;
            case 7:
                seleccionarCB(cbIng6, cbIng1);
                seleccionarCB(cbIng6, cbIng2);
                seleccionarCB(cbIng6, cbIng3);
                seleccionarCB(cbIng6, cbIng4);
                seleccionarCB(cbIng6, cbIng5);
                seleccionarCB(cbIng6, cbIng7);
                break;
            case 8:
                seleccionarCB(cbIng6, cbIng1);
                seleccionarCB(cbIng6, cbIng2);
                seleccionarCB(cbIng6, cbIng3);
                seleccionarCB(cbIng6, cbIng4);
                seleccionarCB(cbIng6, cbIng5);
                seleccionarCB(cbIng6, cbIng7);
                seleccionarCB(cbIng6, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng6, cbIng1);
                seleccionarCB(cbIng6, cbIng2);
                seleccionarCB(cbIng6, cbIng3);
                seleccionarCB(cbIng6, cbIng4);
                seleccionarCB(cbIng6, cbIng5);
                seleccionarCB(cbIng6, cbIng7);
                seleccionarCB(cbIng6, cbIng8);
                seleccionarCB(cbIng6, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng6, cbIng1);
                seleccionarCB(cbIng6, cbIng2);
                seleccionarCB(cbIng6, cbIng3);
                seleccionarCB(cbIng6, cbIng4);
                seleccionarCB(cbIng6, cbIng5);
                seleccionarCB(cbIng6, cbIng7);
                seleccionarCB(cbIng6, cbIng8);
                seleccionarCB(cbIng6, cbIng9);
                seleccionarCB(cbIng6, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng6ActionPerformed

    private void cbIng7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng7ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 7:
                seleccionarCB(cbIng7, cbIng1);
                seleccionarCB(cbIng7, cbIng2);
                seleccionarCB(cbIng7, cbIng3);
                seleccionarCB(cbIng7, cbIng4);
                seleccionarCB(cbIng7, cbIng5);
                seleccionarCB(cbIng7, cbIng6);
                break;
            case 8:
                seleccionarCB(cbIng7, cbIng1);
                seleccionarCB(cbIng7, cbIng2);
                seleccionarCB(cbIng7, cbIng3);
                seleccionarCB(cbIng7, cbIng4);
                seleccionarCB(cbIng7, cbIng5);
                seleccionarCB(cbIng7, cbIng6);
                seleccionarCB(cbIng7, cbIng8);
                break;
            case 9:
                seleccionarCB(cbIng7, cbIng1);
                seleccionarCB(cbIng7, cbIng2);
                seleccionarCB(cbIng7, cbIng3);
                seleccionarCB(cbIng7, cbIng4);
                seleccionarCB(cbIng7, cbIng5);
                seleccionarCB(cbIng7, cbIng6);
                seleccionarCB(cbIng7, cbIng8);
                seleccionarCB(cbIng7, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng7, cbIng1);
                seleccionarCB(cbIng7, cbIng2);
                seleccionarCB(cbIng7, cbIng3);
                seleccionarCB(cbIng7, cbIng4);
                seleccionarCB(cbIng7, cbIng5);
                seleccionarCB(cbIng7, cbIng6);
                seleccionarCB(cbIng7, cbIng8);
                seleccionarCB(cbIng7, cbIng9);
                seleccionarCB(cbIng7, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng7ActionPerformed

    private void cbIng8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng8ActionPerformed
        // TODO add your handling code here:
        switch((int) sIngredientes.getValue()){
            case 8:
                seleccionarCB(cbIng8, cbIng1);
                seleccionarCB(cbIng8, cbIng2);
                seleccionarCB(cbIng8, cbIng3);
                seleccionarCB(cbIng8, cbIng4);
                seleccionarCB(cbIng8, cbIng5);
                seleccionarCB(cbIng8, cbIng6);
                seleccionarCB(cbIng8, cbIng7);
                break;
            case 9:
                seleccionarCB(cbIng8, cbIng1);
                seleccionarCB(cbIng8, cbIng2);
                seleccionarCB(cbIng8, cbIng3);
                seleccionarCB(cbIng8, cbIng4);
                seleccionarCB(cbIng8, cbIng5);
                seleccionarCB(cbIng8, cbIng6);
                seleccionarCB(cbIng8, cbIng7);
                seleccionarCB(cbIng8, cbIng9);
                break;
            case 10:
                seleccionarCB(cbIng8, cbIng1);
                seleccionarCB(cbIng8, cbIng2);
                seleccionarCB(cbIng8, cbIng3);
                seleccionarCB(cbIng8, cbIng4);
                seleccionarCB(cbIng8, cbIng5);
                seleccionarCB(cbIng8, cbIng6);
                seleccionarCB(cbIng8, cbIng7);
                seleccionarCB(cbIng8, cbIng9);
                seleccionarCB(cbIng8, cbIng10);
                break;    
        }//switch
    }//GEN-LAST:event_cbIng8ActionPerformed

    private void cbIng9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng9ActionPerformed
        // TODO add your handling code here:
        int i = (int) sIngredientes.getValue();
        if(i == 9){
                seleccionarCB(cbIng9, cbIng1);
                seleccionarCB(cbIng9, cbIng2);
                seleccionarCB(cbIng9, cbIng3);
                seleccionarCB(cbIng9, cbIng4);
                seleccionarCB(cbIng9, cbIng5);
                seleccionarCB(cbIng9, cbIng6);
                seleccionarCB(cbIng9, cbIng7);
                seleccionarCB(cbIng9, cbIng8);
        }//if Ingredientes == 9
        if(i == 10){
                seleccionarCB(cbIng9, cbIng1);
                seleccionarCB(cbIng9, cbIng2);
                seleccionarCB(cbIng9, cbIng3);
                seleccionarCB(cbIng9, cbIng4);
                seleccionarCB(cbIng9, cbIng5);
                seleccionarCB(cbIng9, cbIng6);
                seleccionarCB(cbIng9, cbIng7);
                seleccionarCB(cbIng9, cbIng8);
                seleccionarCB(cbIng9, cbIng10);
        }//if Ingredientes == 10
    }//GEN-LAST:event_cbIng9ActionPerformed

    private void cbIng10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIng10ActionPerformed
        // TODO add your handling code here:
        seleccionarCB(cbIng10, cbIng1);
        seleccionarCB(cbIng10, cbIng2);
        seleccionarCB(cbIng10, cbIng3);
        seleccionarCB(cbIng10, cbIng4);
        seleccionarCB(cbIng10, cbIng5);
        seleccionarCB(cbIng10, cbIng6);
        seleccionarCB(cbIng10, cbIng7);
        seleccionarCB(cbIng10, cbIng8);
        seleccionarCB(cbIng10, cbIng9);
    }//GEN-LAST:event_cbIng10ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btEstado;
    private javax.swing.JComboBox<String> cbIng1;
    private javax.swing.JComboBox<String> cbIng10;
    private javax.swing.JComboBox<String> cbIng2;
    private javax.swing.JComboBox<String> cbIng3;
    private javax.swing.JComboBox<String> cbIng4;
    private javax.swing.JComboBox<String> cbIng5;
    private javax.swing.JComboBox<String> cbIng6;
    private javax.swing.JComboBox<String> cbIng7;
    private javax.swing.JComboBox<String> cbIng8;
    private javax.swing.JComboBox<String> cbIng9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jdCotizacion;
    private javax.swing.JDialog jdRegVenta;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblCancelar2C;
    private javax.swing.JLabel lblCotizacion;
    private javax.swing.JLabel lblCotizar;
    public static javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblRegVenta;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JSpinner sCosto;
    private javax.swing.JSpinner sIng1;
    private javax.swing.JSpinner sIng10;
    private javax.swing.JSpinner sIng2;
    private javax.swing.JSpinner sIng3;
    private javax.swing.JSpinner sIng4;
    private javax.swing.JSpinner sIng5;
    private javax.swing.JSpinner sIng6;
    private javax.swing.JSpinner sIng7;
    private javax.swing.JSpinner sIng8;
    private javax.swing.JSpinner sIng9;
    private javax.swing.JSpinner sIngredientes;
    private javax.swing.JSpinner sPrecio;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
