package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private String patronymic;
    private Date dateBirthday;
    private String days;
    private Date nextYear;

    public Person(String lastName, String firstName, String patronymic, Date dateBirthday, String days, Date nextYear){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateBirthday = dateBirthday;
        this.days = days;
        this.nextYear = nextYear;
    }

    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
        }
    public String getPatronymic(){
        return patronymic;
    }
    public Date getDateBirthday(){
        return dateBirthday;
    }
    public String getDays() {
        return days;
    }
    public Date getNextYear() {
        return nextYear;
    }

    public int getAge(){
        Date date = new Date();
        return (int)((date.getTime() - getDateBirthday().getTime())/1000/24/60/60/365);
    }


    public String toString(){
        return String.format("Фамилия: %s| Имя: %s| Отчество: %s| Дата: %s| %s|",
                getLastName(),getFirstName(),getPatronymic(), new SimpleDateFormat("dd.MM.yyyy").format(getDateBirthday()),getDays());
    }
}
