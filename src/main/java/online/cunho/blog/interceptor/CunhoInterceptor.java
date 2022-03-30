package online.cunho.blog.interceptor;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.annotation.PassLogin;
import online.cunho.blog.dto.SysUserDto;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class CunhoInterceptor implements HandlerInterceptor {



    /**
     * 在DispatcherServlet处理方法之前执行，一般用来做一些准备工作：比如日志，权限检查
     * 如果返回false 表示被拦截，将不会执行处理方法
     * 返回true继续执行处理方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassLogin.class)) {
            PassLogin passLogin = method.getAnnotation(PassLogin.class);
            if (passLogin.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(AdminUserLogin.class)) {
            AdminUserLogin adminUserLogin = method.getAnnotation(AdminUserLogin.class);
            if (adminUserLogin.required()) {
                HttpSession session = request.getSession(true);
                SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGIN_USER");
                if (sysUserDto == null) {
                    System.out.println(">>>>>need Login");
                    throw new RuntimeException("need Login");
                }
                return true;
            }
        }

        return false;
    }

    /**
     * 在处理方法执行之后执行，在DispatcherServlet处理方法之后执行，一般用来做一些清理工作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在结果返回给客户端之前执行，一般用来释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
