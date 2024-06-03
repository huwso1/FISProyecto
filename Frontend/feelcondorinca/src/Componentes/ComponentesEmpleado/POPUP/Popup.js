import React, { useState } from "react";
import "../../css/Popup.css";
import Form from 'react-bootstrap/Form';
import Calificacion from '../Calificacion.js';  

function Popup({ codigo,fase,onClose,utilitary }) {

    function formulariodefase(){
        if(fase=="Pendiente"){
          return <Calificacion></Calificacion>
        }
        if(fase=="Devuelto"){
          return <Calificacion/>
        }
       
    }
  return (
    <div className="popup-container">
      <div className="popup">
        
        {formulariodefase()}
      
        <Form.Control as="input" type="button" value="cerrar" style={{position:"absolute",bottom:"3rem",right:"4rem", width:"20%"}} onClick={onClose}/>
      </div>
    </div>
  );
};

export default Popup;