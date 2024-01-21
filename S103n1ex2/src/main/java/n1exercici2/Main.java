package n1exercici2;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        List <Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(5);
        listaNumeros.add(10);
        listaNumeros.add(15);
        listaNumeros.add(20);
        listaNumeros.add(25);



        List <Integer> listaInversa = new ArrayList<>();

        ListIterator <Integer> iterator = listaNumeros.listIterator(listaNumeros.size());
        //Si le ponemos el .size() quiere decir que empezamos por el último elemento a iterar

        while(iterator.hasPrevious()){
            listaInversa.add(iterator.previous());
        /*Mientras que haya elementos previos para iterar,
        vas a añadir los elementos previos a la listaInversa
         */
        }
        for(Integer numero : listaInversa){
            System.out.println(numero);

        }
    }
}