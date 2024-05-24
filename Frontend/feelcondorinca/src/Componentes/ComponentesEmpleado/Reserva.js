import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';

function ReservaUnidad({CodigoR,CodigoRe,NombreU,FechaInicio,FechaFinal,handler,estado}){
    
const [debug,setdebug]=useState();
const handlecancelacion=(idreserva)=>{
    handler(idreserva);
}
function buttonvalue(){
    //Añadir el resto de estados de una reserva
    if(estado=='P'){
        return 'Pendiente';
    }
    return 'nose';
}
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
                <p>Fecha de inicio: {FechaInicio} <br></br>
                Fecha Final {FechaFinal}</p>
            </CardBody>
        </Card>
        <Card>
            <CardBody>
            <Form.Control as='input' type='button' value={buttonvalue()} name='Cancelar' onClick={()=>{handlecancelacion(CodigoR)}}></Form.Control>
            </CardBody>
        </Card>
    </CardGroup>
)
}
export default ReservaUnidad;