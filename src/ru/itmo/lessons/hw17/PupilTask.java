package ru.itmo.lessons.hw17;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {


        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(1, "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(10)),
                new Pupil(2, "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(3, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Pupil(4, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(5, "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(6, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(7, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(17)),
                new Pupil(8, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(5)),
                new Pupil(9, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Pupil(10, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(11, "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(12, "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        //  9. Собрать в список всех учеников с именем=someName
        //  10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        // 1.
        Map<Pupil.Gender, ArrayList<Pupil>> map1 = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (Map.Entry<Pupil.Gender, ArrayList<Pupil>> entry : map1.entrySet()) {
            for (Pupil p : entry.getValue()) {
                System.out.println(entry.getKey() + " | " + p);
            }
        }

        // 2.
        System.out.println("-----------------------------------------------");
                                                                                // блок проверки вывода
                                                                                List<Pupil> integers = map1.values().stream()
                                                                                        .flatMap(Collection::stream)
                                                                                        .collect(Collectors.toList());

                                                                                for (Pupil p : integers) {
                                                                                    System.out.println(p.getName() + " " + (LocalDate.now().getYear() - p.getBirth().getYear()));
                                                                                }
        System.out.println("=================");

        double averageAge = pupils.stream()
                .mapToInt(y -> LocalDate.now().getYear() - y.getBirth().getYear())
                .summaryStatistics()
                .getAverage(); // так же можно использовать .average() вместо .summaryStatistics().getAverage(), но тип тогда должен быть не double, а OptionalDouble

        System.out.println(averageAge);
        System.out.println("=================");

        // 3. and 4.
                                                                                // просто эксперимент, чтобы получить само число младшего Pupil
                                                                                /*int minYear = map1.values().stream()
                                                                                        .flatMap(Collection::stream)
                                                                                        .mapToInt(y -> LocalDate.now().getYear() - y.getBirth().getYear()).min().getAsInt();
                                                                                System.out.println(minYear);*/

        // младший
        Pupil target = pupils.stream()
                .max((o1, o2) -> o1.getBirth().getYear() - o2.getBirth().getYear()).get();

        System.out.println(target);
        System.out.println("=================");

        // старший
        Pupil targetOldest = pupils.stream()
                .min(Comparator.comparing(Pupil::getBirth)/*.reversed() - если метод max()*/)
                .orElse(null);
        System.out.println(targetOldest);
        System.out.println("=================");

        // 5.
        System.out.println("-----------------------------------------------");

        Map<Integer, ArrayList<Pupil>> map2 = pupils.stream()
                .collect(Collectors.groupingBy(y -> y.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));

        for (Map.Entry<Integer, ArrayList<Pupil>> entry : map2.entrySet()) {
            System.out.println(entry.getKey());
            for (Pupil p : entry.getValue()) {
                System.out.println(p);
            }
            System.out.println("====");
        }
        System.out.println("-----------------------------------------------");

        // 6.
        List<Pupil> pupilsCopy = new ArrayList<>(pupils);

        HashSet<String> targetSet = new HashSet<>();
        pupilsCopy.removeIf(p -> !targetSet.add(p.getName()));

        for (Pupil p : pupilsCopy) {
            System.out.println(p.getName() + " " + p.getBirth());
        }
        System.out.println("-----------------------------------------------");

        // 7.
        List<Pupil> newPupils = pupils.stream().sorted(new PupilComparatorGender().thenComparing(new PupilComparatorBirth()).thenComparing(new PupilComparatorName()))
                .collect(Collectors.toList())/*forEach(p -> System.out.println(p.getName() + " " + p.getGender() + " " + p.getBirth()))*/;

        for (Pupil p : newPupils) {
            System.out.println(p.getName() + " " + p.getGender() + " " + p.getBirth());
        }
        System.out.println("-----------------------------------------------");

        // 8.
        List<Pupil> integers1 = pupils.stream()
                .filter(p -> LocalDate.now().getYear() - p.getBirth().getYear() > 6 && LocalDate.now().getYear() - p.getBirth().getYear() < 8)
                .collect(Collectors.toList());
        for (Pupil p : integers1) {
            System.out.println(p);
        }
        System.out.println("-----------------------------------------------");

        // 9. Собрать в список всех учеников с именем=someName
        List<Pupil> names = pupils.stream()
                .filter(p -> p.getName().equals("Алена"))
                .collect(Collectors.toList());
        for (Pupil p : names) {
            System.out.println(p);
        }
        System.out.println("-----------------------------------------------");

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> map10 = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(p -> LocalDate.now().getYear() - p.getBirth().getYear())));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (Map.Entry<Pupil.Gender, Integer> entry : map10.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}

class PupilComparatorGender implements Comparator<Pupil>{

    public int compare(Pupil a, Pupil b){

        return a.getGender().compareTo(b.getGender());
    }
}

class PupilComparatorBirth implements Comparator<Pupil>{

    public int compare(Pupil a, Pupil b){

        return a.getBirth().compareTo(b.getBirth());
    }
}

class PupilComparatorName implements Comparator<Pupil>{

    public int compare(Pupil a, Pupil b){

        return b.getName().compareTo(a.getName()); // порядок изменен ("убывание" по алфавиту)
    }
}