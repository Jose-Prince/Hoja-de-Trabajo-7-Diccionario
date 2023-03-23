import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DiccionarioMain {
    public static void main(String[] args) throws IOException {
        Association<String, String> asociacion = new Association<String, String>();
        
        Scanner teclado = new Scanner(System.in);
        BinarySearchTree ingles = new BinarySearchTree();
        try {
            File vocabulario = new File("diccionario");
            Scanner lector = new Scanner(vocabulario);

            while (lector.hasNextLine()){
                String data = lector.nextLine();
                ingles.insert(data);
                System.out.println(data);
            }
            System.out.println("\n");
            ingles.inorder();
            lector.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error ocurred");
        }
    }
}
