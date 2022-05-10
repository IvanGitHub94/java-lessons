package ru.itmo.lessons.course2;

public class ChooseTwoCommand implements Command{
        private Menu menu;

        public ChooseTwoCommand(Menu menu){
            this.menu = menu;
        }
    // для загрузки игры
        public void execute(){
            menu.slideTwo();
        }
}
