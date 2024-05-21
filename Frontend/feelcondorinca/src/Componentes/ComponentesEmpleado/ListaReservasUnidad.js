import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import ReservaUnidad from './Reserva';

function ListaReservasUnidad({Reservas,handlerReservas}){
    const handlerReserva=(idreserva)=>{
        handlerReservas(idreserva);
    }
    var rows=0;
    
    
    return(
        <div>
             <CardGroup  >
            <Card style={{backgroundColor:'#129EF2',alignItems:'center'}} >
                <CardBody >
                    <p>Codigo de la reserva</p>
                    
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
                <CardBody >
                    <p>Nombre del recurso</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
                <CardBody >
                    <p>Nombre usuario</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
                <CardBody >
                    <p>Fecha de inicio y hora-Fecha de finalizacion y hora</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2'}}>
                
            </Card>
        </CardGroup>
        { Reservas.map((reserva)=>{
            rows++;
            return <ReservaUnidad  CodigoR={reserva.idreserva} CodigoRe={reserva.nombrerecurso} NombreU={reserva.nombreusuario} FechaInicio={reserva.fechainicio} FechaFinal={reserva.fechafinal} handler={handlerReserva} estado={reserva.estado}></ReservaUnidad>;
        })}
        </div>
    )
    }
    
    export default ListaReservasUnidad;   