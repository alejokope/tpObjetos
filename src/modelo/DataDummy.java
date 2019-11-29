package modelo;

import modelo.lugarInteres.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataDummy {
    private Villano villanoAsignado;
    private Caso casoAsignado;
    private Jugador jugadorAsignado;
    private CasoAJugar casoAJugar;
    private List<String> paisesVisitados = new ArrayList<>();

    private Jugador jugadorA = new Jugador("cosme fulanito");
    private Jugador jugadorB = new Jugador("perez garcia");
    private Jugador jugadorC = new Jugador("abc");

    private Usuario usuarioA = new Usuario(jugadorA, "1234");
    private Usuario usuarioB = new Usuario(jugadorB, "pepe");
    private Usuario usuarioC = new Usuario(jugadorC, "123");

    private List<Usuario> usuarios = new ArrayList<Usuario>(Arrays.asList(usuarioA, usuarioB, usuarioC));

    public int obtenerNumeroAleatorio(int maximo){
        return (int) (Math.random() * maximo);
    }

    public void setearCarmenSanDiego(CasoAJugar casoAJugar){
        this.casoAJugar = casoAJugar;
    }
    public boolean esUnUsuarioValido(JTextField nombreIngresadoTextField, JPasswordField contraseniaIngresadaTextField) {
        return usuarios.stream()
                .anyMatch(usuario -> usuario.esElMismoUsuario(nombreIngresadoTextField, contraseniaIngresadaTextField));
    }

    public Jugador obtenerJugadorAsignado(JTextField nombreIngresadoTextField){
        return usuarios.stream()
                .filter(usuario -> usuario.esElMismoNombre(nombreIngresadoTextField))
                .collect(Collectors.toList())
                .get(0)
                .getJugador();
    }

    public List<String> getPaisesVisitados() {
        return paisesVisitados;
    }

    public void addPaisVisitado(String pais){
        this.paisesVisitados.add(pais);
    }

    public CasoAJugar getCasoAJugar() {
        return casoAJugar;
    }

    public void setearPaisJugadorAsignado(Pais pais){
        jugadorAsignado.setPaisActual(pais);
    }
    public Jugador getJugadorAsignado() {
        return jugadorAsignado;
    }

    public void setJugadorAsignado(Jugador jugadorAsignado) {
        this.jugadorAsignado = jugadorAsignado;
    }

    public String obtenerNombreDelJugadorAsignado(){
        return jugadorAsignado.getNombre();
    }

    public Caso getCasoAsignado(){
        return casoAsignado;
    }

    public void setCasoAsignado(Caso casoAsignado){
        this.casoAsignado = casoAsignado;
    }

    public String obtenerTituloDelCasoAsignado(){
        return casoAsignado.getTitulo();
    }

    public void setearCasoAsignadoAJugadorAsignado(){
        jugadorAsignado.setPaisActual(casoAsignado.getPaisOrigen());
    }

    public String obtenerNombreDelPaisActualDelJugadorAsignado(){
        return jugadorAsignado.getPaisActual().getNombre();
    }

    public String obtenerReporteDelCasoAsignado() {
        return casoAsignado.getReporte();
    }

    public Villano getVillanoAsignado() {
        return villanoAsignado;
    }

    public void setVillanoAsignado(Villano villanoAsignado) {
        this.villanoAsignado = villanoAsignado;
    }

    //todo si la lista de paises es siempre la misma guardarla en un atributo para que no este armandola todo el tiempo y solo la consultemos.

        public Caso obtenerCasoAlAzar (){
            Caso caso = new Caso();
            ArrayList<Pais> listaPaises = obtenerListaPaises();
            Pais origen = obtenerPaisOrigen();
            ArrayList<Pais> planEscape = generarCasos(origen);
            caso.setPaisOrigen(origen);
            caso.setPlanEscape(planEscape);
            //caso.setPlanEscape(listaPaises);
            caso.setResponsable(obtenerVillanoAlAzar(planEscape));
            caso.setObjeto(origen.getObjeto().getValue());
            caso.setReporte(origen.getReporte().getValue());
            caso.setTitulo(origen.getTitulo().getValue());
            caso.pasarVillanoPorPaises();
            listaPaises.remove(origen);
            setCasoAsignado(caso);

            return caso;
        }

        public ArrayList<Persona> obtenerVillanos(){
            ArrayList<Persona> villanos = new ArrayList<Persona>();
            Persona tomas = new Persona();
            Persona nicolas = new Persona();
            Persona belen = new Persona();
            Persona maria = new Persona();
            

            ArrayList<String> hobbiesNicolas = new ArrayList<String>();
            ArrayList<String> hobbiesTomas = new ArrayList<String>();
            ArrayList<String> hobbiesMaria = new ArrayList<String>();
            ArrayList<String> hobbiesBelen = new ArrayList<String>();

            ArrayList<String> seniasNicolas = new ArrayList<String>();
            ArrayList<String> seniasTomas = new ArrayList<String>();
            ArrayList<String> seniasMaria = new ArrayList<String>();
            ArrayList<String> seniasBelen = new ArrayList<String>();

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

            seniasTomas.add("Tiene pelo rubio.");
            seniasTomas.add("Lleva consigo una pulsera de oro blanco.");
            seniasTomas.add("Su comida favorita son los varenikes.");
            seniasTomas.add("Usa zapatillas de distinto color.");
            seniasTomas.add("Tiene anteojos.");
            seniasTomas.add("Tiene aritos en la oreja.");

            seniasBelen.add("Tiene pelo rubio.");
            seniasBelen.add("Tiene anteojos.");
            seniasBelen.add("Su color favorito es el negro.");
            seniasBelen.add("Su comida favorita son las pastas.");

            seniasMaria.add("Tiene pelo negro.");
            seniasMaria.add("Su color favorito es el negro.");
            seniasMaria.add("Tiene anteojos.");
            seniasMaria.add("Su comida favorita son los varenikes.");
            seniasMaria.add("Tiene aritos en la oreja.");

            seniasNicolas.add("Tiene pelo negro.");
            seniasNicolas.add("Su comida favorita son las pastas.");
            seniasNicolas.add("Tiene aritos en la oreja.");
            seniasNicolas.add("Su color favorito es el violeta.");

            tomas.setNombre("Tomas");
            tomas.setSexo("Masculino");
            tomas.setHobbies(hobbiesTomas);
            tomas.setSeniasParticulares(seniasTomas);

            nicolas.setNombre("Nicolas");
            nicolas.setSexo("Masculino");
            nicolas.setHobbies(hobbiesNicolas);
            nicolas.setSeniasParticulares(seniasNicolas);

            belen.setNombre("Belen");
            belen.setSexo("Femenino");
            belen.setHobbies(hobbiesBelen);
            belen.setSeniasParticulares(seniasBelen);

            maria.setNombre("Maria");
            maria.setSexo("Femenino");
            maria.setHobbies(hobbiesMaria);
            maria.setSeniasParticulares(seniasMaria);

            villanos.add(tomas);
            villanos.add(belen);
            villanos.add(maria);
            villanos.add(nicolas);

            return villanos;
        }

        private Villano obtenerVillanoAlAzar (ArrayList<Pais> planEscape){
            Villano villano = new Villano();
            ArrayList<Persona> listaPersonas = obtenerVillanos();
            int numeroAzar = obtenerNumeroAleatorio(listaPersonas.size());

            villano.setNombre(listaPersonas.get(numeroAzar).getNombre());
            villano.setSexo(listaPersonas.get(numeroAzar).getSexo());
            villano.setSeniasParticulares(listaPersonas.get(numeroAzar).getSeniasParticulares());
            villano.setHobbies(listaPersonas.get(numeroAzar).getHobbies());
            villano.setPlanEscape(planEscape);
            villano.setPaisActual(planEscape.get(0));
            villano.setearLugarInteresActual();
            setVillanoAsignado(villano);

            return villano;
        }

        public LugarInteres obtenerLugarDeInteresOrigen(Villano villano){
            return villano.paisActual.getLugaresInteres().get(obtenerNumeroAleatorio(villano.getPaisActual().getLugaresInteres().size()));
        }



        public ArrayList<Pais> obtenerListaPaises (){
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

            argentina.setObjeto(Objeto.OBJETO1);
            brasil.setObjeto(Objeto.OBJETO2);
            chile.setObjeto(Objeto.OBJETO3);
            uruguay.setObjeto(Objeto.OBJETO4);
            mexico.setObjeto(Objeto.OBJETO5);
            francia.setObjeto(Objeto.OBJETO6);
            colombia.setObjeto(Objeto.OBJETO7);
            egipto.setObjeto(Objeto.OBJETO8);
            india.setObjeto(Objeto.OBJETO9);

            argentina.setReporte(Reporte.REPORTE1);
            brasil.setReporte(Reporte.REPORTE2);
            chile.setReporte(Reporte.REPORTE3);
            uruguay.setReporte(Reporte.REPORTE4);
            mexico.setReporte(Reporte.REPORTE5);
            francia.setReporte(Reporte.REPORTE6);
            colombia.setReporte(Reporte.REPORTE7);
            egipto.setReporte(Reporte.REPORTE8);
            india.setReporte(Reporte.REPORTE9);

            argentina.setTitulo(Titulo.TITULO1);
            brasil.setTitulo(Titulo.TITULO2);
            chile.setTitulo(Titulo.TITULO3);
            uruguay.setTitulo(Titulo.TITULO4);
            mexico.setTitulo(Titulo.TITULO5);
            francia.setTitulo(Titulo.TITULO6);
            colombia.setTitulo(Titulo.TITULO7);
            egipto.setTitulo(Titulo.TITULO8);
            india.setTitulo(Titulo.TITULO9);

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
            uruguay.setLugaresInteres(Arrays.asList(new Banco(), new Embajada()));

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
            brasil.setConexiones(Arrays.asList(argentina,uruguay,mexico,egipto,francia));
            uruguay.setConexiones(Arrays.asList(argentina,brasil,chile,colombia,egipto));
            chile.setConexiones(Arrays.asList(argentina,uruguay,india,mexico,egipto));
            mexico.setConexiones(Arrays.asList(brasil,chile,colombia,egipto,argentina));
            colombia.setConexiones(Arrays.asList(uruguay,mexico,argentina,india,francia));
            india.setConexiones(Arrays.asList(india,argentina,chile,egipto,francia));
            egipto.setConexiones(Arrays.asList(india,francia,mexico,uruguay,brasil));
            francia.setConexiones(Arrays.asList(egipto,argentina,india,brasil,uruguay));

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


        public Pais obtenerPaisOrigen(){
            ArrayList<Pais> listaPaises = obtenerListaPaises();
            return listaPaises.get(obtenerNumeroAleatorio(listaPaises.size()));
        }

        private ArrayList<Pais> generarCasos (Pais pais){
            ArrayList <Pais> caso = new ArrayList<Pais>();
            caso.add(pais);
            return devolverListaPaisesAzar(pais,caso);


        }

        private ArrayList<Pais> devolverListaPaisesAzar (Pais pais, ArrayList<Pais> caso){
            ArrayList <Pais> caso2 = caso;
            Pais proximo = obtenerConexionAleatoria(pais);
            if(caso.size() == 7){ //aumento la cantidad de paises en la lista despues de la modificacion de arriba
                return caso2;
            }
            while(caso.contains(proximo)){
                proximo = obtenerConexionAleatoria(pais);
            }

            caso2.add(proximo);
            devolverListaPaisesAzar(proximo,caso2);
            return caso2;

        }
        private Pais obtenerConexionAleatoria(Pais pais){
            int numAlAzar = obtenerNumeroAleatorio(pais.getConexiones().size());
            return pais.getConexiones().get(numAlAzar);
        }

		public Pais getPaisActual() {
			return jugadorAsignado.getPaisActual();
		}

        public List<String> obtenerListaPaisesCaso(){
            return this.casoAsignado.getPlanEscape().stream().map(pais -> pais.getNombre()).collect(Collectors.toList());
        }
}

