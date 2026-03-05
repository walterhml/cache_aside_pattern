package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {

        DbInit.init();
        H2Console.start();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/users", exchange -> {

            String path = exchange.getRequestURI().getPath();
            Long id = Long.parseLong(path.split("/")[2]);

            long start = System.currentTimeMillis();

            String user = UserService.getUser(id);

            long time = System.currentTimeMillis() - start;

            String response = "User: " + user + "\nTempo: " + time + "ms";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Server rodando em http://localhost:8080");
    }
}