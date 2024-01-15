package main_functions;

import animals.*;
import programm_interface.InputFunctionException;

import java.util.ArrayList;
import java.util.Scanner;

import static programm_interface.MenuInterface.menuInterface;

public class AddAnimal {
    public static void addNewAnimal(ArrayList<Animal> animals) {
        Scanner sc = new Scanner(System.in);
        int type = chooseType(animals);
        ArrayList<String> commands = new ArrayList<>();
        String name;
        String command;

        if (type == 1) {
            System.out.println("Введите имя кошки:");
            name = sc.nextLine();
            System.out.println();

            System.out.println("Введите команду, которую знает кошка:");
            command = sc.nextLine();
            System.out.println();

            if (command != null && !command.isBlank() && !command.isEmpty())
                commands.add(command);

            animals.add(new Cat("Кошка", name, commands));

            System.out.println("Кошка успешно добавлена в реестр домашних животных.");
            menuInterface(animals);
        } else if (type == 2) {
            System.out.println("Введите имя собаки:");
            name = sc.nextLine();
            System.out.println();

            System.out.println("Введите команду, которую знает собака:");
            command = sc.nextLine();
            System.out.println();

            if (command != null && !command.isBlank() && !command.isEmpty())
                commands.add(command);

            animals.add(new Dog("Собака", name, commands));

            System.out.println("Собака успешно добавлена в реестр домашних животных.");
            menuInterface(animals);
        } else if (type == 3) {
            System.out.println("Введите имя осла:");
            name = sc.nextLine();
            System.out.println();

            System.out.println("Введите команду, которую знает осел:");
            command = sc.nextLine();
            System.out.println();

            if (command != null && !command.isBlank() && !command.isEmpty())
                commands.add(command);

            animals.add(new Donkey("Осел", name, commands));

            System.out.println("Осел успешно добавлен в реестр домашних животных.");
            menuInterface(animals);
        } else if (type == 4) {
            System.out.println("Введите имя хомяка:");
            name = sc.nextLine();
            System.out.println();

            System.out.println("Введите команду, которую знает хомяк:");
            command = sc.nextLine();
            System.out.println();

            if (command != null && !command.isBlank() && !command.isEmpty())
                commands.add(command);

            animals.add(new Hamster("Хомяк", name, commands));

            System.out.println("Хомяк успешно добавлен в реестр домашних животных.");
            menuInterface(animals);
        } else if (type == 5) {

            System.out.println("Введите имя лошади:");
            name = sc.nextLine();
            System.out.println();

            System.out.println("Введите команду, которую знает лошадь:");
            command = sc.nextLine();
            System.out.println();

            if (command != null && !command.isBlank() && !command.isEmpty())
                commands.add(command);

            animals.add(new Horse("Лошадь", name, commands));

            System.out.println("Лошадь успешно добавлена в реестр домашних животных.");
            menuInterface(animals);
        }
    }

    public static int chooseType(ArrayList<Animal> animals) {
        Scanner sc = new Scanner(System.in);
        boolean exceptionCheck = true;
        int command = 0;

        while (exceptionCheck) {
            System.out.println("""
                    
                    
                    Выберете вид животного:
                                    
                    1. Кот
                    2. Собака
                    3. Осел
                    4. Хомяк
                    5. Лошадь
                    6. Назад
                                        
                    """);

            command = Integer.parseInt(sc.nextLine());

            try {
                if (1 <= command && command <= 5) exceptionCheck = false;
                else if (command == 6) {
                    exceptionCheck = false;
                    menuInterface(animals);
                }
            } catch (InputFunctionException e) {
                System.out.println(e.getMessage());
            }
        }

        return command;
    }
}
