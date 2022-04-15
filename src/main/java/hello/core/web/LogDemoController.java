package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    // 스프링 애플리케이션을 실행 시키면 오류가 발생한다. 메시지 마지막에 싱글톤이라는 단어가 나오고…
    // 스프링 애플리케이션을 실행하는 시점에 싱글톤 빈은 생성해서 주입이 가능하지만, request 스코프 빈은
    // 아직 생성되지 않는다. 이 빈은 실제 고객의 요청이 와야 생성할 수 있다!

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(requestURI);
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "OK";
    }
    // 출력 결과
    // [247d3691-def4-4a6e-a460-027ba80c6104] request scope bean create:hello.core.common.MyLogger@49707c7d
    // [247d3691-def4-4a6e-a460-027ba80c6104][/log-demo] controller test
    // [247d3691-def4-4a6e-a460-027ba80c6104][/log-demo] service id : testId
    // [247d3691-def4-4a6e-a460-027ba80c6104] request scope bean close:hello.core.common.MyLogger@49707c7d

}

// > 참고: requestURL MyLogger 저장하는 부분은 컨트롤러 보다는 공통 처리가 가능한 스프링
// 인터셉터나 서블릿 필터 같은 곳을 활용하는 것이 좋다. 여기서는 예제를 단순화하고, 아직 스프링
// 인터셉터를 학습하지 않은 분들을 위해서 컨트롤러를 사용했다. 스프링 웹에 익숙하다면 인터셉터를
// 사용해서 구현해보자.