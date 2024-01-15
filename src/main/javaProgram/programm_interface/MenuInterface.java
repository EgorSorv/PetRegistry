package programmInterface;

import java.util.Scanner;

public class MenuInterface {

    public static void menuInterface(int command) {
        Scanner sc = new Scanner(System.in);

        if (command == 2) System.out.println("Завершение работы");
        else if (command == 1) {
            System.out.println("""
                    Список доступных комманд:
                                    
                    1. Добавить новое животное.
                    2. Вывести список животных.
                    3. Выучить новую команду.
                    """);

            command = sc.nextInt();

            try {
                if (command == 1)
                        addNewAnimal();
                    else if (command == 2)
                        showAllAnimals;
                    else if (command == 3)
                        teachNewCommand();
            } catch (InputCommandException e) {
                System.out.println(e.getMessage());
                menuInterface(command);
            }
        }
    }
}
