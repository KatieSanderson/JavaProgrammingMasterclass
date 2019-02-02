package Section9;

import java.util.List;

public class Game implements ISaveable {

    List<String> storage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Game(String name) {
        this.name = name;
    }

    @Override
    public List<String> save() {
        return storage;
    }

    @Override
    public void populate(List<String> points) {
        storage = points;
    }

    @Override
    public String toString() {
        return name;
    }
}
