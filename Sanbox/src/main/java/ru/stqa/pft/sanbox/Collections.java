package ru.stqa.pft.sanbox;

import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};  // Массив

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP"); // Динамический список

        for (String l : languages) {
            System.out.println("Я хочу изучить " + l);
        }
    }
}
