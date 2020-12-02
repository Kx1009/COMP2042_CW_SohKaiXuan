package frogger;

/** Setup the obstacles for each row in game level 4 */
public class Level4 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level4 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level4(){
        super(4);
        getAnimal().setWater(479.33);
        // row 1
        add(new Turtle(0, row[0], 2));
        add(new Turtle(220, row[0], 2));
        // row 2
        add(new WetTurtle(200, row[1], -1));
        add(new WetTurtle(700, row[1], -1));
        // row 3
        add(new Log(2, 0, row[2], 1.9));
        add(new Log(2, 250, row[2], 1.9));
        add(new Log(2, 500, row[2], 1.9));
        // row 4
        add(new Log(0, 400, row[3], 4.3));
        // row 5
        add(new Turtle(500, row[4], -2));
        add(new WetTurtle(300, row[4], -2));
        add(new Turtle(700, row[4], -2));
        // row 6
        add(new Log(1, 0, row[5], 1.7));
        add(new Log(1, 400, row[5], 1.7));
        // row 8
        add(new Obstacle(1, 100, row[7], 4));
        add(new Obstacle(1, 500, row[7], 4));
        // row 9
        add(new Obstacle(0, 100, row[8], -2));
        add(new Obstacle(0, 400, row[8], -2));
        // row 10
        add(new Obstacle(1, 0, row[9], 3));
        add(new Obstacle(1, 400, row[9], 3));
    }
}
