package ru.itmo.lessons.course2.Nodes;

public class Node {
    public int key; //ключ узла
    public String data; //некоторые данные в узле
    public Node leftChild; //левый потомок
    public Node rightChild; //правый потомок

    /**
     * Метод который выводит на экран содержимое узла
     */
    public void printNode(){
        System.out.println("KEY " + key + " DATA: " + data);
    }

}
