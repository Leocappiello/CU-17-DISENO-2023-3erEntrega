fetch('http://localhost:8080/data')
  .then(response => response.json())
  .then(data => {
    const tabla = document.getElementById('resultado').querySelector('tbody');
    
    // cliente nombre
    /* console.log(data.llamada.cliente.nombreCompleto); */
    /* console.log(data.categoria.nombre); */
    /* console.log(data.categoria.opciones); */
    /* console.log(data.llamada.subOpcionLlamada); */
    /* console.log(data.llamada.estadoActual.nombre); */
    

    // Iterar sobre los datos y agregar filas a la tabla
    
    

    data.forEach(item => {
      const fila = document.createElement('tr');

      const {nombre, opciones} = item.categoria
      const {subOpcionLlamada, estadoActual, cliente} = item.llamada
      const nombreCliente = cliente.nombreCompleto;
      const nombreEstadoAct = estadoActual.nombre;


      console.log(nombre, opciones, subOpcionLlamada, estadoActual, nombreCliente, nombreEstadoAct);

      console.log(item);
      fila.innerHTML = `
        <th scope="row">${item.id}</th>
        <td>${item.nombre_apellido}</td>
        <td>${item.categoria}</td>
        <td class="text-center">${item.opcion}</td>
        <td class="text-center">${item.subopcion}</td>
        <td class="text-center">${item.estado}</td>
        <td class="text-center"><button class="btn btn-primary" type="button" onclick="location.href='./pages/llamadas.html'">
        <span class="material-symbols-outlined align-middle">more_horiz</span>
        </button></td>
      `;
      tabla.appendChild(fila);
    });
  });


  