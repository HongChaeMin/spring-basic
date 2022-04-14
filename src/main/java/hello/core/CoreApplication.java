package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	// 수동 빈 등록, 자동 빈 등록 오류시 스프링 부트 에러
	//`Consider renaming one of the beans or enabling overriding by setting
	//spring.main.allow-bean-definition-overriding=true`

}
