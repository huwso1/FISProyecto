import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import './css/Unidad.css';
import {useState} from 'react';
import Unidadmap from './ComponentesAdmin/Mapeo/Unidadmap';

function CrearRecurso (){
var horas=["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"];
const [Lunesi,Setlunesi]=useState("");
const [Lunesf,Setlunesf]=useState("");
const [Martesi,Setmartesi]=useState("");
const [Martesf,Setmartesf]=useState("");
const [Miercolesi,Setmiercolesi]=useState("");
const [Miercolesf,Setmiercolesf]=useState("");
const [Juevesi,Setjuevesi]=useState("");
const [Juevesf,Setjuevesf]=useState("");
const [Viernesi,Setviernesi]=useState("");
const [Viernesf,Setviernesf]=useState("");
const [Sabadosi,Setsabadosi]=useState("");
const [Sabadosf,SetSabadosf]=useState("");
const [message,SetMessage]=useState("");
const [unidad,SetUnidad]=useState('');
const [unidades,SetUnidades]=useState([new Unidadmap(1,"Homicidios"),new Unidadmap(2,"Laboratorios"),new Unidadmap(3,"Documentales Holman")]);








return(
  
<div className="center-card">

<Card style={{border:'none',marginTop:'20rem',height:"5px"}} >

<h2> Ingrese los datos del nuevo recurso</h2>

</Card>

<Card style={{  width:'40rem', marginTop:'7rem', backgroundColor:'#D6F2F5' }}>
<CardBody>
<Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label >Nombre Recurso</Form.Label>
        <Form.Control type="text" placeholder="Distri Sanitas" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>Unidad</Form.Label>
        <Form.Control as="select" placeholder="Unidad" onChange={(element)=>{SetUnidad(element.target.value)}}>
          {unidades.map((opcionunidad)=>{
            return <option value={opcionunidad.id}>{opcionunidad.nombre}</option>
          })}
        </Form.Control>
        
        <Form.Label >Horarios</Form.Label>
        <div></div>
        <Card>
        <div className="center-div">
        <Form.Label>Lunes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Lunesi} onChange={(e)=>{Setlunesi(e.target.value.trim())}} >
          
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Lunesf} onChange={(e)=>{Setlunesf(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        
        <div className="center-div">
        <Form.Label>Martes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Martesi} onChange={(e)=>{Setmartesi(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Martesf} onChange={(e)=>{Setmartesf(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        
        <div className="center-div">
        <Form.Label>Miercoles</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Miercolesi} onChange={(e)=>{Setmiercolesi(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Miercolesf} onChange={(e)=>{Setmiercolesf(e.target.value.trim())}} >
        {horas.map((e)=>{
            
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <div className="center-div">
        <Form.Label>Jueves</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Juevesi} onChange={(e)=>{Setjuevesi(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Juevesf} onChange={(e)=>{Setjuevesf(e.target.value.trim())}}  >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
    
        <div className="center-div">
        <Form.Label>Viernes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Viernesi} onChange={(e)=>{Setviernesi(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Viernesf} onChange={(e)=>{Setviernesf(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
      
      <div className="center-div">
        <Form.Label>Sabado</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Sabadosi} onChange={(e)=>{Setsabadosi(e.target.value.trim())}}  >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Sabadosf} onChange={(e)=>{SetSabadosf(e.target.value.trim())}} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        
        </div>
        </Card>
        </Form.Group>
        <div style={{padding:'1em 2em'}}></div>
        <Form.Control as="button" style={{padding:'2px 2em',backgroundColor:'#92a8d1'}}>Crear Recurso</Form.Control>
    </Form>
    
</CardBody>

</Card>
<h1>{Lunesi}</h1>
</div>
);
}
export default CrearRecurso;