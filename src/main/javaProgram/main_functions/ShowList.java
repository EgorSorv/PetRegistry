package main_functions;

import animals.Animal;

import java.util.ArrayList;

import static programm_interface.MenuInterface.menuInterface;

public class ShowList {
    public static void showAllAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("""
                                        
                                        
                    """);
            System.out.println("Вид - " + animal.getType());
            System.out.println("Имя - " + animal.getName());
            showCommands(animal.getCommands(), animal.getName());

        }

        menuInterface(animals);
    }

    public static void showCommands(ArrayList<String> commands, String name) {
        if (commands.size() != 0) {
            System.out.println(name + " знает команды:");

            for (String command : commands)
                System.out.println(command);
        }
        else System.out.println(name + " пока не знает команд.");
    }
}
