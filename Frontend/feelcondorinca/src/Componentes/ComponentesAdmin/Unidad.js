import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';

function Unidad({Nombre,CantidaddeReservas,idunidad,handler}){
    
const [debug,setdebug]=useState();
const handlemodificacion=(Nombre,idunidad)=>{
    handler(Nombre,idunidad);
}
return(
    <CardGroup>
        <Card>
            <CardBody>
                <p>{Nombre}</p>
                
            </CardBody>
        </Card>
        <Card>
            <CardBody>
                <p>{CantidaddeReservas}</p>
            </CardBody>
        </Card>
        <Card>
            <CardBody>
            <Form.Control as='input' type='button' value='Modificar' name='Modificar' onClick={()=>{handlemodificacion(Nombre,idunidad)}}></Form.Control>
            </CardBody>
        </Card>
    </CardGroup>
)
}
export default Unidad;