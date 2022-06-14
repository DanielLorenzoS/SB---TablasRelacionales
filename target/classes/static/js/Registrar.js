async function registrarUsuario() {

    let persona = {};
    persona.nombre = document.querySelector("#txtNombre").value;
    persona.apellidoPaterno = document.querySelector("#txtApellidoPaterno").value;
    persona.apellidoMaterno = document.querySelector("#txtApellidoMaterno").value;
    persona.identificacion = document.querySelector("#txtIdentificacion").value;
    persona.correo = document.querySelector("#txtCorreo").value;
    persona.contraseña = document.querySelector("#txtContraseña").value;

    let repeatPassword = document.querySelector("#txtRContraseña").value;

    if (persona.contraseña == repeatPassword) {
        const request = await fetch("/persona/", {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(persona),
        });

        window.location.href = "./login";
    } else {
        alert("La contraseña no coincide");
    }
}
