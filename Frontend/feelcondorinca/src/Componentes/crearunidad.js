import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import './css/Unidad.css';
import axios from 'axios';
import {useState} from 'react';
function CrearUnidad ({idunidad,nombreunidad}){
var horas=["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"];
const [Nombre,setNombre]=useState("");
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
const [intervalominimo,SetInterval]=useState("");

if(idunidad!=null){
  //Aqui ira la peticion para recuperar los datos de la unidad
  //Aqui ira la peticion para recuperar el empleado de la unidad
}

const crearUnidadP=(element)=>{
  element.preventDefault();
  if(intervalominimo!="" && intervalominimo!=null && Nombre!=="" && Nombre!=null){
 axios.post("http://localhost:8080/Administracion/CrearUnidad",{"Nombre":Nombre,"Lunesi":Lunesi,"Lunesf":Lunesf,"Martesi":Martesi,"Martesf":Martesf,
 "Miercolesi":Miercolesi,"Miercolesf":Miercolesf,"Juevesi":Juevesi,"Juevesf":Juevesf,"Viernesi":Viernesi,"Viernesf":Viernesf,"Sabadosi":Sabadosi,"Sabadosf":Sabadosf,"intervalominimo":intervalominimo
 }).then((response)=>{
  SetMessage(response.data.message);
 }).catch((error)=>{
  SetMessage(error.response.data.message);
 });
}else{
  SetMessage("Campos como el intervalo minimo de prestamo y el nombre de la unidad son obligatorios");
}

}



function minhour(Horainicial){
  var index=0;
  horas.find((hour)=>{ index++; if(hour==Horainicial){ return true;} return false;})
  
  return horas.slice(index);
  

};

function updateMonday(horai){
  Setlunesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setlunesf(horas.at(index));

}
function updateTuesday(horai){
  Setmartesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setmartesf(horas.at(index));
    
}
function updateWednesday(horai){
  Setmiercolesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setmiercolesf(horas.at(index));
    
}
function updatethursday(horai){
  Setjuevesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setjuevesf(horas.at(index));
    
}

function updateFriday(horai){
  Setviernesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setviernesf(horas.at(index));
    
}

function updateSaturday(horai){
  Setsabadosi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    SetSabadosf(horas.at(index));
    
}
  



function titulounidad(){
  if(nombreunidad!==null){
    return <h2> Ingrese los datos de la unidad {nombreunidad}</h2>;
  }
  return <h2> Ingrese los datos de la nueva unidad </h2>;
}
function Nameset(){
  if(nombreunidad!=null){
    return(<></>);
  }
  return <><Form.Label >Nombre Unidad</Form.Label>
  <Form.Control type="text" placeholder="Distri Sanitas" value={Nombre} onChange={(element)=>{setNombre(element.target.value)}} /> </>;
}



return(
  
<div className="center-card">

<Card style={{border:'none', marginTop:'15rem'}} >

{titulounidad()}

</Card>

<Card style={{  width:'40rem', marginTop:'4rem', backgroundColor:'#D6F2F5' }}>

<CardBody>
<Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
      {Nameset()}
        
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>Intervalo minimo de prestamo(En minutos)</Form.Label>
        <Form.Control as="input" type="number" onChange={(element)=>{
            SetInterval(element.target.value);
        }} />
        
        <Form.Label >Horarios</Form.Label>
        <div></div>
        <Card>
        <div className="center-div">
        <Form.Label>Lunes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Lunesi} onChange={(e)=>{updateMonday(e.target.value.trim()) }} >
          
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Lunesf} onChange={(e)=>{Setlunesf(e.target.value.trim()) }} >
        {minhour(Lunesi).map((e)=>{
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
        <Form.Control as="select" value={Martesi} onChange={(e)=>{updateTuesday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Martesf} onChange={(e)=>{Setmartesf(e.target.value.trim())}} >
        {minhour(Martesi).map((e)=>{
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
        <Form.Control as="select" value={Miercolesi} onChange={(e)=>{updateWednesday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Miercolesf} onChange={(e)=>{Setmiercolesf(e.target.value.trim())}} >
        {minhour(Miercolesi).map((e)=>{
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
        <Form.Control as="select" value={Juevesi} onChange={(e)=>{updatethursday(e.target.value.trim()) } } >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Juevesf} onChange={(e)=>{Setjuevesf(e.target.value.trim())}}  >
        {minhour(Juevesi).map((e)=>{
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
        <Form.Control as="select" value={Viernesi} onChange={(e)=>{updateFriday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Viernesf} onChange={(e)=>{Setviernesf(e.target.value.trim())}} >
        {minhour(Viernesi).map((e)=>{
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
        <Form.Control as="select" value={Sabadosi} onChange={(e)=>{updateSaturday(e.target.value.trim()) }}  >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Sabadosf} onChange={(e)=>{SetSabadosf(e.target.value.trim())}} >
        {minhour(Sabadosi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        
        </div>
        </Card>
        </Form.Group>
        <div style={{padding:'1em 2em'}}></div>
        <Form.Control as="button" style={{padding:'2px 2em',backgroundColor:'#92a8d1'}} onClick={crearUnidadP}>Crear unidad</Form.Control>
    </Form>
    
</CardBody>

</Card>
<h1>{message}</h1>
</div>
);
}
export default CrearUnidad;