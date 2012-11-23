package de.groupon.hcktn.groupong.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        GroupongWebConfig.class,

        PersistenceConfig.class
})
public class GroupongConfig{
}
