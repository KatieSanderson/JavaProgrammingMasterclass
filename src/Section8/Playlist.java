package Section8;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

    private final List<Song> list;

    private Playlist() {
        list = new LinkedList<>();
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.play();
    }

    private void play() {
        populateList();
        printOptions();
        selectOption();
    }

    private void populateList() {
        Album album1 = new Album();
        Album album2 = new Album();
        list.add(album1.getSongs().get(0));
        list.add(album2.getSongs().get(1));
        list.add(album1.getSongs().get(2));
        list.add(album2.getSongs().get(4));
    }

    private void selectOption() {
        System.out.println("Please choose an option: ");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = list.listIterator();

        while (!quit) {
            int selectedOption = scanner.nextInt();
            scanner.nextLine();
            switch (selectedOption) {
                case 0 :
                    System.out.println("Quitting application");
                    quit = true;
                    break;
                case 1 :
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now listening to " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached end of list");
                        goingForward = false;
                    }
                    break;
                case 2 :
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now listening to " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("Reached start of list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            System.out.println("Now listening to " + listIterator.next().getTitle());
                        }
                        goingForward = true;
                    } else {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now listening to " + listIterator.previous().getTitle());
                        }
                        goingForward = false;
                    }
                    break;
                case 4:
                    for (Song song : list) {
                        System.out.println(song.getTitle());
                    }
                    break;
                case 5 :
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            System.out.println("Removing current song : " + listIterator.next().getTitle());
                        }
                        goingForward = true;
                    } else {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Removing current song : " + listIterator.previous().getTitle());
                        }
                        goingForward = false;
                    }
                    if (list.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous());
                        }
                    }
                    break;
            }
        }

    }

    private static void printOptions() {
        System.out.println("" +
                "Options are: \n" +
                "0 - Quit\n" +
                "1 - Skip forward to next song\n" +
                "2 - Skip backwards to previous song\n" +
                "3 - Replay the current song\n" +
                "4 - List the songs in the playlist\n" +
                "5 - Remove the current song from playlist");
    }
}
