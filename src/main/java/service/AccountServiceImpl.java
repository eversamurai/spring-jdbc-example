package service;

import model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 *of course I also can come up with dedictated DAO object
 *based on Account entity, but many of that object functions
 *is out of scope(as CRUD operations for account) we need
 *only update existing accounts so simple queries are more affordable
 *to reduce the unnecessary complexity, in scope of this exact task
 *Also LOGGER are skipped to
**/

@Component
public class AccountServiceImpl implements  AccountService {


    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addMoneyToAccount(int accountId, double moneyValue){
        jdbcTemplate.update(Query.ADD_MONEY_BY_ACCOUNT_ID,moneyValue,accountId);

    }

    @Override
    public void chargeAccount(int accountId, double moneyValue){
        jdbcTemplate.update(Query.CHARGE_MONEY_FORM_ACCOUNT,moneyValue,accountId);
    }

    @Override
    public double checkWages(int id){

       return jdbcTemplate.queryForObject(Query.CHECK_ACCOUNT_WAGES, new Object[]{id},Double.class);

    }



}
