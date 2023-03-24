import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import structure5.BinarySearchTree;

public class DiccionarioMain {
    public static void main(String[] args) throws IOException {
        Association<String, String> asociacion = new Association<String, String>();
        
        Scanner teclado = new Scanner(System.in);

        BST ingles = new BST();
        BST español = new BST();
        BST frances = new BST();
        try {
            File vocabulario = new File("diccionario");
            Scanner lector = new Scanner(vocabulario);

            System.out.println("\nVocabulario:\n");
            while (lector.hasNextLine()){
                String data = lector.nextLine().toLowerCase();
                System.out.println(data);
                ingles.add(data);
                
                String[] palabras = data.split(",");
                String dataEs = palabras[1] + "," + palabras[0] + "," + palabras[2];
                español.add(dataEs);
  

                String dataFr = palabras[2] + "," + palabras[0] + "," + palabras[1];
                frances.add(dataFr);
            }

            System.out.println("\nDiccionario ordenado por inglés:\n");
            ingles.inorder();
            System.out.println("\nDiccionario ordenado por español:\n");
            español.inorder();
            System.out.println("\nDiccionario ordenado por francés:\n");
            frances.inorder();
            lector.close();

            File oraciones = new File("texto");
            lector = new Scanner(oraciones);

            while (lector.hasNextLine()){
                int e = 0;
                int i = 0;
                int f = 0;
                String sentence = lector.nextLine().toLowerCase();
                String[] palabras = sentence.split(" ");
                for (String palabra : palabras) {
                    if (ingles.containsNode(palabra) == true)
                        i += 1;   
                    else if (español.containsNode(palabra) == true)
                        e += 1;
                    else if (frances.containsNode(palabra) == true)
                        f += 1;
                }
                if (i >= e && i >= f){
                    String idioma = "ingles";

                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma inglés.");
                    System.out.println("Traducción al español: " + asociacion.traduccionEs(palabras, idioma, ingles));
                    System.out.println("traducción al francés: " + asociacion.traduccionFr(palabras, idioma, ingles));
                }
                else if (e >= i && e >= f) {
                    String idioma = "español";
            
                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma español.");
                    
                    System.out.println("Traducción al inglés: " + asociacion.traduccionEn(palabras, idioma, español));
                    System.out.println("traducción al francés: " + asociacion.traduccionFr(palabras, idioma, español));
                }
                else if (f >= i && f >= i) {
                    String idioma = "frances";

                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma frances.");

                    System.out.println("Traducción al inglés: " + asociacion.traduccionEn(palabras, idioma, frances));
                    System.out.println("traducción al español: " + asociacion.traduccionEs(palabras, idioma, frances));
                }
            }

            lector.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error ocurred");
        }
        System.out.println("");
    }
}
