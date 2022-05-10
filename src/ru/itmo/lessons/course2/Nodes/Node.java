package ru.itmo.lessons.course2.Nodes;

public class Node {
    public int key; //ключ узла, без ключа бинарное древо поиска не может существовать
    public String data; //некоторые данные в узле
    public Node leftChild; //левый потомок
    public Node rightChild; //правый потомок

    public void printNode(){
        System.out.println(data);
    }

}
