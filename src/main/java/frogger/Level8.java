package frogger;

public class Level8 extends Level {

    public void act(long now) {

    }

    public Level8(){
        super(8);
        getAnimal().setWater(586);

        add(new Log(0, 0, row[0], -1));
        add(new Log(1, 400, row[0], -1));

        add(new Turtle(600, row[1], -4));
        add(new WetTurtle(200, row[1], -4));

        add(new Log(2, 150, row[2], 0.8));
        add(new Log(1, 650, row[2], 0.8));

        add(new WetTurtle(0, row[3], -3));
        add(new WetTurtle(270, row[3], -3));
        add(new WetTurtle(530, row[3], -3));

        add(new Turtle(100, row[4], 2));
        add(new Log(2,430, row[4], 2));

        add(new WetTurtle(200, row[5], -2));
        add(new WetTurtle(700, row[5], -2));

        add(new Log(0,430, row[6], 1));
        add(new Turtle(170, row[6], 1));

        add(new WetTurtle(200, row[7], -3));
        add(new WetTurtle(700, row[7], -3));

        add(new Obstacle(1, 0, row[9], 5));
        add(new Obstacle(2, 400, row[9], 5));

    }
}
