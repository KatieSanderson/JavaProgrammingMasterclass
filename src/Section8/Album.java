package Section8;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private final List<Song> songs;

    public Album() {
        songs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            songs.add(new Song("a" + i, i));
        }
    }

    public List<Song> getSongs() {
        return songs;
    }
}
