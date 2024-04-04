/*
 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
     приложения, которое является
        а) информационной системой ветеринарной клиники
        б) архивом выставки котов
        в) информационной системой Театра кошек Ю. Д. Куклачёва

  Ветеринарная клиника
      поля:     кличка (name)
                порода (breed)
                окрас (color)
                возраст (age)
                владелец (owner)
                номер карты (cardID)
                прививки (vaccinationList)
                история посещений (visitHistory)
      методы:   getters (getName, getBreed, getColor, getAge и т.д.)
                setters (getName, getBreed, getColor, getAge и т.д.)
                addVisit
                addVaccination
*/

/*
    Архив выставки котов
      поля:     кличка (name)
                порода (breed)
                окрас (color)
                возраст (age)
                владелец (owner)
                прививки (vaccinationList)
                история участий (eventHistory)
                награды (awards)
      методы:   getters (getName, getBreed, getColor, getAge и т.д.)
                setters (getName, getBreed, getColor, getAge и т.д.)
                addAward
                addEvent
 */

/*
    Театра кошек Ю. Д. Куклачёва
      поля:     кличка (name)
                порода (breed)
                окрас (color)
                возраст (age)
                дрессировщик (trainer)
                прививки (vaccinationList)
                навыки (skillsList)
      методы:   getters (getName, getBreed, getColor, getAge и т.д.)
                setters (getName, getBreed, getColor, getAge и т.д.)
                addSkill
 */

//  1.  Создайте несколько
//      экземпляров этого класса, выведите их в консоль.
//  2.  Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
//      его кличка, цвет и возраст (или другие параметры на ваше усмотрение)


import java.util.Objects;

public class Cat {
    private String name;
    private String color;
    private int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Кличка:  %s, \tцвет: %s, \tвозраст: %d", name, color, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cat cat = (Cat) obj;
        // System.out.println("this:  " + this);
        return name.equals(cat.name) && color.equals(cat.color) && age == cat.age;
    }

    @Override
    public int hashCode() {
        // System.out.println("hashCode(): " + this + "\t\t" + Objects.hash(name, color, age));
        return Objects.hash(name, color, age);
    }
}