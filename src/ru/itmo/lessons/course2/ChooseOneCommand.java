package ru.itmo.lessons.course2;

public class ChooseOneCommand implements Command{
        private Menu menu;

        public ChooseOneCommand(Menu menu){
            this.menu = menu;
        }
    // для старта игры
        public void execute(){
            menu.slideOne();
        }
}
