import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Unidadmap from './Mapeo/Unidadmap';
import Listaunidades from './Listaunidades';


function AdministrarU(){
const [ordenarPor,setOrdenar]=useState("");
const ordenar=["Nombre","Cantidad de reservas"];
const [unidades,setUnidades]=useState([new Unidadmap("Tinderud",32),new Unidadmap("Laboratorios",92),new Unidadmap("Homicidios",300)]);
const [isModifying,setModifying]=useState(true);
const [nombreM,setNombrem]=useState('');

const handlermod=(nombreunidad)=>{
    setNombrem(nombreunidad);
    setModifying(false);
}
if(ordenarPor==='Nombre'){
    var aux=unidades.slice();
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
if(ordenarPor==='Cantidad de reservas'){
    var aux=unidades.slice();
    unidades.sort((a, b) => {
        return a.cantidaddereservas-b.cantidaddereservas;
        
      });
}
if(isModifying){
return(

<div style={{display:'flex',height:'100em'}} >
    
   <Card style={{ minHeight:'100%', backgroundColor:'#D6F2F5', width:'20%', paddingTop:'4rem',height:'100%',alignItems:'center' }}>
    <Form.Label style={{left:'50%'}}>Ordenar Por</Form.Label>
    <Form.Control as='select' placeholder='Ordenar Por' onChange={(element)=>{setOrdenar(element.target.value)}}>
       { ordenar.map((element)=>{
        return <option value={element}>{element}</option>;
        })}
    </Form.Control>
</Card>
<Card style={{width:'80%'}}>
    <Listaunidades unidades={unidades} handlerunidades={handlermod}> </Listaunidades>
</Card>


</div>


)}else{
    return(<p>{nombreM}</p>)
}
}
export default AdministrarU;