package de.groupon.hcktn.groupong.config.profile.zzabost;

import de.groupon.hcktn.groupong.config.context.GroupongConfig;
import de.groupon.hcktn.groupong.config.profile.GroupongDeveloper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("zzabost")
@Import(GroupongConfig.class)
public class AppProfile extends GroupongDeveloper {

    @Override
    public String getPersistencePostgresConnectionUrl() {
        return "jdbc:postgresql://10.232.36.16:5432/t_stardeals_db";
    }

}