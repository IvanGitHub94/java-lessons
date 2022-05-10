package ru.itmo.lessons.course2;

public class ChooseFourCommand implements Command{
    private Menu menu;

    public ChooseFourCommand(Menu menu){
        this.menu = menu;
    }
// для сохранения игры
    public void execute(){
        menu.slideFour();
    }
}
