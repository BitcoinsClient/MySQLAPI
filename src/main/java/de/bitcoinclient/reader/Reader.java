package de.bitcoinclient.reader;

import de.bitcoinclient.connection.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reader {
    private final ConnectionManager connectionManager;

    public Reader(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public int getAsInt(String table, String column, String searchID, String searchValue, int limit) {
        int selection = 0;
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"' limit " + limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }
    public int getAsInt(String table, String column, String searchID, String searchValue) {
        int selection = 0;
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }

    public String getAsString(String table, String column, String searchID, String searchValue, int limit) {
        String selection = "";
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"' limit " + limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }
    public String getAsString(String table, String column, String searchID, String searchValue) {
        String selection = "";
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }

    public long getAsLong(String table, String column, String searchID, String searchValue, int limit) {
        long selection = 0;
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"' limit " + limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }
    public long getAsLong(String table, String column, String searchID, String searchValue) {
        long selection = 0;
        if(connectionManager.getConnection() == null) {
            return selection;
        }
        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("SELECT " + column + " FROM " + table + " WHERE "+searchID+" = '"+searchValue+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                selection = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selection;
    }
}
