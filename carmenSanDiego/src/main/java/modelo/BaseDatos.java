package modelo;

import java.util.ArrayList;

public class BaseDatos {
    public ArrayList<Persona> obtenerListaPersonas(){
        Persona tomas = new Persona();
        Persona nicolas = new Persona();
        Persona belen = new Persona();
        Persona maria = new Persona();

        ArrayList<String> hobbiesNicolas = new ArrayList<String>();
        ArrayList<String> hobbiesTomas = new ArrayList<String>();
        ArrayList<String> hobbiesMaria = new ArrayList<String>();
        ArrayList<String> hobbiesBelen = new ArrayList<String>();

        ArrayList<String> señasNicolas = new ArrayList<String>();
        ArrayList<String> señasTomas = new ArrayList<String>();
        ArrayList<String> señasMaria = new ArrayList<String>();
        ArrayList<String> señasBelen = new ArrayList<String>();

        hobbiesTomas.add("Juega al rugby.");
        hobbiesTomas.add("Toca el charango.");
        hobbiesTomas.add("Le gusta las fiestas electrónicas.");
        hobbiesTomas.add("Anda skate.");
        hobbiesTomas.add("Le gusta viajar.");
        hobbiesTomas.add("Le gusta salir a bailar.");

        hobbiesNicolas.add("Toca la guitarra.");
        hobbiesNicolas.add("Juega al futbol.");
        hobbiesNicolas.add("Juega a la play.");
        hobbiesNicolas.add("Toca el charango.");
        hobbiesNicolas.add("Anda en bicicleta.");
        hobbiesNicolas.add("Le gusta viajar.");
        hobbiesNicolas.add("Juega al rugby.");

        hobbiesBelen.add("Toca el acordeon.");
        hobbiesBelen.add("Hace danza clásica.");
        hobbiesBelen.add("Hace natación.");
        hobbiesBelen.add("Le gusta salir a bailar.");
        hobbiesBelen.add("Le gusta viajar.");
        hobbiesBelen.add("Anda skate.");
        hobbiesBelen.add("Le gusta las fiestas electrónicas.");

        hobbiesMaria.add("Le gusta nadar.");
        hobbiesMaria.add("Anda en rollers.");
        hobbiesMaria.add("Le gusta viajar.");
        hobbiesMaria.add("Toca la guitarra.");
        hobbiesMaria.add("Toca el acordeon.");
        hobbiesBelen.add("Le gusta las fiestas electrónicas.");
        hobbiesBelen.add("Le gusta salir a bailar.");


        tomas.setNombre("Tomas");
        tomas.setSexo("Masculino");

        nicolas.setNombre("Nicolas");
        nicolas.setSexo("Masculino");

        belen.setNombre("Belen");
        belen.setSexo("Femenino");

        maria.setNombre("Maria");
        maria.setSexo("Femenino");

        señasTomas.add("Tiene pelo rubio");
        señasTomas.add("Lleva consigo una pulsera de oro blanco");
        señasTomas.add("Su comida favorita son los varenikes");
        señasTomas.add("Usa zapatillas de distinto color");



    }















}
