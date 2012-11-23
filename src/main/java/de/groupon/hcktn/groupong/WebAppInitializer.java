package de.groupon.hcktn.groupong;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    private static final String PROFILE_PROPERTY = "env";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

        String profile = System.getProperty(PROFILE_PROPERTY);
        if (StringUtils.isBlank(profile)) {
            throw new ServletException("Groupon profile not specified! If you run application via maven please set -D" + PROFILE_PROPERTY + "=<your_profile>");
        }

        appContext.getEnvironment().setActiveProfiles("groupong", profile);
        appContext.setServletContext(servletContext);
        appContext.scan("de.groupon.hcktn.groupong");
        appContext.refresh();

        servletContext.addListener(new ContextLoaderListener(appContext));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("groupong", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }


}