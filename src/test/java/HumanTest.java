import org.junit.jupiter.api.Test;
import org.shvetsov.Human;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    // Образцы тестовых объектов
    private final Human human1 = new Human(
            "Иван",
            LocalDate.of(1990, 5, 15),
            Human.Gender.MALE
    );

    private final Human human1Copy = new Human(
            "Иван",
            LocalDate.of(1990, 5, 15),
            Human.Gender.MALE
    );

    private final Human human2 = new Human(
            "Мария",
            LocalDate.of(1995, 8, 20),
            Human.Gender.FEMALE
    );
    
    @Test
    void equals_IsReflexive() {
        assertEquals(human1, human1);
    }

    @Test
    void equals_IsSymmetric() {
        assertEquals(human1, human1Copy);
        assertEquals(human1Copy, human1);
    }

    @Test
    void equals_IsTransitive() {
        Human human1Copy2 = new Human(
                "Иван",
                LocalDate.of(1990, 5, 15),
                Human.Gender.MALE
        );
        assertEquals(human1, human1Copy);
        assertEquals(human1Copy, human1Copy2);
        assertEquals(human1, human1Copy2);
    }

    @Test
    void equals_IsConsistent() {
        assertTrue(human1.equals(human1Copy));
        assertTrue(human1.equals(human1Copy)); // Повторный вызов
    }

    @Test
    void equals_Null_ReturnsFalse() {
        assertFalse(human1.equals(null));
    }

    @Test
    void equals_DifferentClass_ReturnsFalse() {
        assertFalse(human1.equals("Это строка, а не Human"));
    }

    @Test
    void equals_DifferentFields_ReturnsFalse() {
        assertFalse(human1.equals(human2));
    }

    @Test
    void equals_SameFields_ReturnsTrue() {
        assertEquals(human1, human1Copy);
    }
}