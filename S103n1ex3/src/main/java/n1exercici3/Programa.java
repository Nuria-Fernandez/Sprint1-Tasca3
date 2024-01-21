package n1exercici3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Programa {

    public static void arrancarPrograma(){
        HashMap<String, String> listaPaises = leerArchivo();

        String nombre = pedirNombre("Introduce tu nombre para empezar el juego");

        int puntuacion = 0;
        for(int i = 0; i < 10; i++) {
            String paisJugado = paisAleatorio(listaPaises);
            String respuesta = pedirNombre("Di la capital de " + paisJugado);
            if(respuesta.equalsIgnoreCase(listaPaises.get(paisJugado))){//del hashmap(listaPaises) pongo el key(paisJugado) y esto me da el value
                puntuacion = puntuacion + 1;
            } else {
                System.out.println("No es correcto");
            }
        }
        System.out.println("Tu puntación es " + puntuacion);
        escribirArchivo(nombre, puntuacion);
    }

    private static HashMap<String, String> leerArchivo(){

        HashMap<String, String> paises = new HashMap<>();
        File fichero = new File("src/main/java/n1exercici3/countries.txt");

        try (FileReader fr = new FileReader(fichero);//fichero que va a leer
             BufferedReader bf = new BufferedReader(fr);//acción de leer
        ) {
            String linea = "";
            while((linea = bf.readLine()) != null){//bf.readLine()---> Extraigo linea del archivo y la guardo en línea
                String[] particionLinea = linea.split(" ");
                if(particionLinea.length == 2){
                    String pais = particionLinea[0].trim();//Se quitan espacios delante y detrás del String
                    String capital = particionLinea[1].trim();
                    paises.put(pais, capital);// inserta un nuevo par clave-valor y lo guarda en el HashMap paises
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("No se ha podido cerrar el recurso");
        }

        return paises;
    }
    private static String paisAleatorio(HashMap<String, String> listaPaises){
        int numLineasArchivo = listaPaises.size();//Nos da el num de parejas de palabras del .txt
        int numAleatorio = (int) (Math.random() * numLineasArchivo);
        //Multiplico por el numero de parejas que hay en el .txt para que me dé uno de los países
        String pais = (String) listaPaises.keySet().toArray()[numAleatorio];
        /*keySet devuelve el conjunto de claves. Las claves son los primeros elementos de cada pareja
        toArray devuelve una lista de objetos.
        El algoritmo devuelve un array de objetos y entre corchetes le estoy diciendo que coja
        del array el numero aleatorio
        */

        return pais;
    }
    private static void escribirArchivo(String nombre, int puntuacion){

        try(FileWriter datosUsuario = new FileWriter("src/main/java/n1exercici3/Clasificación.txt");
            BufferedWriter bf = new BufferedWriter(datosUsuario)){
            //pongo el FileWriter y el Buffered en parentesis porque es un resource y así cierra el recurso sin necesidad
            //de hacer un finally con .close
            datosUsuario.write(nombre + " " + puntuacion + "\n");

        } catch (IOException e){
            System.out.println("No se ha podido encontrar el archivo");

        }

    }
    private static String pedirNombre(String mensaje) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        String nombre = input.nextLine();
        return nombre;
    }
}

