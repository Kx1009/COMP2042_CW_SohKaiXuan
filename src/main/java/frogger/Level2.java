package frogger;

public class Level2 extends Level {

    public void act(long now) {

    }

    public Level2(){
        super(2);
        getAnimal().setWater(479.33);
        add(new Log(2, 0, row[0], -1));
        add(new Log(2, 220, row[0], -1));
        add(new Log(2, 440, row[0], -1));

        add(new WetTurtle(600, row[1], 2));
        add(new WetTurtle(400, row[1], 2));
        add(new WetTurtle(200, row[1], 2));

        add(new Log(0, 0, row[2], -1));
        add(new Log(0, 400, row[2], -1));

        add(new Turtle(200, row[3], -2));
        add(new Turtle(700, row[3], -2));

        add(new WetTurtle(500, row[4], -1));
        add(new WetTurtle(300, row[4], -1));
        add(new WetTurtle(700, row[4], -1));

        add(new Log(0, 0, row[5], 3));
        add(new Log(0, 400, row[5], 3));

        add(new Obstacle(0, 100, row[7], -5));
        add(new Obstacle(0, 400, row[7], -5));

        add(new Obstacle(0, 100, row[8], 1));
        add(new Obstacle(0, 400, row[8], 1));

        add(new Obstacle(2, 0, row[9], 3));
        add(new Obstacle(2, 400, row[9], 3));

    }
}
