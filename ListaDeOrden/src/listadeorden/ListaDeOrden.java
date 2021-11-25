package listadeorden;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author eber
 */
interface OrdenarAnon{
    public void OrdenAnon();
}

interface OrdenarLamb{
    List make(List AL);
}

interface OrdenarRefe{
    List make(List AR);
}

class OrdenRefe{
    static List longitud(List AR){
        Collections.sort(AR, Comparator.comparing(String::length));
        return AR;
    }
    static List alfa(List AR){
        AR.sort(Comparator.naturalOrder());
        return AR;
    }
}

public class ListaDeOrden {
    public static void main(String[] args) {
        List lista = new ArrayList<String>();
        
        lista.add("Chocolate"); lista.add("12345");
        lista.add("Cadena");    lista.add("Numero");
        lista.add("ABCDE");     lista.add("Cheese");
        lista.add("Doh");       lista.add("Bort");
        lista.add("Hielo");     lista.add("Repampanos");
        lista.add("A");
        
        List listaOriginal = lista;
        
        System.out.println("Lista original: ");
        System.out.println(lista + "\n");
        System.out.println("Lista ordenada por clase anónima");
        OrdenarAnon ordenA = new OrdenarAnon(){
            public void OrdenAnon(){
                // ordenar por longitud
                Collections.sort(lista, Comparator.comparing(String::length));
                System.out.println("Por longitud: "+lista);
                
                // ordenrar por orden alfabetico
                lista.sort(Comparator.naturalOrder());
                System.out.println("\nPor orden alfábetico: "+ lista);
            }
        };
        ordenA.OrdenAnon();
        
        System.out.println("\n"+"\n");

        System.out.println("\nLista ordenada por expresion lambda");
        OrdenarLamb longitud = (AL)
                -> {
            Collections.sort(lista, Comparator.comparing(String::length));
            return lista;
        };
        System.out.println("Por longitud: " + longitud.make(lista));
        
        OrdenarLamb alfa = (AL)
                -> {
            lista.sort(Comparator.naturalOrder());
            return lista;
        };
        System.out.println("\nPor orden alfábetico: "+ alfa.make(lista));
        
        System.out.println("\n"+"\n");
        
        System.out.println("\nLista ordenada por métodos de referencia");
        OrdenarRefe longRefe = OrdenRefe::longitud;
        OrdenarRefe alfaRefe = OrdenRefe::alfa;
        
        System.out.println("Por longitud: "+ longRefe.make(lista));
        System.out.println("\nPor orden alfábetico: "+ alfaRefe.make(lista)+"\n");
    }
}
