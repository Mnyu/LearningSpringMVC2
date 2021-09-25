//package com.learnjava.frenemy.config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class FrenemyAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        // Annotation based spring configuration web context
//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(FrenemyAppConfig.class);
//
//        // 1. Create Dispatcher Servlet
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
//
//        // 2. Register Dispatcher Servlet with the Servlet Context object.
//        ServletRegistration.Dynamic dynamicServletRegistration = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
//        dynamicServletRegistration.setLoadOnStartup(1);
//        dynamicServletRegistration.addMapping("/mywebsite.com/*");
//    }
//}
