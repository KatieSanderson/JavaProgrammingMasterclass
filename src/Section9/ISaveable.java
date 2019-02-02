package Section9;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {

    List<String> storage = new ArrayList<>();

    List<String> save();

    void populate(List<String> points);

}
