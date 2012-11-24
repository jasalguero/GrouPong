package de.groupon.hcktn.groupong.config.profile;

import de.groupon.api.shared.config.ApplicationConfiguration;
import de.groupon.config.profile.BaseProfile;
import de.groupon.config.util.data.EnvironmentData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public abstract class GroupongBaseProfile extends BaseProfile {
    private final static Logger log = LoggerFactory.getLogger(GroupongBaseProfile.class);

    @Autowired
    EnvironmentData environmentData;

    @Bean
    public GroupongConfiguration geoAppConfiguration() {
        final GroupongConfiguration groupongConfiguration = new GroupongConfiguration();

        groupongConfiguration.setTest("test");

        return groupongConfiguration;
    }

    @Bean
    public ApplicationConfiguration applicationConfiguration() {
        return new ApplicationConfiguration();
    }

    @Bean
    public ApplicationConfiguration appConfiguration() {
        final ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();

        applicationConfiguration.setEnvironment(environmentData().getAppEnvironment());
        applicationConfiguration.setDataCenterZone(environmentData().getAppDataCenterZone());

        applicationConfiguration.setInstanceKey(getAppInstanceKey());
        applicationConfiguration.setEnvironmentId(getAppEnvironmentId());

        applicationConfiguration.setMaintenanceMode(Boolean.FALSE);

        return applicationConfiguration;
    }
}
