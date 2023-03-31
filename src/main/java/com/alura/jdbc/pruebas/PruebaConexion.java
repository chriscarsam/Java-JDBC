package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://172.17.0.2/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "user",
                "clave");

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
