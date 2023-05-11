package de.bitcoinclient.writer;

import de.bitcoinclient.connection.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Writer {
    private final ConnectionManager connectionManager;

    public Writer(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void insert(String table, HashMap<String, Object> values) {
        final int[] up = {0};
        final String[] value = {"("};
        final String[] items = {"("};
        HashMap<Integer, Object> temp = new HashMap<>();

        values.forEach((s, o) -> {
            if(up[0] == 0) {
                value[0] = value[0] + s;
                items[0] = items[0] + "?";
            } else {
                value[0] = value[0]+", "+s;
                items[0] = items[0]+", " + "?";
            }
            temp.put(up[0], o);
            up[0] = up[0] + 1;
        });
        value[0] = value[0]+")";
        items[0] = items[0]+")";

        try {
            PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement("INSERT INTO " + table + " " + value[0]+" VALUES "+items[0]);
            temp.forEach((integer, o) -> {
                try {
                    if(o instanceof String) {
                        preparedStatement.setString(integer+1, (String) o);
                    }
                    if(o instanceof Integer) {
                        preparedStatement.setInt(integer+1, (int) o);
                    }
                    if(o instanceof Long) {
                        preparedStatement.setLong(integer+1, (long) o);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String table, String update, Object updateValue, String search, Object searchValue) {
        try {
            PreparedStatement preparedStatement =
                    connectionManager.getConnection().prepareStatement("UPDATE " + table + " SET " + update+" = ?"+" WHERE "+search+" = ?");

            if(updateValue instanceof String) {
                preparedStatement.setString(1, (String) updateValue);
            }
            if(updateValue instanceof Integer) {
                preparedStatement.setInt(1, (int) updateValue);
            }
            if(updateValue instanceof Long) {
                preparedStatement.setLong(1, (long) updateValue);
            }

            if(searchValue instanceof String) {
                preparedStatement.setString(2, (String) searchValue);
            }
            if(searchValue instanceof Integer) {
                preparedStatement.setInt(2, (int) searchValue);
            }
            if(searchValue instanceof Long) {
                preparedStatement.setLong(2, (long) searchValue);
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
