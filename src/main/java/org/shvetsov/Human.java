package org.shvetsov;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Human {
    private String Name;
    private LocalDate createDate;
    private Gender gender;

     public enum Gender {
        MALE, FEMALE;
    }

    public Human(String Name, LocalDate createDate, Gender gender) {
        this.Name = Name;
        this.createDate = createDate;
        this.gender = gender;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
         return Objects.hash(Name, createDate, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj;
        return Objects.equals(Name, human.Name) &&
                Objects.equals(createDate, human.createDate) &&
                gender == human.gender;
    }
}
