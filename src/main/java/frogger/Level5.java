package frogger;

public class Level5 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level5 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level5(){
        super(5);
        getAnimal().setWater(532.66);
        add(new Log(0,0, row[0], -1.4));
        add(new Log(0,400, row[0], -1.4));

        add(new WetTurtle(600, row[1], 2));
        add(new Turtle(400, row[1], 2));
        add(new WetTurtle(200, row[1], 2));

        add(new WetTurtle(200, row[2], -3));
        add(new Turtle(700, row[2], -3));

        add(new Log(0, 50, row[3], 2.3));
        add(new Log(0, 430, row[3], 2.3));

        add(new Turtle(500, row[4], -1));
        add(new Turtle(300, row[4], -1));
        add(new Turtle(700, row[4], -1));

        add(new WetTurtle(100, row[5], 2));
        add(new WetTurtle(300, row[5], 2));
        add(new WetTurtle(600, row[5], 2));

        add(new Log(1, 0, row[6], 1));
        add(new Log(1, 500, row[6], 1));

        add(new Obstacle(0, 50, row[8], -3));
        add(new Obstacle(0, 300, row[8], -3));
        add(new Obstacle(0, 550, row[8], -3));

        add(new Obstacle(1, 100, row[9], 3));
        add(new Obstacle(2, 500, row[9], 3));

    }
}
