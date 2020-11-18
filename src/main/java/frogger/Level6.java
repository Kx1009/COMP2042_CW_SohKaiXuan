package frogger;

public class Level6 extends Level {

    public void act(long now) {

    }

    public Level6(){
        super(6);
        getAnimal().setWater(532.66);
        add(new Turtle(200, row[0], -1));
        add(new Turtle(700, row[0], -1));

        add(new WetTurtle(590, row[1], 3));
        add(new WetTurtle(170, row[1], 3));

        add(new Log(0,0, row[2], 1));
        add(new Log(0,400, row[2], 1));

        add(new Log(1, 30, row[3], 3));
        add(new Log(1, 280, row[3], 3));
        add(new Log(1, 600, row[3], 3));

        add(new WetTurtle(200, row[4], -1));
        add(new WetTurtle(640, row[4], -1));

        add(new Turtle(100, row[5], 2));
        add(new Turtle(300, row[5], 2));
        add(new Turtle(600, row[5], 2));

        add(new Log(2, 0, row[6], -1.7));
        add(new Log(2, 435, row[6], -1.7));

        add(new Obstacle(2, 100, row[8], 2));
        add(new Obstacle(0, 550, row[8], 2));

        add(new Obstacle(1, 130, row[9], 5));
        add(new Obstacle(0, 570, row[9], 5));

    }
}
