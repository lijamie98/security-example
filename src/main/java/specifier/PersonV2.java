package specifier;

/**
 * Created by jamie on 6/26/18.
 */
public class PersonV2 {
    int age = 0;
    boolean discount = false;

    public void setAge(int age) {
        this.age = age;
        if (this.age > 65) {
            discount = true;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", discount=" + discount +
                '}';
    }
}
