import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        final String folderName = System.getProperty("user.dir") + File.separator + "users";
        File file = new File(folderName);
        List<String> bundle;
        List<User> newUsers;
        List<User> users = new ArrayList<User>(Arrays.asList(new User("Pavel", "Koutchmel", 30),
                new User("Victoria", "Koutchmel", 25), new User("Pavel", "Nikiforov", 40),
                new User("Ivan", "Durak", 23), new User("Alesha", "Popovich", 40),
                new User("Ilya", "Muromec", 38), new User("Jo", "Baiden", 80)));

        if (!file.exists()){
            if (file.mkdir()) System.err.println("Каталог " + folderName + " создан.");
            else System.err.println("Не удалось создать каталог.");
        }
        else {
            System.err.println("Каталог уже существует.");
        }

        //Сериализация объектов
        for(User user : users){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderName + File.separator + user.toString()+".txt"))){
                oos.writeObject(user);
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }

        System.out.println();
        //Десериализация объектов
        bundle = new ArrayList<>(Arrays.asList(file.list()));
        newUsers = new ArrayList<>(bundle.size());
        for (String str : bundle){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderName + File.separator + str));) {
                newUsers.add((User) ois.readObject());
            }catch (IOException e){
                System.err.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        for (User user : newUsers){
            System.out.println(user.get());
        }
    }
}
