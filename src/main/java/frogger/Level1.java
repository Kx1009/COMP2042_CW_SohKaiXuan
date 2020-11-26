package frogger;

public class Level1 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level1 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level1(){
        super(1);
        getAnimal().setWater(426);
        add(new Log(2, 0, row[0], 0.75));
        add(new Log(2, 220, row[0],0.75));
        add(new Log(2, 440, row[0],0.75));

        add(new WetTurtle(600, row[1], -1));
        add(new WetTurtle(400, row[1], -1));
        add(new WetTurtle(200, row[1], -1));

        add(new Log(0, 0, row[2], -2));
        add(new Log(0, 400, row[2],-2));

        add(new Log(2, 50, row[3], 0.75));
        add(new Log(2, 270, row[3], 0.75));
        add(new Log(2, 490, row[3], 0.75));

        add(new Turtle(500, row[4], -1));
        add(new Turtle(300, row[4], -1));
        add(new Turtle(700, row[4], -1));

        add(new Obstacle(0, 500, row[6], -5));

        add(new Obstacle(2, 0, row[7], 1));
        add(new Obstacle(2, 500, row[7], 1));

        add(new Obstacle(0, 100, row[8], -1));
        add(new Obstacle(0, 250, row[8], -1));
        add(new Obstacle(0, 400, row[8], -1));
        add(new Obstacle(0, 550, row[8], -1));

        add(new Obstacle(1, 0, row[9], 1));
        add(new Obstacle(1, 300, row[9], 1));
        add(new Obstacle(1, 600, row[9], 1));

    }
}
