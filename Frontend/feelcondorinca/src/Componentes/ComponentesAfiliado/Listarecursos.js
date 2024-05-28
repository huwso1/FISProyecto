import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import Recursomap from '../ComponentesAdmin/Mapeo/Recursomap';
import '../css/Unidad.css';
import RecursoA from './recursoA';

function Listarecursos({recursos,handlerrecurso,unidad}){
const handlerlista=(nombreM,idrecurso)=>{
    handlerrecurso(nombreM,idrecurso);
}
var rows=0;


return(
    <div>
         <CardGroup  >
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}} >
            <CardBody >
                <p>Recurso</p>
                
            </CardBody>
        </Card>
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
            <CardBody >
                <p>Horarios recurso</p>
            </CardBody>
        </Card>
        <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
            <CardBody >
                <p>Descripcion</p>
            </CardBody>
        </Card>
    </CardGroup>
    
    { recursos?.map((recurso)=>{
        //Cambiar la comparacion por el id de la unidad en lugar del nombre
        var umidad=recurso.Unidad+'';
        var umidadbuscada=unidad.id+'';
        console.log(umidad);
        if(umidad.toUpperCase()===umidadbuscada.toUpperCase()){
        return <RecursoA  Recurso={recurso} handler={handlerlista}></RecursoA>;
        }
        return <></>;
    })}
    </div>
)
}

export default Listarecursos;