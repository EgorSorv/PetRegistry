package main_functions;

import animals.Animal;
import programm_interface.InputFunctionException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main_functions.ShowList.showCommands;
import static programm_interface.MenuInterface.menuInterface;

public class Command {
    public static void teachNewCommand(ArrayList<Animal> animals) {
        Scanner sc = new Scanner(System.in);
        String name;
        int index;
        ArrayList<String> commands;
        boolean exceptionCheck = true;

        while (exceptionCheck) {
            System.out.println("""
            
            
            Введите имя животного:
            """);

            name = sc.nextLine();
            index = findAnimal(name, animals);

            try {
                if (index != -1) {
                    exceptionCheck = false;
                    commands = animals.get(index).getCommands();
                    chooseFunction(name, commands, animals);
                }
            } catch (RuntimeException e) {
                System.out.println("Животное с таким именем не найдено.");
            }
        }
    }

    public static int findAnimal(String name, ArrayList<Animal> animals) {
        int result = -1;

        for (int i = 0; i < animals.size(); i++)
            if (Objects.equals(animals.get(i).getName(), name))
                result = i;

        return result;
    }

    public static void chooseFunction(String name, ArrayList<String> commands, ArrayList<Animal> animals) {
        Scanner sc = new Scanner(System.in);
        boolean exceptionCheck = true;
        int command;

        while (exceptionCheck) {
            try {
                System.out.println("""
                        
                        
                        Введите номер функции:
                        
                        1. Вывести список команд, которые выполняет животное
                        2. Добавить команду для животного
                        3. Назад
                        """);

                command = Integer.parseInt(sc.nextLine());

                if (command == 1) {
                    exceptionCheck = false;
                    showCommands(commands, name);
                }
                else if (command == 2) {
                    exceptionCheck = false;
                    addNewCommand(commands, name);
                }
                else if (command == 3) {
                    exceptionCheck = false;
                    menuInterface(animals);
                }

                exceptionCheck = false;
            } catch (InputFunctionException e) {
                System.out.println(e.getMessage());
            }
        }

        menuInterface(animals);
    }

    public static void addNewCommand(ArrayList<String> commands, String name) {
        Scanner sc = new Scanner(System.in);
        String command;

        System.out.println();

        command = sc.nextLine();

        if (command != null && !command.isEmpty() && !command.isBlank()) {
            commands.add(command);
            System.out.println(name + " теперь знает команду - " + command);
        }
    }
}
