package com.beer.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class BaseDao {

    protected Connection getConnection() {
        Connection connection = getConnection(Constants.DRIVER, Constants.URL,
                Constants.USERNAME, Constants.PASSWORD);
		return connection;
    }

    protected Connection getConnection(String url) {
        return getConnection(Constants.DRIVER, url, Constants.USERNAME,
                Constants.PASSWORD);
    }

    Connection getConnection(String driver, String url, String username,
            String password) {
        Connection conn = null;
		System.out.println("driver=" + driver + " url=" + url + " username="+ username + " password=" + password);

        try {
	       System.out.println("Constants.DRIVER=" + Constants.DRIVER + " Constants.URL=" + Constants.URL + 
		   " Constants.USERNAME="+ Constants.USERNAME + " Constants.PASSWORD=" + Constants.PASSWORD);

            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        } catch (SQLException se) {
	       System.out.println("Constants.DRIVER=" + Constants.DRIVER + " Constants.URL=" + Constants.URL + 
		   " Constants.USERNAME="+ Constants.USERNAME + " Constants.PASSWORD=" + Constants.PASSWORD);
            se.printStackTrace(); 
            throw new RuntimeException(se);
        } catch (ClassNotFoundException ce) {
            throw new RuntimeException(ce);
        }
        return conn;
    }

    protected void closeDbConnection(ResultSet resultSet, PreparedStatement stmt,
            Connection conn) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

}
