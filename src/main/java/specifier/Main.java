package specifier;

import java.lang.reflect.Field;

/**
 * Created by jamie on 6/26/18.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person, 70);
        System.out.println(person);
    }
}
