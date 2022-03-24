package online.cunho.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("online.cunho")
@ServletComponentScan
@MapperScan("online.cunho.blog.dao")
public class MyBlogBackendApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MyBlogBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyBlogBackendApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("Blog地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
//        SpringApplication.run(MyBlogBackendApplication.class, args);
    }

}
