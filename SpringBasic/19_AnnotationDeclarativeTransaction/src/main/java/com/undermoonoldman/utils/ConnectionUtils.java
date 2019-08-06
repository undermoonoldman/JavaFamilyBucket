package com.undermoonoldman.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;


/**连接工具类,用于从数据源中获取一个连接,并且实现与线程的绑定*/

@Component
public class ConnectionUtils {
    @Qualifier("dataSource")
    @Autowired
    ComboPooledDataSource dataSource;

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    public Connection getThreadConnection(){
        Connection connection = connectionThreadLocal.get();

        if(connection == null){
            try {
                connection = dataSource.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            connectionThreadLocal.set(connection);
        }
        return connection;
    }

    public void removeConnection(){
        connectionThreadLocal.remove();
    }
}
