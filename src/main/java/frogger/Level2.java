package frogger;

public class Level2 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level2 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level2(){
        super(2);
        getAnimal().setWater(426);
        add(new Turtle(0, row[0], 2));
        add(new Turtle(220, row[0],2));
        add(new Turtle(440, row[0],2));

        add(new WetTurtle(600, row[1], -1));
        add(new WetTurtle(400, row[1], -1));
        add(new Turtle(200, row[1], -1));

        add(new Log(0, 0, row[2], 2.75));
        add(new Log(0, 400, row[2],2.75));

        add(new Turtle(500, row[3], -1));
        add(new WetTurtle(300, row[3], -1));
        add(new WetTurtle(700, row[3], -1));

        add(new Log(1, 150, row[4], -0.8));
        add(new Log(1, 490, row[4], -0.8));

        add(new Obstacle(0, 0, row[6], 5));
        add(new Obstacle(0, 500, row[6], 5));

        add(new Obstacle(2, 0, row[7], 1));
        add(new Obstacle(2, 500, row[7], 1));

        add(new Obstacle(0, 100, row[8], 2));
        add(new Obstacle(0, 250, row[8], 2));
        add(new Obstacle(0, 550, row[8], 2));

        add(new Obstacle(0, 0, row[9], -2));
        add(new Obstacle(0, 300, row[9], -2));
        add(new Obstacle(0, 550, row[9], -2));

    }
}
