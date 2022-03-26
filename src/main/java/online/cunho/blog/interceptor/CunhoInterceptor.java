package online.cunho.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CunhoInterceptor implements HandlerInterceptor {

    /**
     * 在DispatcherServlet处理方法之前执行，一般用来做一些准备工作：比如日志，权限检查
     * 如果返回false 表示被拦截，将不会执行处理方法
     * 返回true继续执行处理方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("执行preHandler..." + request.getRemoteAddr() + request.getRemoteUser());
        System.out.println(">>>>..." + request.getHeader("User-Agent") + "||" + request.getHeader("Referer") + "||" + request.getRequestURI() + "||" + request.getRequestURL() + "||" + request.getRemoteUser());
        return true;
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
