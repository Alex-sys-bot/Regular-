package ru.sapteh;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        List<Person> listPerson = new ArrayList<>();

//        createFile;
        String fileName = "Persons.txt";
        File file = new File(fileName);
        System.out.println(file.createNewFile() ? "Создание файла: успешно" : "Создание файла: не успешно");


//        writeFile;
        BufferedReader writerFile = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите данные:");
        String write = writerFile.readLine();
        FileWriter fwPersons = new FileWriter(fileName);
        Person person = getPerson(write);
        listPerson.add(person);

        for (Person person1: listPerson) {
            fwPersons.write(person1.toString() + " Возраст: " + person1.getAge() + "| ");
        }

        fwPersons.close();
    }

//        createObject
    public static Person getPerson(String strSub) throws ParseException {
        String[] arrPerson = strSub.split(" ");
        String lastName  = arrPerson[0];
        String firstName = arrPerson[1];
        String patronymic = arrPerson[2];
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(arrPerson[3].replaceAll("[^0-9]", "."));
//        quantityDay;
        String daysWeek = String.format("%ta",date);
        System.out.printf("%tF \n",nexDayBirthday(date));
        System.out.println(quantityDays(nexDayBirthday(date)));
        return new Person(lastName,firstName,patronymic,date,daysWeek, nexDayBirthday(date));
    }

    public static Date nexDayBirthday(Date birthday ) throws ParseException {
//        birthday
        String[] parseBirthday = String.format("%tF", birthday).split("-");
        int days = Integer.parseInt(parseBirthday[2]);
        int month = Integer.parseInt(parseBirthday[1]);
        int year = Integer.parseInt(parseBirthday[0]);

//        lastBirthday
        Date nowDate = new Date();
        String[] stringsNowDate = String.format("%tF", nowDate).split("-");
        int nowDays = Integer.parseInt(stringsNowDate[2]);
        int nowMonth = Integer.parseInt(stringsNowDate[1]);
        int nowYear = Integer.parseInt(stringsNowDate[0]);

        if (nowMonth <= month && nowDays <= days){
            return new SimpleDateFormat("dd.MM.yyyy").parse( days + "." + month + "." + nowYear);
        } else {
            nowYear = nowYear + 1;
            return new SimpleDateFormat("dd.MM.yyyy").parse( days + "." + month + "." + nowYear);
        }
    }

    public static int quantityDays(Date quantity){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date nowDate = calendar.getTime();
        int daysOfBirthday = (int)((quantity.getTime() - nowDate.getTime())/1000/24/60/60);
        return daysOfBirthday;
    }
}
