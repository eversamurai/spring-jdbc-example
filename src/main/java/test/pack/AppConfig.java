package test.pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import service.AccountService;
import service.AccountServiceImpl;

import javax.sql.DataSource;


/**
 * Created by max on 7/14/17.
 */
@Configuration
public class AppConfig {

    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl();
    }

    @Bean
    public DataSource dataSource() {

               return new EmbeddedDatabaseBuilder()
                       .setType(EmbeddedDatabaseType.H2)
                       .addScript("classpath:sql/init.sql")
                       .build();
    }



}
