package de.groupon.hcktn.groupong.config.context;

import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import de.groupon.api.shared.exception.ResponseErrorConverter;
import de.groupon.config.web.context.WebConfigContext;
import de.groupon.config.web.util.DefaultResponseBodyTypeConfiguration;
import de.groupon.config.web.util.xstream.XStreamStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "de.groupon.hcktn.groupong", excludeFilters = {@ComponentScan.Filter(Configuration.class)})
public class GroupongWebConfig extends WebConfigContext {

    @Bean
    public DefaultResponseBodyTypeConfiguration defaultResponseBodyTypeConfiguration() {
        final DefaultResponseBodyTypeConfiguration defaultResponseBodyTypeConfiguration = new DefaultResponseBodyTypeConfiguration();

        Map<String, String> mediaTypes = Maps.newHashMap();
        mediaTypes.put("/*", MediaType.APPLICATION_JSON_VALUE);
        defaultResponseBodyTypeConfiguration.setMediaTypes(mediaTypes);

        return defaultResponseBodyTypeConfiguration;
    }

    @Override
    @Bean
    public XStreamMarshaller XStreamMarshaller() {
        XStreamMarshaller xStreamMarshaller = super.XStreamMarshaller();

        xStreamMarshaller.setMode(XStream.NO_REFERENCES);
        xStreamMarshaller.getXStream().registerConverter(new ResponseErrorConverter());
        xStreamMarshaller.getXStream().registerConverter(new XStreamStringConverter());

        return xStreamMarshaller;
    }

}
