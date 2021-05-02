window.addEventListener('load', function () {
    function cridarGraph() {
      let codi = document.getElementById('codi').value*1;
      let njugador = document.getElementById('njugador').value*1;
      let moviment = document.getElementById('moviment').value;
      var consulta = `
      mutation moureJugador($codi: ID!,$njugador: Int!, $moviment: String!){
        moureJugador(codi: $codi,njugador:$njugador,moviment:$moviment)
      }`;
      fetch('/graphql', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify({
          query: consulta,
          variables: {codi,njugador,moviment},
        })
      })
        .then(r => r.json())
        .then(dades => document.getElementById('sortida').innerText= JSON.stringify(dades));
    }
    document.getElementById('enviar').addEventListener('click', cridarGraph);
  });