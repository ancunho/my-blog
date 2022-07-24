package online.cunho.blog.interceptor;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.annotation.PassLogin;
import online.cunho.blog.annotation.UserLogin;
import online.cunho.blog.dto.CustomerDto;
import online.cunho.blog.dto.SysUserDto;
import online.cunho.blog.entity.TbAccessHist;
import online.cunho.blog.service.CommonService;
import online.cunho.blog.util.Box;
import online.cunho.blog.util.HttpUtility;
import online.cunho.blog.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class CunhoInterceptor implements HandlerInterceptor {

    @Autowired
    private CommonService commonService;

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

        if (method.isAnnotationPresent(UserLogin.class)) {
            UserLogin userLogin = method.getAnnotation(UserLogin.class);
            if (userLogin.required()) {
                HttpSession session = request.getSession(true);
                CustomerDto customerDto = (CustomerDto) session.getAttribute("CUSTOMER_USER");
                if (customerDto == null) {
                    System.out.println(">>>>>>Customer User Need Login");
//                    response.sendRedirect("/customer/login");
                    throw new RuntimeException("need Customer Login");
//                    return false;
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

        Box box = HttpUtility.getBox(request);

        try {
            if (request.getRequestURI().contains("getAlarm")) {

            } else {
                HttpSession session = request.getSession(true);
                CustomerDto customerDto = (CustomerDto) session.getAttribute("CUSTOMER_USER");

                TbAccessHist tbAccessHist = new TbAccessHist();
                if (customerDto == null || customerDto.getUserSeq() == null || "".equals(Util.nullempty(customerDto.getUserSeq()))) {
                    tbAccessHist.setCuser("stranger");
                    tbAccessHist.setCustomerSeq(null);
                } else {
                    tbAccessHist.setCuser(customerDto.getUsername());
                    tbAccessHist.setCustomerSeq(customerDto.getUserSeq());
                }

                tbAccessHist.setIpAddr(Util.getRemortIP(request));
                tbAccessHist.setUserAgent(request.getHeader("User-Agent"));
                tbAccessHist.setSessionId(request.getSession(true).getId());
                tbAccessHist.setReferer(request.getHeader("Referer"));
                tbAccessHist.setRequestUrl(request.getRequestURL().toString());
                tbAccessHist.setRequestUri(request.getRequestURI());

                StringBuffer sbHeader = new StringBuffer();
                sbHeader.append("RemoteAddr=" + request.getRemoteAddr()).append("&");

                Enumeration eHeader = request.getHeaderNames();
                while (eHeader.hasMoreElements()) {
                    String hName = (String) eHeader.nextElement();
                    String hValue = request.getHeader(hName);
                    sbHeader.append(hName + "=" + hValue).append("&");
                }
                tbAccessHist.setHeaderInfo(sbHeader.toString());
                tbAccessHist.setParameters(box.toString());
                tbAccessHist.setUseYn("1");

//                commonService.insertTbAccessHist(tbAccessHist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
