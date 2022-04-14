package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( // 컴포넌트 스캔은 이름 그대로 @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
        excludeFilters = @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Configuration.class )
) // Configuration 이 붙은 클래스는 빼줌 (예제 유지 목적)
// @Configuration 이 컴포넌트 스캔의 대상이 된 이유도 @Configuration 소스코드를 열어보면 @Component 어노테이션이 붙어있음
public class AutoAppConfig {

}
