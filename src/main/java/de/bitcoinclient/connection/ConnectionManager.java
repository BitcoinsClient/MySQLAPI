package de.bitcoinclient.connection;

import de.bitcoinclient.reader.Reader;
import de.bitcoinclient.writer.Writer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private final String host;
    private final String dbName;
    private final String dbUser;
    private final String dbUserPassword;
    private Connection connection = null;

    public ConnectionManager(String host, String dbName, String dbUser, String dbUserPassword) {
        this.host = host;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbUserPassword = dbUserPassword;

        try {
            create();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Versucht die Verbindung herzustellen
    public void create() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://"+ host +"/"+dbName+"?user="+dbUser+"&password="+dbUserPassword);
        connection.createStatement();
    }

    //return Die Verbindung zum Server
    public String getHost() {
        return host;
    }

    //return Den Datenbanken Name
    public String getName() {
        return dbName;
    }

    //return Das Passworts des Nutzers
    public String getUserPassword() {
        return dbUserPassword;
    }

    //return Den Nutzername des Nutzers für die Datenbank
    public String getUser() {
        return dbUser;
    }

    //return Die Verbindung zur Datenbank !Kann null sein!
    public Connection getConnection() {
        return connection;
    }

    //Kann die Elemente auslesen
    public Reader getReader() {
        return new Reader(this);
    }

    //Kan die Elemente schreiben
    public Writer getWriter() {
        return new Writer(this);
    }
}
