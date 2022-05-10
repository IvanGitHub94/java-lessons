package ru.itmo.lessons.course2;

public class ChooseFourCommand implements Command{
    private Menu menu;

    public ChooseFourCommand(Menu menu){
        this.menu = menu;
    }
// для выхода из игры
    public void execute(){
        menu.slideFour();
    }
}
