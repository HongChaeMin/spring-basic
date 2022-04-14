package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( // 컴포넌트 스캔은 이름 그대로 @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Configuration.class )
) // Configuration 이 붙은 클래스는 빼줌 (예제 유지 목적)
// @Configuration 이 컴포넌트 스캔의 대상이 된 이유도 @Configuration 소스코드를 열어보면 @Component 어노테이션이 붙어있음
public class AutoAppConfig {

    // 컴포넌트 스캔은 @Component 뿐만 아니라 다음과 내용도 추가로 대상에 포함한다.
    // - @Component : 컴포넌트 스캔에서 사용 / 스프링 MVC 컨트롤러로 인식
    // - @Controller : 스프링 MVC 컨트롤러에서 사용
    // - @Service : 스프링 비즈니스 로직에서 사용 / 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는데 도움
    // - @Repository : 스프링 데이터 접근 계층에서 사용 / 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
    // - @Configuration : 스프링 설정 정보에서 사용 / 스프링 빈이 싱글톤을 유지하도록 추가 처리

}
