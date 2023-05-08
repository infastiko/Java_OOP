package Task_7.Phonebook.UI;

import Task_7.Phonebook.Config;
import Task_7.Phonebook.Core.MVP.Presenter;
import Task_7.Phonebook.Core.MVP.View;

import java.util.Scanner;

public class App {
    public static void ButtonClick(){
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new NewConsoleView();
        Presenter presenter = new Presenter(view, Config.getPathDb());
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - prev  2 - next  3 - save  4 - remove");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        presenter.add();
                        presenter.saveToFile();
                        break;
                    case "4":
                        presenter.remove();
                        presenter.saveToFile();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
}
