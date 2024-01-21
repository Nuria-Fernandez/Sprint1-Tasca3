package n1exercici1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList <Month> listaMeses = new ArrayList<>();

        Month mes1 = new Month("Enero");
        Month mes2 = new Month("Febrero");
        Month mes3 = new Month("Marzo");
        Month mes4 = new Month("Abril");
        Month mes5 = new Month("Mayo");
        Month mes6 = new Month("Junio");
        Month mes7 = new Month("Julio");
        Month mes8 = new Month("Agosto");
        Month mes9 = new Month("Septiembre");
        Month mes10 = new Month("Octubre");
        Month mes11 = new Month("Noviembre");
        Month mes12 = new Month("Diciembre");


        listaMeses.add(mes1);
        listaMeses.add(mes2);
        listaMeses.add(mes3);
        listaMeses.add(mes4);
        listaMeses.add(mes5);
        listaMeses.add(mes6);
        listaMeses.add(mes7);
        listaMeses.add(mes9);
        listaMeses.add(mes10);
        listaMeses.add(mes11);
        listaMeses.add(mes12);

        //lista sin agosto
        for(Month mes : listaMeses){
            System.out.println(mes.getName());
        }
        System.out.println(" ");

        listaMeses.add(7, mes8);

        //lista con agosto
        for(Month mes : listaMeses){
            System.out.println(mes.getName());
        }
        System.out.println(" ");

        //para comprobar la NO duplicidad
        Month mes13 = new Month("Abril");
        listaMeses.add(mes13);

        //de ArrayList a HashSet
        HashSet <Month> mesesLista = new HashSet<>(listaMeses);

        //imprimo para comprobar que el mes13 no lo imprime por estar duplicado
        for(Month mes : mesesLista){
            System.out.println(mes.getName());
        }
        System.out.println(" ");

        //imprimo la lista recorriéndola con un iterador
        Iterator <Month> it = mesesLista.iterator();
        while(it.hasNext()){
            String nombreMes = it.next().getName();
            System.out.println(nombreMes);
        }







    }
}