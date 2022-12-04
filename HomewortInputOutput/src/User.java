import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String get(){
        return "Name: " + name + "\n" + "Surname: " + surname + "\n" + "Age: " + age;
    }

    @Override
    public String toString() {
        return name + '_' + surname;
    }
}
