import controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.View;


public class Main {

    public static void main(String[] args) {
        ApplicationContext contex = new ClassPathXmlApplicationContext("spring.xml");
        View view = contex.getBean("consoleView", View.class);
        MainController controller = contex.getBean(MainController.class);
        System.out.println("start application");
        controller.start(view);

    }
}
