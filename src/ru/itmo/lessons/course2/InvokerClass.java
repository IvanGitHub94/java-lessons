package ru.itmo.lessons.course2;

public class InvokerClass {
    private Command flipOneCommand;
    private Command flipTwoCommand;

    public InvokerClass(Command flipOneCommand,Command flipTwoCommand){
        this.flipOneCommand = flipOneCommand;
        this.flipTwoCommand = flipTwoCommand;
    }

    public void flipOne(){
        flipOneCommand.execute();
    }

    public void flipTwo(){
        flipTwoCommand.execute();
    }
}
