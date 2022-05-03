package ru.itmo.lessons.course2;

public class ChooseTwoCommand implements Command{
        private Slider slider;

        public ChooseTwoCommand(Slider slider){
            this.slider = slider;
        }

        public void execute(){
            slider.slideTwo();
        }
}
