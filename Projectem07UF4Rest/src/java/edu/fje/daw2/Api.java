/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fje.daw2;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author Sergio
 */
@Path("api")
public class Api {

    @Context
    private UriInfo context;
    private static List<Jugador> jugadors = new ArrayList<>();
    /**
     * Creates a new instance of Api
     */
    public Api() {
        if (jugadors.size() == 0) {
            jugadors.add(new Jugador(0,0,"",0,0));
        }
    }

    /**
     * Retrieves representation of an instance of edu.fje.daw2.Api
     * @return an instance of java.lang.String
     */
    @Path("/temporal")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String temporal() {
        return jugadors.toString();
    }

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
    
    
    
    @Path("/moureJugador/codiPartida/jugador/tipusMoviment")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response mourejugador(@FormParam("codi") int codi, @FormParam("njugador") int njugador, @FormParam("tipusmoviment") String tipusmoviment) {
        String missatge="";
        Jugador jugador2 = jugadors.stream().filter(customer -> customer.getCodi()==codi && customer.getNjugador()!=njugador ).findAny().orElse(null);
        if(jugador2!=null){
            if("pedra".equals(tipusmoviment)); //Comprovacio de que es tiri el moviment correcte pedra/paper/tisora
            else if ("paper".equals(tipusmoviment));
            else if ("tisora".equals(tipusmoviment));
            else return Response.status(422).entity("Jugador "+njugador+": el teu moviment "+tipusmoviment+" es incorrecte").build();
            
            Jugador jugador = jugadors.stream().filter(customer -> customer.getCodi()==codi && customer.getNjugador()==njugador ).findAny().orElse(null);
            if(jugador.getTorn()==jugador2.getTorn()); //comprovacio del correcte funcionament en quant a torns tirats
            else if(jugador.getTorn()+1==jugador2.getTorn());
            else return Response.status(422).entity("Jugador "+njugador+": Esperi a que tiri l'altre jugador").build();
       
            if(jugador.getPuntuacio()!=3 && jugador2.getPuntuacio()!=3); //comprovacio que la partida hagi finalizat (3 pts)
            else return Response.status(422).entity("Partida "+codi+": finalitzada\n Jugador1: "+jugador.getPuntuacio()+"\t Jugador2: "+jugador2.getPuntuacio()+"\n Per esborrar la partida aneu a /acabarJoc/codiPartida").build();
            
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
                        return Response.status(422).entity(jugador.getNjugador()+"Error en la logica del programa, no s'ha trobat un cas en que jugador1 i jugador 2 guayi o empatin").build();
                }      
            }else missatge=missatge+"Moviment fet amb exit, espera a que l'altre jugador faci el moviment.";
            return Response.status(200).entity("Codi Partida: "+codi+" Jugador "+njugador+" has tirat "+tipusmoviment+" "+missatge).build();
        }else return Response.status(422).entity("Espera a que l'altre jugador s'uneixi o codi de partida incorrecte").build();
    }
    
    /**En aquesta peticio consultem l'estat de la partida
     * es comproba que existeix la partida
     * es comproba que existeix el segon jugador
     * es comproba la puntacio i torn de cada jugador 
     * @param codi
     * @return 
     */
    @Path("/consultarEstatPartida/{codi}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response consultarEstatPartida(@PathParam("codi") int codi) {
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
        if(existeixcodi==0) return Response.status(422).entity("Aquesta sala no existeix, ets segur que es aquesta?").build();
        else if (existeix==0) return Response.status(200).entity(concatenaEstat+" Encara no s'ha unit l'altre jugador, espera").build();
        else return Response.status(200).entity(concatenaEstat).build();
    }
    
    /* En aquesta peticio creem una nova partida o ens unim
    * es comproba si existeix la partida, si existeix ens unim com (jugador 2), sino es crea (jugador 1)
    * es comproba que no estigui plena(max.2 jugadors)
    * param codi
    * return
    */
    @Path("/iniciarJoc/codiPartida")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response iniciarJoc(@FormParam("codi") int codi) {
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
            return Response.status(200).entity("Codi Partida: "+codi+" | Jugador: "+creajugador.getNjugador()).build();
        }else return Response.status(422).entity("Aquesta Sala esta plena").build();
    }
       
    
    
    @Path("/acabarJoc/codiPartida")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response acabarJoc(@FormParam("codi") int codi) {
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
        if(existeix!=-1) return Response.status(200).entity("Partida "+codi+": eliminada").build();
        else  return Response.status(422).entity("Partida "+codi+": no existeix, ets segur que és aquesta?").build();
    }
}
