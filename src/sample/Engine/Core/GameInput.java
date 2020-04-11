package sample.Engine.Core;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;

public class GameInput extends Canvas {

    private static GameInput instance;

    private static final HashSet<KeyCode> pressedKeys = new HashSet<>();

    public static void setup()
    {
        instance = new GameInput();

        instance.setFocusTraversable(true);
        instance.requestFocus();

        instance.setOnKeyPressed(GameInput::keyPress);
        instance.setOnKeyReleased(GameInput::keyRelease);
    }

    private static void keyPress(KeyEvent e)
    {
        pressedKeys.add(e.getCode());
    }

    private static void keyRelease(KeyEvent e)
    {
        pressedKeys.remove(e.getCode());
    }

    public static boolean isKeyPressed(KeyCode key)
    {
        return pressedKeys.contains(key);
    }

    public static GameInput getInstance()
    {
        return instance;
    }

}
