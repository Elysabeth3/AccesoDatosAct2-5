import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private List<Contacto> listaContactos;

    public boolean addContacto(Contacto contacto){
        return listaContactos.add(contacto);
    }

    public List<Contacto> getListaContactos() {
        List<Contacto> copia = new ArrayList<>(listaContactos);
        return copia;
    }

    public Contacto buscarContacto(String nombre, String apellidos){
        Contacto contactoDevolver;
        for (int i = 0; i<listaContactos.size();i++){
            contactoDevolver = listaContactos.get(i);
            if (contactoDevolver.getNombre().equalsIgnoreCase(nombre) && contactoDevolver.getNombre().equalsIgnoreCase(apellidos)){
                return contactoDevolver;
            }
        }
        return null;
    }

    public Contacto buscarContacto(String numTel){
        Contacto contactoDevolver;
        for (int i = 0; i<listaContactos.size();i++){
            contactoDevolver = listaContactos.get(i);
            if (contactoDevolver.getNumTel().equals(numTel)){
                return contactoDevolver;
            }
        }
        return null;
    }

}
