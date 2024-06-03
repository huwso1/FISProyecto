import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Popup from './POPUP/Popup.js';
import axios from 'axios';

function Reserva({CodigoR,CodigoRe,NombreU,FechaInicio,FechaFinal,handler,Estado,Fecha,CodigoU}){
    
const [debug,setdebug]=useState();
const[estado,setEstado]=useState();
const [openPop,setPop]=useState();


const PeticionPrestar=(e)=>{
    
    axios.post("http://localhost:8080/Empleado/RegistrarPrestamo",{"idReserva":CodigoR}).then((response)=>{
        alert("Reserva prestada con esito");
        window.location.reload();
    }).catch((response)=>{
        setdebug(response);
    })
}
function updatePop(bool){
if(estado=="Por Confirmar"){
    PeticionPrestar();
}else{
setPop(bool);
}
}

const handlecancelacion=(idreserva)=>{
    handler(idreserva);
}
function onClose(){
    setPop(false);
}
function Handler(){
    
    
    if(estado=="PRESTAR"){
        //Envia la peticion de prestamo :v
    }
    
    if(estado=="DEVOLVER" && openPop==true){
        //Envia la peticion de devolucion y abre la calificacion
        return <Popup fase={estado} onClose={onClose} utilitary={CodigoR} codigo={CodigoU}></Popup>
    }
    if(estado=="Por Confirmar"){
            
    }
    
}
function estados(){
    if(Estado==="PENDIENTE"){
        setEstado("Pendiente");
        return "Pendiente";
    }
    if(Estado==="PORCONFIRMAR"){
        setEstado("Por Confirmar");
        return "Por Confirmar";
    }
    if(Estado==="CANCELADA"){
        setEstado("cancelada");
        return "Cancelada";
    }
    if(Estado==="PRESTAR"){
        setEstado("PRESTAR");
        return "PRESTAR";
    }
    if(Estado==="CONFIRMADA"){
        setEstado("DEVOLVER");
        return "CONFIRMADA";
    }
    if(Estado==="FINALIZADACALIFICADA"){
        setEstado("Finalizada");
        return "Finalizada";
    }
    if(Estado==="FALLA DE SERVICIO"){
        setEstado("FALLA DE SERVICIO");
        return "Falla DE SERVICIO";
    }
    if(Estado==="DEVUELTO SIN CALIFICAR"){
        setEstado("DEVUELTO SIN CALIFICAR");
        return "DEVUELTO SIN CALIFICAR";
    }
    if(Estado==="CALIFICADO"){
        setEstado("CALIFICADO");
        return "CALIFICADO";
    }
    
}
useEffect(()=>{
    estados();
    },[])
    useEffect(()=>{
        estados();
        },[Estado])
return(
    <CardGroup>
        <Card style={{alignItems:'center'}} >
            <CardBody >
                <p>{CodigoR}</p>
                
            </CardBody>
        </Card>
        <Card style={{alignItems:'center'}}>
            <CardBody >
                <p>{CodigoRe}</p>
            </CardBody>
        </Card>
        <Card style={{alignItems:'center'}}>
            <CardBody >
                <p>{NombreU}</p>
            </CardBody>
        </Card>
        <Card style={{alignItems:'center'}}>
            <CardBody >
                <p>Fecha: {Fecha} <br></br>
                Hora de inicio: {FechaInicio} <br></br>
                Hora de finalizacion: {FechaFinal}</p>
            </CardBody>
        </Card>
        <Card>
            <CardBody>
            <Form.Control as='input' type='button' value={estado} name='Cancelar' onClick={()=>{updatePop(true)}}></Form.Control>
            </CardBody>
            {Handler()}
        </Card>
    </CardGroup>
)
}
export default Reserva;