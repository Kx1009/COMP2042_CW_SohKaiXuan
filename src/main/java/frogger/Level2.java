package frogger;

public class Level2 extends Level {

    public void act(long now) {

    }

    public Level2(){
        super(2);
        getAnimal().setWater(426);
        int a = 130;
        add(new Log(2, 150, 0, 166, 1));
        add(new Log(2, 150, 220, 166, 1));
        add(new Log(2, 150, 440, 166, 1));

        add(new WetTurtle(600, 217, -1, a));
        add(new WetTurtle(400, 217, -1, a));
        add(new WetTurtle(200, 217, -1, a));

        add(new Log(0, 300, 0, 276, -2));
        add(new Log(0, 300, 400, 276, -2));

        add(new Log(2, 150, 50, 329, 1));
        add(new Log(2, 150, 270, 329, 1));
        add(new Log(2, 150, 490, 329, 1));

        add(new WetTurtle(500, 376, -1, a));
        add(new WetTurtle(300, 376, -1, a));
        add(new WetTurtle(700, 376, -1, a));

        add(new Obstacle(0, 100, 490, -5, 50));
        add(new Obstacle(0, 400, 490, -5, 50));

        add(new Obstacle(2, 0, 540, 1, 200));
        add(new Obstacle(2, 500, 540, 1, 200));

        add(new Obstacle(0, 100, 597, 5, 50));
        add(new Obstacle(0, 400, 597, 5, 50));

        add(new Obstacle(2, 0, 649, 3, 200));
        add(new Obstacle(2, 400, 649, 3, 200));

    }
}
