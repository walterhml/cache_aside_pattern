package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbInit {

    public static void init() {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:h2:./testdb",
                    "sa",
                    ""
            );

            Statement stmt = conn.createStatement();

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users(
                    id INT PRIMARY KEY,
                    name VARCHAR(100)
                )
            """);

            stmt.execute("""
                MERGE INTO users KEY(id)
                VALUES (1,'Ana'), (2,'Carlos')
            """);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}