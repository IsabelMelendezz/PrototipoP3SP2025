/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.seguridad;


import Modelo.seguridad.ReservacionDAO;
import Controlador.seguridad.Reservacion;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import Controlador.seguridad.Bitacora;
import Controlador.seguridad.UsuarioConectado;

public class MantenimientoReservacion extends javax.swing.JInternalFrame {
    final int APLICACION = 202; // ID diferente para reservaciones

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id empresa");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        List<Reservacion> reservaciones = reservacionDAO.select();
        
        tablaReservaciones.setModel(modelo);
        String[] dato = new String[4];
        for (int i = 0; i < reservaciones.size(); i++) {
            dato[0] = reservaciones.get(i).getId_empresa();
            dato[1] = reservaciones.get(i).getNombre();
            dato[2] = reservaciones.get(i).getDireccion();
            dato[3] = reservaciones.get(i).getTelefono();
            modelo.addRow(dato);
        }
    }

    public void buscarReservacion() {
        Reservacion reservacionAConsultar = new Reservacion();
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        reservacionAConsultar.setId_empresa(txtbuscado.getText());
        reservacionAConsultar = reservacionDAO.query(reservacionAConsultar);
        
        txtCodigoHabitacion.setText(reservacionAConsultar.getDireccion());
        txtNombreHabitacion.setText(reservacionAConsultar.getNombre());
        txtNombreCliente.setText(reservacionAConsultar.getTelefono());
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        Bitacora bitacoraRegistro = new Bitacora();
        bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION, "Consulta Datos Reservación");
    }

    public MantenimientoReservacion() {
        initComponents();
        llenadoDeTablas();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Componentes de la interfaz
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtNombreHabitacion = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservaciones = new javax.swing.JTable();
        label2 = new javax.swing.JLabel();
        txtCodigoHabitacion = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        txtCodigoReservacion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Empresas");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12));
        label1.setText("Reservaciones");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12));
        label3.setText("Telefono");

        txtNombreHabitacion.setFont(new java.awt.Font("Century Gothic", 0, 12));
        txtNombreHabitacion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaReservaciones.setFont(new java.awt.Font("Century Gothic", 0, 12));
        tablaReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id empresa", "Nombre", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tablaReservaciones);

        label2.setFont(new java.awt.Font("Century Gothic", 1, 12));
        label2.setText("Nombre Empresa");

        txtCodigoHabitacion.setFont(new java.awt.Font("Century Gothic", 0, 12));
        txtCodigoHabitacion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12));
        label4.setText("Direccion");

        txtNombreCliente.setFont(new java.awt.Font("Century Gothic", 0, 12));
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12));
        label5.setText("Id Empresa");

        txtCodigoReservacion.setFont(new java.awt.Font("Century Gothic", 0, 12));
        txtCodigoReservacion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(txtCodigoReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(txtCodigoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(txtNombreHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        Reservacion reservacionAEliminar = new Reservacion();
        reservacionAEliminar.setId_empresa(txtbuscado.getText());
        reservacionDAO.delete(reservacionAEliminar);
        llenadoDeTablas();
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        Bitacora bitacoraRegistro = new Bitacora();
        bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION, "Borrar Datos Reservación");
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        Reservacion reservacionAInsertar = new Reservacion();
        reservacionAInsertar.setId_empresa(txtCodigoReservacion.getText());
        reservacionAInsertar.setNombre(txtCodigoHabitacion.getText());
        reservacionAInsertar.setDireccion(txtNombreHabitacion.getText());
        reservacionAInsertar.setTelefono(txtNombreCliente.getText());
        reservacionDAO.insert(reservacionAInsertar);
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        Bitacora bitacoraRegistro = new Bitacora();
        bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION, "Ingreso Datos Reservación");
        llenadoDeTablas();
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        buscarReservacion();
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        Reservacion reservacionAActualizar = new Reservacion();
        reservacionAActualizar.setId_empresa(txtbuscado.getText());
        reservacionAActualizar.setNombre(txtCodigoHabitacion.getText());
        reservacionAActualizar.setDireccion(txtNombreHabitacion.getText());
        reservacionAActualizar.setTelefono(txtNombreCliente.getText());
        reservacionDAO.update(reservacionAActualizar);
        llenadoDeTablas();
        
        UsuarioConectado usuarioEnSesion = new UsuarioConectado();
        Bitacora bitacoraRegistro = new Bitacora();
        bitacoraRegistro.setIngresarBitacora(usuarioEnSesion.getIdUsuario(), APLICACION, "Actualización Datos Reservación");
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        txtCodigoReservacion.setText("");
        txtCodigoHabitacion.setText("");
        txtNombreHabitacion.setText("");
        txtNombreCliente.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JTable tablaReservaciones;
    private javax.swing.JTextField txtCodigoHabitacion;
    private javax.swing.JTextField txtCodigoReservacion;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreHabitacion;
    private javax.swing.JTextField txtbuscado;
}