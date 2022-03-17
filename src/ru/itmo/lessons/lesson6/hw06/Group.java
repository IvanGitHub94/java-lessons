package ru.itmo.lessons.lesson6.hw06;

import java.util.Objects;

public class Group {
    private String groupName;
    private boolean openGroup; // набор в группу ведется или нет
    private Alpinist[] alpArr; // массив альпинистов
    private Mountain targetMountain; // гора, на которую восходит группа

    // Конструкторы
    public Group(boolean openGroup, Alpinist[] alpArr){
        setOpenGroup(openGroup);
        setAlpArr(alpArr);
    }

    // Сеттеры
    public void setGroupName(String groupName) {
        if (groupName.length() < 3) {
            throw new IllegalArgumentException("Название группы должно содержать хотя бы 3 символа");
        }
        this.groupName = groupName;
    }

    public void setOpenGroup(boolean openGroup) {
        this.openGroup = openGroup;
    }

    public void setAlpArr(Alpinist[] alpArr) {
        this.alpArr = alpArr;
    }

    public void setTargetMountain(Mountain targetMountain) {
        this.targetMountain = targetMountain;
    }

    // Геттеры
    public String getGroupName() {
        return groupName;
    }

    public boolean isOpenGroup() {
        return openGroup;
    }

    public Alpinist[] getAlpArr() {
        return alpArr;
    }

    public Mountain getTargetMountain() {
        return targetMountain;
    }

    ////////////////////////////////////////////////
    public void addAlpinist(Alpinist alpinist) {
        if (!openGroup) {
            System.out.println("Набор в группу '" + groupName + "' закрыт.");
        } else {
            for (int i = 0; i < alpArr.length; i++) {
                if (alpArr[i] == null) {
                    alpArr[i] = alpinist;
                    return;
                }
            }
            System.out.println("Набор альпинистов в группу '" + groupName + "' завершен.");
            System.out.println("Альпинисту '"
                    + alpinist.getName()
                    + "' не хватило места в группе '"
                    + groupName
                    + "'.");
            openGroup = false;
        }
    }

    public void addAlpinist(Alpinist... alpinists){
        for (Alpinist alpinist : alpinists) {
            addAlpinist(alpinist);
        }
    }

}
