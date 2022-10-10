$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });
    
    $("#form-register").submit(function(event){
         event.preventDefault();
        registrarUsuario();
        

});

});

function autenticarUsuario() {

    let username = $("#username").val(); //lo que hay en el front (login.html) pongalo en el back
    let password = $("#password").val(); //lo que hay en el front (login.html) pongalo en el back

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            password: password
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
// FUNCION DE REGISTRAR
function registrarUsuario() {

    let username = $("#input-username").val();
    let password = $("#input-contrasena").val();
    let passwordConfirmacion = $("#input-contrasena-repeat").val();
    let cedula = $("#input-cedula").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let correo = $("#input-email").val();
    let fecha_nac = $("#input-fecha_nac").val();
    let celular = $("#input-celular").val();
    let rol = $("#input-rol").val();

    if (password == passwordConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                password: password,
                cedula: cedula,
                nombre: nombre,
                apellidos: apellidos,
                correo: correo,
                fecha_nac: fecha_nac,
                celular: celular,
                rol: rol
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "tableUsers.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

