package de.groupon.hcktn.groupong.config.profile;

import de.groupon.config.util.data.PostgresPersistenceData;
import de.groupon.config.util.data.RedisPersistenceData;
import org.springframework.context.annotation.Bean;

public abstract class GroupongDeveloper extends GroupongBaseProfile {

    @Bean
    @Override
    public PostgresPersistenceData postgresPersistenceData() {
        return new PostgresPersistenceData(getPersistencePostgresConnectionUrl(), getPersistencePostgresUsername(), getPersistencePostgresPassword());
    }

    @Bean
    @Override
    public RedisPersistenceData redisPersistenceData() {
        return new RedisPersistenceData(getPersistenceRedisHost(), getPersistenceRedisPort(), getPersistenceRedisUsername(), getPersistenceRedisPassword());
    }

    @Override
    public String getPersistenceRedisHost() {
        return "10.232.36.15";
    }

    @Override
    public Integer getPersistenceRedisPort() {
        return 6376;
    }
}
