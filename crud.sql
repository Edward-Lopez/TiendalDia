delete from tiendaaldia.usuarios where idUsuarios = 6;
INSERT INTO tiendaaldia.usuarios (nombresUsuarios, apellidosUsuarios, tipoIdentificacion, identificacion, direccionUsuarios, telefonoUsuarios, correoUsuarios) 
    VALUES (6, 'Kelly', "Valdéz", "CC", "1024590061", "Kr 32 79-18","3115647420", "kellinda@gmail.com");
update tiendaaldia.usuarios SET apellidosUsuarios = "Paniagua", tipoIdentificacion = "PA" where idUsuarios = 4;
SELECT * FROM tiendaaldia.usuarios;