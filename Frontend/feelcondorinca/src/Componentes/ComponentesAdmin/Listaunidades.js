import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import Unidad from './Unidad';
import '../css/Unidad.css';

function Listaunidades({unidades,handlerunidades}){
const handlerUnidades=(nombreM,idunidad)=>{
    handlerunidades(nombreM,idunidad);
}
var rows=0;


return(
    <div>
         <CardGroup  >
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}} >
            <CardBody >
                <p>Nombre de la unidad</p>
                
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
    { unidades.map((unidad)=>{
        rows++;
        return <Unidad  Nombre={unidad.nombre} CantidaddeReservas={unidad.cantidaddereservas} idunidad={unidad.id} handler={handlerUnidades}></Unidad>;
    })}
    </div>
)
}

export default Listaunidades;