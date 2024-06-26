import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import ReservaUnidad from './Reserva';

function ListaReservasUnidad({Reservas,handlerReservas,Recurso}){
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
                    <p>Fecha de inicio-Fecha de finalizacion</p>
                </CardBody>
            </Card>
            <Card style={{backgroundColor:'#129EF2'}}>
                
            </Card>
        </CardGroup>
        { Reservas.map((reserva)=>{
            rows++;
            if(reserva.idrecurso==Recurso || Recurso==null){
            return <ReservaUnidad  CodigoR={reserva.idreserva} CodigoRe={reserva.idrecurso} NombreU={reserva.idUsuario} FechaInicio={reserva.fechainicio} FechaFinal={reserva.fechafinal} Fecha={reserva.nombrerecurso} handler={handlerReserva} Estado={reserva.estado} ></ReservaUnidad>;
            }
            return <></>;
        })}
        </div>
    )
    }
    
    export default ListaReservasUnidad;   