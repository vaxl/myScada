package view;

import Controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * Created by U7 on 12.03.2017.
 */
public class ConsoleView implements View{
    @Autowired
    private Controller controller;
    private static final Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        while (true){
            String cmd = scanner.nextLine();
            /// TODO: 12.03.2017  
            
        }
    }
}
