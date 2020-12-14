package frogger;

/** Setup the obstacles for each row in game level 5 */
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
        // row 1
        add(new Log(0,0, row[0], -1.4));
        add(new Log(0,400, row[0], -1.4));
        // row 2
        add(new WetTurtle(600, row[1], 2));
        add(new Turtle(400, row[1], 2));
        add(new WetTurtle(200, row[1], 2));
        // row 3
        add(new WetTurtle(200, row[2], -3));
        add(new Turtle(700, row[2], -3));
        // row 4
        add(new Log(0, 50, row[3], 2.3));
        add(new Log(0, 430, row[3], 2.3));
        // row 5
        add(new Turtle(500, row[4], -1));
        add(new Turtle(300, row[4], -1));
        add(new Turtle(700, row[4], -1));
        // row 6
        add(new WetTurtle(100, row[5], 2));
        add(new WetTurtle(300, row[5], 2));
        add(new WetTurtle(600, row[5], 2));
        // row 7
        add(new Log(2, 0, row[6], 1));
        add(new Log(2, 500, row[6], 1));
        // row 9
        add(new Obstacle(1, 50, row[8], -3));
        add(new Obstacle(1, 300, row[8], -3));
        add(new Obstacle(1, 550, row[8], -3));
        // row 10
        add(new Obstacle(2, 100, row[9], 3));
        add(new Obstacle(3, 500, row[9], 3));
    }
}
