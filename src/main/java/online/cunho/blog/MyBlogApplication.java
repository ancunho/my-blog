package online.cunho.blog;

import online.cunho.blog.config.CunhoSessionListener;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@SpringBootApplication
@ComponentScan("online.cunho")
@ServletComponentScan
@MapperScan("online.cunho.blog.dao")
public class MyBlogApplication {

    private static final Logger log = LoggerFactory.getLogger(MyBlogApplication.class);

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new CunhoSessionListener();
    }

    public static void main(String[] args) {
        log.info("MyBlogApplication starting .......");
        SpringApplication app = new SpringApplication(MyBlogApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("MyBlogApplication started ....... SUCCESS!");
        log.info("MyBlogApplication 地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
