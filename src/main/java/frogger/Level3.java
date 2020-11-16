package frogger;

public class Level3 extends Level {

    public void act(long now) {

    }

    public Level3(){
        super(3);
        getAnimal().setWater(532.66);
        int a = 130;
        add(new Turtle(200, 166, -2, a));
        add(new Turtle(700, 166, -2, a));

        add(new WetTurtle(600, 217, 1, a));
        add(new WetTurtle(400, 217, 1, a));
        add(new WetTurtle(200, 217, 1, a));

        add(new Log(0, 300, 0, 276, -2));
        add(new Log(0, 300, 400, 276, -2));

        add(new Log(2, 150, 50, 329, -0.75));
        add(new Log(2, 150, 270, 329, -0.75));
        add(new Log(2, 150, 490, 329, -0.75));

        add(new WetTurtle(500, 376, -1, a));
        add(new WetTurtle(300, 376, -1, a));
        add(new WetTurtle(700, 376, -1, a));

        add(new Turtle(100, 429, 2, a));
        add(new Turtle(300, 429, 2, a));
        add(new Turtle(600, 429, 2, a));

        add(new Log(1, 200, 0, 492, 1));
        add(new Log(1, 200, 500, 492, 1));

        add(new Obstacle(0, 100, 597, -7, 50));
        add(new Obstacle(0, 550, 597, -7, 50));

        add(new Obstacle(2, 100, 649, 1, 200));
        add(new Obstacle(2, 500, 649, 1, 200));

    }
}
