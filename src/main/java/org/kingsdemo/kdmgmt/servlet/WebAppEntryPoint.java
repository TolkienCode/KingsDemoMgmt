package org.kingsdemo.kdmgmt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppEntryPoint implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        ServletRegistration.Dynamic registration = container.addServlet("kdmgmt", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/kdmgmt/*");
    }

}