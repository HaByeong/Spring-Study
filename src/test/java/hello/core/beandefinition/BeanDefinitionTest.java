package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    //ApplicationContext ac -> 이걸로 접근 불가!! (다형성의 한계)
    //getBeanDefinitionNames() 같은 메서드들은 ApplicationContext에 구현이 되어 있지 않아 -> 자식 클래스에 구현되어 있음

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
          BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

          if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
              System.out.println("beanDefinitionName = " + beanDefinitionName +
                      " beanDefinition = " + beanDefinition);
          }
        }
    }
}
