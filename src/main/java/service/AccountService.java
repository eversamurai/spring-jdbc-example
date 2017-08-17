package service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;


public interface AccountService {
    @Autowired
    void setDataSource(DataSource dataSource);

    void addMoneyToAccount(int accountId, double moneyValue);

    void chargeAccount(int accountId, double moneyValue);

    double checkWages(int id);
}
