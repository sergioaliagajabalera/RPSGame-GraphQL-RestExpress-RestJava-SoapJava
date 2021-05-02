/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectem07uf4consumidorjavasoap;

/**
 *
 * @author Sergio
 */
public class Projectem07UF4consumidorJavaSoap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(iniciarJoc(127));
        System.out.println(consultarEstatPartida(127));
        System.out.println(iniciarJoc(127));
        System.out.println(consultarEstatPartida(127));
        System.out.println(moureJugador(127,1,"paper"));
        System.out.println(consultarEstatPartida(127));
        System.out.println(moureJugador(127,2,"pedra"));
        System.out.println(consultarEstatPartida(127));
        System.out.println(moureJugador(127,1,"tisora"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,1,"pedra"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,1,"paper"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,1,"tisora"));
        System.out.println(moureJugador(127,1,"tisora"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(moureJugador(127,2,"paper"));
        System.out.println(consultarEstatPartida(127));
        System.out.println(acabarJoc(127));
       
         
    }

    //es registra el usuari
    private static String iniciarJoc(int codi) {
        projectem07uf4consumidorjavasoap.JugadorsWebService_Service service = new projectem07uf4consumidorjavasoap.JugadorsWebService_Service();
        projectem07uf4consumidorjavasoap.JugadorsWebService port = service.getJugadorsWebServicePort();
        return port.iniciarJoc(codi);
    }

    //s'envia un moviment
    private static String moureJugador(int codi, int njugador, java.lang.String tipusmoviment) {
        projectem07uf4consumidorjavasoap.JugadorsWebService_Service service = new projectem07uf4consumidorjavasoap.JugadorsWebService_Service();
        projectem07uf4consumidorjavasoap.JugadorsWebService port = service.getJugadorsWebServicePort();
        return port.moureJugador(codi, njugador, tipusmoviment);
    }

    //es consulta el estat partida
    private static String consultarEstatPartida(int codi) {
        projectem07uf4consumidorjavasoap.JugadorsWebService_Service service = new projectem07uf4consumidorjavasoap.JugadorsWebService_Service();
        projectem07uf4consumidorjavasoap.JugadorsWebService port = service.getJugadorsWebServicePort();
        return port.consultarEstatPartida(codi);
    }
    
    
    //finaliza el joc
    private static String acabarJoc(int codi) {
        projectem07uf4consumidorjavasoap.JugadorsWebService_Service service = new projectem07uf4consumidorjavasoap.JugadorsWebService_Service();
        projectem07uf4consumidorjavasoap.JugadorsWebService port = service.getJugadorsWebServicePort();
        return port.acabarJoc(codi);
    }
 
}
