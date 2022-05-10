package ru.itmo.lessons.course2.Nodes;

public class Tree {

    Node root;

    // Поиск элемента в дереве по ключу
    public Node find(int key){
        Node current = root;
        while(current.key!=key){
            if(current.key<key){
                current = current.rightChild;
            }else{
                current = current.leftChild;
            }
            if(current==null){
                return null;
            }
        }
        return current;
    }

    /* Вставка в дерево. Суть таже что и поиск
       Только вместо вывода элемента к нему левым или правым потомком
       добавляем новый элемент*/
    public void insert(int key, String data){
        Node node = new Node();
        node.key = key;
        node.data = data;
        if(root==null){
            root = node;
        }else{
            Node current = root;
            Node prev = null;
            while (true){
                prev = current;
                if(key<prev.key){
                    current = current.leftChild;
                    if(current==null){
                        prev.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current==null){
                        prev.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
}
