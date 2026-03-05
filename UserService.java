package org.example;

import redis.clients.jedis.Jedis;

public class UserService {

    private static Jedis redis = new Jedis("localhost", 6379);

    public static String getUser(Long id) {

        String key = "user:" + id;

        String cached = redis.get(key);

        if (cached != null) {
            System.out.println("CACHE HIT");
            return cached;
        }

        System.out.println("CACHE MISS");

        String user = Database.findUser(id);

        redis.setex(key, 20, user); // ttl com 20 segundos

        return user;
    }
}