import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //Прочесть информацию введеную из клавиатуры и записать в созданный вами txt файл,
        //если введена "stop" строка тогда закончить запись в файл.
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла для записи: ");
        String fileName = in.next();
        String fileExtension = ".txt";
        String folderName = System.getProperty("user.dir");
        String fullName = folderName + File.separator + fileName + fileExtension;
        String stop = "stop";
        File file = new File(fullName);
        try {
            if (file.createNewFile()){
                System.out.println("Файд " + fileName + fileExtension + " создан.");
            }
            else {
                System.out.println("Файл " + fileName + fileExtension + " уже существует");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        if (isEmptyTxtFile(fullName)){
            System.out.println("Введите текст для записи в файл: ");
        }
        else {
            System.out.println("Файл уже содержит текст. Введите текст для дозаписи в файл: ");
        }
        while (true){
            try(
                    //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    FileWriter fw = new FileWriter(fullName, true);
            ){
                String text = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if (text.equals(stop)){
                    System.out.println("Запись окончена. Записанный файл содержит: " + new BufferedReader(new FileReader(fullName)).readLine());

                    fw.close();
                    break;
                }
                else {
                    fw.write(text + " ");
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    static boolean isEmptyTxtFile(String fullName){
        boolean result = false;
        try(
                FileReader fr = new FileReader(fullName);
                BufferedReader br = new BufferedReader(fr);
                ){
            result = br.lines().toArray().length == 0;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}