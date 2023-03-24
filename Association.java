public class Association<K, V> {

    K idioma1;
    V idioma2;

    

    public K getIdioma1() {
        return this.idioma1;
    }

    public void setIdioma1(K idioma1) {
        this.idioma1 = idioma1;
    }

    public V getIdioma2() {
        return this.idioma2;
    }

    public void setIdioma2(V idioma2) {
        this.idioma2 = idioma2;
    }

    public String traduccionEs(String[] palabras, String idioma, BST arbolIdioma){
        String traduccion = "";
        if (idioma.equalsIgnoreCase("ingles")) {
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[1] + " ";
                }

            }
        } else if (idioma.equalsIgnoreCase("frances")){
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[2] + " ";
                }
            }
        }
        return traduccion;
    }

    public String traduccionEn(String[] palabras, String idioma, BST arbolIdioma){
        String traduccion = "";
        if (idioma.equalsIgnoreCase("español")) {
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[1] + " ";
                }

            }
        } else if (idioma.equalsIgnoreCase("frances")){
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[1] + " ";
                }
            }
        }
        return traduccion;
    }

    public String traduccionFr(String[] palabras, String idioma, BST arbolIdioma){
        String traduccion = "";
        if (idioma.equalsIgnoreCase("ingles")) {
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[2] + " ";
                }
            }
        } else if (idioma.equalsIgnoreCase("español")){
            for (String palabra : palabras) {
                if(arbolIdioma.getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[2] + " ";
                }
            }
        }
        return traduccion;
    }

    

}
