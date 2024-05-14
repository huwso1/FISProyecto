import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import CardGroup from 'react-bootstrap/CardGroup';
import Card  from 'react-bootstrap/Card';
import '../css/Unidad.css';

function ListaEmpleados(idunidad){
const [Empleados,setEmpleados]=useState(["Jhon","Alex","Esteban"]);

return(
    <div style={{width:"30rem" , marginTop:"7rem" ,paddingRight:"4rem"}}>
<Card >
    <CardGroup> 
        <Card>Nombre Empleado</Card>
    </CardGroup>
    
   
        {Empleados.map((empleado)=>{
            return <Card>empleado</Card>
        })}
    
    
</Card>
</div>
);


}
export default ListaEmpleados;