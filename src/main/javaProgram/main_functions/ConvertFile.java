package main_functions;

import animals.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConvertFile {
    public static void convertFileToList(String path, ArrayList<Animal> animals) {
        String type = "";
        String name = "";
        String commandsString;
        ArrayList<String> commands;

        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));

            for (String line: allLines) {
                String[] result = line.split(", ");
                type = result[0];
                name = result[1];
                commandsString = String.join(", ", Arrays.copyOfRange(result, 2, result.length));

                commands = new ArrayList<>(Arrays.asList(commandsString.split(", ")));

                if (Objects.equals(type, "Кошка"))
                    animals.add(new Cat(type, name, commands));
                else if (Objects.equals(type, "Собака"))
                    animals.add(new Dog(type, name, commands));
                else if (Objects.equals(type, "Осел"))
                    animals.add(new Donkey(type, name, commands));
                else if (Objects.equals(type, "Хомяк"))
                    animals.add(new Hamster(type, name, commands));
                else if (Objects.equals(type, "Лошадь"))
                    animals.add(new Horse(type, name, commands));
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время чтения файла, повторите снова.");
        }
    }

    public static void convertListToFile(String path, ArrayList<Animal> animals) {
        String type;
        String name;
        String commands;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (Animal animal: animals) {
                type = animal.getType();
                name = animal.getName();
                commands = animal.getCommands().toString()
                        .replace("[", "")
                        .replace("]", "");

                writer.write(type + ", " + name + ", " + commands);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, повторите снова.");
        }
    }
}
