package de.groupon.hcktn.groupong.config.context;

import de.groupon.api.shared.domain.AccessContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        GroupongWebConfig.class,

        PersistenceConfig.class
})
public class GroupongConfig{
}
