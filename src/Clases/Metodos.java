/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */

//Esta clase contiene todos los metodos para trabajar con la interfaz y la base de datos
public class Metodos {
    
    public static Connection con;
    public static Statement st;
    //paramtros a usar
    
    //metodo para conectar con la BD no recibe ningún parámetro
    public static void ConectarBD(){
    try {
            //Nombre del driver para conectar MySQL con Java
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*Nombre del servidor, base de datos que se quiere emplear, 
            usuario y contraseña con la que se conecta al servidor*/
            con = DriverManager.getConnection("jdbc:mysql://localhost/alphamanagersd","root","1324");
        } catch (ClassNotFoundException ex) {
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
            showMessageDialog(null, "Ocurrio un error inesperado "+ex);
            return;
        } catch (SQLException ex) {
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
            showMessageDialog(null, "Error al conectar \n"+ex);
            return;
        }
    }//Metodo para conectar con MySQL
    
    //Método para ejecutar cualquier sentencia DML que no sea SELECT.
    //recibe la sentencia SQL a ejecutar y el JFrame donde se ejecuta (this).
    public static void RUD(String query, JFrame JF){
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //Ejecuta la sentencia DML INSERT INTO con los parametros recibidos
            st.executeUpdate(query); 
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Ocurrio un error inesperado "+ex);
            return;
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        showMessageDialog(JF, "Operación finalizada con éxito.");
    }//Metodo para ejecutar INSERT, UPDATE y DELETE.
    
    /*public static void main(String[] args) {
        ConectarBD();
    }Descongelar si necesitan probar algún método*/
    
    //metodo para cambiar de una ventana a otra recibe como parametros dos Jframes
    public static void Cambiar_Ventana(JFrame JF1, JFrame JF2){
        /*Nota primero deben crear un objeto de la clase(ventana) que van a abrir
        Ejemplo: Principal pr = new Principal();
        Principal (nombre de la interfaz) pr (nombre de la instancia)*/ 
        JF1.setVisible(true);//Abre el primer jframe que recibe 
        JF2.dispose();//Cierra el segundo jframe que recibe
    }//Metodo para cambiar de ventana
    
    //metodo para abir un jdialog recibe un jframe, el jdialog a abrir y dos enteros para el ancho y alto.
    public static void Abrir_Dialogo(JDialog JD, JFrame JF, int Ancho, int Alto){
        JD.setSize(Ancho, Alto);
        JD.setLocationRelativeTo(JF);//posiciona el cuadro de diálogo en el centro de la ventana.
        JD.setVisible(true);
        JD.requestFocus();
    }//Metodo para abrir un cuadro de dialogo
    
    //meetodo para vaciar una tabla recibe un modelo de tabla y una tabla (JTable) 
    public static void vaciarTabla(DefaultTableModel Modelo, JTable JT){
        //Inicializamos la tabla con un modelo
        Modelo = (DefaultTableModel) JT.getModel();
        int i = 0;
        while(i < Modelo.getRowCount()){
            Modelo.removeRow(i);
        }//metodo while para remover los renglones de la tabla
    }//metodo para vaciar una tabla
    
    /*metodo para validar que un jtext no este vacío, recibe 1 JTexField, 1 JFrame
    Y 1 String, que es el nombre del campo.*/
    public static boolean validarCampo(JTextField JTF, JFrame JF, String Nombre){
        if(JTF.getText().isBlank()){//Compara si hay algo escrito en el campo, ademas de espacios
            showMessageDialog(JF, Nombre+" requerido");//Manda un mensaje
            JTF.requestFocus();//Manda la atención al jtext
            return true;
        }//if
        return false;
    }//metodo para validar cualquier campo que no deba ir vacio
    
    //recibe el txt a reiniciar y el texto original
    public static void reiniciarTxt(JTextField JTF, String campo){
        JTF.setForeground(Color.gray);
        JTF.setText(campo);
    }//metodo para reiniciar txt
    
    //recibe el txt a usar
    public static void usarTxt(JTextField JTF){
        JTF.setText("");
        JTF.setForeground(Color.black);
    }//metodo usar txt
}//clase metodos

/*//Ejemplo de como hacer una consulta a la BD
    Recibe dos parametros la sentencia SQL a ejecutar y el jframe donde se ejecuta (this)
    public Object[] consulta(String query, JFrame JF){
        //el tamaño del vector cambia en función de los campos de la tabla
        Object Nombres [] = new Object [4];
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Nombres[0] = rs.getInt(1);
                Nombres[1] = rs.getString(2);
                Nombres[2] = rs.getString(3);
                Nombres[3] = rs.getString(4);
                //el tipo de dato varia en función del campo al que correponde
                //el numero de instrucciones debe coincidir con el total de campos consultados 
            }//ciclo while guarda los valores obtenidos de la consulta en las varibables que se muestran.
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Error en "+ex);
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        return Nombres;
    }//READ*/

/*  //Ejemplo de como llenar una tabla de cualquier interfaz
    No recibe ningún parametro 
    private void llenarTabla(){
        //Inicializamos la tabla con un modelo
        Tabla = (DefaultTableModel) TblDiscografia.getModel();
        //arreglo para almacenar el resultado de cada campo varia de acuerdo a los campos a consultar
        Object [] row = new Object[4];
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //sentencia SELECT a ejecutar
            String query = "SELECT * FROM tabla";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                Tabla.addRow(row);
                //el tipo de dato varia en función del campo al que correponde
                //el numero de instrucciones debe coincidir con el total de campos en la tabla
            }//ciclo while guarda los valores obtenidos de la consulta en las varibables que se muestran.
        } catch (SQLException ex) {
            showMessageDialog(this, "Error en "+ex);
            System.exit(EXIT_ON_CLOSE);
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
    }//metodo para llenar la tabla donde se visualizan los datos*/