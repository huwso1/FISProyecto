import React from "react";
import button from "bootstrap/js/src/button"
import {useNavigate} from "react-router";

function Login() {

    const navigate = useNavigate();

    return(
        <figure className="text-center">
            <blockquote className="blockquote">
                <div className="contenedor-login">
                    <label htmlFor="exampleInputEmail1" className="form-label">Usuario</label>
                    <input type="text" name="Usuario"/>
                    <h1>Contraseña</h1>
                    <input type="text" name="Contrasena"/>
                    <button type="button" className="btn btn-primary" onClick={() => navigate('/NavigateBar')}>Ingresar</button>
                    <p></p>
                    <img src={require("./Imagenes/Facilito.png")}/>
                </div>
            </blockquote>
        </figure>

    );
}

export default Login;