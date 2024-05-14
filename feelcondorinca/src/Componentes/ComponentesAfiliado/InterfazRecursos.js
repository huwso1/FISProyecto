import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Recursomap from '../ComponentesAdmin/Mapeo/Recursomap';
import Unidadmap from '../ComponentesAdmin/Mapeo/Unidadmap';
import Listarecursos from './Listarecursos';
import HacerReserva from './HacerReserva';

function InterfazRecursos(){
    const [recursos,setRecursos]=useState([new Recursomap(1,"Perros",32,"Tinderud","15:00","16:00"),new Recursomap(2,"Gatos",92,"Tinderud"),new Recursomap(3,"Homicidios",300,"Laboratorios")]);
    const [ordenarPor,setOrdenar]=useState("");
    const [unidades,setUnidades]=useState([new Unidadmap(1,"Tinderud",32),new Unidadmap(2,"Laboratorios",92),new Unidadmap(3,"Homicidios",300)]);
    const [unidad,setUnidad]=useState("");
    const [recursoR,setRecursoR]=useState(null);
    const [isModifying,setModifying]=useState(true);
    const ordenar=["Nombre"];
    
    const handlerreserva=(nombrerecurso,idrecurso)=>{
        setRecursoR(recursos.find((recurso)=>recurso.id==idrecurso));
        setModifying(false);
    }

    if(ordenarPor==='Nombre'){
        var aux=recursos.slice();
        unidades.sort((a, b) => {
            const nameA = a.nombre.toUpperCase(); // ignore upper and lowercase
            const nameB = b.nombre.toUpperCase(); // ignore upper and lowercase
            if (nameA < nameB) {
              return -1;
            }
            if (nameA > nameB) {
              return 1;
            }
          
            // names must be equal
            return 0;
          });
    }
    if (isModifying){
    return(
    <div style={{display:'flex',height:'100em'}} >
    
    <Card style={{ minHeight:'100%', backgroundColor:'#D6F2F5', width:'20%', paddingTop:'4rem',height:'100%',alignItems:'center' }}>
     <Form.Label style={{left:'50%'}}>Ordenar Por</Form.Label>
     <Form.Control as='select' placeholder='Ordenar Por' onChange={(element)=>{setOrdenar(element.target.value)}}>
        { ordenar.map((element)=>{
         return <option value={element}>{element}</option>;
         })}
     </Form.Control>
     <Form.Label style={{left:'50%'}}>Unidad</Form.Label>
     <Form.Control as='select' placeholder='Unidad' onChange={(element)=>{setUnidad(element.target.value)}}>
        { unidades.map((element)=>{
         return <option value={element.nombre}>{element.nombre}</option>;
         })}
     </Form.Control>
 </Card>
 <Card style={{width:'80%'}}>
     <Listarecursos recursos={recursos} handlerrecurso={handlerreserva} unidad={unidad}></Listarecursos>
     {recursoR? <p>{recursoR.nombre}</p>:""}
     
 </Card>
 
 
 </div>)}else{

  return(  <HacerReserva Recursoareservar={recursoR}></HacerReserva>);
 }
}
export default InterfazRecursos;

