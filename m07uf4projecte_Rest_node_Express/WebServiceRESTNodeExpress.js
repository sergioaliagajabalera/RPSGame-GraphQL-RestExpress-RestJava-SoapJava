const express = require('express');
const app=express();
var bodyParser = require('body-parser');
const jwt = require("jsonwebtoken");
const { read } = require('fs');







app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use((req, res, next) => {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.header(
      "Access-Control-Allow-Headers",
      "Origin, X-Requested-With, Content-Type, Accept"
    );
    next();
  });


var jugadors = [{codi:0 , njugador:null,moviment:null,torn:0,puntuacio:0}];



app.get('/', (req, res)=>res.send('Hola benvigut, si vols crear una partida per jugar posa /iniciarJoc/codiPartida\n'));
app.get('/iniciarJoc/codiPartida', (req, res)=>res.sendFile(__dirname+'/crearpartida.html'));
app.get('/moureJugador/codiPartida/jugador/tipusMoviment', (req, res)=>res.sendFile(__dirname+'/canvimoviment.html'));
app.get('/acabarJoc/codiPartida', (req, res)=>res.sendFile(__dirname+'/eliminarpartida.html'));

app.get('/temporal', (req, res)=>res.send(jugadors));


app.get('/consultarEstatPartida/codiPartida:JSON', (req, res)=>{
    console.log(req.params.JSON);
    try {
        let u = jwt.verify(req.params.JSON, 'clau');
        console.log(u);
        res.status(200).send(`PARTIDA ${u.sub}\n jugador ${u.jugador} has dit ${u.moviment}, es el teu torn ${u.torn} amb una puntuacio de ${u.puntuacio} `);

      } catch(err) {
        res.status(400).send("Error");
      }
});

app.post('/iniciarJoc/codiPartida', (req, res)=>{
    var jugador={};
    if(jugadors.find(a =>a.codi===parseInt(req.body.codi) && a.njugador==2)) return res.status(422).send("Aquesta Sala esta plena"); 
    else if(jugadors.find(a =>a.codi===parseInt(req.body.codi))) jugador={codi: parseInt(req.body.codi),njugador:2,moviment:'',torn:0,puntuacio:0};
    else jugador={codi: parseInt(req.body.codi),njugador:1,moviment:'',torn:0,puntuacio:0};


    jugadors.push(jugador);
    const token = jwt.sign({
        sub: jugador.codi,
        jugador: jugador.njugador,
        moviment: jugador.moviment,
        torn: jugador.torn,
        puntuacio: jugador.puntuacio
    }, "clau", { expiresIn: "3 hours" });
    res.status(200).send({ JSON: token })
});

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

    app.put('/moureJugador/codiPartida/jugador/tipusMoviment', (req, res)=>{
       var missatge='';
        if(jugadors.find(a =>a.codi===parseInt(req.body.codi) && a.njugador!=parseInt(req.body.njugador))){
        if(req.body.njugador==='1' || req.body.njugador==='2'){
            if(req.body.moviment==="pedra" || req.body.moviment==="paper" || req.body.moviment==="tisora" ){
                var jugador = jugadors.find(a =>a.codi===parseInt(req.body.codi) && a.njugador===parseInt(req.body.njugador));
                var modificaMoviment={codi: parseInt(req.body.codi),njugador: parseInt(req.body.njugador),moviment: req.body.moviment,torn: jugador.torn+1,puntuacio: jugador.puntuacio};
                var jugador2= jugadors.find(a =>a.codi===parseInt(req.body.codi) && a.njugador!=parseInt(req.body.njugador));
                
                if(modificaMoviment.torn-1==jugador2.torn || modificaMoviment.torn==jugador2.torn){
                    if(jugador.puntuacio!==3 && jugador2.puntuacio!==3){
                        if(modificaMoviment.torn===jugador2.torn){
                            var modificaMoviment2={codi: jugador2.codi,njugador: jugador2.njugador,moviment: jugador2.moviment,torn: jugador2.torn,puntuacio: jugador2.puntuacio};
                            resultat= pedrapapertisores(modificaMoviment.moviment,jugador2.moviment);
                            if(resultat==0){
                                missatge=missatge+"EMPAT";
                            }
                            if(resultat==1){
                                modificaMoviment={codi: parseInt(req.body.codi),njugador: parseInt(req.body.njugador),moviment: req.body.moviment,torn: modificaMoviment.torn,puntuacio: modificaMoviment.puntuacio+1};
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
                        const token = jwt.sign({
                            sub: jugador.codi,
                            jugador: jugador.njugador,
                            moviment: modificaMoviment.moviment,
                            torn: modificaMoviment.torn,
                            puntuacio: modificaMoviment.puntuacio
                        }, "clau", { expiresIn: "3 hours" });
                        res.status(200).send({ Text:missatge,JSON: token})
                    }else res.status(422).send(`Partida ${req.body.codi}: finalitzada\n Jugador1: ${jugador.puntuacio}\t Jugador2: ${jugador2.puntuacio}\n Per esborrar la partida aneu a /acabarJoc/codiPartida`);
                }else res.status(422).send(`Jugador ${req.body.njugador}: Esperi a que tiri l'altre jugador`);
            }else res.status(422).send(`Jugador ${req.body.njugador}: el teu moviment ${req.body.moviment} es incorrecte`);
        }else  res.status(422).send(`Jugador ${req.body.njugador} es incorrecte`);
    }else res.status(422).send("Espera a que l'altre jugador s'uneixi o codi de partida incorrecte");
});

app.delete('/acabarJoc/codiPartida', (req, res)=>{
    var jugador = jugadors.find(a =>a.codi===parseInt(req.body.codi));
    var index =jugadors.indexOf(jugador);
    console.log(index);
    if (index!=-1){
        jugadors.splice(index, 1);
        if(jugadors.find(a =>a.codi===parseInt(req.body.codi))){
        jugador = jugadors.find(a =>a.codi===parseInt(req.body.codi));
        index = jugadors.indexOf(jugador);
        jugadors.splice(index, 1);
        }
    }
    if (index!=-1)res.status(200).send('Partida eliminada');
    else res.status(422).send('Aquesta Partida no existeix');
});

app.listen(3000, ()=>console.log('inici servidor'));