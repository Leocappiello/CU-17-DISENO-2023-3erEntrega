const url = 'http://localhost:8080/data';
const table = document.getElementById('resultado').querySelector('tbody');

async function getData() {
    const data = await fetch(url);
    return await data.json();
}

async function extractData(data) {
    console.log(data);
    console.log(data.llamada.subOpcionLlamada.opcionLlamada.categoriaLlamada);

    const { nombre } = data.llamada.subOpcionLlamada.opcionLlamada.categoriaLlamada;
    const nombreCategoria = nombre;
    const nombreCliente = data.llamada.cliente.nombreCompleto
    const opcionesCategoria = data.llamada.subOpcionLlamada.opcionLlamada.nombre;
    const subOpcionLlamada = data.llamada.subOpcionLlamada.nombre
    const nombreEstadoAct = data.llamada.estadoActual.nombre;

    return { nombreCliente, nombreCategoria, opcionesCategoria, subOpcionLlamada, nombreEstadoAct }
}

(async function insertDataTable() {
    const data = await getData();

    data.forEach(async (item, index) => {
        const {nombreCliente, nombreCategoria, opcionesCategoria, subOpcionLlamada, nombreEstadoAct} = await extractData(item);
        
        let estadoActual = ``;
        
        if (nombreEstadoAct == 'Finalizada') {
            estadoActual = `badge rounded-pill bg-danger`
        } else if (nombreEstadoAct == 'Iniciada') {
            estadoActual = `badge rounded-pill bg-primary`
        } else {
            estadoActual = ``
        }

        table.innerHTML += `
            <th scope="row">${index}</th>
            <td>${nombreCliente}</td>
            <td>${nombreCategoria}</td>
            <td class="text-center">${opcionesCategoria}</td>
            <td class="text-center">${subOpcionLlamada}</td>
            <td class="text-center d-flex justify-content-center mt-2 ${estadoActual}">${nombreEstadoAct}</td>

            <td class="text-center">
                <button class="btn btn-primary text-black" type="button" onclick="location.href='./pages/llamadas.html?id=${index}'">
                <span class="material-symbols-outlined align-middle">more_horiz</span>
                </button>
            </td>
        `
    })
})()


