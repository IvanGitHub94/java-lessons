package ru.itmo.lessons.hw17;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        /*List<Pupil> integers = map1.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());*/

        /*for (Pupil p : integers) {
            System.out.println(LocalDate.now().getYear() - p.getBirth().getYear());
        }*/

        System.out.println("=================");

        double averageAge = map1.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(y -> LocalDate.now().getYear() - y.getBirth().getYear())
                .summaryStatistics()
                .getAverage();

        System.out.println(averageAge);

        // 3. and 4.
        // просто эксперимент, чтобы получить само число младшего Pupil
        /*int minYear = map1.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(y -> LocalDate.now().getYear() - y.getBirth().getYear()).min().getAsInt();
        System.out.println(minYear);*/

        // младший
        Pupil target = map1.values().stream()
                .flatMap(Collection::stream)
                .max(Comparator.comparing(Pupil::getBirth)/*.reversed() - если метод min()*/)
                .orElse(null);

        System.out.println(target);
        // старший
        Pupil targetOldest = map1.values().stream()
                .flatMap(Collection::stream)
                .min(Comparator.comparing(Pupil::getBirth)/*.reversed() - если метод max()*/)
                .orElse(null);
        System.out.println(targetOldest);

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
    }
}
