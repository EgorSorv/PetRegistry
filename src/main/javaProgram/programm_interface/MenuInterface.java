package programm_interface;

import animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

import static main_functions.AddAnimal.addNewAnimal;
import static main_functions.Command.teachNewCommand;
import static main_functions.ShowList.showAllAnimals;
import static programm_interface.Menu.menu;

public class MenuInterface {

    public static void menuInterface(ArrayList<Animal> animals) {
        Scanner sc = new Scanner(System.in);
        int command;

        boolean exceptionCheck = true;

        while (exceptionCheck) {
            System.out.println("""
                    
                    
                    Список доступных функций:
                                        
                    1. Добавить новое животное.
                    2. Вывести список животных.
                    3. Выучить новую команду.
                    4. Назад
                                            
                    """);

            command = Integer.parseInt(sc.nextLine());

            try {
                if (command == 1) {
                    exceptionCheck = false;
                    addNewAnimal(animals);
                }
                else if (command == 2) {
                    exceptionCheck = false;
                    showAllAnimals(animals);
                }
                else if (command == 3) {
                    exceptionCheck = false;
                    teachNewCommand(animals);
                }
                else if (command == 4) {
                    exceptionCheck = false;
                    menu(animals);
                }
            } catch (InputFunctionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
