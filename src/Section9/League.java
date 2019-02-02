package Section9;

import java.util.ArrayList;
import java.util.List;

public class League<T extends Team> {

    private final String name;
    private final List<T> teams;

    public League(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public void addTeam(T team) {
        teams.add(team);
    }

    public void showLeagueTable() {
    }

}
