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

            while (lector.hasNextLine()){
                String data = lector.nextLine().toLowerCase();
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
                    if (ingles.containsNode(palabra) == true){
                        i += 1;   
                    } 
                    else if (español.containsNode(palabra) == true)
                        e += 1;
                    else if (frances.containsNode(palabra) == true)
                        f += 1;
                }
                if (i >= e && i >= f){
                    String traduccion1 = "";
                    String traduccion2 = "";
                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma inglés.");
                    for (String palabra : palabras) {
                        if(ingles.getNode(palabra).contains("*")){
                            traduccion1 = traduccion1 + ingles.getNode(palabra) + " ";
                            traduccion2 = traduccion2 + ingles.getNode(palabra) + " "; 
                        } else {
                            String word = ingles.getNode(palabra);
                            String[] words = word.split(",");

                            traduccion1 = traduccion1 + words[1] + " ";
                            traduccion2 = traduccion2 + words[2] + " ";
                        }

                    }
                    System.out.println("Traducción al español: " + traduccion1);
                    System.out.println("traducción al francés: " + traduccion2);
                }
                else if (e >= i && e >= f) {
                    String traduccion1 = "";
                    String traduccion2 = "";
                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma español.");
                    for (String palabra : palabras) {
                        if(español.getNode(palabra).contains("*")){
                            traduccion1 = traduccion1 + español.getNode(palabra) + " ";
                            traduccion2 = traduccion2 + español.getNode(palabra) + " "; 
                        } else {
                            String word = español.getNode(palabra);
                            String[] words = word.split(",");

                            traduccion1 = traduccion1 + words[1] + " ";
                            traduccion2 = traduccion2 + words[2] + " ";
                        }
                    }
                    System.out.println("Traducción al inglés: " + traduccion1);
                    System.out.println("traducción al francés: " + traduccion2);
                }
                else if (f >= i && f >= i) {
                    String traduccion1 = "";
                    String traduccion2 = "";
                    System.out.println("\nLa oración por traducir es: " + sentence + ". Esta en el idioma inglés.");
                    for (String palabra : palabras) {
                        if(frances.getNode(palabra).contains("*")){
                            traduccion1 = traduccion1 + frances.getNode(palabra) + " ";
                            traduccion2 = traduccion2 + frances.getNode(palabra) + " "; 
                        } else {
                            String word = frances.getNode(palabra);
                            String[] words = word.split(",");

                            traduccion1 = traduccion1 + words[1] + " ";
                            traduccion2 = traduccion2 + words[2] + " ";
                        }
                    }
                    System.out.println("Traducción al inglés: ");
                    System.out.println("traducción al español: ");
                }
            }

            lector.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error ocurred");
        }
    }
}
