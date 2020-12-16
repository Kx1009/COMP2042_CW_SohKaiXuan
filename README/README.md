# COMP2042_CW_SohKaiXuan

## Key Changes

### Resources Files
The resources files are separated from classes and grouped into various folders for a better organization. Unnecessary files are removed such as the pictures of 
frogger in different directions except front and jumping to front are deleted as the pictures of other directions can be set by rotating the existing image to 
corresponding angle. This applies to the `Obstacles` and `WaterPlatform` too. They are rotated if their speed set is greater than 0. 
For `WetTurtle` class, a random integer is created every time the WetTurtle object is instantiated to differ the animation state for every `WetTurtle`.

### Background Image and Button
A `BackgroundImage` class is created to instantiate different type of background such as start screen, info screen and each unique game level screens while 
the `Button` class is used to handle the creation of `Button` objects in some screens and their respective functionalities.

### Game Level
Addition of `LevelFactory` class which is able to create a `Level` is one of the key changes. The `Level` class is the parent class of all game level class such 
as `Level1` and `Level2` which extends `World`. The existence of `Level` class is to prevent the redundant declarations and instantiations of identical logics and objects 
used in all game levels such as the creation of `Animal` object and the `timer` to start the game. In this case, all the game level will only have to call `super(x)` indicating 
the corresponding game level number, the y-coordinate for the water boundaries and the instantiation of Obstacles object or WaterPlatform object following with adding 
these objects into the background. By implementing **Factory Pattern**, the `LevelFactory` is implemented in the main while creating each game level object instead of 
instantiating each game level object. Using the method `createLevel(level)`, the game level corresponding to the integer `level` can be created without exposing the creation 
logic in the `Main` class.

### Scene Controller
Next, a scene controller is added by the `Controller` class implementing Singleton Pattern to handle multiple screens in the game. In the `Controller` class, `private 
static Controller controller` is instantiated and a method `getInstance()` which will return `controller` is declared. Implementing **Singleton Pattern** this ensures 
only one single `Controller` exists in the whole package as it is used to store various scenes and switch between these scenes by the methods 
`addScreen(name, pane)` and `activate(name)`. Thus, other class can use the `getInstance()` to have the access to `controller` and implement the methods required.

### High Score
Lastly, at the end of the game, a high score list will pop out and show if the player’s score in that level make it to the list. The high score list is permanent and 
saved in each game level respective file which is handled by the `Score` class. The `Score` object consists of several methods such as `readScore()` which will access the 
respective high score file and read the high score list, `changeScore(h)` which will update the high score list with the player’s score, `h` and `renew()` which update the 
respective high score file.
