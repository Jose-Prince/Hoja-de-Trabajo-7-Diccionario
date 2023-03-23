import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DiccionarioMain {
    public static void main(String[] args) throws IOException {
        Association<String, String> asociacion = new Association<String, String>();
        
        Scanner teclado = new Scanner(System.in);
        BinarySearchTree ingles = new BinarySearchTree();
        BinarySearchTree español = new BinarySearchTree();
        BinarySearchTree frances = new BinarySearchTree();
        try {
            File vocabulario = new File("diccionario");
            Scanner lector = new Scanner(vocabulario);

            while (lector.hasNextLine()){
                String data = lector.nextLine().toLowerCase();
                ingles.insert(data);
                System.out.println(data);

                String[] palabras = data.split(",");
                String dataEs = palabras[1] + "," + palabras[0] + "," + palabras[2];
                español.insert(dataEs);

                String dataFr = palabras[2] + "," + palabras[0] + "," + palabras[1];
                frances.insert(dataFr);
            }
            
            System.out.println("\nDiccionario ordenado por inglés:\n");
            ingles.inorder();
            System.out.println("\nDiccionario ordenado por español:\n");
            español.inorder();
            System.out.println("\nDiccionario ordenado por francés:\n");
            frances.inorder();

            File oraciones = new File("texto");
            lector = new Scanner(oraciones);


            lector.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error ocurred");
        }
    }
}
