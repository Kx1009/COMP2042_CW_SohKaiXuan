package frogger;

public class Level4 extends Level {

    public void act(long now) {

    }

    public Level4(){
        super(4);
        getAnimal().setWater(426);
        int a = 130;
        add(new Log(2, 150, 0, 166, 0.75));
        add(new Log(2, 150, 220, 166, 0.75));
        add(new Log(2, 150, 440, 166, 0.75));

        add(new WetTurtle(600, 217, -1, a));
        add(new WetTurtle(400, 217, -1, a));
        add(new WetTurtle(200, 217, -1, a));

        add(new Log(0, 300, 0, 276, -2));
        add(new Log(0, 300, 400, 276, -2));

        add(new Log(2, 150, 50, 329, 0.75));
        add(new Log(2, 150, 270, 329, 0.75));
        add(new Log(2, 150, 490, 329, 0.75));

        add(new Turtle(500, 376, -1, a));
        add(new Turtle(300, 376, -1, a));
        add(new Turtle(700, 376, -1, a));

        add(new Obstacle(0, 500, 490, -5, 50));

        add(new Obstacle(2, 0, 540, 1, 200));
        add(new Obstacle(2, 500, 540, 1, 200));

        add(new Obstacle(0, 100, 597, -1, 50));
        add(new Obstacle(0, 250, 597, -1, 50));
        add(new Obstacle(0, 400, 597, -1, 50));
        add(new Obstacle(0, 550, 597, -1, 50));

        add(new Obstacle(1, 0, 649, 1, 120));
        add(new Obstacle(1, 300, 649, 1, 120));
        add(new Obstacle(1, 600, 649, 1, 120));

    }
}
