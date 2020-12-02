package frogger;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

/** The root node that every display object attaches to */
public abstract class World extends Pane {
    /** timer object */
    private AnimationTimer timer;

    /**
     * Create a World object
     * Add listener to the current scene that listens to key event
     */
    public World() {
    	sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
					});
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
					});
				}
			}
		});
    }

    /**
     * Create a timer that calls the act method in every nanoseconds
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
            }
        };
    }

    /**
     * Create a timer and start it
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stop the current timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Add an Actor object
     * @param actor Actor object that needs to be added
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Remove an Actor object
     * @param actor Actor object that needs to be removed
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Get the Actor object attaching to the World object
     * @param cls class of the objects used to add
     * @param <A> the class that must extend Actor
     * @return the children nodes of World object
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
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
