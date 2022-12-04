import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        while (true){
            int num1 = new Random().nextInt(str.length());
            int num2 = new Random().nextInt(num1, str.length());
            System.out.println("num1 = " + num1 + "\nnum2 = " + num2);
            Thread.sleep(50);
        }
    }
}
