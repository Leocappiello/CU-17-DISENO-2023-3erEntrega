const baseUrl = 'http://localhost:8080'
const url = baseUrl + '/data?id=';
const table = document.getElementById("detalleLlamada")
const titleMenuValidacion = document.getElementById("title-menu-validacion")
const confirmarBoton = document.getElementById("confirm-button")
const descripcionesValidacion = document.getElementsByClassName('floatingTextarea')
let validacionRequerida = '';

confirmarBoton.addEventListener(("click"), async () => {
    const options = document.getElementsByName('flexRadioDefault');
    const modal = document.getElementById('modal-body')
    const floatingTextarea = document.getElementById('floatingTextarea')
    var selectedOption;
    let result = false;
    
    for (var i = 0; i < options.length; i++) {
        if (options[i].checked) {
            selectedOption = options[i].nextElementSibling.innerHTML;
            break;
        }
    }

    if (options[i].classList.contains("correcta-true")) {
        modal.innerHTML = `<h3 class='text-center'>✔️ OPCION CORRECTA</h3>`
        result = true;
        
        setTimeout( function () {
            modal.innerHTML += "<h5 id='callcu'>Registrando accion requerida...<h5>"
        }, 1000)

        setTimeout( function () {
            let callcu = document.getElementById('callcu')
            
            if (Math.random() < 0.5) {
                callcu.innerHTML = "<h5 id='callcu'>No se pudo registrar la accion requerida<h5>"
            } else {
                callcu.innerHTML = "<h5 id='callcu'>Se registro la accion requerida con exito<h5>"
            }

        }, 3000)
    } else {
        modal.innerHTML = `<h3 class='text-center'>❌OPCION INCORRECTA</h3>`
    }

    result = {
        correcto: [result],
        descripcion: floatingTextarea.value
    }

    const requestPost = await fetch(baseUrl, {
        method: "POST",
        body: JSON.stringify(result),
        headers: {
            'Content-Type': 'application/json'
        },
    })
})

async function getData(urlSearch) {
    const data = await fetch(urlSearch);
    return await data.json();
}

async function extractData(data) {
    const nombreCliente = data.llamada.cliente.nombreCompleto
    const nombreCategoria = data.llamada.subOpcionLlamada.opcionLlamada.categoriaLlamada.nombre;
    const opcionesCategoria = data.llamada.subOpcionLlamada.opcionLlamada.nombre;
    const subOpcionLlamada = data.llamada.subOpcionLlamada.nombre
    const nombreEstadoAct = data.llamada.estadoActual.nombre
    
    /* const opcionesCategoria = opciones;

    const { subOpcionLlamada, estadoActual, cliente } = data.llamada
    const nombreEstadoAct = estadoActual.nombre;
    const nombreCliente = cliente.nombreCompleto; */

    return { nombreCliente, nombreCategoria, opcionesCategoria, subOpcionLlamada, nombreEstadoAct }
}

async function extractValidaciones(data) {
    validacionRequerida = data.llamada.subOpcionLlamada.validacionRequerida
    return validacionRequerida;
}

(async function insertDataCall() {
    const actualUrl = new URL(window.location.href);
    const params = new URLSearchParams(actualUrl.search);
    const id = params.get('id')
    const newUrl = url + id

    const data = await getData(newUrl);
    const { nombreCliente, nombreCategoria, opcionesCategoria, subOpcionLlamada } = await extractData(data)

    table.innerHTML = `
    <h2 class="fs-5 m-2 pb-1 border-bottom">Detalles de la llamada ${id}</h2>
        <div class="detail mx-4 d-flex justify-content-between text-center" >
            <p><strong>Cliente:</strong>${nombreCliente}</p>
            <p><strong>Categoria:</strong>${nombreCategoria}</p>
            <p><strong>Opción:</strong>${opcionesCategoria}</p>
            <p><strong>Subopción:</strong>${subOpcionLlamada}</p>
        </div>
    `

    titleMenuValidacion.innerHTML = `
        <h2 class="fs-5 m-2 pb-1 border-bottom">Validaciones de la ${subOpcionLlamada}</h2>
        <div class="detail mx-4 my-3">
            <div class="accordion" id="accordionExample">
            </div>
        </div>
    `
    
    const arrValidaciones = await extractValidaciones(data)
    arrValidaciones.forEach((elem) => {
        const insideValidacion = document.getElementById("accordionExample")

        insideValidacion.innerHTML += `
        <div class="accordion-item">
            <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                <strong>Validación</strong>
            </button>
            </h2>
            
            <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <p class="mb-3">${elem.nombre}</p>
                    <div class="form-floating">
                        <div id="validaciones">
                        </div>
                    <textarea id="floatingTextarea"  style="margin-top: 3rem;" class="form-control floatingTextarea" placeholder="Registrar respuesta aquí"></textarea>
                    <label  style="margin-top: 3rem;" for="floatingTextarea">Descripción de la respuesta</label>
                    </div>
                </div>
            </div>
        </div>
        `

        const validaciones = document.getElementById("validaciones");

        arrValidaciones[0].opcionesValidacion.forEach((elem, index) => {
            validaciones.innerHTML += `
                <div class="form-check">
                    <input class="form-check-input correcta-${elem.correcta}" type="radio" name="flexRadioDefault" id="option${index}" value="option${index}">
                    <label class="form-check-label" for="option${index}">
                    ${elem.descripcion}
                    </label>
                </div>
            `
        })
    });

    
})()

        
