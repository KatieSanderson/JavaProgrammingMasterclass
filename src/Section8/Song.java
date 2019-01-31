package Section8;

public class Song {

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    private final String title;
    private final int duration;

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}
