package specifier;

import java.lang.reflect.Field;

/**
 * Created by jamie on 6/26/18.
 */
public class Main2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PersonV2 person = new PersonV2();

        /*
            Changing the access specifier by-passes "set" function and causes problems.
         */
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person, 70);
        System.out.println(person);

        /*
            The setAge function also sets the discount field.
         */
        person.setAge(70);
        System.out.println(person);
    }
}
