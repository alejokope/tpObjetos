package modelo;

import modelo.lugarinteres.*;

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

    public Villano obtenerVillanoAlAzar (ArrayList<Pais> planEscape,Pais origen){
        Villano villano = new Villano();
        ArrayList<Persona> listaPersonas = obtenerListaPersonas();
        int numeroAzar = utils.obtenerNumeroAleotorio(listaPersonas.size());

        villano.setNombre(listaPersonas.get(numeroAzar).getNombre());
        villano.setSexo(listaPersonas.get(numeroAzar).getSexo());
        villano.setSeñasParticulares(listaPersonas.get(numeroAzar).getSeñasParticulares());
        villano.setHobbies(listaPersonas.get(numeroAzar).getHobbies());
        villano.setPlanEscape(planEscape);
        villano.setPaisActual(origen);

        return villano;
    }



    public ArrayList<Pais> obtenerListaPaises (){

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

        argentina.setObjeto(Objetos.OBJETO1);
        brasil.setObjeto(Objetos.OBJETO2);
        chile.setObjeto(Objetos.OBJETO3);
        uruguay.setObjeto(Objetos.OBJETO4);
        mexico.setObjeto(Objetos.OBJETO5);
        francia.setObjeto(Objetos.OBJETO6);
        colombia.setObjeto(Objetos.OBJETO7);
        egipto.setObjeto(Objetos.OBJETO8);
        india.setObjeto(Objetos.OBJETO9);

        argentina.setReporte(Reporte.REPORTE1);
        brasil.setReporte(Reporte.REPORTE2);
        chile.setReporte(Reporte.REPORTE3);
        uruguay.setReporte(Reporte.REPORTE4);
        mexico.setReporte(Reporte.REPORTE5);
        francia.setReporte(Reporte.REPORTE6);
        colombia.setReporte(Reporte.REPORTE7);
        egipto.setReporte(Reporte.REPORTE8);
        india.setReporte(Reporte.REPORTE9);


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



        argentina.setConexiones(Arrays.asList(brasil,uruguay,chile,colombia,india,egipto));
        brasil.setConexiones(Arrays.asList(argentina,uruguay,mexico,egipto));
        uruguay.setConexiones(Arrays.asList(argentina,brasil,chile,colombia,egipto));
        chile.setConexiones(Arrays.asList(argentina,uruguay,india));
        mexico.setConexiones(Arrays.asList(brasil,chile,colombia,egipto));
        colombia.setConexiones(Arrays.asList(uruguay,mexico,argentina,india));
        india.setConexiones(Arrays.asList(india,argentina,chile,egipto,francia));
        egipto.setConexiones(Arrays.asList(india,francia,mexico,uruguay,brasil));
        francia.setConexiones(Arrays.asList(egipto,argentina,india));

        paises.add(argentina);
        paises.add(brasil);
        paises.add(uruguay);
        paises.add(chile);
        paises.add(mexico);
        paises.add(colombia);
        paises.add(india);
        paises.add(egipto);
        paises.add(francia);

        return paises;
    }

//todo si la lista de paises es siempre la misma guardarla en un atributo para que no este armandola todo el tiempo y solo la consultemos.

    public Caso obtenerCasoAlAzar (){
        Caso caso = new Caso();
        ArrayList<Pais> listaPaises = obtenerListaPaises();
        Pais origen = obtenerPaisOrigen();
        ArrayList<Pais> planEscape = generarCasos(origen);
        caso.setPaisOrigen(origen);
        caso.setPlanEscape(planEscape);
        caso.setResponsable(obtenerVillanoAlAzar(planEscape,origen));
        caso.setObjeto(origen.getObjeto().getValue());
        caso.setReporte(origen.getReporte().getValue());
        listaPaises.remove(origen);
        return caso;
    }

    public Pais obtenerPaisOrigen(){
        ArrayList<Pais> listaPaises = obtenerListaPaises();
        return listaPaises.get(utils.obtenerNumeroAleotorio(listaPaises.size()));
    }

    public ArrayList<Pais> generarCasos (Pais pais){
        ArrayList <Pais> caso = new ArrayList<Pais>();
        return devolverListaPaisesAzar(pais,caso);


    }

    public ArrayList<Pais> devolverListaPaisesAzar (Pais pais, ArrayList<Pais> caso){
        ArrayList <Pais> caso2 = caso;
        Pais proximo = obtenerConexionAleatoria(pais);
        if(caso.size() == 7){
            return caso2;
        }
        while(caso.contains(proximo)){
            proximo = obtenerConexionAleatoria(pais);
        }

        caso2.add(proximo);
        devolverListaPaisesAzar(proximo,caso2);
        return caso2;

    }
    public Pais obtenerConexionAleatoria(Pais pais){
        int numAlAzar = utils.obtenerNumeroAleotorio(pais.getConexiones().size());
        return pais.getConexiones().get(numAlAzar);
    }













}
