package com.undermoonoldman.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcDemo {
    @Test
    public void testJdbc() throws Exception{
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "805237796");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, info);
        String sql = "select * from customers where ID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString("NAME"));
        }

        resultSet.close();
        connection.close();
    }

}
