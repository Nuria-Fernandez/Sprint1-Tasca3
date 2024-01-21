package n1exercici1;
import java.util.Objects;

public class Month {
    private String name;

    public Month(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "El nombre del mes es: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Month){
            Month other = (Month)obj;
        if(this.name.equalsIgnoreCase(other.name)){
            return true;
            }
            return false;
        }
        return false;
    }
    /*Modifico para saber si tengo dos objetos Month iguales comparando
    el name, ya que si no lo modifico para que compare el name, java no
    reconoce que son iguales porque no son atributos predefinidos en java
     */

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    /*de normal nos da el numero de almacenamiento del objeto. Con la sobreescritura
    conseguimos que dé el mismo num de almacenamiento a los objetos que compartan el mismo name
     */
}
