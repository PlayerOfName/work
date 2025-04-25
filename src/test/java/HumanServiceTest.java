import org.junit.jupiter.api.Test;
import org.shvetsov.Human;
import org.shvetsov.HumanService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanServiceTest {

    private HumanService humanService = new HumanService();

    private final List<Human> testHumans = List.of(
            new Human("Иван", LocalDate.of(1990, 5, 15), Human.Gender.MALE),
            new Human("Мария", LocalDate.of(1985, 8, 20), Human.Gender.FEMALE),
            new Human("Алексей", LocalDate.of(1995, 3, 10), Human.Gender.MALE),
            new Human("Елена", LocalDate.of(2000, 7, 25), Human.Gender.FEMALE)
    );

    @Test
    void filterByName() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, "Иван", null, null, null, HumanService.SortField.NONE);

        assertEquals(1, result.size());
        assertTrue(result.stream().allMatch(h -> h.getName().contains("Иван")));
    }

    @Test
    void filterByAgeRange() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, null, 35, 25, null, HumanService.SortField.NONE);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(h -> {
            int age = Period.between(h.getCreateDate(), LocalDate.now()).getYears();
            return age >= 25 && age <= 35;
        }));
    }

    @Test
    void filterByGender() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, null, null, null, Human.Gender.MALE, HumanService.SortField.NONE);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(h -> h.getGender() == Human.Gender.MALE));
    }

    @Test
    void sortByAge_shouldReturnYoungestFirst() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, null, null, null, null, HumanService.SortField.AGE);

        List<Human> sorted = List.copyOf(result);
        int age1 = Period.between(sorted.get(0).getCreateDate(), LocalDate.now()).getYears();
        int age2 = Period.between(sorted.get(1).getCreateDate(), LocalDate.now()).getYears();
        assertTrue(age1 <= age2);
    }

    @Test
    void sortByAge() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, null, null, null, null, HumanService.SortField.AGE);

        List<Human> sorted = List.copyOf(result);
        int age1 = Period.between(sorted.get(0).getCreateDate(), LocalDate.now()).getYears();
        int age2 = Period.between(sorted.get(1).getCreateDate(), LocalDate.now()).getYears();
        assertTrue(age1 <= age2);
    }

    @Test
    void emptyResult() {
        Collection<Human> result = humanService.filterHumans(
                testHumans, "НетТакогоИмени", 10, 5, null, HumanService.SortField.NONE);

        assertTrue(result.isEmpty());
    }
}
