package vgromova.qa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static vgromova.qa.utils.RandomUtils.getRandomInt;

public class TestData {

    //Статичные переменные
    public final static String FIRST_NAME = "Ivan",
            LAST_NAME = "Ivanov",
            USER_EMAIL = "ivanov@ya.ru",
            USER_NUMBER = "9306705718",
            GENDER = "Male",
            DAY_OF_BIRTH = "03",
            MONTH_OF_BIRTH = "March",
            YEAR_OF_BIRTH = "1990",
            CURRENT_ADDRESS = "India",
            SUBJECT = "Computer Science",
            HOBBY = "Sports",
            PICTURE = "kot_shrek.jpg",
            STATE = "Rajasthan",
            CITY = "Jaipur";

    //Генерация данных

    public String generateCityByState(String state) {
        String[] cityList1 = {"Delhi", "Gurgaon", "Noida"};
        String[] cityList2 = {"Agra", "Lucknow", "Merrut"};
        String[] cityList3 = {"Karnal", "Panipat"};
        String[] cityList4 = {"Jaipur", "Jaiselmer"};
        String city = null;
        if (state == "NCR") {
            city = cityList1[getRandomInt(0, 2)];
        } else if (state == "Uttar Pradesh") {
            city = cityList2[getRandomInt(0, 1)];
        } else if (state == "Haryana") {
            city = cityList3[getRandomInt(0, 2)];
        } else if (state == "Rajasthan") {
            city = cityList4[getRandomInt(0, 1)];
        }

        return city;

    }
    Faker faker = new Faker(new Locale("en"));

    String randFirstName = faker.name().firstName(),
            randLastName = faker.name().lastName(),
            randUserEmail = faker.internet().emailAddress(),
            randUserNumber = faker.phoneNumber().subscriberNumber(10),
            randCurrentAddress  = faker.address().streetAddress();

    String[] genderList = {"Male", "Female", "Other"},
            monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"},
            subjectsList = {"Maths", "English", "Computer Science", "Arts", "History", "Economics", "Biology"},
            hobbiesList = {"Sports", "Reading", "Music"},
            stateList = {"NCR", "Haryana", "Rajasthan", "Uttar Pradesh"};

    String randGender = genderList[getRandomInt(0, 2)],
            randMonthOfBirth = monthList[getRandomInt(0, 11)],
            randDayOfBirth = String.valueOf(getRandomInt(1, 28)),
            randYearOfBirth = String.valueOf(getRandomInt(1900, 2000)),
            randSubject = subjectsList[getRandomInt(0, 6)],
            randHobby = hobbiesList[getRandomInt(0, 2)],
            randState = stateList[getRandomInt(0, 3)],
            randCity = generateCityByState(randState);



}
