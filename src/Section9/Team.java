package Section9;

public class Team implements Comparable<Team> {

    private final String name;
    private int rank;

    public Team(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Team team) {
        return Integer.compare(this.rank, team.getRank());
//        if (this.rank > team.getRank()) {
//            return 1;
//        } else if (this.rank < team.getRank()) {
//            return -1;
//        } else {
//            return 0;
//        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }
}
