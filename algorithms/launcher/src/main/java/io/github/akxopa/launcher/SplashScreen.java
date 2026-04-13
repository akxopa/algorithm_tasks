package io.github.akxopa.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplashScreen {
    public void startApp() throws InterruptedException {
       String title = "Algorithm Tasks";
        
        System.out.print("\n\n\t\t"); // отступы
        
        for (int i = 0; i < title.length(); i++) {
            System.out.print(title.charAt(i));
            
            // Эффект печатной машинки
            if (title.charAt(i) != ' ') {
                System.out.print("\b"); // имитация стука
                Thread.sleep(50);
                System.out.print(title.charAt(i));
            }
            
            Thread.sleep(100);
            
            // Дополнительная пауза на пробелах
            if (title.charAt(i) == ' ') {
                Thread.sleep(200);
            }
        }
        
        System.out.println("\n\n\t\t=== Loading... ===\n");
    }
}
