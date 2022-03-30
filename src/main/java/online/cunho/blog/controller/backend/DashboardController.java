package online.cunho.blog.controller.backend;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.common.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/backend/dashboard")
public class DashboardController {

//    @GetMapping(value = "/chart01")
//    public BaseResponse dashboard_chart_01(HttpServletRequest request) {
//        Option option = new Option();
//        Title title = new Title();
//        title.setText("title01");
//        option.setTitle(title);
//
//
//    }

}
