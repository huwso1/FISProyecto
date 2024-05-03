import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import Recurso from './Recurso';
import '../css/Unidad.css';

function Listarecursos({recursos,handlerrecurso,unidad}){
const handlerlista=(nombreM)=>{
    handlerrecurso(nombreM);
}
var rows=0;


return(
    <div>
         <CardGroup  >
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}} >
            <CardBody >
                <p>Nombre del Recurso</p>
                
            </CardBody>
        </Card>
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
            <CardBody >
                <p>Cantidad de reservas</p>
            </CardBody>
        </Card>
        <Card style={{backgroundColor:'#129EF2'}}>
            
        </Card>
    </CardGroup>
    { recursos?.map((recurso)=>{
        var umidad=recurso.Unidad+'';
        var umidadbuscada=unidad+'';
        console.log(umidad);
        if(umidad.toUpperCase()==umidadbuscada.toUpperCase()){
        return <Recurso  Nombre={recurso.nombre} CantidaddeReservas={recurso.cantidaddereservas} handler={handlerlista}></Recurso>;
        }
        return <></>;
    })}
    </div>
)
}

export default Listarecursos;