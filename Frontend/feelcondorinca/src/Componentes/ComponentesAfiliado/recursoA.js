import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import Recursomap from '../ComponentesAdmin/Mapeo/Recursomap';
import '../css/Unidad.css';

function RecursoA({Recurso,handler}){
    
const [debug,setdebug]=useState();

useEffect(()=>{
    console.log("cambiao");
    },[Recurso])
const handlemodificacion=(Nombre,idrecurso)=>{
    handler(Nombre,idrecurso);
}
return(
    <CardGroup>
        <Card onClick={()=>{handlemodificacion(Recurso.nombre,Recurso.id)}} style={{cursor:"pointer"}}>
            <CardBody>
                <p>{Recurso.nombre}</p>
            </CardBody>
        </Card>
        <Card>
            <CardBody>
                <p>Lunes:{Recurso.horariolunesi}-{Recurso.horariolunesf}</p> 
                <p>Martes:{Recurso.horariomartesi}-{Recurso.horariomartesf}</p> 
                <p>Miercoles:{Recurso.horariomiercolesi}-{Recurso.horariomiercolesf}</p> 
                <p>Jueves:{Recurso.horariojuevessi}-{Recurso.horariojuevesf}</p> 
                <p>Viernes:{Recurso.horarioviernesi}-{Recurso.horarioviernesf}</p> 
                <p>Sabado:{Recurso.horariosabadoi}-{Recurso.horariosabadof}</p> 
            </CardBody>
        </Card>
        <Card>
            <CardBody>
            <p>Descripcion</p>
            <p>{Recurso.descripcion}</p>
            </CardBody>
        </Card>
    </CardGroup>
)
}
export default RecursoA;