/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Reservacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservacionDAO {
    private static final String SQL_SELECT = "SELECT id_empresa, nombre, direccion, telefono FROM reservaciones";
    private static final String SQL_INSERT = "INSERT INTO reservaciones(id_empresa, nombre, direccion, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE reservaciones SET nombre=?, direccion=?, telefono=? WHERE id_empresa = ?";
    private static final String SQL_DELETE = "DELETE FROM reservaciones WHERE id_empresa=?";
    private static final String SQL_QUERY = "SELECT  id_empresa, nombre, direccion, telefono FROM reservaciones WHERE id_empresa = ?";

    public List<Reservacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reservacion reservacion = null;
        List<Reservacion> reservaciones = new ArrayList<Reservacion>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idEmpresa = rs.getString("id_empresa");
                String Nombre = rs.getString("nombre");
                String Direccion = rs.getString("direccion");
                String Telefono= rs.getString("telefono");
                
                reservacion = new Reservacion();
                reservacion.setId_empresa(idEmpresa);
                reservacion.setNombre(Nombre);
                reservacion.setDireccion(Direccion);
                reservacion.setTelefono(Telefono);
                
                reservaciones.add(reservacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return reservaciones;
    }

    public int insert(Reservacion reservacion) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, reservacion.getId_empresa());
            stmt.setString(2, reservacion.getNombre());
            stmt.setString(3, reservacion.getDireccion());
            stmt.setString(4, reservacion.getTelefono());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Reservacion reservacion) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query: " + SQL_UPDATE);
        stmt = conn.prepareStatement(SQL_UPDATE);
        
        stmt.setString(1, reservacion.getNombre());
        stmt.setString(2, reservacion.getDireccion());
        stmt.setString(3, reservacion.getTelefono());
        stmt.setString(4, reservacion.getId_empresa()); // Correcto aquí

        rows = stmt.executeUpdate();
        System.out.println("Registros actualizados: " + rows);

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return rows;
}


    public int delete(Reservacion reservacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, reservacion.getId_empresa());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Reservacion query(Reservacion reservacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, reservacion.getId_empresa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idEmpresa = rs.getString("id_empresa");
                String Nombre = rs.getString("nombre");
                String Direccion = rs.getString("direccion");
                String Telefono= rs.getString("telefono");
                
                reservacion = new Reservacion();
               stmt.setString(1, reservacion.getId_empresa());
                stmt.setString(2, reservacion.getNombre());
               stmt.setString(3, reservacion.getDireccion());
             stmt.setString(4, reservacion.getTelefono());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return reservacion; 
    }
}