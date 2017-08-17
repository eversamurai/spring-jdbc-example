package main.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;
import test.pack.AppConfig;

import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void addMoneyToAccount() throws Exception {
        assertEquals(100,accountService.checkWages(1),0.01);
        accountService.addMoneyToAccount(1,100);
        assertEquals(200,accountService.checkWages(1),0.01);

    }

    @Test
    public void chargeAccount() throws Exception {
        assertEquals(4000.0,accountService.checkWages(2),0.01);
        accountService.chargeAccount(2,100.2);
        assertEquals(3899.8,accountService.checkWages(2),0.01);
    }

    @Test
    public void checkWages() throws Exception {
        assertEquals(10,accountService.checkWages(3),0.01);
    }

}