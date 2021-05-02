window.addEventListener('load', function () {
    function cridarGraph() {
      let codi = document.getElementById('codi').value*1;
      var consulta = `
      query consultarEstatPartida($codi: ID!){
        consultarEstatPartida(codi: $codi){
          codi
          njugador
          puntuacio
          torn
        }
      }`;
      fetch('/graphql', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify({
          query: consulta,
          variables: {codi},
        })
      })
        .then(r => r.json())
        .then(dades => document.getElementById('sortida').innerText= JSON.stringify(dades));
    }
    document.getElementById('enviar').addEventListener('click', cridarGraph);
  });