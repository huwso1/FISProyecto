import React from "react";
import Button from "react-bootstrap/Button";

function Afiliado(){
    return (
        <div className="d-flex align-items-center justify-content-center" style={{height: "100vh"}}>
            <div className="text-center">
                <h1 className="mb-4">Bienvenid@ {window.sessionStorage.getItem("nombre")+" "+window.sessionStorage.getItem("apellido")}</h1>
            </div>
        </div>
    )
}

export default Afiliado;