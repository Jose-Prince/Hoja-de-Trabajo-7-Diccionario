import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PruebasUnitarias {

    BST ingles = new BST();
    BST español = new BST();
    BST frances = new BST();
    Association<String, String> asociacion = new Association<String, String>();

    //Prueba para añadir un elemento
    @Test 
    public void addTest(){
        String palabra = "elemento";
        ingles.add(palabra);
        español.add(palabra);
        assertEquals(ingles.getNode(palabra), español.getNode(palabra));
    }

    //Prueba para buscar un elemento
    @Test
    public void searchTest() {
        español.add("hola");
        español.add("adios");
        español.add("queso");
        español.add("comida");

        assertEquals(true, español.containsNode("queso"));
    }

    //Prueba para obtener un elemento del árbol
    @Test 
    public void getTest() {
        String palabra = "elemento";
        ingles.add(palabra);
        assertEquals(palabra, ingles.getNode(palabra));
    }

    //Prueba traducción de español a ingles
    @Test
    public void EStoENTest() {
        String oracion = "La casa bonita";
        String[] words = oracion.split(" ");

        español.add("house,casa,loger");

        assertEquals("*La* *casa* *bonita* ", asociacion.traduccionEn(words, "español", español));
    }

    //Prueba traduccion de español a frances
    @Test
    public void EStoFRTest() {
        String oracion = "La casa bonita";
        String[] words = oracion.split(" ");
        
        español.add("house,casa,loger");

        assertEquals("*La* *casa* *bonita* ", asociacion.traduccionFr(words, "español", español));
    }
    //Prueba traduccion de ingles a español
    @Test
    public void ENtoESTest() {
        String oracion = "The pretty house";
        String[] words = oracion.split(" ");
        
        ingles.add("house,casa,loger");

        assertEquals("*The* *pretty* casa ", asociacion.traduccionEs(words, "ingles", ingles));
    }

    //Prueba traduccion de ingles a frances
    @Test
    public void ENtoFRTest() {
        String oracion = "The pretty house";
        String[] words = oracion.split(" ");
        
        ingles.add("house,casa,loger");

        assertEquals("*The* *pretty* loger ", asociacion.traduccionFr(words, "ingles", ingles));
    }
    //Prueba traduccion de frances a español
    @Test
    public void FRtoESTest() {
        String oracion = "La joile loger";
        String[] words = oracion.split(" ");
        
        frances.add("house,casa,loger");

        assertEquals("*La* *joile* *loger* ", asociacion.traduccionEs(words, "frances", frances));
    }
    //Prueba traduccion de frances a ingles
    @Test
    public void FRtoENTest() {
        String oracion = "La joile loger";
        String[] words = oracion.split(" ");
        
        frances.add("house,casa,loger");

        assertEquals("*La* *joile* *loger* ", asociacion.traduccionEn(words, "frances", frances));
    }
}
