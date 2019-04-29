package com.company;

public class Main {

    public static void main(String[] args)
    {
        Str input = new Str();

        input.Init();
        input.fromInfixToPostfix();
        input.Display();
    }
}
