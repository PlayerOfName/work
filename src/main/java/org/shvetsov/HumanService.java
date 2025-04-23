package org.shvetsov;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HumanService {

    public enum SortField {
        NAME, AGE, NONE, GENDER
    }

    public Collection<Human> filterHumans(Collection<Human> humans,
                                          String name,
                                          Integer maxAge,
                                          Integer minAge,
                                          Human.Gender gender,
                                          SortField sortField) {
        Comparator<Human> comparator = getComparator(sortField);

        return humans.stream()
                .filter(human -> name == null || human.getName().contains(name))
                .filter(human -> {
                    if (maxAge == null && minAge == null) return true;

                    int age = Period.between(human.getCreateDate(), LocalDate.now()).getYears();
                    boolean matches = true;

                    if (minAge != null) {
                        matches = age >= minAge;
                    }
                    if (maxAge != null) {
                        matches = matches && (age <= maxAge);
                    }
                    return matches;
                })
                .filter(human -> gender == null || human.getGender() == gender)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private Comparator<Human> getComparator(SortField sortField) {
        if (sortField == null || sortField == SortField.NONE) {
            return (a, b) -> 0;
        }

        switch (sortField) {
            case NAME:
                return Comparator.comparing(Human::getName);
            case AGE:
                return Comparator.comparingInt(h ->
                        Period.between(h.getCreateDate(), LocalDate.now()).getYears());
            case GENDER:
                return Comparator.comparing(Human::getGender);
            default:
                return (a, b) -> 0;
        }
    }

    public Collection<Human> filtersHumans(Collection<Human> humans, String name) {
        return humans.stream()
                .filter(human -> human.getName().equals(name))
                .collect(Collectors.toList());
    }
}
