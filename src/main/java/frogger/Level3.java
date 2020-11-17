package frogger;

public class Level3 extends Level {

    public void act(long now) {

    }

    public Level3(){
        super(3);
        getAnimal().setWater(532.66);
        add(new Turtle(200, row[0], -1));
        add(new Turtle(700, row[0], -1));

        add(new WetTurtle(600, row[1], 3));
        add(new WetTurtle(400, row[1], 3));
        add(new WetTurtle(200, row[1], 3));

        add(new Log(0,0, row[2], -2));
        add(new Log(0,400, row[2], -2));

        add(new Log(2, 50, row[3], -0.5));
        add(new Log(2, 270, row[3], -0.5));
        add(new Log(2, 490, row[3], -0.5));

        add(new WetTurtle(500, row[4], -1));
        add(new WetTurtle(300, row[4], -1));
        add(new WetTurtle(700, row[4], -1));

        add(new Turtle(100, row[5], 2));
        add(new Turtle(300, row[5], 2));
        add(new Turtle(600, row[5], 2));

        add(new Log(1, 0, row[6], 1));
        add(new Log(1, 500, row[6], 1));

        add(new Obstacle(0, 100, row[8], -3));
        add(new Obstacle(0, 550, row[8], -3));

        add(new Obstacle(2, 100, row[9], 1));
        add(new Obstacle(2, 500, row[9], 1));

    }
}
