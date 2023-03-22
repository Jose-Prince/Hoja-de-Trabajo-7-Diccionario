import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DiccionarioMain {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        
        try {
            File vocabulario = new File("diccionario");
            Scanner lector = new Scanner(vocabulario);

            while (lector.hasNextLine()){
                String data = lector.nextLine();
                System.out.println(data);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error ocurred");
        }
    }
}
