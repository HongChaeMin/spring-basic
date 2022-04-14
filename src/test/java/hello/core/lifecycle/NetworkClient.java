package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // 결과
    // 생성자 호출 url : null
    // afterPropertiesSet 호출
    // connect : http://localhost:80
    // call : http://localhost:80 message : 초기화 연결 메세지
    // 15:50:53.519 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@1b11171f, started on Thu Apr 14 15:50:53 KST 2022
    // destroy 호출
    // close : http://localhost:80
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet 호출");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy 호출");
        disconnect();
    }
}
