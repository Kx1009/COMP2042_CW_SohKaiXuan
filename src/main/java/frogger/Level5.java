package frogger;

public class Level5 extends Level {

    public void act(long now) {

    }

    public Level5(){
        super(5);
        getAnimal().setWater(692.65);

        add(new Log(2, 0, row[0], 2));
        add(new Log(2, 240, row[0], 2));
        add(new Log(2, 568, row[0], 2));

        add(new WetTurtle(670, row[1], -1));
        add(new WetTurtle(330, row[1], -1));

        add(new Turtle(130, row[2], -3));
        add(new Turtle(450, row[2], -3));
        add(new Turtle(720, row[2], -3));

        add(new Log(2, 50, row[3], 2));
        add(new Log(2, 270, row[3], 2));

        add(new WetTurtle(720, row[4], 3));
        add(new WetTurtle(430, row[4], 3));
        add(new WetTurtle(210, row[4], 3));

        add(new Turtle(100, row[5], 2));
        add(new Turtle(300, row[5], 2));
        add(new Turtle(600, row[5], 2));

        add(new Log(0, 0, row[6], -1.3));
        add(new Log(0, 400, row[6], -1.3));

        add(new Log(1, 0, row[7], -2.8));
        add(new Log(1, 370, row[7], -2.8));

        add(new WetTurtle(680, row[8], 1));
        add(new WetTurtle(420, row[8], 1));
        add(new WetTurtle(140, row[8], 1));

        add(new Turtle(200, row[9], -3));
        add(new Turtle(450, row[9], -3));
        add(new Turtle(700, row[9], -3));

    }
}
