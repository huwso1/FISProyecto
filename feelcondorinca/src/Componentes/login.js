import React from "react";

function Login() {
    return(
      <div className="contenedor-login">
        <h1>Usuario</h1>
        <input type="text" name="Usuario"/>
        <h1>Contraseña</h1>
        <input type="text" name="Contrasena"/>
        <p></p>
        <img src={require("./Imagenes/Facilito.png")}/>
      </div>
    );
}
export default Login;