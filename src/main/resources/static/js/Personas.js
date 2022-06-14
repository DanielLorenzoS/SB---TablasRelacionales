function getHeaders() {
  return {
    Accept: "application/json",
    "Content-Type": "application/json",
    Authorization: localStorage.token,
  };
}

async function cargarPersonas() {
  const request = await fetch("/persona", {
    method: "GET",
    headers: getHeaders(),
  });
  const personas = await request.json();

  let listadoHtml = "";
  console.log(personas);

  for (let persona of personas) {
    let personaHtml = `<div class="table">
                              <div class="cont-entry">
                                <div class="entry">'Nombre: ' ${persona.nombre}  </div>
                                <div class="entry">'Apellidos: ' ${persona.apellidoPaterno}  </div>
                                <div class="entry">${persona.apellidoMaterno}  </div>
                                <div class="entry">'Correo: ' ${persona.correo}  </div>                              
                              </div>
                              <div class="cont-edit">
                                <div onclick="eliminarPersona(${persona.id})" class="entry eliminar">  Eliminar  </div>
                              </div>
                              
                         </div><br>`;

    listadoHtml += personaHtml;
  }

  document.querySelector(".content").outerHTML = listadoHtml;
}
cargarPersonas();

async function eliminarPersona(id) {
  if (confirm("Deseas eliminar este usuario?")) {
    const request = await fetch("/persona/delete/"+id, {
      method: "DELETE",
      headers: getHeaders(),
    });
  } else {
    return;
  }
  location.reload();
}
