package frogger;

public class Level1 extends World {

    private int Endx;
    private int Endy;
    public void act(long now) {

    }

    public Level1(){
        BackgroundImage froggerback = new BackgroundImage(1);
        this.add(froggerback);

        this.add(new Log(2, 150, 0, 166, 0.75));
        this.add(new Log(2, 150, 220, 166, 0.75));
        this.add(new Log(2, 150, 440, 166, 0.75));

        this.add(new Log(0, 300, 0, 276, -2));
        this.add(new Log(0, 300, 400, 276, -2));

        this.add(new Log(2, 150, 50, 329, 0.75));
        this.add(new Log(2, 150, 270, 329, 0.75));
        this.add(new Log(2, 150, 490, 329, 0.75));

        int a = 130;
        this.add(new Turtle(500, 376, -1, a));
        this.add(new Turtle(300, 376, -1, a));
        this.add(new Turtle(700, 376, -1, a));
        this.add(new WetTurtle(600, 217, -1, a));
        this.add(new WetTurtle(400, 217, -1, a));
        this.add(new WetTurtle(200, 217, -1, a));

        Endx = 141-13;
        Endy = 96;
        for (int i = 0; i < 5; i++) {
            this.add(new End(13+i*Endx,Endy));
        }

        this.add(new Obstacle(1, 0, 649, 1, 120));
        this.add(new Obstacle(1, 300, 649, 1, 120));
        this.add(new Obstacle(1, 600, 649, 1, 120));

        this.add(new Obstacle(0, 100, 597, -1, 50));
        this.add(new Obstacle(0, 250, 597, -1, 50));
        this.add(new Obstacle(0, 400, 597, -1, 50));
        this.add(new Obstacle(0, 550, 597, -1, 50));

        this.add(new Obstacle(2, 0, 540, 1, 200));
        this.add(new Obstacle(2, 500, 540, 1, 200));

        this.add(new Obstacle(0, 500, 490, -5, 50));
        // reposition the score
        this.add(new Digit(0, 30, 565, 35));

    }
}
