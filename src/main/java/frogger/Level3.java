package frogger;

public class Level3 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level3 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level3(){
        super(3);
        getAnimal().setWater(479.33);
        // row 1
        add(new Log(2, 0, row[0], -1));
        add(new Log(2, 220, row[0], -1));
        add(new Log(2, 440, row[0], -1));
        // row 2
        add(new WetTurtle(600, row[1], 2));
        add(new WetTurtle(400, row[1], 2));
        add(new WetTurtle(200, row[1], 2));
        // row 3
        add(new Log(0, 0, row[2], -0.8));
        add(new Log(0, 400, row[2], -0.8));
        // row 4
        add(new Turtle(200, row[3], -2));
        add(new Turtle(700, row[3], -2));
        // row 5
        add(new WetTurtle(500, row[4], -1));
        add(new Turtle(300, row[4], -1));
        add(new WetTurtle(700, row[4], -1));
        // row 6
        add(new Log(0, 0, row[5], 3));
        add(new Log(0, 400, row[5], 3));
        // row 8
        add(new Obstacle(0, 100, row[7], -3));
        add(new Obstacle(0, 400, row[7], -3));
        // row 9
        add(new Obstacle(0, 100, row[8], 2));
        add(new Obstacle(0, 400, row[8], 2));
        // row 10
        add(new Obstacle(2, 0, row[9], 3));
        add(new Obstacle(2, 400, row[9], 3));

    }
}
