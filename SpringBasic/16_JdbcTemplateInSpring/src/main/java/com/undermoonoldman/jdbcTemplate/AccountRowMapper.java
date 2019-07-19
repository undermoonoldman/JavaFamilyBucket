package com.undermoonoldman.jdbcTemplate;

import com.undermoonoldman.bean.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**定义Account的封装策略
 * 把结果集中的数据封装到Account中
 * Spring把每个Account添加到集合中*/
public class AccountRowMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
