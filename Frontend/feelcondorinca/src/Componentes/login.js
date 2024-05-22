import React from "react";
import button from "bootstrap/js/src/button"
import axios from 'axios';
import {useState} from 'react';
import {useNavigate} from "react-router";

function Login() {
    const [usuario,SetUsuario]=useState('');
    const [password,SetPassword]=useState('');
    const [message,SetMessage]=useState('');

    const peticion=()=>{
        axios.post("http://localhost:8080/usuario/Login",{"idUsuario":usuario,"contrasenia":password}).then((response)=>{
        window.sessionStorage.setItem("apellido",response.data.apellido) ;  
        window.sessionStorage.setItem("nombre",response.data.nombre) ;  
        window.sessionStorage.setItem("rol",response.data.rol) ;
        window.sessionStorage.setItem("idUsuario",usuario) ;
        if(response.data.rol=="AFILIADO"){
            navigate("/NavigateBarAfiliado");
        }
        if(response.data.rol=="EMPLEADO"){
            navigate("/NavigateBarEMPLEADO");
        }
        if(response.data.rol=="ADMIN"){
            navigate("/NavigateBar");
        }
            
        }).catch((error)=>{
            SetMessage(error.response.data);
        })
    }
    

    const navigate = useNavigate();


    return (
        <div className="d-flex justify-content-center align-items-center" >
            <figure className="figure text-center">
                <img src={require("./Imagenes/Escudo1.png")}/>
                <h1 class = "probar">Usuario</h1>
                <div className="form-group">
                    <input type="text" name="Usuario" onChange={(element)=>{
                        SetUsuario(element.target.value);
                    }}/>
                </div>
                <h1 class = "probar">Contraseña</h1>
                <div className="form-group">
                    <input type="text" name="Contrasena" onChange={(element)=>{
                        SetPassword(element.target.value);
                    }}/>
                </div>
                <div className="form-group" class = "probar">
                    <button type="button" className="btn btn-primary" onClick={peticion}>Ingresar
                    </button>
                </div>
                <p>{message}</p>
            </figure>
        </div>
    );
}

export default Login;