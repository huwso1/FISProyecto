import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';

function Recurso({Nombre,idrecurso,CantidaddeReservas,handler}){
    
const [debug,setdebug]=useState();
const handlemodificacion=(Nombre,idrecurso)=>{
    handler(Nombre,idrecurso);
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
            <Form.Control as='input' type='button' value='Modificar' name='Modificar' onClick={()=>{handlemodificacion(Nombre,idrecurso)}}></Form.Control>
            </CardBody>
        </Card>
    </CardGroup>
)
}
export default Recurso;