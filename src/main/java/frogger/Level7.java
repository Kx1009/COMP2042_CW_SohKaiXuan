package frogger;

public class Level7 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level7 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level7(){
        super(7);
        getAnimal().setWater(586);

        add(new Turtle(350, row[0], 2));
        add(new Turtle(100, row[0], 2));
        add(new Log(1, 610, row[0], 2));

        add(new WetTurtle(600, row[1], -2));
        add(new Turtle(200, row[1], -2));

        add(new Log(0, 0, row[2], -4));
        add(new Log(1, 400, row[2], -4));

        add(new Log(1, 150, row[3], 2.1));
        add(new Log(2, 650, row[3], 2.1));

        add(new WetTurtle(400, row[4], -2));
        add(new Turtle(200, row[4], -2));
        add(new WetTurtle(600, row[4], -2));

        add(new Log(2,130, row[5], 1.25));
        add(new Log(0,490, row[5], 1.25));

        add(new WetTurtle(600, row[6], 1));
        add(new WetTurtle(300, row[6], 1));
        add(new WetTurtle(100, row[6], 1));

        add(new Turtle(200, row[7], -3));
        add(new Turtle(700, row[7], -3));

        add(new Obstacle(0, 0, row[9], 5));
        add(new Obstacle(0, 400, row[9], 5));

    }
}
