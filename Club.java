public class Club {
    private String name;
    private String country;
    private char pot;
    private int group;
    public Club(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public Club(String name, String country, char pot) {
        this(name, country);
        this.pot = pot;
    }
    public Club(String name, String country, char pot, int group) {
        this(name, country, pot);
        this.group = group;
    }
    public char getPot() {
        return pot;
    }
    @Override
    public String toString() {
        return name + " <" + country + ">";
    }
    public boolean similar(Club club, int stage) {
        if(stage == 1) {
            return this.pot == club.pot || this.country.equals(club.country);
        } else if(stage == 2) {
            return this.pot == club.pot || this.group == club.group || this.country.equals(club.country);
        } else {
            return false;
        }
    }
}