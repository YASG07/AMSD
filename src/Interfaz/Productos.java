/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.Metodos;
import static Clases.Metodos.con;
import static Clases.Metodos.st;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        Metodos.ConectarBD();
        llenarTabla();
        if(Login.Rol == 2)
            lblRMenu.setVisible(false);
    }

    int idc;
    DefaultTableModel m;

    private void llenarTabla() {
        //Inicializamos la tabla con un modelo
        DefaultTableModel Tabla = (DefaultTableModel) tblProductos.getModel();
        //arreglo para almacenar el resultado de cada campo varia de acuerdo a los campos a consultar
        Object[] row = new Object[8];
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //sentencia SELECT a ejecutar
            String query = "SELECT * FROM Productos";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            rs = st.executeQuery(query);
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getInt(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getDate(8);

                Tabla.addRow(row);
                //el tipo de dato varia en función del campo al que correponde
                //el numero de instrucciones debe coincidir con el total de campos en la tabla
            }//ciclo while guarda los valores obtenidos de la consulta en las varibables que se muestran.
        } catch (SQLException ex) {
            showMessageDialog(this, "Error en " + ex);
            System.exit(EXIT_ON_CLOSE);
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
    }

    private void borrarDatos() {
        int fila = tblProductos.getSelectedRow();
        try {
            if (fila < 0) {
                showMessageDialog(null, "No ha seleccionado un producto");
            } else {
                String query = "DELETE FROM PRODUCTOS where idProduc=" + idc;
                st = con.createStatement();
                st.executeUpdate(query);

                showMessageDialog(null, "Producto eliminado");

            }
        } catch (SQLException e) {
            showMessageDialog(null, "Ocurrio un error con la consulta" + e);
        }
    }

    private void registrar() {
        String nomP = txtNombreRp.getText();
        String Prepa = txtPrepaRp.getText();
        String tipoP = txtTipoRp.getText();
        int costoP = Integer.parseInt(txtCostoRp.getText());
        int precioP = Integer.parseInt(txtPrecioRp.getText());
        int existP = Integer.parseInt(txtExistenciaRp.getText());
        String fechaEx = txtFechaExpRp.getText();
        try {
            String sql = "INSERT INTO PRODUCTOS(nombre_produc,preparacion_produc,tipo_produc,costo_produc,precio_produc, existencia, FchExpira)"
                    + "VALUES ('" + nomP + "','" + Prepa + "','" + tipoP + "','" + costoP + "','" + precioP + "','" + existP + "','" + fechaEx + "')";
            st = con.createStatement();
            st.executeUpdate(sql);
            showMessageDialog(null, "Producto Registrado");
        } catch (SQLException ex) {
            showMessageDialog(null, "Ocurrio un error en la consulta" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDAcProd = new javax.swing.JDialog();
        txtNomAc = new javax.swing.JTextField();
        txtExisAc = new javax.swing.JTextField();
        txtCostoAc = new javax.swing.JTextField();
        txtPrecioAc = new javax.swing.JTextField();
        txtFechaExAc = new javax.swing.JTextField();
        txtTipoAc = new javax.swing.JTextField();
        txtPrepaAc = new javax.swing.JTextField();
        lblActualizarJDAc = new javax.swing.JLabel();
        lblRegresarJDAc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDArProd = new javax.swing.JDialog();
        txtNombreRp = new javax.swing.JTextField();
        txtExistenciaRp = new javax.swing.JTextField();
        txtCostoRp = new javax.swing.JTextField();
        txtPrecioRp = new javax.swing.JTextField();
        txtFechaExpRp = new javax.swing.JTextField();
        txtTipoRp = new javax.swing.JTextField();
        txtPrepaRp = new javax.swing.JTextField();
        lblRegistrarJDRp = new javax.swing.JLabel();
        lblRegresarJDRp = new javax.swing.JLabel();
        lblRMenu = new javax.swing.JLabel();
        lblInsumos = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jcCriBusqueda = new javax.swing.JComboBox<>();
        lblGuardar = new javax.swing.JLabel();
        lblActualizar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        jDAcProd.setTitle("Actualizar Producto");
        jDAcProd.setLocation(new java.awt.Point(0, 0));
        jDAcProd.setMinimumSize(new java.awt.Dimension(430, 430));
        jDAcProd.setResizable(false);

        txtNomAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNomAc.setForeground(new java.awt.Color(150, 150, 150));
        txtNomAc.setText("Nombre:");
        txtNomAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomAcKeyTyped(evt);
            }
        });

        txtExisAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtExisAc.setForeground(new java.awt.Color(150, 150, 150));
        txtExisAc.setText("Existencia:");
        txtExisAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExisAcKeyTyped(evt);
            }
        });

        txtCostoAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCostoAc.setForeground(new java.awt.Color(150, 150, 150));
        txtCostoAc.setText("Costo:");
        txtCostoAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoAcKeyTyped(evt);
            }
        });

        txtPrecioAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecioAc.setForeground(new java.awt.Color(150, 150, 150));
        txtPrecioAc.setText("Precio:");
        txtPrecioAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioAcKeyTyped(evt);
            }
        });

        txtFechaExAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaExAc.setForeground(new java.awt.Color(150, 150, 150));
        txtFechaExAc.setText("Fecha de expiración:");
        txtFechaExAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaExAcKeyTyped(evt);
            }
        });

        txtTipoAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoAc.setForeground(new java.awt.Color(150, 150, 150));
        txtTipoAc.setText("Tipo:");
        txtTipoAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoAcKeyTyped(evt);
            }
        });

        txtPrepaAc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrepaAc.setForeground(new java.awt.Color(150, 150, 150));
        txtPrepaAc.setText("Preparación:");
        txtPrepaAc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrepaAcKeyTyped(evt);
            }
        });

        lblActualizarJDAc.setText("Act. regis");
        lblActualizarJDAc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActualizarJDAcMouseClicked(evt);
            }
        });

        lblRegresarJDAc.setText("Ic. Salir");
        lblRegresarJDAc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarJDAcMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Costo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de Exp.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tipo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Preparación");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Existencia");

        javax.swing.GroupLayout jDAcProdLayout = new javax.swing.GroupLayout(jDAcProd.getContentPane());
        jDAcProd.getContentPane().setLayout(jDAcProdLayout);
        jDAcProdLayout.setHorizontalGroup(
            jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDAcProdLayout.createSequentialGroup()
                .addComponent(lblRegresarJDAc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(lblActualizarJDAc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDAcProdLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDAcProdLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaExAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jDAcProdLayout.createSequentialGroup()
                            .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDAcProdLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))
                            .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrecioAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtExisAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtCostoAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDAcProdLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipoAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDAcProdLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrepaAc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jDAcProdLayout.setVerticalGroup(
            jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDAcProdLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExisAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaExAc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrepaAc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDAcProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegresarJDAc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActualizarJDAc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jDArProd.setTitle("Guardar producto");
        jDArProd.setLocation(new java.awt.Point(0, 0));
        jDArProd.setMinimumSize(new java.awt.Dimension(430, 430));
        jDArProd.setResizable(false);

        txtNombreRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreRp.setForeground(new java.awt.Color(150, 150, 150));
        txtNombreRp.setText("Nombre:");
        txtNombreRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRpKeyTyped(evt);
            }
        });

        txtExistenciaRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtExistenciaRp.setForeground(new java.awt.Color(150, 150, 150));
        txtExistenciaRp.setText("Existencia:");
        txtExistenciaRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaRpKeyTyped(evt);
            }
        });

        txtCostoRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCostoRp.setForeground(new java.awt.Color(150, 150, 150));
        txtCostoRp.setText("Costo:");
        txtCostoRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoRpKeyTyped(evt);
            }
        });

        txtPrecioRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecioRp.setForeground(new java.awt.Color(150, 150, 150));
        txtPrecioRp.setText("Precio:");
        txtPrecioRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioRpKeyTyped(evt);
            }
        });

        txtFechaExpRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaExpRp.setForeground(new java.awt.Color(150, 150, 150));
        txtFechaExpRp.setText("Fecha de esxpiración:");
        txtFechaExpRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaExpRpKeyTyped(evt);
            }
        });

        txtTipoRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoRp.setForeground(new java.awt.Color(150, 150, 150));
        txtTipoRp.setText("Tipo:");
        txtTipoRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoRpKeyTyped(evt);
            }
        });

        txtPrepaRp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrepaRp.setForeground(new java.awt.Color(150, 150, 150));
        txtPrepaRp.setText("Preparación:");
        txtPrepaRp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrepaRpKeyTyped(evt);
            }
        });

        lblRegistrarJDRp.setText("Ic. Registrar");
        lblRegistrarJDRp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarJDRpMouseClicked(evt);
            }
        });

        lblRegresarJDRp.setText("Ic. Salir");
        lblRegresarJDRp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarJDRpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDArProdLayout = new javax.swing.GroupLayout(jDArProd.getContentPane());
        jDArProd.getContentPane().setLayout(jDArProdLayout);
        jDArProdLayout.setHorizontalGroup(
            jDArProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDArProdLayout.createSequentialGroup()
                .addComponent(lblRegresarJDRp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegistrarJDRp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDArProdLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jDArProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrepaRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaExpRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExistenciaRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreRp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDArProdLayout.setVerticalGroup(
            jDArProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDArProdLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtNombreRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtExistenciaRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCostoRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrecioRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFechaExpRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTipoRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrepaRp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jDArProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrarJDRp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegresarJDRp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");

        lblRMenu.setText("Ic. Menú");
        lblRMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRMenuMouseClicked(evt);
            }
        });

        lblInsumos.setText("Ic. Insumos");
        lblInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsumosMouseClicked(evt);
            }
        });

        lblBuscar.setText("Ic. Buscar");
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });

        jcCriBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcCriBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Criterio de búsqueda", "Nombre", "Precio", "Tipo" }));

        lblGuardar.setText("Ic. Guardar");
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        lblActualizar.setText("Ic. Actualizar");
        lblActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActualizarMouseClicked(evt);
            }
        });

        lblEliminar.setText("Ic. Eliminar");
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Prod.", "Preparacion", "Tipo Prod", "Costo Elaboracion", "Precio Producto", "Existencia", "Fecha de Expiracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcCriBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                        .addGap(100, 100, 100)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcCriBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        borrarDatos();
        Metodos.vaciarTabla(m, tblProductos);
        llenarTabla();
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int fila = tblProductos.getSelectedRow();
        if (fila == -1) {
            showMessageDialog(null, "No ha seleccionado un producto");
        } else {
            idc = Integer.parseInt((String) tblProductos.getValueAt(fila, 0).toString());
            String nomP = (String) tblProductos.getValueAt(fila, 1);
            String Prepa = (String) tblProductos.getValueAt(fila, 2);
            String TipoP = (String) tblProductos.getValueAt(fila, 3);
            int CostoPr = (int) tblProductos.getValueAt(fila, 4);
            int PrecioP = (int) tblProductos.getValueAt(fila, 5);
            int existen = (int) tblProductos.getValueAt(fila, 6);
            Date fechEx = (Date) tblProductos.getValueAt(fila, 7);

            txtNomAc.setText(nomP);
            txtExisAc.setText("" + existen);
            txtCostoAc.setText("" + CostoPr);
            txtPrecioAc.setText("" + PrecioP);
            txtFechaExAc.setText("" + fechEx);
            txtTipoAc.setText(TipoP);
            txtPrepaAc.setText(Prepa);
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void lblActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseClicked
        jDAcProd.setVisible(true);
        jDAcProd.setLocationRelativeTo(this);
    }//GEN-LAST:event_lblActualizarMouseClicked

    private void lblRMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRMenuMouseClicked
        Principal pc = new Principal();
        Metodos.Cambiar_Ventana(pc, this);
    }//GEN-LAST:event_lblRMenuMouseClicked

    private void lblInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsumosMouseClicked
        Insumos in = new Insumos();
        Metodos.Cambiar_Ventana(in, this);
    }//GEN-LAST:event_lblInsumosMouseClicked

    private void lblRegresarJDAcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarJDAcMouseClicked
        jDAcProd.dispose();
    }//GEN-LAST:event_lblRegresarJDAcMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        jDArProd.setVisible(true);
        jDArProd.setLocationRelativeTo(this);
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void lblRegresarJDRpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarJDRpMouseClicked
        jDArProd.dispose();
    }//GEN-LAST:event_lblRegresarJDRpMouseClicked

    private void lblRegistrarJDRpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarJDRpMouseClicked
        registrar();
        Metodos.vaciarTabla(m, tblProductos);
        llenarTabla();
    }//GEN-LAST:event_lblRegistrarJDRpMouseClicked

    private void txtCostoRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '.') {
            if (key == KeyEvent.VK_ENTER) {
                txtPrecioRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        ////

    }//GEN-LAST:event_txtCostoRpKeyTyped

    private void txtPrecioRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '.') {
            if (key == KeyEvent.VK_ENTER) {
                txtFechaExpRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        //// 
    }//GEN-LAST:event_txtPrecioRpKeyTyped

    private void txtFechaExpRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaExpRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '-') {
            if (key == KeyEvent.VK_ENTER) {
                txtTipoRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        ////
    }//GEN-LAST:event_txtFechaExpRpKeyTyped

    private void txtPrepaRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrepaRpKeyTyped
        
    }//GEN-LAST:event_txtPrepaRpKeyTyped

    private void txtTipoRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isLetter(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtPrepaRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo letras");
        }
        ////  
    }//GEN-LAST:event_txtTipoRpKeyTyped

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked

        if (jcCriBusqueda.getSelectedItem().toString().equals("Criterio de búsqueda")) {
            showMessageDialog(this, "Favor de Elegir un Criterio de Búsqueda");
        } else {
            if (jcCriBusqueda.getSelectedItem().toString().equals("Nombre")) {
                String titulos[] = {"idProduc", "nombre_produc", "preparacion_produc", "tipo_produc", "costo_produc", "precio_produc", "existencia", "FchExpira"};
                Object[] row = new Object[8];
                try {
                    String sqlN = "SELECT * FROM Productos WHERE nombre_produc LIKE '%" + txtBuscar.getText() + "%'";
                    st = con.createStatement();
                    DefaultTableModel Tabla = new DefaultTableModel(null, titulos);
                    ResultSet rs = st.executeQuery(sqlN);
                    while (rs.next()) {
                        row[0] = rs.getInt("idProduc");
                        row[1] = rs.getString("nombre_produc");
                        row[2] = rs.getString("preparacion_produc");
                        row[3] = rs.getString("tipo_produc");
                        row[4] = rs.getInt("costo_produc");
                        row[5] = rs.getInt("precio_produc");
                        row[6] = rs.getInt("existencia");
                        row[7] = rs.getDate("FchExpira");

                        Tabla.addRow(row);
                    }

                    tblProductos.setModel(Tabla);
                } catch (SQLException ex) {
                    showMessageDialog(this, "Error al filtrar los datos" + ex.getMessage(), "Error", ERROR_MESSAGE);
                }
            } else {
                if (jcCriBusqueda.getSelectedItem().toString().equals("Precio")) {
                    String titulos[] = {"idProduc", "nombre_produc", "preparacion_produc", "tipo_produc", "costo_produc", "precio_produc", "existencia", "FchExpira"};
                    Object[] row = new Object[8];
                    try {
                        String sqlN = "SELECT * FROM Productos WHERE precio_produc LIKE '%" + txtBuscar.getText() + "%'";
                        st = con.createStatement();
                        DefaultTableModel Tabla = new DefaultTableModel(null, titulos);
                        ResultSet rs = st.executeQuery(sqlN);
                        while (rs.next()) {
                            row[0] = rs.getInt("idProduc");
                            row[1] = rs.getString("nombre_produc");
                            row[2] = rs.getString("preparacion_produc");
                            row[3] = rs.getString("tipo_produc");
                            row[4] = rs.getInt("costo_produc");
                            row[5] = rs.getInt("precio_produc");
                            row[6] = rs.getInt("existencia");
                            row[7] = rs.getDate("FchExpira");

                            Tabla.addRow(row);
                        }

                        tblProductos.setModel(Tabla);
                    } catch (SQLException ex) {
                        showMessageDialog(this, "Error al filtrar los datos" + ex.getMessage(), "Error", ERROR_MESSAGE);
                    }
                } else {
                    if (jcCriBusqueda.getSelectedItem().toString().equals("Tipo")) {
                        String titulos[] = {"idProduc", "nombre_produc", "preparacion_produc", "tipo_produc", "costo_produc", "precio_produc", "existencia", "FchExpira"};
                        Object[] row = new Object[8];
                        try {
                            String sqlN = "SELECT * FROM Productos WHERE tipo_produc LIKE '%" + txtBuscar.getText() + "%'";
                            st = con.createStatement();
                            DefaultTableModel Tabla = new DefaultTableModel(null, titulos);
                            ResultSet rs = st.executeQuery(sqlN);
                            while (rs.next()) {
                                row[0] = rs.getInt("idProduc");
                                row[1] = rs.getString("nombre_produc");
                                row[2] = rs.getString("preparacion_produc");
                                row[3] = rs.getString("tipo_produc");
                                row[4] = rs.getInt("costo_produc");
                                row[5] = rs.getInt("precio_produc");
                                row[6] = rs.getInt("existencia");
                                row[7] = rs.getDate("FchExpira");

                                Tabla.addRow(row);
                            }

                            tblProductos.setModel(Tabla);
                        } catch (SQLException ex) {
                            showMessageDialog(this, "Error al filtrar los datos" + ex.getMessage(), "Error", ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_lblBuscarMouseClicked
    private void actualizar() {

        try {
            String sql = "UPDATE PRODUCTOS SET nombre_produc = ?, preparacion_produc = ?, tipo_produc = ?, costo_produc = ?, precio_produc = ?, existencia = ?, FchExpira = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtNomAc.getText());
            pst.setString(2, txtPrepaAc.getText());
            pst.setString(3, txtTipoAc.getText());
            pst.setFloat(4, Float.parseFloat(txtCostoAc.getText()));
            pst.setFloat(5, Float.parseFloat(txtPrecioAc.getText()));
            pst.setInt(6, Integer.parseInt(txtExisAc.getText()));
            pst.setString(7, txtFechaExAc.getText());
            int n = pst.executeUpdate();
            if (n > 0) {
                showMessageDialog(this, "Producto Actualizado");
            } else {
                showMessageDialog(this, "Ocurrio un error al modificar");
            }
        } catch (SQLException e) {
            showMessageDialog(this, e);
        } catch (NumberFormatException e) {

        }
    }
    private void lblActualizarJDAcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarJDAcMouseClicked
        actualizar();
        Metodos.vaciarTabla(m, tblProductos);
        llenarTabla();
    }//GEN-LAST:event_lblActualizarJDAcMouseClicked

    private void txtExistenciaRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtCostoRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
    }//GEN-LAST:event_txtExistenciaRpKeyTyped

    private void txtNombreRpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRpKeyTyped
        int key = evt.getKeyChar();
        if (Character.isLetter(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtExistenciaRp.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo Letras");
        }
    }//GEN-LAST:event_txtNombreRpKeyTyped

    private void txtNomAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomAcKeyTyped
        int key = evt.getKeyChar();
        if (Character.isLetter(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtExisAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo Letras");
        }
    }//GEN-LAST:event_txtNomAcKeyTyped

    private void txtExisAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExisAcKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtCostoAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
    }//GEN-LAST:event_txtExisAcKeyTyped

    private void txtCostoAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoAcKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '.') {
            if (key == KeyEvent.VK_ENTER) {
                txtPrecioAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        ////
    }//GEN-LAST:event_txtCostoAcKeyTyped

    private void txtPrecioAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioAcKeyTyped
        int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '.') {
            if (key == KeyEvent.VK_ENTER) {
                txtFechaExAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        ////
    }//GEN-LAST:event_txtPrecioAcKeyTyped

    private void txtFechaExAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaExAcKeyTyped
       int key = evt.getKeyChar();
        if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER || key == '-') {
            if (key == KeyEvent.VK_ENTER) {
                txtTipoAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo números");
        }
        //// 
    }//GEN-LAST:event_txtFechaExAcKeyTyped

    private void txtTipoAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoAcKeyTyped
       int key = evt.getKeyChar();
        if (Character.isLetter(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
            if (key == KeyEvent.VK_ENTER) {
                txtPrepaAc.requestFocus();
            }
        } else {
            evt.consume();
            showMessageDialog(this, "Por favor introducir solo letras");
        }
        ////  
    }//GEN-LAST:event_txtTipoAcKeyTyped

    private void txtPrepaAcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrepaAcKeyTyped
        
    }//GEN-LAST:event_txtPrepaAcKeyTyped

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDialog jDAcProd;
    public javax.swing.JDialog jDArProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCriBusqueda;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblActualizarJDAc;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblInsumos;
    private javax.swing.JLabel lblRMenu;
    private javax.swing.JLabel lblRegistrarJDRp;
    private javax.swing.JLabel lblRegresarJDAc;
    private javax.swing.JLabel lblRegresarJDRp;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCostoAc;
    private javax.swing.JTextField txtCostoRp;
    private javax.swing.JTextField txtExisAc;
    private javax.swing.JTextField txtExistenciaRp;
    private javax.swing.JTextField txtFechaExAc;
    private javax.swing.JTextField txtFechaExpRp;
    private javax.swing.JTextField txtNomAc;
    private javax.swing.JTextField txtNombreRp;
    private javax.swing.JTextField txtPrecioAc;
    private javax.swing.JTextField txtPrecioRp;
    private javax.swing.JTextField txtPrepaAc;
    private javax.swing.JTextField txtPrepaRp;
    private javax.swing.JTextField txtTipoAc;
    private javax.swing.JTextField txtTipoRp;
    // End of variables declaration//GEN-END:variables
}
