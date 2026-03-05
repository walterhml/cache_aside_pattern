package org.example;

import org.h2.tools.Server;

public class H2Console {

    public static void start() {

        try {

            Server.createWebServer(
                    "-web",
                    "-webAllowOthers",
                    "-webPort",
                    "8082"
            ).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}