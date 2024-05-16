import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Reserva from './Reserva';

function ListaReservas({Reservas,handlerReservas}){
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
                    <p>Codigo del recurso</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2',alignItems:'center'}}>
                <CardBody >
                    <p>Fecha de inicio-Fecha de finalizacion</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2'}}>
                
            </Card>
        </CardGroup>
        { Reservas.map((reserva)=>{
            rows++;
            return <Reserva  CodigoR={reserva.idreserva} CodigoRe={reserva.idrecurso} FechaInicio={reserva.fechainicio} FechaFinal={reserva.fechafinal} handler={handlerReserva}></Reserva>;
        })}
        </div>
    )
    }
    
    export default ListaReservas;   