package ru.itmo.lessons.course2;

public class ChooseThreeCommand implements Command{
    private Menu menu;

    public ChooseThreeCommand(Menu menu){
        this.menu = menu;
    }

    public void execute(){
        menu.slideThree();
    }
}
