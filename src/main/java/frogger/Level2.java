package frogger;

public class Level2 extends Level {

    public void act(long now) {

    }

    public Level2(){
        super(2);
        getAnimal().setWater(479.33);
        int a = 130;
        add(new Log(2, 150, 0, 166, -1));
        add(new Log(2, 150, 220, 166, -1));
        add(new Log(2, 150, 440, 166, -1));

        add(new WetTurtle(600, 217, 2, a));
        add(new WetTurtle(400, 217, 2, a));
        add(new WetTurtle(200, 217, 2, a));

        add(new Log(0, 300, 0, 276, -5));
        add(new Log(0, 300, 400, 276, -5));

        add(new Turtle(200, 329, -2, a));
        add(new Turtle(700, 329, -2, a));

        add(new WetTurtle(500, 376, -1, a));
        add(new WetTurtle(300, 376, -1, a));
        add(new WetTurtle(700, 376, -1, a));

        add(new Log(0, 300, 0, 436, 3));
        add(new Log(0, 300, 400, 436, 3));

        add(new Obstacle(0, 100, 540, -5, 50));
        add(new Obstacle(0, 400, 540, -5, 50));

        add(new Obstacle(0, 100, 597, 5, 50));
        add(new Obstacle(0, 400, 597, 5, 50));

        add(new Obstacle(2, 0, 649, 3, 200));
        add(new Obstacle(2, 400, 649, 3, 200));

    }
}
