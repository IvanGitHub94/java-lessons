package ru.itmo.lessons.hw15;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";
        System.out.println("______________ 1 ______________");
        taskOne(firstTaskMap, city);

        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в списке вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println("______________ 2 ______________");
        for (Map.Entry<String, Integer> entry : taskTwo(words).entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println("______________ 3 ______________");
        for (Map.Entry<String, Customer> entry : taskThree(customerMap, 17, 48).entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        //String text = "still still still use will still using like fact" + "here look still";
        String target = "more";
        System.out.println("______________ 4.1 ______________");
        System.out.println(taskFour1(target, text));

        System.out.println("______________ 4.2 ______________");
        for (Map.Entry< Integer, ArrayList<String> > entry : taskFour2(text).entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        System.out.println("______________ 4.3 ______________");
        taskFour3(text);

    }

    public static void taskOne(HashMap<String, String> firstTaskMap, String city) {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : firstTaskMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(city)) {
                result.add(entry.getKey());
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static HashMap<String, Integer> taskTwo(List<String> words) {
        HashMap<String, Integer> result = new HashMap<>();

        ArrayList<String> copy = new ArrayList<>(words);

        HashSet<String> tempSet = new HashSet<>(words);

        int count = 0;
        for (String s : words) {
            for (String str : copy) {
                if (s.equalsIgnoreCase(str)) {
                    count++;
                }
            }
            for (String s1 : tempSet) {
                if (s.equalsIgnoreCase(s1)) {
                    result.put(s1, count);
                }
            }
            count = 0;
        }

        return result;
    }

    public static HashMap<String, Customer> taskThree(HashMap<String, Customer> customerMap, int from, int to) {
        HashMap<String, Customer> result = new HashMap<>();
        for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() < to) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public static int taskFour1(String target, String text) {
        // ! пришлось использовать регулярку, так как в тексте есть конструкция "more-or-less" и "-" не позволяют корректно отработать
        String[] words = text.replaceAll("\\W+", " ").split(" ");
        int count = 0;
        for (String s : words) {
            if (s.equalsIgnoreCase(target)) count++;
        }
        return count;
    }

    public static HashMap< Integer, ArrayList<String> > taskFour2(String text) {
        String[] words = text.replaceAll("\\W+", " ").split(" ");
        HashSet<Integer> lengths = new HashSet<>();

        for (String s : words) {
            lengths.add(s.length());
        }

        HashMap< Integer, ArrayList<String> > res = new HashMap<>();
        for (Integer integer : lengths) {
            ArrayList<String> temp = new ArrayList<>();
            for (String str : words) {
                if (str.length() == integer) {
                    temp.add(str);
                    res.put(integer, temp);
                }
            }
        }
        return res;
    }

    public static void /*ArrayList<String>*/ taskFour3(/*HashMap < Integer, ArrayList<String> > res*/ String text) {
        HashMap< ArrayList<String> , Integer> temp = new HashMap<>();

        HashSet<String> strings = new HashSet<String>();
// добавляем в сет чтобы не сравнивать лишние разы и корректно увеличивать счетчик далее
        for (ArrayList<String> arrayList : /*res.values()*/ taskFour2(text).values()) {
            for (String s : arrayList) {
                strings.add(s.toLowerCase());
            }
        }

        ArrayList<String> copy = new ArrayList<String>();
        for (ArrayList<String> arr : taskFour2(text).values()) {
            for (String s : arr) {
                copy.add(s.toLowerCase());
            }
        }

        // подсчет сколько раз встречается то или иное слово и добавление в мапу - ключ - список из всех одинаковых слов,
        // значение - сколько данное слово встречается в тексте
        int count = 0;
        for (String s1 : strings) {
            ArrayList<String> arrL = new ArrayList<>();
            for (String s : copy) {
                if (s.equals(s1)) {
                    count++;
                    arrL.add(s1);
                }
            }
            temp.put(arrL, count);
            count = 0;
        }

        int a = Integer.MIN_VALUE;
        for (Map.Entry<ArrayList<String>, Integer> entry : temp.entrySet()) {
            //System.out.println(entry.getKey() + " | " + entry.getValue());
            if (entry.getValue() > a) a = entry.getValue();
        }
        System.out.println(a + "\n"); // число повторений самого частого слова в тексте

        int q = 9;
        int top = 1;
        for (int i = a; i > 0; i--) {
        for (Map.Entry<ArrayList<String>, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == i) {
                    if (q < 0) break;
                    System.out.println(top + " место: " + entry.getKey().get(0) + " - количество упоминаний в тексте - " + entry.getKey().size());
                    top++;
                    q--;
                }
            }
        }

    }
}
