import animals.Animal;

import java.util.ArrayList;

import static main_functions.ConvertFile.convertFileToList;
import static main_functions.ConvertFile.convertListToFile;
import static programm_interface.Menu.menu;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/javaProgram/ListOfAnimals.txt";

        ArrayList<Animal> animals = new ArrayList<Animal>();
        convertFileToList(path, animals);

        menu(animals);

        convertListToFile(path, animals);
    }
}
