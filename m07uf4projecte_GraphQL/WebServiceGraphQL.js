const express  = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');


const esquema = buildSchema(`
type Jugador {
  codi: ID!
  njugador: Int
  moviment: String
  torn: Int
  puntuacio: Int
}

type Query {
  consultarEstatPartida(codi: ID!): [Jugador]
  temporal: [Jugador]
}

type Mutation {
  iniciarJoc(codi: ID!): Jugador
  moureJugador(codi: ID!, njugador: Int!,moviment: String!): String
  acabarJoc(codi: ID!): String
}
`);

// aquesta arrel té una funció per a cada endpoint de l'API
function pedrapapertisores(jugador1,jugador2){
  switch(jugador2){
      case 'pedra':
          switch(jugador1){
              case 'paper': return 1;
              case 'tisora': return 2;
              case 'pedra':  return 0;
          }
          break;
      case 'paper':
          switch(jugador1){
              case 'tisora': return 1;
              case 'pedra': return 2;
              case 'paper': return 0;
          }
          break;
      case 'tisora':
          switch(jugador1){
              case 'pedra': return 1;
              case 'paper': return 2;
              case 'tisora': return 0;
          }
          break;
      default: break;
  }
}




const jugadors = [{codi:0 , njugador:null,moviment:null,torn:0,puntuacio:0}];

const arrel = {
    temporal() {
        return jugadors;
    },
    consultarEstatPartida: ({codi}) => {
        let jugador= jugadors.filter(a => a.codi == codi);
        console.log(jugador);
        if (!jugador) throw new Error("Sala "+codi+': no existeix, ets segur que es aquesta?');
        return jugador; 
    },
    iniciarJoc: ({ codi }) => {
      var jugador={};
      if(jugadors.find(a =>a.codi===codi && a.njugador==2))  throw new Error("Sala "+codi+": esta plena");
      else if(jugadors.find(a =>a.codi===codi)) jugador={codi: codi,njugador:2,moviment:'',torn:0,puntuacio:0};
      else jugador={codi: codi,njugador:1,moviment:'',torn:0,puntuacio:0};
      jugadors.push(jugador);
      return jugador;
    },
    moureJugador: ({ codi,njugador,moviment }) => {
      var missatge='';
      if(jugadors.find(a =>a.codi===codi && a.njugador!=njugador)){
        if(njugador===1 || njugador===2){
          if(moviment==="pedra" || moviment==="paper" || moviment==="tisora" ){
              var jugador = jugadors.find(a =>a.codi===codi && a.njugador===njugador);
              var modificaMoviment={codi: codi,njugador: njugador,moviment: moviment,torn: jugador.torn+1,puntuacio: jugador.puntuacio};
              var jugador2= jugadors.find(a =>a.codi===codi && a.njugador!=njugador);
                
              if(modificaMoviment.torn-1==jugador2.torn || modificaMoviment.torn==jugador2.torn){
                  if(jugador.puntuacio!==3 && jugador2.puntuacio!==3){
                      if(modificaMoviment.torn===jugador2.torn){
                        var modificaMoviment2={codi: jugador2.codi,njugador: jugador2.njugador,moviment: jugador2.moviment,torn: jugador2.torn,puntuacio: jugador2.puntuacio};
                        resultat= pedrapapertisores(modificaMoviment.moviment,jugador2.moviment);
                        if(resultat==0){
                          missatge=missatge+"EMPAT";
                        }
                        if(resultat==1){
                          modificaMoviment={codi: codi,njugador: njugador,moviment: moviment,torn: modificaMoviment.torn,puntuacio: modificaMoviment.puntuacio+1};
                          missatge=missatge+"GUANYES!!!!";
                        }
                        if(resultat==2){
                          modificaMoviment2={codi: jugador2.codi,njugador: jugador2.njugador,moviment: jugador2.moviment,torn: jugador2.torn,puntuacio: modificaMoviment2.puntuacio+1};
                          missatge=missatge+"PERDS :(";
                        }
                        var index2 =jugadors.indexOf(jugador2);
                        jugadors[index2]=modificaMoviment2;
                      }else missatge=missatge+"Moviment fet amb exit, espera a que l'altre jugador faci el moviment.";
                      var index =jugadors.indexOf(jugador);
                      jugadors[index]=modificaMoviment;
                      return "Codi Partida: "+codi+" Jugador "+njugador+" has tirat "+moviment+" "+missatge;
                    }else return `Partida ${codi}: finalitzada\n Jugador1: ${jugador.puntuacio}\t Jugador2: ${jugador2.puntuacio}\n Per esborrar la partida aneu a /acabarJoc/codiPartida`;
                }else throw new Error(`Jugador ${njugador}: Esperi a que tiri l'altre jugador`);
            }else throw new Error(`Jugador ${njugador}: el teu moviment ${moviment} es incorrecte`);
        }else throw new Error(`Jugador ${njugador} es incorrecte`);
      }else throw new Error("Espera a que l'altre jugador s'uneixi o codi de partida incorrecte");
    },
    acabarJoc: ({codi})=>{
      var jugador = jugadors.find(a =>a.codi===codi);
      var index =jugadors.indexOf(jugador);
      console.log(index);
      if (index!=-1){
          jugadors.splice(index, 1);
          if(jugadors.find(a =>a.codi===codi)){
          jugador = jugadors.find(a =>a.codi===codi);
          index = jugadors.indexOf(jugador);
          jugadors.splice(index, 1);
          }
      }
      return  index!=-1? "Partida eliminada" : "Aquesta Partida no existeix";
      
    }
};

const app = express();
app.use(express.static('public'))
app.use('/graphql', graphqlHTTP({
    schema: esquema,
    rootValue: arrel,
    graphiql: true,
}));
app.listen(4000);
console.log('Executant servidor GraphQL API a http://localhost:4000/graphql');

/*
//Classe que representa un Alumne
class Jugador {
    constructor(codi) {
        this.codi = codi;
        this.nom = nom;
    }
}
*/