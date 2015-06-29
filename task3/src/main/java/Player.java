/**
 * Player class, contains the player's name.
 *
 * @author Kamil Best
 */
class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    /**
     * The method returns player name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }
}