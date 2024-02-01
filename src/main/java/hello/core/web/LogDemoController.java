package hello.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import hello.core.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class  LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    //HttpServletRequest -> 자바에서 제공하는 표준 서블릿 규약이 있는데 그에 의한 HttpRequest 정보를 받을 수 있다.
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
