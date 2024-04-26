import React from "react";
import button from "bootstrap/js/src/button"
import {useNavigate} from "react-router";

function Login() {

    const navigate = useNavigate();

    return (
        <div className="d-flex justify-content-center align-items-center" >
            <figure className="figure text-center">
                <img src={require("./Imagenes/Escudo1.png")}/>
                <h1 class = "probar">Usuario</h1>
                <div className="form-group">
                    <input type="text" name="Usuario"/>
                </div>
                <h1 class = "probar">Contraseña</h1>
                <div className="form-group">
                    <input type="text" name="Contrasena"/>
                </div>
                <div className="form-group" class = "probar">
                    <button type="button" className="btn btn-primary" onClick={() => navigate('/NavigateBar')}>Ingresar
                    </button>
                </div>
                <p></p>
            </figure>
        </div>
    );
}

export default Login;