import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Reserva from '../ComponentesAdmin/Mapeo/Reserva';
import {useNavigate} from 'react-router-dom';
import ListaReservas from './ListaReservas'
import axios from 'axios';



function MisReservas(){
const [idRecurso,SetidRecurso]=useState();
const [ordenarPor,setOrdenar]=useState("");
const [recursos,setRecursos]=useState([]);
const ordenar=["Mas Reciente"];
const [reservas,setReservas]=useState([]);
const [message,Setmessage]=useState("");
const navigate=useNavigate();

useEffect(() => {
    const fetchData = async () => {
        try {
            // Esperamos la resolución de la promesa usando await
            const data = await peticionReservas();
            console.log(data);
            var listareservas=[];
            var listarecursos=[];
            data.map((reserva)=>{
                var Inicio=reserva.horaInicial;
                
                if(reserva.horaInicial<10){
                    Inicio="0"+Inicio;
                }
                if(reserva.minutoInicial<10){
                    Inicio=Inicio+":0"+reserva.minutoInicial;
                }else{
                    Inicio=":"+reserva.minutoInicial;
                }
                var Final=reserva.horaFinal;
                
                if(reserva.horaFinal<10){
                    Final="0"+Final;
                }
                if(reserva.minutoFinal<10){
                    Final=Final+":0"+reserva.minutoFinal;
                }else{
                    Final=":"+reserva.minutoFinal;
                }
                if(!listarecursos.includes(reserva.idRecurso.nombre)){
                    listarecursos.push(reserva.idRecurso.nombre);
                };
                listareservas.push(new Reserva(reserva.idReserva,reserva.idRecurso.nombre,window.sessionStorage.getItem("idUsuario"),Inicio,Final,reserva.estadoReserva,reserva.observaciones,reserva.fecha));
            })
            setRecursos(listarecursos);
            console.log(listareservas);
            setReservas(listareservas);
            // Una vez que la promesa se resuelve, actualizamos el estado con los datos recibidos
            // Aquí puedes ver los datos en la consola
        } catch (error) {
            // Manejamos cualquier error que pueda ocurrir
            //Se setea la lista con una lista ejemplo, la idea es que el back envie una lista json con objetos analista general
            // que tendran como atributos, nombre y id
            console.error('Error al obtener los datos:', error);
        }
    };
  
    fetchData();
  }, []);

  var peticionReservas = () => {
    return new Promise((resolve, reject) => {
        
        axios.post("http://localhost:8080/Afiliado/ReservasUsuario", {"idUsuario":window.sessionStorage.getItem("idUsuario") })
            .then((response) => {
                // Resolvemos la promesa con los datos recibidos
                resolve(response.data);
            })
            .catch((error) => {
                // Rechazamos la promesa con el mensaje de error
                
            });
    });
  };

  var CancelarReserva = (idReserva) => {
    return new Promise((resolve, reject) => {
        
        axios.post("http://localhost:8080/Afiliado/CancelarReserva", {"idReserva":idReserva })
            .then((response) => {
                // Resolvemos la promesa con los datos recibidos
                window.location.reload();
                resolve(response.data);
            })
            .catch((error) => {
                // Rechazamos la promesa con el mensaje de error
                
            });
    });
  };
const handlereliminar=(idReserva)=>{
    //Llamar a la peticion
    CancelarReserva(idReserva);
    navigate("/NavigateBarAfiliado/MisReservas");
    
}
function ordenarr(criterio){
         
    if(criterio=='Mas Reciente'){
        var aux=reservas.slice(0);
        aux.sort((a, b) => {

            
          
            // names must be equal
            return b.idreserva-a.idreserva;
          });
          
          setReservas(aux);
    }
}


return(

<div style={{display:'flex',height:'100em'}} >
    
   <Card style={{ minHeight:'100%', backgroundColor:'#D6F2F5', width:'20%', paddingTop:'4rem',height:'100%',alignItems:'center' }}>
    <Form.Label style={{left:'50%'}}>Ordenar por</Form.Label>
    <Form.Control as='select' placeholder='Ordenar Por' onChange={(element)=>{ordenarr(element.target.value)}} onClick={(element)=>{ordenarr(element.target.value)}}>
       { ordenar.map((element)=>{
        return <option value={element}>{element}</option>;
        })}
    </Form.Control>
    <Form.Label style={{left:'50%'}}>Filtrar por Recurso</Form.Label>
    <Form.Control as='select' placeholder='Recurso' onChange={(element)=>{SetidRecurso(element.target.value)}} onClick={(element)=>{SetidRecurso(element.target.value)}}>
       { recursos.map((recurso)=>{
        return <option value={recurso}>{recurso}</option>;
        })}
    </Form.Control>
    
    
</Card>
<Card style={{width:'80%'}}>
    <ListaReservas Reservas={reservas} handlerReservas={handlereliminar} Recurso={idRecurso} > </ListaReservas>
    <p>Debug: {message}</p>
</Card>


</div>


)
}
export default MisReservas;