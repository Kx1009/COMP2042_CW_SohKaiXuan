package frogger;

public class Level10 extends Level {

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public void act(long now) { }

    /**
     * Construct Level10 object
     * Call parent class Level with current game level
     * Set water boundaries
     * Add obstacles into each row
     */
    public Level10(){
        super(10);
        getAnimal().setWater(692.65);

        add(new Log(1, 20, row[0], 2));
        add(new Log(1, 300, row[0], 2));
        add(new Log(1, 590, row[0], 2));

        add(new Turtle(30, row[1], -1));
        add(new WetTurtle(670, row[1], -1));
        add(new WetTurtle(330, row[1], -1));

        add(new Turtle(130, row[2], -3));
        add(new Turtle(620, row[2], -3));

        add(new Log(2, 50, row[3], 2));
        add(new Log(2, 270, row[3], 2));

        add(new WetTurtle(720, row[4], -1));
        add(new Turtle(430, row[4], -1));
        add(new Turtle(210, row[4], -1));

        add(new Log(2, 110, row[5], 1.9));
        add(new Log(2, 530, row[5], 1.9));

        add(new Log(0, 0, row[6], 2.7));
        add(new Log(1, 400, row[6], 2.7));

        add(new Turtle(680, row[7], -2));
        add(new Turtle(420, row[7], -2));
        add(new WetTurtle(140, row[7], -2));

        add(new WetTurtle(680, row[8], 1));
        add(new Turtle(420, row[8], 1));
        add(new WetTurtle(140, row[8], 1));

        add(new Turtle(200, row[9], -3));
        add(new Turtle(450, row[9], -3));
        add(new Turtle(700, row[9], -3));

    }
}
