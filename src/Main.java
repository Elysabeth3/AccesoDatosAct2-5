import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    public static void guardarDatos(Agenda agenda) {
        try (ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("contactos.obj"))) {
            guardar.writeObject(agenda);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Agenda cargarDatos() {
        Agenda agendaCargada = new Agenda();
        try (ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("contactos.obj"))) {
            agendaCargada = (Agenda) cargar.readObject();
        } catch (FileNotFoundException exception) {
            System.out.println("Archivo no encontrado");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return agendaCargada;
    }

    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Introducir contacto");
            System.out.println("2. Buscar contacto por el nombre");
            System.out.println("3. Buscar contacto por el numero");
            System.out.println("4. Mostrar lista contactos");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
        } while ((opcion < 0) || (opcion > 6));

        return opcion;
    }

    public static void main(String[] args) {
        File archivoContactos = new File("contactos.obj");
        Agenda agenda;
        int opcion;

        if (archivoContactos.exists()){
            agenda = cargarDatos();
        } else {
            agenda = new Agenda();
        }

        do {
            opcion = menu();
            switch (opcion) {
                case 1 -> {
                    Contacto contacto = crearContacto();
                    if (agenda.addContacto(contacto)) {
                        System.out.println("Contacto introducido con exito");
                    } else {
                        System.out.println("No se ha podido introducir el contacto");
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el nombre del contacto");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce los apellidos del contacto");
                    String apellidos = teclado.nextLine();

                    Contacto contacto = agenda.buscarContacto(nombre,apellidos);
                    if (contacto != null){
                        System.out.println(contacto);
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el numero del contacto");
                    String numero = teclado.nextLine();
                    Contacto contacto = agenda.buscarContacto(numero);
                    if (contacto != null){
                        System.out.println(contacto);
                    }
                }
                case 4 -> {
                    List<Contacto> contactoList = agenda.getListaContactos();
                    for (int i = 0; i<contactoList.size();i++){
                        System.out.println(contactoList.get(i));
                    }
                }
                case 0 -> {
                    guardarDatos(agenda);
                }
            }
        } while (opcion != 0);





    }

    private static Contacto crearContacto() {
        String nombre;
        String apellidos;
        String correo;
        String numTel;
        String descripcion;

        System.out.print("Introduce el nombre del Contacto: ");
        nombre = teclado.nextLine();
        System.out.print("Introduce los apellidos del Contacto: ");
        apellidos = teclado.nextLine();
        System.out.print("Introduce el correo electronico del Contacto: ");
        correo = teclado.nextLine();
        System.out.print("Introduce el numero de telefono del Contacto: ");
        numTel = teclado.nextLine();
        System.out.print("Introduce la descripcion del Contacto: ");
        descripcion = teclado.nextLine();

        return new Contacto(nombre,apellidos,correo,numTel,descripcion);
    }
}