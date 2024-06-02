import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';

function Reserva({CodigoR,CodigoRe,FechaInicio,FechaFinal,handler,Fecha,Estado}){
    
const [debug,setdebug]=useState();
const [estado,setEstado]=useState();
const handlecancelacion=(idreserva)=>{
    handler(idreserva);
}
function estados(){
    if(Estado==="PENDIENTE"){
        setEstado("Cancelar");
        return "Cancelar";
    }
    if(Estado==="CANCELADA"){
        setEstado("cancelada");
        return "Cancelar";
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
                <p>Fecha: {Fecha}<br></br>
                    Hora de inicio: {FechaInicio} <br></br>
                Hora Final {FechaFinal}</p>
            </CardBody>
        </Card>
        <Card>
            <CardBody>
            <Form.Control as='input' type='button' value={estado} name='Cancelar' onClick={()=>{if(estado=="Cancelar"){handlecancelacion(CodigoR) }}}></Form.Control>
            </CardBody>
        </Card>
    </CardGroup>
)
}
export default Reserva;