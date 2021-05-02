/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fje.daw2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sergio
 */
@WebService(serviceName = "JugadorsWebService")
public class JugadorsWebService {
    private static List<Jugador> jugadors = new ArrayList<>();
    /**
     * This is a sample web service operation
     */
   

    /**
     * Web service operation
     */
    @WebMethod(operationName = "iniciarJoc")
    public String iniciarJoc(@WebParam(name = "codi") int codi) {
        //TODO write your implementation code here:
        Jugador creajugador = new Jugador(0,0,"",0,0);
        Iterator<Jugador> iter = jugadors.iterator();
        int existeixcodi=0,existeix=0;
        Jugador paraiterar;
        int njugadoriteracio, codiiteracio;
        while(iter.hasNext()) {
            paraiterar=iter.next();
            codiiteracio=paraiterar.getCodi();
            njugadoriteracio=paraiterar.getNjugador();
            if(codiiteracio==codi) existeixcodi=1; 
            if(codiiteracio==codi && njugadoriteracio==2 ) existeix=1; 
        };
        if(existeixcodi==1){ creajugador.setCodi(codi); creajugador.setNjugador(2);}
        else {creajugador.setCodi(codi); creajugador.setNjugador(1);}
        if(existeix==0){
            jugadors.add(creajugador);
            return "Codi Partida: "+codi+" | Jugador: "+creajugador.getNjugador();
        }else return "Aquesta Sala esta plena";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "acabarJoc")
    public String acabarJoc(@WebParam(name = "codi") int codi) {
        Iterator<Jugador> iter = jugadors.iterator();
        Jugador paraiterar;
        int obtecodi=-1,existeix=-1;
        while(iter.hasNext()) {     
            paraiterar = iter.next();
            obtecodi=paraiterar.getCodi();
            if (obtecodi == codi){
                existeix=0;
                iter.remove();
            } 
        }
        if(existeix!=-1) return "Partida "+codi+": eliminada";
        else  return "Partida "+codi+": no existeix, ets segur que és aquesta?";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarEstatPartida")
    public String consultarEstatPartida(@WebParam(name = "codi") int codi) {
       Iterator<Jugador> iter = jugadors.iterator();
        int existeixcodi=0,existeix=0,njugadoriteracio, codiiteracio;
        Jugador paraiterar;
        String concatenaEstat=""; 
        while(iter.hasNext()) {
            paraiterar=iter.next();
            codiiteracio=paraiterar.getCodi();
            njugadoriteracio=paraiterar.getNjugador();
            if(codiiteracio==codi && njugadoriteracio!=2){ 
                existeixcodi=1;
                concatenaEstat+="Al millor de 3:\nPartida "+codiiteracio+": \n Jugador1:"+paraiterar.puntuacio+"pts torn:"+paraiterar.torn+"\t " ;
                }; 
            if(codiiteracio==codi && njugadoriteracio==2 ){ 
                existeix=1;
                concatenaEstat+="Jugador2:"+paraiterar.puntuacio+"pts torn:"+paraiterar.torn+"\n Per esborrar la partida aneu a /acabarJoc/codiPartida";
            } 
        }
        if(existeixcodi==0) return "Aquesta sala no existeix, ets segur que es aquesta?";
        else if (existeix==0) return concatenaEstat+" Encara no s'ha unit l'altre jugador, espera";
        else return concatenaEstat;
    }

    /**
     * Web service operation
     */
    
    public int pedrapapertisores(String jugador1,String jugador2) {
        switch(jugador2){
            case "pedra":
                switch(jugador1){
                    case "paper": return 1;
                    case "tisora": return 2;
                    case "pedra":  return 0;
                }
                break;
            case "paper":
                switch(jugador1){
                    case "tisora": return 1;
                    case "pedra": return 2;
                    case "paper": return 0;
                }
                break;
            case "tisora":
                switch(jugador1){
                    case "pedra": return 1;
                    case "paper": return 2;
                    case "tisora": return 0;
                }
                break;
            default: break;
        }
        return -1;
    }
    
    
    @WebMethod(operationName = "moureJugador")
    public String moureJugador(@WebParam(name = "codi") int codi, @WebParam(name = "njugador") int njugador, @WebParam(name = "tipusmoviment") String tipusmoviment) {
        String missatge="";
        Jugador jugador2 = jugadors.stream().filter(customer -> customer.getCodi()==codi && customer.getNjugador()!=njugador ).findAny().orElse(null);
        if(jugador2!=null){
            if("pedra".equals(tipusmoviment)); //Comprovacio de que es tiri el moviment correcte pedra/paper/tisora
            else if ("paper".equals(tipusmoviment));
            else if ("tisora".equals(tipusmoviment));
            else return "Jugador "+njugador+": el teu moviment "+tipusmoviment+" es incorrecte";
            
            Jugador jugador = jugadors.stream().filter(customer -> customer.getCodi()==codi && customer.getNjugador()==njugador ).findAny().orElse(null);
            if(jugador.getTorn()==jugador2.getTorn()); //comprovacio del correcte funcionament en quant a torns tirats
            else if(jugador.getTorn()+1==jugador2.getTorn());
            else return "Jugador "+njugador+": Esperi a que tiri l'altre jugador";
       
            if(jugador.getPuntuacio()!=3 && jugador2.getPuntuacio()!=3); //comprovacio que la partida hagi finalizat (3 pts)
            else return "Partida "+codi+": finalitzada\n Jugador1: "+jugador.getPuntuacio()+"\t Jugador2: "+jugador2.getPuntuacio()+"\n Per esborrar la partida aneu a /acabarJoc/codiPartida";
            
            jugador.setTorn(jugador.getTorn()+1);
            jugador.setMoviment(tipusmoviment);
       
            if(jugador.getTorn()==jugador2.getTorn()){ //començem a la logica del programa en cas de que tots dos jugadors tenen el mateix torn
                int resultat=pedrapapertisores(jugador.getMoviment(),jugador2.getMoviment());
                switch (resultat){
                    case 0:
                        missatge=missatge+"EMPAT";
                        break;
                    case 1:
                        jugador.setPuntuacio(jugador.getPuntuacio()+1);
                        missatge=missatge+"GUANYES!!!!";
                        break;
                    case 2:
                        jugador2.setPuntuacio(jugador2.getPuntuacio()+1);
                        missatge=missatge+"PERDS :(";
                        break;
                    default:
                        return jugador.getNjugador()+"Error en la logica del programa, no s'ha trobat un cas en que jugador1 i jugador 2 guayi o empatin";
                }      
            }else missatge=missatge+"Moviment fet amb exit, espera a que l'altre jugador faci el moviment.";
            return "Codi Partida: "+codi+" Jugador "+njugador+" has tirat "+tipusmoviment+" "+missatge;
        }else return "Espera a que l'altre jugador s'uneixi o codi de partida incorrecte";
    }

}
