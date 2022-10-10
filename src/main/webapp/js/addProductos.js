$(document).ready(function () {

    
    $("#form-register").submit(function(event){
         event.preventDefault();
        registrarProducto();
        

});

});

//FUNCION AGREGAR PRODUCTOS


function registrarProducto() {

    let num_parte = $("#input-numerodeparte").val();
    let nombre = $("#input-nombreproducto").val();
    let categoria = $("#input-categoria").val();
    let cantidad = $("#input-cantidad").val();
    let descripcion = $("#input-descripcion").val();
    let fecha_in = $("#input-fechaingreso").val();
    let precio = $("#input-precio").val();
 
   
    

    if (precio != 0) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletProductoRegister",
            data: $.param({
                num_parte: num_parte,
                nombre: nombre,
                categoria: categoria,
                cantidad: cantidad,
                descripcion: descripcion,
                fecha_in: fecha_in,
                precio: precio
            }),
      success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "tableProductos.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del producto");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

