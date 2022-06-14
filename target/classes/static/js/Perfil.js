async function registrarFactura() {

    let factura = {};
    /*factura.nombre = document.querySelector("#txtNombre").value;*/
    factura.fecha = document.querySelector("#txtFecha").value;
    factura.concepto = document.querySelector("#txtConcepto").value;
    factura.iva = document.querySelector("#txtIva").value;
    factura.cuotaIva = document.querySelector("#txtCuota").value;
    factura.total = document.querySelector("#txtTotal").value;

    const request = await fetch("/factura/", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(factura),
    });
    location.reload();
}

function getHeaders() {
    return {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: localStorage.token,
    };
}

async function cargarFacturas() {
    const request = await fetch("/factura", {
        method: "GET",
        headers: getHeaders(),
    });
    const facturas = await request.json();

    let listadoHtml = "";

    for (let factura of facturas) {
        let facturaHtml = ` <div class="facturasGuardadas">
                                <h5>Fecha: ${factura.fecha} </h5>
                                <h5>Concepto: ${factura.concepto}</h5>
                                <h5>IVA: ${factura.iva}</h5>
                                <h5>Cuota IVA: ${factura.cuotaIva}</h5>
                                <h5>Total: ${factura.total}</h5>
                            </div>`;

        listadoHtml += facturaHtml;
    }
    console.log(listadoHtml);
    document.querySelector(".reload").outerHTML = listadoHtml;

}

cargarFacturas();

recargar = () => location.reload();