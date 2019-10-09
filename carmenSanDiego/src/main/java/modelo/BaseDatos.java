package modelo;

import modelo.lugarinteres.Banco;
import modelo.lugarinteres.Biblioteca;
import modelo.lugarinteres.Club;
import modelo.lugarinteres.Embajada;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseDatos {
    private Utils utils;

    public BaseDatos() {
        utils = new Utils();
    }

    public ArrayList<Persona> obtenerListaPersonas(){
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
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

        señasTomas.add("Tiene pelo rubio.");
        señasTomas.add("Lleva consigo una pulsera de oro blanco.");
        señasTomas.add("Su comida favorita son los varenikes.");
        señasTomas.add("Usa zapatillas de distinto color.");
        señasTomas.add("Tiene anteojos.");
        señasTomas.add("Tiene aritos en la oreja.");

        señasBelen.add("Tiene pelo rubio.");
        señasBelen.add("Tiene anteojos.");
        señasBelen.add("Su color favorito es el negro.");
        señasBelen.add("Su comida favorita son las pastas.");

        señasMaria.add("Tiene pelo negro.");
        señasMaria.add("Su color favorito es el negro.");
        señasMaria.add("Tiene anteojos.");
        señasMaria.add("Su comida favorita son los varenikes.");
        señasMaria.add("Tiene aritos en la oreja.");

        señasNicolas.add("Tiene pelo negro.");
        señasNicolas.add("Su comida favorita son las pastas.");
        señasNicolas.add("Tiene aritos en la oreja.");
        señasNicolas.add("Su color favorito es el violeta.");

        tomas.setNombre("Tomas");
        tomas.setSexo("Masculino");
        tomas.setHobbies(hobbiesTomas);
        tomas.setSeñasParticulares(señasTomas);

        nicolas.setNombre("Nicolas");
        nicolas.setSexo("Masculino");
        nicolas.setHobbies(hobbiesNicolas);
        nicolas.setSeñasParticulares(señasNicolas);

        belen.setNombre("Belen");
        belen.setSexo("Femenino");
        belen.setHobbies(hobbiesBelen);
        belen.setSeñasParticulares(señasBelen);

        maria.setNombre("Maria");
        maria.setSexo("Femenino");
        maria.setHobbies(hobbiesMaria);
        maria.setSeñasParticulares(señasMaria);

        listaPersonas.add(tomas);
        listaPersonas.add(belen);
        listaPersonas.add(maria);
        listaPersonas.add(nicolas);

        return listaPersonas;
    }

    public Villano obtenerVillanoAlAzar (){
        Villano villano = new Villano();
        ArrayList<Persona> listaPersonas = obtenerListaPersonas();
        int numeroAzar = utils.obtenerNumeroAleotorio(listaPersonas.size());

        villano.setNombre(listaPersonas.get(numeroAzar).getNombre());
        villano.setSexo(listaPersonas.get(numeroAzar).getSexo());
        villano.setSeñasParticulares(listaPersonas.get(numeroAzar).getSeñasParticulares());
        villano.setHobbies(listaPersonas.get(numeroAzar).getHobbies());
       // villano.setPlanEscape(getPlanEscape());


    }

    public void obtenerListaPaises (){

        /* private String nombre;
        private List<String> caracteristicas;
        private List<LugarInteres> lugaresInteres; */

        ArrayList<Pais> paises = new ArrayList<Pais>();

        Pais argentina = new Pais();
        Pais brasil = new Pais();
        Pais chile = new Pais();
        Pais uruguay = new Pais();
        Pais mexico = new Pais();
        Pais francia = new Pais();
        Pais colombia = new Pais();
        Pais egipto = new Pais();
        Pais india = new Pais();

        argentina.setNombre("Argentina");
        argentina.setCaracteristicas(Arrays.asList("toman mate","bailan tango"));
        argentina.setLugaresInteres(Arrays.asList(new Banco(), new Club()));

        brasil.setNombre("Brasil");
        brasil.setCaracteristicas(Arrays.asList("toman caipirinha","juegan volley-beach"));
        brasil.setLugaresInteres(Arrays.asList(new Banco(), new Biblioteca()));

        chile.setNombre("Chile");
        chile.setCaracteristicas(Arrays.asList("visitan la nieve","tienen terremotos"));
        chile.setLugaresInteres(Arrays.asList(new Club(), new Biblioteca(), new Embajada()));

        uruguay.setNombre("Uruguay");
        uruguay.setCaracteristicas(Arrays.asList("toman mate","comen alfajores"));
        argentina.setLugaresInteres(Arrays.asList(new Banco(), new Embajada()));

        mexico.setNombre("Mexico");
        mexico.setCaracteristicas(Arrays.asList("asesinan gente","venden droga"));
        mexico.setLugaresInteres(Arrays.asList(new Embajada(), new Club()));

        francia.setNombre("Francia");
        francia.setCaracteristicas(Arrays.asList("van a la cancha","corren maratones", "bandera de color azul, roja, blanca"));
        francia.setLugaresInteres(Arrays.asList(new Biblioteca(), new Embajada(), new Club()));

        colombia.setNombre("Colombia");
        colombia.setCaracteristicas(Arrays.asList("venden droga","su color de bandera es roja, azul, amarillo"));
        colombia.setLugaresInteres(Arrays.asList(new Banco(), new Club()));

        india.setNombre("India");
        india.setCaracteristicas(Arrays.asList("su bandera es blanca, verde y amarillo","adoran a las vacas","flotan"));
        india.setLugaresInteres(Arrays.asList(new Banco(),new Embajada(),new Biblioteca()));

        egipto.setNombre("Egipto");
        egipto.setCaracteristicas(Arrays.asList("tienen el rio mas largo","tienen piramides","trabajan mucho","tienen mucha historia"));
        egipto.setLugaresInteres(Arrays.asList(new Banco(), new Club()));
    }













}
