package Section9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

    Game game;

    public PlayGame(Game game) {
        this.game = game;
    }

    public static void main(String[] args) {
        PlayGame play = new PlayGame(new Game("Runescape"));
        play.saveGame();

    }
    public void saveGame() {
        game.save();
    }

    public void populateFields(Game game) {
        List<String> values = readValues();
        game.populate(values);
    }

    public static List<String> readValues() {
        List<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while(!quit) {
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 :
                    quit = true;
                    break;
                case 1 :
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
