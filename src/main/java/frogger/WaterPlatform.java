package frogger;

public class WaterPlatform extends Actor {

    /** speed of the platform */
    public double speed;

    /**
     * Construct a WaterPlatform object which is parent class of Turtle, WetTurtle and Log
     * @param xpos x-coordinate of the WaterPlatform when it is added to the scene
     * @param ypos y-coordinate of the WaterPlatform when it is added to the scene
     * @param s speed and direction of movement of WaterPlatform (speed > 0 indicates moving to right and vice versa)
     */
    public WaterPlatform(int xpos, int ypos, double s) {
        setX(xpos);
        setY(ypos);
        speed = s;
    }

    /**
     * Get the speed of the Log
     * @return the speed of the Log
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    @Override
    public void act(long now) { }
}
