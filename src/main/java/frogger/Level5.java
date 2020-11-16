package frogger;

public class Level5 extends Level {

    public void act(long now) {

    }

    public Level5(){
        super(5);
        getAnimal().setWater(692.65);
        int a = 130;
        add(new Log(2, 150, 0, 166, 2));
        add(new Log(2, 150, 240, 166, 2));
        add(new Log(2, 150, 568, 166, 2));

        add(new WetTurtle(670, 217, -1, a));
        add(new WetTurtle(330, 217, -1, a));

        add(new Turtle(130, 276, -3, a));
        add(new Turtle(450, 276, -3, a));
        add(new Turtle(720, 276, -3, a));

        add(new Log(2, 150, 50, 329, 1));
        add(new Log(2, 150, 270, 329, 1));

        add(new WetTurtle(750, 376, 3, a));
        add(new WetTurtle(470, 376, 3, a));
        add(new WetTurtle(250, 376, 3, a));

        add(new Log(1, 200, 0, 540, -2));
        add(new Log(1, 200, 370, 540, -2));

        add(new WetTurtle(680, 597, 1, a));
        add(new WetTurtle(420, 597, 1, a));
        add(new WetTurtle(140, 597, 1, a));

        add(new Turtle(200, 649, -3, a));
        add(new Turtle(450, 649, -3, a));
        add(new Turtle(700, 649, -3, a));

    }
}
