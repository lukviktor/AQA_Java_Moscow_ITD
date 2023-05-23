package data;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class DataAutorization {
    public static final String USER_NAME = "user";
    public static final String PASSWORD = "password";

    static Random random = new Random();

    public static int randomNumberForName() {
        int min = 1;
        int max = 5;
        int diff = max - min;
        int index = random.nextInt(diff + 1) + min;
        return index;
    }

    public static int randomNumberForPassword() {
        int min = 0;
        int max = 10;
        int diff = max - min;
        int index = random.nextInt(diff + 1) + min;
        return index;
    }

    public static final String USER_NAME_RANDOM = String.format("UserName_%s", RandomStringUtils.randomAlphabetic(randomNumberForName()));
    public static final String USER_FIRST_NAME_RANDOM = String.format("FirstName_%s", RandomStringUtils.randomAlphabetic(randomNumberForName()));
    public static final String USER_LAST_NAME_RANDOM = String.format("LastName_%s", RandomStringUtils.randomAlphabetic(randomNumberForName()));
    public static final String USER_EMAIL_RANDOM = String.format("autotest_%s@gmail.com", RandomStringUtils.randomAlphabetic(randomNumberForName()));
    public static final String USER_PASSWORD_RANDOM = RandomStringUtils.randomAlphanumeric(randomNumberForName()) +
            RandomStringUtils.randomNumeric(randomNumberForPassword());

    @Test
    public void setUserName() {
        System.out.println(USER_NAME_RANDOM);
        System.out.println(USER_FIRST_NAME_RANDOM);
        System.out.println(USER_LAST_NAME_RANDOM);
        System.out.println(USER_EMAIL_RANDOM);
        System.out.println(USER_PASSWORD_RANDOM);
    }
}
