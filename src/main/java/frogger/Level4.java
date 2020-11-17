package frogger;

public class Level4 extends Level {

    public void act(long now) {

    }

    public Level4(){
        super(4);
        getAnimal().setWater(586);

        add(new Turtle(450, row[0], 1));
        add(new Turtle(200, row[0], 1));
        add(new Turtle(700, row[0], 1));

        add(new WetTurtle(600, row[1], -1));
        add(new WetTurtle(400, row[1], -1));
        add(new WetTurtle(200, row[1], -1));

        add(new Log(0, 0, row[2], -2.25));
        add(new Log(0, 400, row[2], -2.25));

        add(new WetTurtle(600, row[3], 1));
        add(new WetTurtle(300, row[3], 1));
        add(new WetTurtle(100, row[3], 1));

        add(new Turtle(500, row[4], -2));
        add(new Turtle(300, row[4], -2));
        add(new Turtle(700, row[4], -2));

        add(new Log(2,270, row[5], 1.25));
        add(new Log(2,490, row[5], 1.25));

        add(new Log(1, 150, row[6], 2.5));
        add(new Log(1, 380, row[6], 2.5));
        add(new Log(1, 650, row[6], 2.5));

        add(new Turtle(200, row[7], -1));
        add(new Turtle(350, row[7], -1));
        add(new Turtle(700, row[7], -1));

        add(new Obstacle(0, 0, row[9], 5));
        add(new Obstacle(0, 400, row[9], 5));

    }
}
