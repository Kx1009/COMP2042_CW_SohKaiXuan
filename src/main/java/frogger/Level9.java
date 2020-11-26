package frogger;

public class Level9 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level9 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level9(){
        super(9);
        getAnimal().setWater(692.65);

        add(new Log(2, 0, row[0], 0.8));
        add(new Log(2, 568, row[0], 0.8));

        add(new WetTurtle(670, row[1], -1));
        add(new Turtle(210, row[1], -1));

        add(new WetTurtle(540, row[2], 3));
        add(new Log(2, 50, row[2], 3));

        add(new Log(0, 130, row[3], -4.1));
        add(new Log(2, 610, row[3], -4.1));

        add(new Turtle(720, row[4], 3));
        add(new Turtle(430, row[4], 3));
        add(new Turtle(210, row[4], 3));

        add(new WetTurtle(100, row[5], 2));
        add(new Turtle(300, row[5], 2));
        add(new WetTurtle(600, row[5], 2));

        add(new Log(2, 0, row[6], -3.3));
        add(new Log(1, 400, row[6], -3.3));

        add(new Log(1, 0, row[7], -2.8));
        add(new Log(0, 470, row[7], -2.8));

        add(new Turtle(200, row[8], -3));
        add(new Turtle(450, row[8], -3));
        add(new Turtle(700, row[8], -3));

        add(new WetTurtle(680, row[9], 1));
        add(new WetTurtle(420, row[9], 1));
        add(new WetTurtle(140, row[9], 1));

    }
}
