package hello.core.singleton;

public class SingletonService {

    // 참고: 싱글톤 패턴을 구현하는 방법은 여러가지가 있다. 여기서는 객체를 미리 생성해두는 가장 단순하고 안전한 방법을 선택했다.

    // 애플리케이션을 실행할 때 자기 자신의 객체를 생성해 가지고 있음
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 다른 곳에서 생성을 못하도록 private으로 선언
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
