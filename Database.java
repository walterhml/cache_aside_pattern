package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:h2:./testdb";

    public static String findUser(Long id) {

        try {

            Connection conn = DriverManager.getConnection(URL, "sa", "");

            Statement stmt = conn.createStatement();

            Thread.sleep(3000); // tempo de demora

            ResultSet rs = stmt.executeQuery(
                    "SELECT name FROM users WHERE id = " + id
            );

            if (rs.next()) {
                return rs.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}