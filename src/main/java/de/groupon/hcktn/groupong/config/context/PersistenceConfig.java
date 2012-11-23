package de.groupon.hcktn.groupong.config.context;

import de.groupon.config.util.data.PostgresPersistenceData;
import fr.xebia.springframework.jdbc.ManagedBasicDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    PostgresPersistenceData postgresPersistenceData;

    @Bean
    public BasicDataSource dataSource() {
        final ManagedBasicDataSource basicDataSource = new ManagedBasicDataSource();

        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl(postgresPersistenceData.getConnectionUrl());
        basicDataSource.setUsername(postgresPersistenceData.getUsername());
        basicDataSource.setPassword(postgresPersistenceData.getPassword());
        basicDataSource.setMaxActive(50);
        basicDataSource.setMaxWait(1000*120);
        basicDataSource.setMaxIdle(1);
        basicDataSource.setInitialSize(5);
        basicDataSource.setValidationQuery("SELECT 1;");
        basicDataSource.setTestOnBorrow(false);
        basicDataSource.setTestOnReturn(false);
        basicDataSource.setTestWhileIdle(true);
        basicDataSource.setTimeBetweenEvictionRunsMillis(10000);

        return basicDataSource;
    }
}
