import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

public class FileHelper {
    ArrayList<String>ReadTextFromFile(String inputFilePath){
        ArrayList<String> text = new ArrayList<String>();
        try{
            URL url = FileHelper.class.getResource(inputFilePath);

            File file = new File(inputFilePath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
                text.add(sc.nextLine());
            }
            return text;
        }finally{
          return text;
        }



    }
}
