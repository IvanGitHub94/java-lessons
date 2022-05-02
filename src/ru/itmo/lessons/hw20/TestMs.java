package ru.itmo.lessons.hw20;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TestMs {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime a = LocalDateTime.now();
        System.out.println(a);
        Thread.sleep(12);
        LocalDateTime b = LocalDateTime.now();
        System.out.println(b);
        System.out.println("-------------------------------");

        long durationInMs = TimeUnit.NANOSECONDS.toMillis(710688300 - 646430200);
        System.out.println(durationInMs);
    }
}
