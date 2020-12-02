package frogger;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

/** Parent class to all moving object in the game screen */
public abstract class Actor extends ImageView{

    /**
     * Move the Actor object by certain pixels from its current position
     * @param dx distance to move along x-axis in pixels
     * @param dy distance to move along y-axis in pixels
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Get the World instance
     * @return World object
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Get the width of the Actor object
     * @return the width of the Actor object
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Get the height of the Actor object
     * @return the height of the Actor object
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Get all the object with the class that intersects the Actor
     * @param cls class used to check for intersecting
     * @param <A> the class that must extend Actor
     * @return an array of object with that class that intersects the Actor object
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    public abstract void act(long now);

}
