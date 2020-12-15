package frogger;

/** Construct a game level */
public class LevelBuilder {

    /** the game level object */
    private Level gameLevel;

    /** Construct a LevelBuilder object */
    public LevelBuilder() {
    }

    /**
     * Instantiate the respective game level object
     * @param level the game level
     * @return the respective game level object
     */
    public Level getLevel(int level) {
        switch(level) {
            case 1:
                gameLevel = new Level1();
                break;
            case 2:
                gameLevel = new Level2();
                break;
            case 3:
                gameLevel = new Level3();
                break;
            case 4:
                gameLevel = new Level4();
                break;
            case 5:
                gameLevel = new Level5();
                break;
            case 6:
                gameLevel = new Level6();
                break;
            case 7:
                gameLevel = new Level7();
                break;
            case 8:
                gameLevel = new Level8();
                break;
            case 9:
                gameLevel = new Level9();
                break;
            case 10:
                gameLevel = new Level10();
                break;
        }
        return gameLevel;
    }
}
