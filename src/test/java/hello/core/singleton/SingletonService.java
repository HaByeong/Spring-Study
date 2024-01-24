package hello.core.singleton;

public class SingletonService {
    //자기 자신 객체 생성해서 참조값에 넣어놓는다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
