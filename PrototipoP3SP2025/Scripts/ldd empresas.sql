CREATE TABLE reservaciones (
    id_empresa int(11) NOT NULL,
    nombre_empresa varchar(60) NOT NULL,
    direccion varchar(60) NOT NULL,
    telefono varchar(25) NOT NULL,
    PRIMARY KEY (id_empresa)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
