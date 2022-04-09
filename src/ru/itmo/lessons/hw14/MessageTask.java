package ru.itmo.lessons.hw14;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        int low = 0;
        int medium = 0;
        int high = 0;
        int urgent = 0;
        for (Message m : messageList) {
            if (m.getPriority() == MessagePriority.LOW) low++;
            if (m.getPriority() == MessagePriority.MEDIUM) medium++;
            if (m.getPriority() == MessagePriority.HIGH) high++;
            if (m.getPriority() == MessagePriority.URGENT) urgent++;
        }
        System.out.println("LOW: " + low);
        System.out.println("MEDIUM: " + medium);
        System.out.println("HIGH: " + high);
        System.out.println("URGENT: " + urgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        HashSet<Integer> integers = new HashSet<>();
        for (Message m : messageList) {
            integers.add(m.getCode());
        }

        HashMap<Integer, Integer> res = new HashMap<>();
        int count = 0;
        for (Integer i : integers) {
            for (Message m : messageList) {
                if (m.getCode() == i) {
                    count++;
                }
            }
            res.put(i, count);
            count = 0;
        }

        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            System.out.println("Code: " + entry.getKey() + ", " + "Count: " + entry.getValue());
        }

    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Integer> integers = new HashSet<>();
        for (Message m : messageList) {
            integers.add(m.getCode());
        }

        HashMap<Integer, Integer> res = new HashMap<>();
        int count = 0;
        for (Integer i : integers) {
            for (Message m : messageList) {
                if (m.getCode() == i) {
                    count++;
                }
            }
            res.put(i, count);
            count = 0;
        }

        int uniqueMessage = 0;
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() == 1) uniqueMessage++;
            System.out.println("Code: " + entry.getKey() + ", " + "Count: " + entry.getValue());
        }
        System.out.println("Уникальных (по коду) сообщений: " + uniqueMessage);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        LinkedHashSet<Message> res = new LinkedHashSet<>(messageList);
        LinkedList<Message> res1 = new LinkedList<>(res);

        return res1;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
        System.out.println(messageList);
    }

}
