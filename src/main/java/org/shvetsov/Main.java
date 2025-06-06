package org.shvetsov;

import org.shvetsov.avia.*;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final HumanService humanService = new HumanService();

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

/*        Collection<Human> humans = List.of(
                new Human("Иван", LocalDate.of(1990, 5, 15), Human.Gender.MALE),
                new Human("Игорь", LocalDate.of(1975, 5, 15), Human.Gender.MALE),
                new Human("Мария", LocalDate.of(1995, 8, 20), Human.Gender.FEMALE),
                new Human("Александр", LocalDate.of(1997, 8, 20), Human.Gender.FEMALE),
                new Human("Николай", LocalDate.of(1995, 8, 20), Human.Gender.MALE),
                new Human("Алексей", LocalDate.of(1990, 5, 15), Human.Gender.MALE),
                new Human("Егор", LocalDate.of(1990, 5, 15), Human.Gender.MALE),
                new Human("Иван", LocalDate.of(1990, 5, 15), Human.Gender.MALE)
                );

        Collection<Human> filteredHumans = humanService.filterHumans(humans, null, null, 34, Human.Gender.MALE, HumanService.SortField.NAME);

        for (Human human : filteredHumans) {
            System.out.println(human.getName());
            System.out.println(human.getCreateDate());
            System.out.println(human.getGender());
        }
        System.out.println(filteredHumans.stream().count());*/ // tests
        List<Aircraft> aircrafts = List.of(
                new PassengerPlane("73089", 215, 2100),
                new CargoPlane("76501", 60, 2300),
                new PassengerHelicopter("68345", 12, 16.4),
                new CargoHelicopter("68921", 5.5, 14.8)
        );
        for (Aircraft aircraft : aircrafts) {
            System.out.println(aircraft.toString());
        }
    }

    //Из String в Integer 1
    public static <T, R> Collection<R> convertCollection(Collection<T> source, Function<T, R> mapper) {
        if (source == null) {
            return Collections.emptyList();
        }
        return source.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    // 3 доработать для целых
    public static Double convert(String s) {
        double result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            } else {
                result += (s.charAt(i) - '0') * Math.pow(10, s.length() - i - 1);
            }
        }
        return result;
    }

    public static Double calculationContribution(Double sum, Integer countMonth, Double percent) {
        percent = percent / 100;
        return sum * Math.pow((1 + percent / 12), countMonth);
    }
}