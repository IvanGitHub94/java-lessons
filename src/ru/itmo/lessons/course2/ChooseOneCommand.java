package ru.itmo.lessons.course2;

public class ChooseOneCommand implements Command{
        private Slider slider;

        public ChooseOneCommand(Slider slider){
            this.slider = slider;
        }

        public void execute(){
            slider.slideOne();
        }
}
