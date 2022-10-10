var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getProducto().then(function () {       
        

        getProductos(false, "ASC");


    });
});

function getProductos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductosListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarProductos(parsedResult);
            } else {
                console.log("Error recuperando los datos de los productos");
            }
        }
    });
}

function mostrarProductos(producto) {
     let contenido = "";
       $.each(usuario, function (index, producto) {
    
    
     producto = JSON.parse(producto);
      
        

            contenido += '<tr><th scope="row">' + producto.num_parte + '</th>' +
                    '<td>' + producto.nombre + '</td>' +
                    '<td>' + producto.categoria + '</td>' +
                    '<td>' + producto.cantidad + '</td>' +
                    '<td>' + producto.descripcion + '</td>' +
                    '<td>'+ producto.fecha_in +'</td>'+
                    '<td>'+ producto.precio +'</td>'+
                                                        '</tr>'
            

        }
    );
    $("#Producto-tbody").html(contenido);
}




