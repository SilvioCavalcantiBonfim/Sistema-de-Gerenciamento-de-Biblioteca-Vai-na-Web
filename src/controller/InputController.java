package controller;

import java.util.Objects;

public abstract class InputController {

    private static InputController instance = null; 

    public abstract String next();

    public abstract Integer nextInt();

    public static InputController getInstance(){
        if (Objects.isNull(instance)) {
            instance = new ConsoleInputController();
        }
        return instance;
    }
}
