import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Reserva from '../ComponentesAdmin/Mapeo/Reserva';
import {useNavigate} from 'react-router-dom';
import ListaReservasUnidad from './ListaReservasUnidad'




function MisReservasEmpleado(){
const [idRecurso,SetidRecurso]=useState();
const [ordenarPor,setOrdenar]=useState("");
const ordenar=["Mas Reciente"];
const [reservas,setReservas]=useState([new Reserva(1,2,1,"2015-02-02","2022-04-15","P","nada","Perros","Maincra25")]);
const [message,Setmessage]=useState("");
const navigate=useNavigate();


const handlerprestar=(idReserva)=>{
    //Llamar a la peticion
    Setmessage(idReserva);
    navigate("/NavigateBarAfiliado/MisReservas");
    
}
if(ordenarPor==='Mas reciente'){
    var aux=reservas.slice();
    reservas.sort((a, b) => {
        
      
        // names must be equal
        return a.idreserva-b.idreserva;
      });
}


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
    <ListaReservasUnidad Reservas={reservas} handlerReservas={handlerprestar} > </ListaReservasUnidad>
    <p>Debug: {message}</p>
</Card>


</div>


)
}
export default MisReservasEmpleado;