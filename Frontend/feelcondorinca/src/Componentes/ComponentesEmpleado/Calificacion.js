import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Popup from './POPUP/Popup.js';
import { Rating } from 'react-simple-star-rating'
import axios from 'axios';

function Calificacion({idReserva,idUsuario}){
const [calidad,setCaliddad]=useState(0);
const [cumplimientohorario,setCumplimientohorario]=useState(0);
const [trato_personal,setTratoPersonal]=useState(0);
const [estado,setEstado]=useState(0);
const [message,setMessage]=useState("");

const PeticionCalificacion=(element)=>{
        element.preventDefault()
        
            axios.post("http://localhost:8080/Empleado/RegistrarDevolucion", {"idReserva":idReserva,"calidad":calidad,"cumplimientohorario":cumplimientohorario,"tratopersonal":trato_personal,"estado":estado,"idEmpleado":window.sessionStorage.getItem("idUsuario") })
                .then((response) => {
                    // Resolvemos la promesa con los datos recibidos
                    alert("Se ha devuelto el recurso con esito");
                    window.location.reload();
                    
                })
                .catch((error) => {
                    // Rechazamos la promesa con el mensaje de error
                    
                });
        
      
}


return( 
    <div style={{paddingTop:"4rem"}}>
        <Form.Label style={{left:'50%'}}><h2>Queremos saber tu opinion</h2></Form.Label>
    <Card style={{border:"0px"}}>
    <Form.Label style={{left:'50%'}}>¿Que calificacion le daria a la calidad de los recursos prestados?</Form.Label>
        <Rating
        onClick={(rate)=>{setCaliddad(rate)}}
      />
    </Card>
    <Card style={{border:"0px"}}>
    <Form.Label style={{left:'50%'}}>¿Como calificaria el cumplimiento de los horarios por parte de nuestros empleados?</Form.Label>
      <Rating
        onClick={(rate)=>{setCumplimientohorario(rate)}}
      />
    </Card>
    <Card style={{border:"0px"}}>
    <Form.Label style={{left:'50%'}}>¿Como calificaria la atencion de nuestros empleados?</Form.Label>
           <Rating
        onClick={(rate)=>{setTratoPersonal(rate)}}
      />
      </Card>
      <Card style={{border:"0px"}}>
    <Form.Label style={{left:'50%'}}>¿Como calificaria el estado fisico de los recursos utilizados?</Form.Label>
           <Rating
        onClick={(rate)=>{setEstado(rate)}}
      />
      </Card>
      <Card style={{border:"0px",justifyContent:"center",alignItems:"center",paddingTop:"2rem"}}>
    
    <Form.Control as="input" type="button" value="Calificar servicio" style={{ width:"20%",backgroundColor:"blue",color:"white"}} onClick={PeticionCalificacion}/>
      </Card>
      
       </div>
);
}
export default Calificacion;