package de.bitcoinclient;

import de.bitcoinclient.connection.ConnectionManager;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager("localhost", "manager", "manager", "Z8YvdBDMDtsv3xBa");
        HashMap<String, Object> items = new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        items.put("UUID", uuid);
        items.put("name", "BitcoinsClient");
        items.put("coins", new Random().nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE));
        items.put("ontime", "0");
        connectionManager.getWriter().insert("users",items);
        connectionManager.getWriter().update("users","name","Hans","UUID",uuid);
    }
}