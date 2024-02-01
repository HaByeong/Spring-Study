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
    private final ObjectProvider<MyLogger> myLoggerProvider;

    //HttpServletRequest -> 자바에서 제공하는 표준 서블릿 규약이 있는데 그에 의한 HttpRequest 정보를 받을 수 있다.
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        //logDemo에서 HTTP 요청이 들어온다. -> 아래 getObject()로 해당 빈을 요청하여 가져올 수 있음!
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
