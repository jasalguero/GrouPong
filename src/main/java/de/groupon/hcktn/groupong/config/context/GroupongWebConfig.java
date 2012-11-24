package de.groupon.hcktn.groupong.config.context;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import de.groupon.api.shared.config.context.AbstractWebConfig;
import de.groupon.api.shared.exception.ResponseErrorConverter;
import de.groupon.config.web.context.WebConfigContext;
import de.groupon.config.web.util.DefaultResponseBodyTypeConfiguration;
import de.groupon.config.web.util.xstream.XStreamStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "de.groupon.hcktn.groupong", excludeFilters = {@ComponentScan.Filter(Configuration.class)})
@EnableAspectJAutoProxy()
@ImportResource("classpath:applicationContext.xml")
public class GroupongWebConfig extends WebConfigContext {

    @Override
    public void addCustomMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Use GSON and the home-grown XML serializer
        // (overriding the default XStream)
        converters.add(GSONHttpMessageConverter());
        converters.add(XmlStreamerHttpMessageConverter());
        // Add converters for RSS feeds and CSV
        converters.add(CsvHttpMessageConverter());
    }


    @Bean
    @Override
    public DefaultResponseBodyTypeConfiguration defaultResponseBodyTypeConfiguration() {
        DefaultResponseBodyTypeConfiguration config = super.defaultResponseBodyTypeConfiguration();
        Map<String, String> mediaTypes = Maps.newHashMap();
        mediaTypes.put("/*", "application/json");
        config.setMediaTypes(mediaTypes);
        return config;
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
