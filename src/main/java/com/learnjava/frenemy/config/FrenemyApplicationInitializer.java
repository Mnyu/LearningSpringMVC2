package com.learnjava.frenemy.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrenemyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{FrenemyAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/mywebsite.com/*"};
    }
}
