function getHeaders() {
    return {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: localStorage.token,
    };
}

entrarPerfil = async () => {
    let persona = {};
    persona.correo = document.querySelector("#txtCorreo").value;
    persona.password = document.querySelector("#txtContraseña").value;

    const request = await fetch(`/persona/login/query?correo=${persona.correo}`, {
        method: "GET",
        headers: getHeaders(),
    });

    const res = await request.json();
    let pivote;
    console.log(res.map((e) => pivote = (e.contraseña)));

    if (persona.password == pivote) {
        window.location.href = "./personas.html";
    } else {
        alert("La contraseña es incorrecta");
    }
}
