import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    //Создать новый файл result.txt.
    //Программно считать файл с текстом, удалить все пробелы и записать полученный текст в result.txt.
    static  final String fileNameTask = "task2";
    static final String fileNameResult = "result";
    static final String fileExtension = ".txt";
    static final String folderName = System.getProperty("user.dir");
    static final  String fullNameTask = folderName + File.separator + fileNameTask + fileExtension;
    static final String fullNameResult = folderName + File.separator + fileNameResult + fileExtension;

    public static void main(String[] args) {
        try(
                FileWriter fw = new FileWriter(fullNameResult, false);
                FileReader fr = new FileReader(fullNameTask);
        ){
            int ch;
            while ((ch = fr.read()) != -1){
                if (ch != ' '){
                    fw.append((char) ch);
                }
            }
            fw.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
