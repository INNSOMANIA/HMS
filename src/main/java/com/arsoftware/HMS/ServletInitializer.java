package com.arsoftware.HMS;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.arsoftware.hms.patient",
        "com.arsoftware.hms.doctor",
        "com.arsoftware.hms.condilition",
        "com.arsoftware.hms.hospital",
        "com.arsoftware.hms.operation",
})
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HmsApplication.class);
    }
}
