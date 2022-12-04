import java.io.*;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        final String fileNameTask2 = "task2.txt";
        final String folderNameTask4 = "task4";
        final String resultFile = "result.txt";
        final String fileExtension = ".txt";
        final String folderName = System.getProperty("user.dir");
        final String fullNameTask2 = folderName + File.separator + fileNameTask2;
        final String fullFolderName = folderName + File.separator + folderNameTask4;
        File folder = new File(fullFolderName);
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        /*try(BufferedReader br = new BufferedReader(new FileReader(fullNameTask2))){
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }*/

        if (!folder.exists()) {
            if (folder.mkdir()) System.err.println("Каталог " + fullFolderName + " создан.");
            else System.err.println("Не удалось создать каталог.");
        } else {
            System.err.println("Каталог уже существует.");
        }

        for (int i = 1; i <= 100; i++){
            try(
                    FileWriter fw = new FileWriter(fullFolderName + File.separator + i + fileExtension);
                    BufferedWriter bw = new BufferedWriter(fw)
            ){
                int num1 = new Random().nextInt(str.length());
                int num2 = new Random().nextInt(num1, str.length());
                bw.write(str.substring(num1, num2));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

            for (File item : folder.listFiles()){
                try (
                        FileWriter fwResult = new FileWriter(folderName+File.separator+resultFile, true);
                        BufferedWriter bwResult = new BufferedWriter(fwResult)
                     ){
                    bwResult.write("Размер файла " + item.getPath() + " = " + item.length() + "\n");
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
