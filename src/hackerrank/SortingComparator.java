package hackerrank;

import java.util.Comparator;

public class SortingComparator {
    public static void main(String[] args) {

    }

    class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        if (a.getScore() == b.getScore()) {
            int res = a.getName().compareToIgnoreCase(b.getName());
            return (res == 0) ? a.getName().compareTo(b.getName()) : res;
        } else if (a.getScore() > b.getScore()) {
            return -1;
        } else {
            return 1;
        }
    }
}

     class Player {
        int score;
        String name;

        public Player(int score, String name){
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getName() {
            return name;
        }
    }
}
