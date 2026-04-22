CREATE TABLE PROVEEDOR (
    ID INT PRIMARY KEY,
    NOMBRE VARCHAR(50),
    RAZONSOCIAL VARCHAR(100),
    TELEFONO VARCHAR(20),
    CORREO VARCHAR(100)
);

INSERT INTO PROVEEDOR (ID, NOMBRE, RAZONSOCIAL, TELEFONO, CORREO) VALUES
(1, 'Distribuidora Animalia', 'Animalia S.A.', '0981-123456', 'contacto@animalia.com'),
(2, 'VetPro Insumos', 'VetPro SRL', '0981-654321', 'ventas@vetpro.com'),
(3, 'Mascotas y Más', 'Mascotas y Más Ltda.', '0981-789012', 'info@mascotasymas.com');
