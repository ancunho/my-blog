package online.cunho.blog.util;

import online.cunho.blog.config.JwtProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JwtTokenUtil {

    @Resource
    private JwtProperties jwtProperties;
}
