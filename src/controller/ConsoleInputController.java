package controller;

import java.util.Scanner;

class ConsoleInputController extends InputController{

    private final Scanner sc;

    public ConsoleInputController(){
        sc = new Scanner(System.in);
    }

    @Override
    public String next() {
        return sc.nextLine();
    }

    @Override
    public Integer nextInt() {
        return sc.nextInt();
    }
    
}
