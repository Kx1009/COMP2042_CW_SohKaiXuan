package frogger;

public class Level4 extends Level {

    public void act(long now) {

    }

    public Level4(){
        super(4);
        getAnimal().setWater(532.66);
        int a = 130;
        add(new Turtle(450, 166, 1, a));
        add(new Turtle(200, 166, 1, a));
        add(new Turtle(700, 166, 1, a));

        add(new WetTurtle(600, 217, -1, a));
        add(new WetTurtle(400, 217, -1, a));
        add(new WetTurtle(200, 217, -1, a));

        add(new Log(0, 300, 0, 276, -2));
        add(new Log(0, 300, 400, 276, -2));

        add(new WetTurtle(600, 329, 1, a));
        add(new WetTurtle(300, 329, 1, a));
        add(new WetTurtle(100, 329, 1, a));

        add(new Turtle(500, 376, -2, a));
        add(new Turtle(300, 376, -2, a));
        add(new Turtle(700, 376, -2, a));

        add(new Log(2, 150, 270, 432, 3));
        add(new Log(2, 150, 490, 432, 3));

        add(new Log(1, 200, 150, 490, 2));
        add(new Log(1, 200, 380, 490, 2));
        add(new Log(1, 200, 650, 490, 2));

        add(new Turtle(200, 540, -1, a));
        add(new Turtle(350, 540, -1, a));
        add(new Turtle(700, 540, -1, a));

        add(new Obstacle(1, 100, 597, 2, 120));
        add(new Obstacle(1, 400, 597, 2, 120));

        add(new Obstacle(0, 0, 649, 4, 50));
        add(new Obstacle(0, 400, 649, 4, 50));

    }
}
